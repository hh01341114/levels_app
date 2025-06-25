package com.example.Service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Service.AttendanceService;
import com.example.domain.entity.AttendanceEntity;
import com.example.domain.entity.UserEntity;
import com.example.enums.AttendanceType;
import com.example.repository.AttendanceRepository;
import com.example.repository.UserRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 *ログイン中のユーザーの打刻情報を取得
	 */
	@Transactional
	@Override
	public void recordPunch(Integer userId, AttendanceType type) {
		Optional<UserEntity> option = userRepository.findById(userId);
		UserEntity userEntity = option.orElse(null);
		
		//打刻情報（ユーザー、打刻種類、打刻時間）
		AttendanceEntity attendanceEntity = new AttendanceEntity();
		attendanceEntity.setUserEntity(userEntity);
		attendanceEntity.setType(type);
		attendanceEntity.setAt(LocalDateTime.now());
		
		//リポシトリに保存
		attendanceRepository.save(attendanceEntity);
	}
	
	/**
	 *勤怠履歴を取得
	 *日付（降順）
	 */
	@Override
	public List<AttendanceEntity> getAttendanceHistory(Integer userId) {
		return attendanceRepository.findByUserEntityIdOrderByAtDesc(userId);
	}
	
}