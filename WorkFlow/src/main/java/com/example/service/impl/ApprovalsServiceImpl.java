package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.entity.ApprovalsEntity;
import com.example.domain.entity.RequestEntity;
import com.example.domain.entity.UserEntity;
import com.example.repository.ApprovalsRepository;
import com.example.service.ApprovalsService;

@Service
public class ApprovalsServiceImpl implements ApprovalsService {
	
	@Autowired
	private ApprovalsRepository approvalsRepository;

	/**
	 *ユーザーの申請状況を取得
	 */
	@Override
	public List<ApprovalsEntity> getApprovalsByRequest(RequestEntity request) {
		return approvalsRepository.findByRequest(request);
	}
	
	/**
	 *全ユーザーの申請取得
	 */
	public List<ApprovalsEntity> getAllApprovals() {
		return approvalsRepository.findAll();
	}
	
	/**
	 *ユーザーに紐づく申請一覧
	 *部署ごと
	 */
	public List<ApprovalsEntity> getApprovalsByApprover(UserEntity userApprover) {
		return approvalsRepository.findByApprover(userApprover);
	}
}