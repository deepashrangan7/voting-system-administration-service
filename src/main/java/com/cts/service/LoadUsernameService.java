package com.cts.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class LoadUsernameService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)  {

		return new User(username, "", new ArrayList<>());
	}

}
