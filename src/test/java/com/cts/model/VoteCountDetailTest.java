package com.cts.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VoteCountDetailTest {

	@Test
	void totalNoOfVoterTest() {
		VotesCountDetail votesCountDetail = new VotesCountDetail();
		votesCountDetail.setTotalNoOfVoters(Long.valueOf(1));
		assertEquals(Long.valueOf(1), votesCountDetail.getTotalNoOfVoters());
	}
	@Test
	void toStringTest() {
		VotesCountDetail votesCountDetail = new VotesCountDetail();
		votesCountDetail.setTotalNoOfVoters(Long.valueOf(1));
		assertEquals(votesCountDetail.toString(),votesCountDetail.toString());
	}

	@Test
	void totalNoOfVotersVotedTest() {
		VotesCountDetail votesCountDetail = new VotesCountDetail();
		votesCountDetail.setTotalNoOfVotersVoted(Long.valueOf(1));
		assertEquals(Long.valueOf(1), votesCountDetail.getTotalNoOfVotersVoted());
	}

	@Test
	void votingPercentageTest() {
		VotesCountDetail votesCountDetail = new VotesCountDetail();
		votesCountDetail.setVotingPercentage(Double.valueOf(100));
		assertEquals(Double.valueOf(100), votesCountDetail.getVotingPercentage());
	}

	@Test
	void constructorTest() {
		VotesCountDetail votesCountDetail = new VotesCountDetail(Long.valueOf(1), Long.valueOf(1));

		assertEquals(Long.valueOf(1), votesCountDetail.getTotalNoOfVoters());
	}

	@Test
	void constructorTest2() {
		VotesCountDetail votesCountDetail = new VotesCountDetail(Long.valueOf(1), Long.valueOf(1), Double.valueOf(100));

		assertEquals(Long.valueOf(1), votesCountDetail.getTotalNoOfVoters());
	}

}
