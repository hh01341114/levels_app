package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.entity.UserEntity;
import com.example.domain.enums.Role;

/**
 * 
 * UserRepositoryクラス
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	// ログインユーザーの取得
	Optional<UserEntity> findByEmail(String email);

	// 登録済みかどうかの確認用メソッド
	boolean existsByEmail(String email);

	// 部署IDでユーザー一覧を取得
	List<UserEntity> findByDepartmentId(String departmentId);

	// 権限（ロール）でユーザー一覧を取得
	List<UserEntity> findByRole(Role role);

	void deleteByEmail(String email);
	
	/**
	 * 部署でユーザー取得
	 * @param departmentId
	 * @return
	 */
	List<UserEntity> findByDepartmentId(Integer departmentId);

}