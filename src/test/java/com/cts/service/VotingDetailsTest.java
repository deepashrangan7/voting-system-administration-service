package com.cts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.feign.VotingDetailServiceFeign;
import com.cts.model.Users;
import com.cts.model.VotesCountDetail;
import com.cts.model.VotesDetail;

@SpringBootTest
class VotingDetailsTest {

	@Mock
	private VotingDetailServiceFeign votingDetailServiceFeign;

	@Test
	void getTotalVoteCatedTest() {
		VotingDetailServiceImpl votingDetailServiceImpl = new VotingDetailServiceImpl();
		VotesCountDetail votesCountDetail = new VotesCountDetail(Long.valueOf(1), Long.valueOf(1));
		when(votingDetailServiceFeign.getVotingCountDetails("asdeeewewe")).thenReturn(votesCountDetail);
		votingDetailServiceImpl.setVotingDetailServiceFeign(votingDetailServiceFeign);
		assertEquals(votesCountDetail, votingDetailServiceImpl.getTotalVotesCasted("asdeeewewe"));
	}

	@Test
	void getVotersOfCandidateTest() {
		VotingDetailServiceImpl votingDetailServiceImpl = new VotingDetailServiceImpl();
		List<Users> users = new ArrayList<Users>();
		when(votingDetailServiceFeign.votersForACandidate("asd", Long.valueOf(1))).thenReturn(users);
		votingDetailServiceImpl.setVotingDetailServiceFeign(votingDetailServiceFeign);


		assertEquals(users, votingDetailServiceImpl.getVotersOfACandidate("asd", Long.valueOf(1)));
	}

	@Test
	void getAllVotersOfCandidateTest() {
		VotingDetailServiceImpl votingDetailServiceImpl = new VotingDetailServiceImpl();
		List<VotesDetail> users = new ArrayList<VotesDetail>();
		when(votingDetailServiceFeign.getVotesDetails("ads")).thenReturn(users);
		votingDetailServiceImpl.setVotingDetailServiceFeign(votingDetailServiceFeign);

		assertEquals(users, votingDetailServiceImpl.getAllCandidatesVotes("ads"));
	}

}
