package com.cts.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Status;
import com.cts.model.Users;
import com.cts.service.HelperService;
import com.cts.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UsersController {

	@Autowired
	private UserService userService;

	@Autowired
	private HelperService helperService;

	@PostMapping("/users")
	public ResponseEntity<Status> addNewUser(@Valid @RequestBody Users user, BindingResult bindingResult) {

		Status status = null;

		if (bindingResult.hasErrors()) {
			// data passed doesn't met the validation set at model class

			status = new Status(400, "please fill valid details");

			status.setFieldErrors(helperService.getAllError(bindingResult));

			log.error("error in user data passed {}", user);

			return new ResponseEntity<Status>(status, HttpStatus.BAD_REQUEST);
		}

		status = userService.addNewUser(user);// save the user

		if (status.getStatusCode() == 200)
			return new ResponseEntity<Status>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<Status>(status, HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/users/{userid}")
	public ResponseEntity<Status> updatePassword(@Valid @RequestBody Users user, BindingResult bindingResult,
			@PathVariable("userid") Long userId) {

		Status status = null;

		if (bindingResult.hasFieldErrors("password")) {

			status = new Status(400, "password constraints doesn't meet");

			List<String> fieldErrors = new ArrayList<String>();
			fieldErrors.add(bindingResult.getFieldError("password").getDefaultMessage());

			status.setFieldErrors(fieldErrors);

			return new ResponseEntity<Status>(status, HttpStatus.BAD_REQUEST);
		}

		status = userService.updatePassword(user, userId);

		if (status.getStatusCode() == 200)
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		else
			return new ResponseEntity<Status>(status, HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/users/status/{status_id}")
	public ResponseEntity<Status> blockAUser(@RequestBody Users user, @PathVariable("status_id") Integer statusId) {
		return userService.changeStatusOfAUser(user, statusId);
	}

}
