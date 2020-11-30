package com.cts.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Party {

	public Party(String partyName) {
		super();
		this.partyName = partyName;
	}

	public Party(Long partyId, String partyName, List<Users> candidates) {
		super();
		this.partyId = partyId;
		this.partyName = partyName;
		this.candidates = candidates;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long partyId;

	@NonNull
	private String partyName;

	@OneToMany(mappedBy = "party")
	@JsonIgnore
	private List<Users> candidates;

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public void setCandidates(List<Users> candidates) {
		this.candidates = candidates;
	}

}
