package com.cts.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@ToString
public class Users {

	public Users(String name, String email, String password, Integer role, Party party) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.party = party;
	}

	public Users(Long userId, String name, String email, String password, Integer role, Integer active, Users isVoted,
			List<Users> voters, Party party) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.active = active;
		this.isVoted = isVoted;
		this.voters = voters;
		this.party = party;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long userId;

	@Column(nullable = false)
	@NonNull
	private String name;

	@Column(nullable = false)
	@NonNull
	private String email;

	@Column(nullable = false)
	@NonNull
	private String password;

	@Column(columnDefinition = "TINYINT", nullable = false)
	@NonNull
	private Integer role;

	@Column(columnDefinition = "TINYINT", nullable = false)
	private Integer active = 1;

	@ManyToOne
	@JoinColumn(name = "voted_user_id")
	private Users isVoted;

	@OneToMany(mappedBy = "isVoted")
	private List<Users> voters;

	@ManyToOne
	@JoinColumn(name = "party_id")
	@NonNull
	private Party party;

	@JsonIgnore
	public Users getIsVoted() {
		return isVoted;
	}

	@JsonIgnore
	public List<Users> getVoters() {
		return voters;
	}

	@JsonIgnore
	public Party getParty() {
		return party;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public void setIsVoted(Users isVoted) {
		this.isVoted = isVoted;
	}

	public void setVoters(List<Users> voters) {
		this.voters = voters;
	}

	public void setParty(Party party) {
		this.party = party;
	}

}
