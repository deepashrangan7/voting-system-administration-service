package com.cts.model;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class TempUser {

	public TempUser(String email, String name, String password, Integer role, Party party) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.role = role;
		this.party = party;
	}

	public TempUser(Long userId, String email, String name, String password, Integer role, Integer active,
			Party party) {
		super();
		this.userId = userId;
		this.email = email;
		this.name = name;
		this.password = password;
		this.role = role;
		this.active = active;
		this.party = party;
	}

	private Long userId;

	@NotBlank(message = "Email should not be blank")
	@NotNull(message = "Email should not be null")
	@Pattern(regexp = "[a-z0-9._%+-A-Z]+@[a-z0-9.-A-Z]+\\.[a-z]{2,4}$", message = "Type Valid emailId")
	@NonNull
	private String email;

	@Column(nullable = false)
	@NotBlank(message = "user name should not be blank")
	@NotNull(message = "user name should not be null")
	@Size(max = 20, min = 4, message = "name should me minimum of length 4 and less than or equal to 20")
	@NonNull
	private String name;

	@NotBlank(message = "password should not be blank")
	@NotNull(message = "password should not be null")
	@Size(max = 15, min = 4, message = "password should me minimum of length 4 and less than or equal to 15")
	@NonNull
	private String password;

	@NotNull(message = "must select a role")
	@Min(value = 0, message = "select a valid role")
	@Max(value = 2, message = "select a valid role")
	@NonNull
	private Integer role;

	private Integer active = 1;

	@NonNull
	private Party party;

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setParty(Party party) {
		this.party = party;
	}
}
