package com.example.service;

import java.util.List;

import com.example.domain.entity.RequestEntity;
import com.example.domain.entity.UserEntity;
import com.example.domain.enums.RequestStatus;

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
}