package com.example.service;

import java.util.List;

import com.example.domain.entity.UserEntity;

/**
 * ユーザー管理画面用インターフェースクラス ユーザー登録、削除を処理
 */
public interface UserManagementService {

	/**
	 * ユーザー一覧を取得
	 * 
	 * @param userEntity
	 * @return
	 */
	public List<UserEntity> getUsers();

	/**
	 * 部署idでユーザー取得
	 * 
	 * @param departmentId
	 * @return
	 */
	public List<UserEntity> getUsersByDepartment(Integer departmentId);

	/**
	 * 入力したデータで検索
	 * @param partialName
	 * @return
	 */
	public List<UserEntity> findUsersByPartialName(String email);
	
	/**
	 * 部署Idと検索結果の反映
	 * @param email
	 * @param departmentId
	 * @return
	 */
	public List<UserEntity> findByEmailAndDepartment(String email, Integer departmentId);
	

	/**
	 * ユーザー登録
	 * 
	 * @param userEntity
	 */
	public void signup(UserEntity userEntity);

	/**
	 * ユーザー削除
	 * 
	 * @param email
	 */
	public void deleteByEmail(String email);

	/**
	 * ユーザー更新
	 * 
	 * @param email
	 * @param password
	 * @param name
	 */
	public void updateUserOne(String email, String password, String name, Integer departmentId);
}