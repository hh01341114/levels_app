package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.entity.RequestEntity;
import com.example.domain.entity.UserEntity;
import com.example.domain.enums.RequestStatus;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Integer> {
	
	/**
	 * ログインユーザー申請
	 * @param userEntity
	 * @return
	 */
	List<RequestEntity> findByUserEntity(UserEntity userEntity);
	
	
	/**
	 * 全ユーザー申請状況
	 * @param status
	 * @return
	 */
	List<RequestEntity> findByStatus(RequestStatus status);
}