package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.entity.UserEntity;
import java.util.List;
import com.example.enums.Role;



/**
 * Homage
 * UserRepositoryクラス
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	//ログインユーザーの取得
	UserEntity findByEmail(String email);
	
    /** 部署IDでユーザー一覧を取得*/
    List<UserEntity> findByDepartmentId(String departmentId);

    /** 権限（ロール）でユーザー一覧を取得 */
    List<UserEntity> findByRole(Role role);
}