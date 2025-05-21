package com.example.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.Service.UserService;
import com.example.domain.entity.UserEntity;
import com.example.repository.UserRepository;

@Service
@Primary
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/**ユーザー取得*/
	@Override
	public UserEntity getUserById(Integer id) {
		return userRepository.findById(id).orElse(null);
	}
	
}