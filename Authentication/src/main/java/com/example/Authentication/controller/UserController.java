package com.example.Authentication.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Authentication.dto.UserDto;
import com.example.Authentication.model.User;
import com.example.Authentication.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	ModelMapper mapper = new ModelMapper();

	@PostMapping("/users")
	String userRegistration(@RequestBody UserDto userDto) {

		User user = mapper.map(userDto, User.class);
		return userService.userRegister(user);
	}

	@GetMapping("/user/login")
	String userLogin(@RequestParam(value = "userId") String userId, @RequestParam(value = "password") String password) {

		return userService.userLogin(userId, password);

	}
}
