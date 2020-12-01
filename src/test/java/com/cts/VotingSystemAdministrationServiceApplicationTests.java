package com.cts;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VotingSystemAdministrationServiceApplicationTests {

	@Test
	void contextLoads() {
		String arr[] = { "deepash", "rangan" };
		VotingSystemAdministrationServiceApplication.main(arr);
		assertTrue(true);

	}

}
