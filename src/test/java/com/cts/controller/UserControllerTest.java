package com.cts.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.cts.model.Status;
import com.cts.model.TempUser;
import com.cts.model.Users;
import com.cts.repository.UserRepository;
import com.cts.service.HelperService;
import com.cts.service.UserService;
import com.cts.service.UserServiceImpl;

@SpringBootTest
class UserControllerTest {
	@Mock
	HelperService helperServiceMock;
	@Mock
	UserService userService;
	@Mock
	UserRepository userRepository;

	@Mock
	BindingResult bindingResult;

	@Test
	void getAllUserTest() {
		List<Users> value = new ArrayList<Users>();
		Users user1 = new Users();
		Users user2 = new Users();
		UsersController uc = new UsersController();
		value.add(user1);
		value.add(user2);
		when(userRepository.findByRoleNot(2)).thenReturn(value);
		UserServiceImpl userServiceMock = new UserServiceImpl();
		userServiceMock.setUserRepository(userRepository);
		uc.setUserService(userServiceMock);

		assertArrayEquals(value.toArray(), uc.getAllUsers().toArray());

	}

	@Test
	void blockAUserTest() {
		UsersController uc = new UsersController();
		TempUser user = new TempUser();
		user.setActive(1);
		Status status = new Status();
		status.setStatusCode(200);
		when(userService.changeStatusOfAUser(user, 1)).thenReturn(new ResponseEntity<Status>(status, HttpStatus.OK));
		uc.setUserService(userService);
		assertEquals(HttpStatus.OK, uc.blockAUser(user, 1).getStatusCode());
	}

	@Test
	void updatePasswordTestStatusOk() {
		UsersController uc = new UsersController();
		TempUser user = new TempUser();
		when(bindingResult.hasFieldErrors("password")).thenReturn(false);
		when(userService.updatePassword(user, Long.valueOf(1))).thenReturn(new Status(200, "ok"));
		uc.setUserService(userService);
		assertEquals(HttpStatus.OK, uc.updatePassword(user, bindingResult, Long.valueOf(1)).getStatusCode());
	}

	@Test
	void addUserTestStatusOk() {
		UsersController uc = new UsersController();
		TempUser user = new TempUser();
		when(bindingResult.hasErrors()).thenReturn(false);
		when(userService.addNewUser(user)).thenReturn(new Status(200, "ok"));
		uc.setUserService(userService);
		assertEquals(HttpStatus.CREATED, uc.addNewUser(user, bindingResult).getStatusCode());
	}

	@Test
	void addUserTestStatusBadRequest() {
		UsersController uc = new UsersController();
		TempUser user = new TempUser();
		when(bindingResult.hasErrors()).thenReturn(false);
		when(userService.addNewUser(user)).thenReturn(new Status(404, "bad_request"));
		uc.setUserService(userService);
		assertEquals(HttpStatus.BAD_REQUEST, uc.addNewUser(user, bindingResult).getStatusCode());
	}

	@Test
	void updatePasswordTestStatusBadRequest() {
		UsersController uc = new UsersController();
		TempUser user = new TempUser();
		when(bindingResult.hasFieldErrors("password")).thenReturn(false);
		when(userService.updatePassword(user, Long.valueOf(1))).thenReturn(new Status(404, "bad_request"));
		uc.setUserService(userService);
		assertEquals(HttpStatus.BAD_REQUEST, uc.updatePassword(user, bindingResult, Long.valueOf(1)).getStatusCode());
	}

}
