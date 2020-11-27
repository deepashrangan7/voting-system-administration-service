package com.cts.service;

import org.springframework.http.ResponseEntity;

import com.cts.model.Status;
import com.cts.model.Users;

public interface UserService {
	
	public Status addNewUser(Users user);
	
	public Status updatePassword(Users user, Long userId);
	
	public ResponseEntity<Status> changeStatusOfAUser(Users user, Integer statusId);
}
