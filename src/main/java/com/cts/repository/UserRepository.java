package com.cts.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cts.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	public Users findByEmail(String email);
	
	public List<Users> findByRoleNot(Integer role);

}
