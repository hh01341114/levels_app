package com.example.Service;

import org.springframework.stereotype.Service;

import com.example.domain.entity.UserEntity;

public interface UserService {
	UserEntity getUserById(Integer id);
}
