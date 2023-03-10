package com.example.ktpApp.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ktpApp.model.User;
import com.example.ktpApp.repository.IUserRepository;
import com.example.ktpApp.service.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	IUserRepository userRepository;

	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.insertUser(user);
	}

	@Override
	public User loginUser(String email, String password) {
		// TODO Auto-generated method stub
		return userRepository.loginUser(email, password);
	}

}
