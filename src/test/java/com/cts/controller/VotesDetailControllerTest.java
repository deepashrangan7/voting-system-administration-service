package com.cts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Users;
import com.cts.model.VotesCountDetail;
import com.cts.model.VotesDetail;
import com.cts.service.VotingDetailService;

@SpringBootTest
class VotesDetailControllerTest {

	@Mock
	VotingDetailService votingDetailService;

	@Test
	void test() {
		VotesCountDetail vcd = new VotesCountDetail();
		when(votingDetailService.getTotalVotesCasted("abc")).thenReturn(vcd);
		VotesDetailController vdc = new VotesDetailController();
		vdc.setVotingDetailService(votingDetailService);
		assertEquals(vcd, vdc.getVotingCountDetails("abc"));
	}

	@Test
	void votesForACandidateTest() {
		List<Users> users = new ArrayList<Users>();
		when(votingDetailService.getVotersOfACandidate("abc", Long.valueOf(1))).thenReturn(users);
		VotesDetailController vdc = new VotesDetailController();
		vdc.setVotingDetailService(votingDetailService);
		assertEquals(users.size(), vdc.votersForACandidate("abc", Long.valueOf(1)).size());
	}

	@Test
	void votesDetailsTest() {
		List<VotesDetail> votes = new ArrayList<VotesDetail>();
		when(votingDetailService.getAllCandidatesVotes("abc")).thenReturn(votes);
		VotesDetailController vdc = new VotesDetailController();
		vdc.setVotingDetailService(votingDetailService);
		assertEquals(votes.size(), vdc.getVotesDetails("abc").size());
	}

}
