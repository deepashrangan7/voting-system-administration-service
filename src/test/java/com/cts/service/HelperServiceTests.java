package com.cts.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Users;
import com.cts.repository.UserRepository;

@SpringBootTest
class HelperServiceTests {

	@InjectMocks
	HelperServiceImpl helperServiceMock;

	@Mock
	UserRepository userRepositoryMock;

	@Test
	void test() {
		Users user = new Users();
		user.setEmail("deepashdeepika7@gmail.com");
		when(userRepositoryMock.findByEmail(user.getEmail())).thenReturn(user);
		assertEquals(false, helperServiceMock.checkUniquenessOfEmailId(user));

	}

	@Test
	void checkUniquenessNullPointertest() {

		when(userRepositoryMock.findByEmail(null)).thenThrow(NullPointerException.class);

		Assertions.assertThrows(NullPointerException.class, () -> {
			helperServiceMock.checkUniquenessOfEmailId(null);
		});
	}

	@Test
	void getAllErrorsTest() {
		assertEquals(null, helperServiceMock.getAllError(null));
	}

	@Test
	void generateRandomPasswordSizeTest() {
		assertEquals(8, helperServiceMock.generateRandomPassword().length());
	}

}
