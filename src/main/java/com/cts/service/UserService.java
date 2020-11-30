package com.cts.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cts.model.Status;
import com.cts.model.TempUser;
import com.cts.model.Users;

public interface UserService {
	
	public Status addNewUser(TempUser user);
	
	public Status updatePassword(TempUser user, Long userId);
	
	public ResponseEntity<Status> changeStatusOfAUser(TempUser user, Integer statusId);

	public List<Users> getAllUsers();
}
