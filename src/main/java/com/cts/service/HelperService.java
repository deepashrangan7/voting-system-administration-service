package com.cts.service;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.cts.model.Users;

public interface HelperService {
	
	public boolean checkUniquenessOfEmailId(Users user);
	
	public List<String> getAllError(BindingResult bindingResult);
	
	public String generateRandomPassword();
}
