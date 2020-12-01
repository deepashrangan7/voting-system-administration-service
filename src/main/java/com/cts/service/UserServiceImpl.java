package com.cts.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.model.Status;
import com.cts.model.TempUser;
import com.cts.model.Users;
import com.cts.repository.PartyRepository;
import com.cts.repository.UserRepository;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@NoArgsConstructor

public class UserServiceImpl implements UserService {

	public UserServiceImpl(HelperService helperService, MailService mailService) {
		super();
		this.helperService = helperService;
		this.mailService = mailService;
	}

	public UserServiceImpl(UserRepository userRepository, HelperService helperService, PartyRepository partyRepository,
			MailService mailService) {
		super();
		this.userRepository = userRepository;
		this.helperService = helperService;
		this.partyRepository = partyRepository;
		this.mailService = mailService;
	}

	@Autowired
	private UserRepository userRepository;
	@Autowired
	@NonNull
	private HelperService helperService;
	@Autowired
	private PartyRepository partyRepository;
	@Autowired
	@NonNull
	private MailService mailService;

	@Transactional
	public Status addNewUser(TempUser tempUser) {
		try {
			String partyFailureMessage = "Candidate party is not correctly added please enter valid party details";

			if (tempUser != null) {

				Users user = new Users();
				user.setEmail(tempUser.getEmail());
				user.setName(tempUser.getName());
				user.setRole(tempUser.getRole());
				// check uniqueness of email
				if (helperService.checkUniquenessOfEmailId(user)) {

					if (tempUser.getRole() == 1 && tempUser.getParty() != null) {// if candidate set the party

						user.setParty(partyRepository.findByPartyName(tempUser.getParty().getPartyName().trim()));
						// mapping the party

						if (user.getParty() == null)
							return new Status(400, partyFailureMessage);

					} else if (user.getRole() == 1)
						return new Status(400, partyFailureMessage);

					// trimming size
					user.setEmail(user.getEmail().trim());
					user.setName(user.getName().trim());
					String password = helperService.generateRandomPassword().trim();// setting random password

					user.setPassword(password);
					user = userRepository.save(user);
					// save the user
					boolean flag = mailService.sendAccountCreationMail(user);// send the password in mail
					if (flag)
						log.info("Mail successfully sent to  {}", user.getEmail());
					else
						log.warn("Mail not sent successfully {}", user.getEmail());

					return new Status(200, "user added succesfully");

				} else {

					return new Status(400, "Email already exist");
				}
			}
		} catch (Exception e) {

			log.error("error occured while saving user {}", e.getMessage());

		}
		return null;
	}

	public Status updatePassword(TempUser user, Long userId) {
		try {

			if (user != null && userId != null) {
				Optional<Users> optionalOldUser = userRepository.findById(userId);
				if (optionalOldUser.isPresent()) {

					Users oldUser = optionalOldUser.get();
					oldUser.setPassword(user.getPassword().trim());// fetch user object and update the password
					userRepository.save(oldUser);// updating the use password
					log.info("user saved successfully with password {}", user);

					return new Status(200, "password update successfully");
				}
			}
		} catch (Exception e) {

			log.error("error occured while updating password {}", e.getMessage());
		}

		return new Status(500, "password not update successfully");
	}

	public ResponseEntity<Status> changeStatusOfAUser(TempUser user, Integer statusId) {

		Status status = new Status(400, "unable to block user at this moment");

		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

		if (user != null && user.getUserId() != null && statusId != null && (statusId == 0 || statusId == 1)) {

			Optional<Users> tentaiveUser = userRepository.findById(user.getUserId());

			if (tentaiveUser.isPresent()) {

				Users userToBeBlocked = tentaiveUser.get();
				userToBeBlocked.setActive(statusId);// changing active status

				try {
					userRepository.save(userToBeBlocked);

					log.info("user status changed successfully");

					String message = "user blocked succesfully";

					if (statusId == 1)
						message = "user unblocked succesfully";

					status = new Status(200, message);

					httpStatus = HttpStatus.OK;

				} catch (Exception e) {

					log.error("error occured while blocking a user {}", e.getMessage());
				}
			}
		}

		return new ResponseEntity<Status>(status, httpStatus);

	}

	public List<Users> getAllUsers() {
		return userRepository.findByRoleNot(2);
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
