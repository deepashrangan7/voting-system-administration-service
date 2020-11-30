package com.cts.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor

public class VotesDetail {
	public VotesDetail(Long candidateId, String name, String email) {
		super();
		this.candidateId = candidateId;
		this.name = name;
		this.email = email;
	}

	public VotesDetail(Long candidateId, String name, String email, Party party, Long totalVotesReceived) {
		super();
		this.candidateId = candidateId;
		this.name = name;
		this.email = email;
		this.party = party;
		this.totalVotesReceived = totalVotesReceived;
	}

	@NonNull
	private Long candidateId;
	@NonNull
	private String name;
	@NonNull
	private String email;
	private Party party;
	private Long totalVotesReceived;

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public void setTotalVotesReceived(Long totalVotesReceived) {
		this.totalVotesReceived = totalVotesReceived;
	}
}
