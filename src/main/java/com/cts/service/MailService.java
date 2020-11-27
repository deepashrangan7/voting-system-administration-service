package com.cts.service;

import com.cts.model.Users;

public interface MailService {
	public boolean sendAccountCreationMail(Users user);
}
