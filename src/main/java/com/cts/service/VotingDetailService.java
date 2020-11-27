package com.cts.service;

import java.util.List;

import com.cts.model.Users;
import com.cts.model.VotesCountDetail;
import com.cts.model.VotesDetail;

public interface VotingDetailService {
	public VotesCountDetail getTotalVotesCasted(String token);

	public List<Users> getVotersOfACandidate(String token, Long candidateId);

	public List<VotesDetail> getAllCandidatesVotes(String token);
}
