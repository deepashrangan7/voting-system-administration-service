package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Users;
import com.cts.model.VotesCountDetail;
import com.cts.model.VotesDetail;
import com.cts.service.VotingDetailService;

@RestController
public class VotesDetailController {

	@Autowired
	private VotingDetailService votingDetailService;

	@GetMapping("/votecountdetails")
	public VotesCountDetail getVotingCountDetails(@RequestHeader("Authorization") String token) {

		return votingDetailService.getTotalVotesCasted(token);
	}

	@GetMapping("/votedetails/{candidate_id}")
	public List<Users> votersForACandidate(@RequestHeader("Authorization")String token,@PathVariable("candidate_id") Long candidateId) {
		return votingDetailService.getVotersOfACandidate(token,candidateId);
	}

	@GetMapping("/votedetails")
	public List<VotesDetail> getVotesDetails(@RequestHeader("Authorization")String token) {
		return votingDetailService.getAllCandidatesVotes(token);
	}
}
