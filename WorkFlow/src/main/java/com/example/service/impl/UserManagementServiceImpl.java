package com.example.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.entity.UserEntity;
import com.example.domain.enums.Role;
import com.example.repository.UserRepository;
import com.example.service.UserManagementService;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;

	/**
	 * ユーザー一覧を取得
	 */
	public List<UserEntity> getUsers() {
		return userRepository.findAll();
	}

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
		userEntity.setId(null);

		String rawPassword = userEntity.getPassword();
		userEntity.setPassword(encoder.encode(rawPassword));

		userRepository.save(userEntity);
	}

	/**
	 *部署で絞り込み
	 */
	@Override
	public List<UserEntity> getUsersByDepartment(Integer departmentId) {
		return userRepository.findByDepartmentId(departmentId);
	}

	/**
	 * ユーザー更新
	 * 
	 * @param email
	 * @param password
	 * @param name
	 */
	@Transactional
	@Override
	public void updateUserOne(String email, String password, String name, Integer departmentId) {
	}

	/**
	 * ユーザー削除
	 */
	@Transactional
	@Override
	public void deleteByEmail(String email) {
		userRepository.deleteByEmail(email);
	}

}