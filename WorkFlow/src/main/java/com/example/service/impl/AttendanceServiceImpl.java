package com.example.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.entity.AttendanceEntity;
import com.example.domain.entity.UserEntity;
import com.example.enums.AttendanceType;
import com.example.repository.AttendanceRepository;
import com.example.repository.UserRepository;
import com.example.service.AttendanceService;
import com.example.service.AttendanceSummaryService;

/**
 * アテンダンスサービスの実装クラス
 * 打刻の情報をDBに記録する
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AttendanceSummaryService attendanceSummaryService;
	
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
		attendanceSummaryService.updateSummary(userEntity, type);
	}
	
	/**
	 *勤怠履歴を取得
	 *日付（降順）
	 */
	@Override
	public List<AttendanceEntity> getAttendanceHistory(UserEntity userEntity) {
		return attendanceRepository.findByUserEntityIdOrderByAtDesc(userEntity);
	}
	
	@Override
	public AttendanceType getLoginUserType(Integer userId) {
		AttendanceEntity attendanceEntity = attendanceRepository.findFirstByUserEntityIdOrderByAtDesc(userId);
			AttendanceType type = attendanceEntity.getType();
			
			return type;
	}
}