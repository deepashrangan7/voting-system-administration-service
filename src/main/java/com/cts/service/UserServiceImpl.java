package com.cts.service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cts.model.Status;
import com.cts.model.Users;
import com.cts.repository.PartyRepository;
import com.cts.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HelperService helperService;
	@Autowired
	private PartyRepository partyRepository;
	@Autowired
	private MailService mailService;

	@Transactional
	public Status addNewUser(Users user) {
		try {

			String partyFailureMessage = "Candidate party is not correctly added please enter valid party details";

			if (user != null) {
				// check uniqueness of email
				if (helperService.checkUniquenessOfEmailId(user)) {
					if (user.getRole() == 1 && user.getParty() != null) {// if candidate set the party

						if (user.getParty().getPartyName() != null)
							user.setParty(partyRepository.findByPartyName(user.getParty().getPartyName()));
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

					if (userRepository.save(user) != null) {//save the user

						log.info("user saved successfully user id is {}", user.getUserId());

						boolean flag = mailService.sendAccountCreationMail(user);// send the password in mail

						if (flag)
							log.info("Mail successfully sent to  {}", user.getEmail());
						else
							log.warn("Mail not sent successfully {}", user.getEmail());

						return new Status(200, "user added succesfully");

					}
				} else {

					return new Status(400, "Email already exist");
				}
			}
		} catch (Exception e) {

			log.error("error occured while saving user {}", e.getMessage());

		}
		return null;
	}

	public Status updatePassword(Users user, Long userId) {
		try {

			if (user != null && userId != null) {

				Users oldUser = userRepository.findById(userId).get();

				oldUser.setPassword(user.getPassword().trim());// fetch user object and update the password

				userRepository.save(oldUser);// updating the use password

				log.info("user saved successfully with password {}", user);

				return new Status(200, "password update successfully");
			} else {
				return new Status(400, "something went wrong");

			}
		} catch (Exception e) {

			log.error("error occured while updating password {}", e.getMessage());
		}

		return new Status(500, "password not update successfully");
	}

	public ResponseEntity<Status> changeStatusOfAUser(Users user, Integer statusId) {

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

}
