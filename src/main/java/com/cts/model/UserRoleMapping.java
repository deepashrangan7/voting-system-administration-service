package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Table(name = "user_role_mapping")
@NoArgsConstructor
@Getter
@ToString
public class UserRoleMapping {

	public UserRoleMapping(Integer roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}

	public UserRoleMapping(Integer id, Integer roleId, String role) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, columnDefinition = "TINYINT")
	@NonNull
	private Integer roleId;

	@Column(nullable = false)
	@NonNull
	private String role;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
