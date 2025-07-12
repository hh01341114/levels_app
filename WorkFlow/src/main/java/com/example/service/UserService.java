package com.example.service;

import java.util.List;

import com.example.domain.entity.UserEntity;

/**
 * ユーザー情報に関するビジネスロジックを定義するサービスインターフェース
 */
public interface UserService {

	/**
	 * ユーザー登録
	 * 
	 * @param userEntity
	 */
	public void signup(UserEntity userEntity);

	/**
	 * ユーザー取得
	 * 
	 * @param userEntity
	 */
	public List<UserEntity> getUserEntities(UserEntity userEntity);

	/**
	 * ユーザー１件取得
	 * 
	 * @param email
	 */
	public UserEntity getUserOne(String email);
	
	/**
	 * IDでユーザーを1件取得
	 * 
	 * @param id
	 * @return ユーザー情報
	 */
	public UserEntity getUserById(Integer id);

	/**
	 * ユーザー更新
	 * 
	 * @param email
	 * @param password
	 * @param name
	 */
	public void updateUserOne(String email, String password, String name);

	/**
	 * ユーザー削除
	 * 
	 * @param email
	 */
	public void deleteByEmail(String email);

	/**
	 * ログインユーザー取得
	 * 
	 * @param email
	 */
	public UserEntity getLoginUser(String email);

}
