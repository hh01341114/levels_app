package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.entity.RequestEntity;
import com.example.domain.entity.UserEntity;
import com.example.domain.enums.RequestStatus;
import com.example.repository.RequestRepository;
import com.example.service.RequestService;

/**
 * Requestサービスの実装クラス
 */
@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Override
	public List<RequestEntity> getUserRequests(UserEntity userEntity) {
		return requestRepository.findByUserEntity(userEntity);
	}
	
	@Override
	public List<RequestEntity> getRequestsByStatus(RequestStatus status) {
		return requestRepository.findByStatus(status);
	}
}