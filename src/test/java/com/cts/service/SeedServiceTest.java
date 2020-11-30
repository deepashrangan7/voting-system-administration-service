package com.cts.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Party;
import com.cts.model.UserRoleMapping;
import com.cts.repository.PartyRepository;
import com.cts.repository.SeedRepository;

@SpringBootTest
class SeedServiceTest {

	@Mock
	private SeedRepository seedRepo;
	@Mock
	private PartyRepository partyRepo;

	@Test
	void seedDataTest() {

		UserRoleMapping userRole = new UserRoleMapping(1, "admin");

		when(seedRepo.save(userRole)).thenReturn(userRole);

		assertNotNull(seedRepo.save(userRole));

	}

	@Test
	void seedDataTestFail() {

		UserRoleMapping userRole = null;

		when(seedRepo.save(userRole)).thenReturn(userRole);

		assertNull(seedRepo.save(userRole));

	}

	@Test
	void partyDataTest() {
		Party party = new Party("A");

		when(partyRepo.save(party)).thenReturn(party);
		assertNotNull(partyRepo.save(party));

	}

	@Test
	void partyDataTestFail() {
		Party party = null;

		when(partyRepo.save(party)).thenReturn(party);
		
		assertNull(partyRepo.save(party));

	}

}
