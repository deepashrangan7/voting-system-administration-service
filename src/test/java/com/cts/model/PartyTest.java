package com.cts.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PartyTest {

	@Test
	void partyNameIest() {
		Party party = new Party("A");
		assertEquals("A", party.getPartyName());
	}

	@Test
	void partyToStringTest() {
		Party party = new Party("A");
		assertEquals(party.toString(), party.toString());
	}

	@Test
	void partyIdIest() {
		Party party = new Party(Long.valueOf(1), "A", null);
		party.setPartyId(Long.valueOf(1));
		assertEquals(1, party.getPartyId());
	}

	@Test
	void partyCandidatesIest() {
		Party party = new Party(Long.valueOf(1), "A", null);
		party.setCandidates(null);
		assertNull(party.getCandidates());
	}
}
