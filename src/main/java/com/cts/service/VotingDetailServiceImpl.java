package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.feign.VotingDetailServiceFeign;
import com.cts.model.Users;
import com.cts.model.VotesCountDetail;
import com.cts.model.VotesDetail;

import lombok.Setter;

@Service
@Setter
public class VotingDetailServiceImpl implements VotingDetailService {

	@Autowired
	private VotingDetailServiceFeign votingDetailServiceFeign;

	public VotesCountDetail getTotalVotesCasted(String token) {

		return votingDetailServiceFeign.getVotingCountDetails(token);

	}

	@Override
	public List<Users> getVotersOfACandidate(String token, Long candidateId) {

		return votingDetailServiceFeign.votersForACandidate(token, candidateId);
	}

	@Override
	public List<VotesDetail> getAllCandidatesVotes(String token) {
		return votingDetailServiceFeign.getVotesDetails(token);
	}

}
