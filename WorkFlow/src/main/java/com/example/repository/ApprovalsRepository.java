package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.entity.ApprovalsEntity;
import com.example.domain.entity.RequestEntity;
import com.example.domain.entity.UserEntity;
import com.example.domain.enums.ApprovalsDecision;


@Repository
public interface ApprovalsRepository extends JpaRepository<ApprovalsEntity, Integer> {
	
	/**
	 * 承認情報を取得する
	 * @param status
	 * @return
	 */
	List<ApprovalsEntity> findByDecision(ApprovalsDecision decision);
	
	/**
	 * ユーザーの申請情報を取得する
	 * @param request
	 * @return
	 */
	List<ApprovalsEntity> findByRequest(RequestEntity request);
	
	/**
	 * 全ユーザーの申請情報を取得する
	 * @param approver
	 * @return
	 */
	List<ApprovalsEntity> findByApprover(UserEntity userApprover);
}