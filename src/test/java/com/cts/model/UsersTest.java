package com.cts.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsersTest {

	@Test
	void userIdTest() {
		Users user = new Users();
		user.setUserId(Long.valueOf(1));
		assertEquals(Long.valueOf(1), user.getUserId());
	}

	@Test
	void userIdTest2() {
		Users user = new Users();
		user.setUserId(null);
		assertNull(user.getUserId());
	}

	@Test
	void toStringTest() {
		Users user = new Users();

		assertEquals(user.toString(), user.toString());
	}

	@Test
	void usernameTest() {
		Users user = new Users();
		user.setName("deepash");
		assertEquals("deepash", user.getName());
	}

	@Test
	void passwordTest() {
		Users user = new Users();
		user.setName("deepash");
		assertEquals("deepash", user.getName());
	}

	@Test
	void emailTest() {
		Users user = new Users();
		user.setEmail("deepash@gmail.com");
		assertEquals("deepash@gmail.com", user.getEmail());
	}

	@Test
	void roleTest() {
		Users user = new Users();
		user.setRole(1);
		assertEquals(1, user.getRole());
	}

	@Test
	void activeTest() {
		Users user = new Users();
		user.setActive(1);
		assertEquals(1, user.getActive());
	}

	@Test
	void isVotedTest() {
		Users user = new Users();
		Users users = new Users();
		users.setName("deepash");

		user.setIsVoted(users);

		assertEquals(users, user.getIsVoted());
	}

	@Test
	void votersTest() {
		Users user = new Users();
		user.setVoters(null);

		assertNull(user.getVoters());
	}

	@Test
	void votersTest2() {
		Users user = new Users();
		Users user1 = new Users();
		Users user2 = new Users();
		List<Users> allUsers = new ArrayList<Users>();

		allUsers.add(user2);
		allUsers.add(user1);
		user.setVoters(allUsers);
		assertArrayEquals(allUsers.toArray(), allUsers.toArray());
	}

	@Test
	void partyTest() {
		Users user = new Users();
		Party party = new Party();
		party.setPartyName("A");
		user.setParty(party);
		assertEquals(party, user.getParty());
	}

	@Test
	void constructorTest() {
		Party party = new Party();
		party.setPartyName("A");
		Users user = new Users("deepash", "deepaash@gmail.com", "1234556", 1, party);

		assertEquals(party, user.getParty());
	}

	@Test
	void constructorTest2() {
		Party party = new Party();
		party.setPartyName("A");
		Users user = new Users(Long.valueOf(1), "deepash", "deepaash@gmail.com", "1234556", 1, 1, null, null, party);

		assertEquals(party, user.getParty());
	}
}
