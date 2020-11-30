
package com.cts.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class VotesCountDetail {

	public VotesCountDetail(Long totalNoOfVoters, Long totalNoOfVotersVoted) {
		super();
		this.totalNoOfVoters = totalNoOfVoters;
		this.totalNoOfVotersVoted = totalNoOfVotersVoted;
	}

	public VotesCountDetail(Long totalNoOfVoters, Long totalNoOfVotersVoted, Double votingPercentage) {
		super();
		this.totalNoOfVoters = totalNoOfVoters;
		this.totalNoOfVotersVoted = totalNoOfVotersVoted;
		this.votingPercentage = votingPercentage;
	}

	@NonNull
	private Long totalNoOfVoters;
	@NonNull
	private Long totalNoOfVotersVoted;

	private Double votingPercentage;

	public void setTotalNoOfVoters(Long totalNoOfVoters) {
		this.totalNoOfVoters = totalNoOfVoters;
	}

	public void setTotalNoOfVotersVoted(Long totalNoOfVotersVoted) {
		this.totalNoOfVotersVoted = totalNoOfVotersVoted;
	}

	public void setVotingPercentage(Double votingPercentage) {
		this.votingPercentage = votingPercentage;
	}

}
