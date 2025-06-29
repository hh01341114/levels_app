package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.entity.UserEntity;
import com.example.domain.enums.Role;
import com.example.repository.UserRepository;
import com.example.service.UserService;

/**
 * 
 */
@Service
@Primary
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	/**
	 * ユーザー登録
	 */
	@Transactional
	@Override
	public void signup(UserEntity userEntity) {
		boolean exists = userRepository.existsByEmail(userEntity.getEmail());
		if (exists) {
			throw new DataAccessException("ユーザーが既に存在") {
			};
		}

		userEntity.setRole(Role.GENERAL);

		String rawPassword = userEntity.getPassword();
		userEntity.setPassword(encoder.encode(rawPassword));

		userRepository.save(userEntity);
	}

	/**
	 * ユーザー取得
	 */
	@Override
	public List<UserEntity> getUserEntities(UserEntity userEntity) {
		return userRepository.findAll();
	}

	/** ユーザー1件取得 */
	@Override
	public UserEntity getUserOne(String email) {
		Optional<UserEntity> option = userRepository.findByEmail(email);
		UserEntity userEntity = option.orElse(null);
		return userEntity;
	}

	/**
	 * ユーザー更新
	 */
	@Transactional
	@Override
	public void updateUserOne(String email, String password, String name) {

	}

	/**
	 * ユーザー削除
	 */
	@Transactional
	@Override
	public void deleteByEmail(String email) {
		userRepository.deleteByEmail(email);
	}

	/**
	 * ログインユーザー取得
	 */
	@Override
	public UserEntity getLoginUser(String email) {
		Optional<UserEntity> optional = userRepository.findByEmail(email);
		UserEntity userEntity = optional.orElse(null);
		return userEntity;
	}

}