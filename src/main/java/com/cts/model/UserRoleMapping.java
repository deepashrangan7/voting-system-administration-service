package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "user_role_mapping")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class UserRoleMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, columnDefinition = "TINYINT")
	@NonNull
	private Integer roleId;

	@Column(nullable = false)
	@NonNull
	private String role;

}
