package com.cts.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TempUserTest {

	@Test
	void activeTest() {
		TempUser user = new TempUser();
		user.setActive(1);
		assertEquals(1, user.getActive());
	}
	@Test
	void partyTest() {
		TempUser user = new TempUser();
		Party party = new Party();
		party.setPartyName("A");
		user.setParty(party);
		assertEquals(party, user.getParty());
	}

	@Test
	void userIdTest() {
		TempUser user = new TempUser();
		user.setUserId(Long.valueOf(1));
		assertEquals(Long.valueOf(1), user.getUserId());
	}

	@Test
	void usernameTest() {
		TempUser user = new TempUser();
		user.setName("deepash");
		assertEquals("deepash", user.getName());
	}

	@Test
	void passwordTest() {
		TempUser user = new TempUser();
		user.setName("deepash");
		assertEquals("deepash", user.getName());
	}

	@Test
	void emailTest() {
		TempUser user = new TempUser();
		user.setEmail("deepash@gmail.com");
		assertEquals("deepash@gmail.com", user.getEmail());
	}

	@Test
	void roleTest() {
		TempUser user = new TempUser();
		user.setRole(1);
		assertEquals(1, user.getRole());
	}

	@Test
	void constructorTest() {
		TempUser tempUser = new TempUser("deepash@gmail.com", "deepaash", "deepash", 1,new Party());
		assertEquals(1, tempUser.getRole());
	}

	@Test
	void constructorTest2() {
		TempUser tempUser = new TempUser(Long.valueOf(1), "deepash@gmail.com", "deepaash", "deepash", 1, 1,
				new Party());
		assertEquals(1, tempUser.getRole());
	}
}
