package com.cts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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

	@Test
	void allDataTest() {
		List<UserRoleMapping> userRole = new ArrayList<UserRoleMapping>();
		userRole.add(new UserRoleMapping(0, "voter"));
		userRole.add(new UserRoleMapping(1, "candidate"));
		userRole.add(new UserRoleMapping(2, "admin"));
		List<Party> parties = new ArrayList<Party>();
		parties.add(new Party("A"));
		parties.add(new Party("B"));
		parties.add(new Party("C"));
		parties.add(new Party("D"));
		when(seedRepo.saveAll(userRole)).thenReturn(userRole);
		when(partyRepo.saveAll(parties)).thenReturn(parties);
		SeedServiceImpl si = new SeedServiceImpl();
		si.setPartyRepo(partyRepo);
		si.setSeedRepo(seedRepo);
		assertEquals("data seeded successfully", si.seedData());
	}

}
