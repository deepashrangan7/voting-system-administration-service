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

public class VotesDetail {
	@NonNull
	private Long candidateId;
	@NonNull
	private String name;
	@NonNull
	private String email;
	private Party party;
	private Long totalVotesReceived;
}
