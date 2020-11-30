package com.cts.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoadUsernameServiceTest {

	@InjectMocks
	LoadUsernameService loadUsernameServiceMock;

	@Test
	void loadUsernameServiceNameTest() {
		String name = "deepashtest";
		assertEquals(name, loadUsernameServiceMock.loadUserByUsername(name).getUsername());
	}
	

}
