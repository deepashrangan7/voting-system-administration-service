
package com.cts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class VotesCountDetail {

	@NonNull
	private Long totalNoOfVoters;
	@NonNull
	private Long totalNoOfVotersVoted;

	private Double votingPercentage;

}
