package com.cts.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.cts.model.Users;
import com.cts.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HelperServiceImpl implements HelperService{

	@Autowired
	private UserRepository userRepository;

	public boolean checkUniquenessOfEmailId(Users user) {
		boolean flag = false;
		if (userRepository.findByEmail(user.getEmail()) == null)
			flag = true;
		return flag;
	}

	// function to get all the field errors
	public List<String> getAllError(BindingResult bindingResult) {
		
		List<String> errors = new ArrayList<String>();

		for (ObjectError error : bindingResult.getAllErrors()) {
			errors.add(error.getDefaultMessage());
		} // getting all field errors
		
		log.info("total field errors {}", errors.size());
		
		return errors;
	}

	public String generateRandomPassword() {

		// rules
		List<CharacterRule> rules = Arrays.asList(new CharacterRule(EnglishCharacterData.UpperCase, 1),
				new CharacterRule(EnglishCharacterData.LowerCase, 1), new CharacterRule(EnglishCharacterData.Digit, 1));

		PasswordGenerator generator = new PasswordGenerator();
		String password = generator.generatePassword(8, rules);

		return password;

	}
}
