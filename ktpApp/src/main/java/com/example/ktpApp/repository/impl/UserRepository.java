package com.example.ktpApp.repository.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ktpApp.model.User;
import com.example.ktpApp.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_user(email, nama, password) VALUES(?,?,?)";
		jdbcTemplate.update(query, new Object[] {user.getEmail(), user.getNama(), user.getPassword()});
		return user;
	}

	@Override
	public User loginUser(String email, String password) {
		// TODO Auto-generated method stub
		String query = "SELECT id, nama, email FROM tb_user WHERE email = ? AND password = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(User.class), email, password);
	}


}
