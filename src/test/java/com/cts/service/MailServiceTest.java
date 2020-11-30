package com.cts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;

import com.cts.model.Users;

@SpringBootTest
class MailServiceTest {

	@Mock
	JavaMailSender javaMailSenderMock;

	@Test
	void accountCreationMailTest() {

		MailServiceImpl mailServiceMocks = new MailServiceImpl(javaMailSenderMock);

		Users user = new Users();
		user.setUserId(Long.valueOf(1));
		user.setEmail("deepashdeepika7@gmail.com");
		user.setName("deepash");
		user.setPassword("12345678");

		assertEquals(true, mailServiceMocks.sendAccountCreationMail(user));

	}

	@Test
	void accountCreationMailFailed() {
		MailServiceImpl mailServiceMocks = new MailServiceImpl(javaMailSenderMock);
		assertEquals(false, mailServiceMocks.sendAccountCreationMail(null));

	}

}
