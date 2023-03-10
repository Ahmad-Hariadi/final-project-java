package com.example.ktpApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ktpApp.model.User;
import com.example.ktpApp.service.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/insertUser")
	public User insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
	
	@PostMapping("/login")
	public User loginUser (@RequestBody User user) {
		return userService.loginUser(user.getEmail(), user.getPassword());
	}
	
}
