package com.example.service;

import java.util.List;

import com.example.domain.entity.ApprovalsEntity;
import com.example.domain.entity.RequestEntity;
import com.example.domain.entity.UserEntity;

public interface ApprovalsService {
	public List<ApprovalsEntity> getApprovalsByRequest(RequestEntity request);
	
	/**
	 * 全ユーザーの申請取得
	 * @return
	 */
	public List<ApprovalsEntity> getAllApprovals();
	
	/**
	 * 管理者に紐づくユーザーの申請取得
	 * 管理者idと紐付け
	 * @param userApprover
	 * @return
	 */
	public List<ApprovalsEntity> getApprovalsByApprover(UserEntity userApprover);
		
}