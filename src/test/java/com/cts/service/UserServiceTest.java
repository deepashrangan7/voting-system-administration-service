package com.cts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;

import com.cts.model.Party;
import com.cts.model.TempUser;
import com.cts.model.Users;
import com.cts.repository.PartyRepository;
import com.cts.repository.UserRepository;

@SpringBootTest
class UserServiceTest {

	@Mock
	UserRepository userRepositoryMock;

	@InjectMocks
	HelperServiceImpl helperServiceMock;

	@Mock
	PartyRepository partyRepository;

	@Mock
	JavaMailSender javaMailSender;

	@Test
	void addUserTest() {
		MailServiceImpl mailService = new MailServiceImpl(javaMailSender);
		TempUser tUser = new TempUser();
		Users user = new Users();
		tUser.setParty(new Party("A"));
		tUser.setEmail("deepash@gmail.com");
		tUser.setName("deepash");
		tUser.setRole(0);

		tUser.setUserId(Long.valueOf(1));

		user.setUserId(Long.valueOf(1));
		user.setParty(new Party("A"));
		user.setEmail("deepash@gmail.com");
		user.setName("deepash");
		user.setRole(0);

		when(userRepositoryMock.save(user)).thenReturn(user);
		UserServiceImpl userServiceMock = new UserServiceImpl(userRepositoryMock, helperServiceMock, partyRepository,
				mailService);
		Assertions.assertThrows(Exception.class, () -> {
			userServiceMock.addNewUser(tUser).getStatusCode();
		});
	}

	@Test
	void updatePasswordTest() {

		UserServiceImpl userServiceImpl = new UserServiceImpl();

		TempUser tUser = new TempUser();
		tUser.setUserId(Long.valueOf(1));
		tUser.setPassword("12345678");
		Users user = new Users();
		user.setUserId(Long.valueOf(1));
		user.setPassword("12345678");
		when(userRepositoryMock.findById(user.getUserId())).thenReturn(Optional.of(user));
		when(userRepositoryMock.save(user)).thenReturn(user);
		userServiceImpl.setUserRepository(userRepositoryMock);
		assertEquals(200, userServiceImpl.updatePassword(tUser, tUser.getUserId()).getStatusCode());
	}

	@Test
	void updatePasswordTestFail() {

		UserServiceImpl userServiceImpl = new UserServiceImpl();

		assertEquals(500, userServiceImpl.updatePassword(null, Long.valueOf(1)).getStatusCode());
	}

	@Test
	void updateStatusTest() {

		UserServiceImpl userServiceImpl = new UserServiceImpl();

		TempUser tUser = new TempUser();
		tUser.setUserId(Long.valueOf(1));
		tUser.setPassword("12345678");
		tUser.setActive(1);
		Users user = new Users();
		user.setUserId(Long.valueOf(1));
		user.setPassword("12345678");
		user.setActive(1);
		when(userRepositoryMock.findById(user.getUserId())).thenReturn(Optional.of(user));
		when(userRepositoryMock.save(user)).thenReturn(user);
		userServiceImpl.setUserRepository(userRepositoryMock);

		assertEquals(HttpStatus.OK, userServiceImpl.changeStatusOfAUser(tUser, 1).getStatusCode());
	}

	@Test
	void updateStatusTestFail() {

		UserServiceImpl userServiceImpl = new UserServiceImpl();

		userServiceImpl.setUserRepository(userRepositoryMock);

		assertEquals(HttpStatus.BAD_REQUEST, userServiceImpl.changeStatusOfAUser(null, 1).getStatusCode());
	}
}
