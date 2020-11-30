package com.cts.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRoleMappingTest {

	@Test
	void roleIdTest() {
		UserRoleMapping userRoleMapping = new UserRoleMapping(1, "A");
		assertEquals(1, userRoleMapping.getRoleId());

	}

	@Test
	void toStringTest() {
		UserRoleMapping userRoleMapping = new UserRoleMapping(1, "A");
		assertEquals(userRoleMapping.toString(), userRoleMapping.toString());

	}

	@Test
	void idTest() {
		UserRoleMapping userRoleMapping = new UserRoleMapping(1, "A");
		userRoleMapping.setId(1);
		assertEquals(1, userRoleMapping.getId());

	}

	@Test
	void constructorTest() {
		UserRoleMapping userRoleMapping = new UserRoleMapping(1, 1, "A");

		assertEquals(1, userRoleMapping.getId());

	}

	@Test
	void roleTest() {
		UserRoleMapping userRoleMapping = new UserRoleMapping(1, "A");
		assertEquals("A", userRoleMapping.getRole());

	}

}
