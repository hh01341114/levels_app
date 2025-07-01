package com.example.service;

import java.util.List;

import com.example.domain.entity.RequestEntity;
import com.example.domain.entity.UserEntity;
import com.example.domain.enums.RequestStatus;
import com.example.form.RequestForm;

public interface RequestService {
	
	/**
	 * ログインユーザーの申請したリクエスト取得
	 * @param userEntity
	 * @return
	 */
	List<RequestEntity> getUserRequests(UserEntity userEntity);
	
	/**
	 * 全ユーザーの申請取得
	 * @param status
	 * @return
	 */
	List<RequestEntity> getRequestsByStatus(RequestStatus status);
	
	/**
	 * 有給申請情報取得
	 * @param userEntity
	 * @param requestForm
	 */
	void savePaidLeaveRequest(UserEntity userEntity, RequestForm requestForm);
}