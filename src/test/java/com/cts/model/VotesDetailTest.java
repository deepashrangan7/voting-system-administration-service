package com.cts.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VotesDetailTest {

	@Test
	void candidateIdTest() {

		VotesDetail votesDetail = new VotesDetail();
		votesDetail.setCandidateId(Long.valueOf(1));
		assertEquals(Long.valueOf(1), votesDetail.getCandidateId());
	}

	@Test
	void toStringTest() {

		VotesDetail votesDetail = new VotesDetail();
		votesDetail.setCandidateId(Long.valueOf(1));
		assertEquals(votesDetail.toString(), votesDetail.toString());
	}

	@Test
	void candidateNameTest() {

		VotesDetail votesDetail = new VotesDetail();
		votesDetail.setName("deepash");
		;
		assertEquals("deepash", votesDetail.getName());
	}

	@Test
	void candidateEmailTest() {

		VotesDetail votesDetail = new VotesDetail();
		votesDetail.setEmail("deepash@gmail.com");
		;
		assertEquals("deepash@gmail.com", votesDetail.getEmail());
	}

	@Test
	void candidatePartyTest() {
		Party party = new Party("B");
		VotesDetail votesDetail = new VotesDetail();
		votesDetail.setParty(party);
		assertEquals("B", votesDetail.getParty().getPartyName());
	}

	@Test
	void candidateVotesTest() {

		VotesDetail votesDetail = new VotesDetail();
		votesDetail.setTotalVotesReceived(Long.valueOf(1));
		assertEquals(Long.valueOf(1), votesDetail.getTotalVotesReceived());
	}

	@Test
	void constructorTest() {

		VotesDetail votesDetail = new VotesDetail(Long.valueOf(1), "deepash", "deepash@gmail.com");

		assertEquals(Long.valueOf(1), votesDetail.getCandidateId());
	}

	@Test
	void constructorTest2() {

		VotesDetail votesDetail = new VotesDetail(Long.valueOf(1), "deepash", "deepash@gmail.com", new Party(),
				Long.valueOf(1));

		assertEquals(Long.valueOf(1), votesDetail.getCandidateId());
	}

}
