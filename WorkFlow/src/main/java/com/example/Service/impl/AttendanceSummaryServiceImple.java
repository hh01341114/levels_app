package com.example.Service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Service.AttendanceSummaryService;
import com.example.domain.entity.AttendanceSummaryEntity;
import com.example.domain.entity.UserEntity;
import com.example.enums.AttendanceType;
import com.example.repository.AttendanceSummaryRepository;

/**
 * アテンダンスサマリーサービスクラスの実装クラス
 * 勤務時間をDBに記録する
 */
@Service
public class AttendanceSummaryServiceImple implements AttendanceSummaryService {
	
	@Autowired
	private AttendanceSummaryRepository summaryRepository;
	
	/**
	 * 打刻日時をint型にするメソッド
	 * @return
	 */
	private int getCurrentTimeAsInt() {
		java.time.LocalTime time = java.time.LocalTime.now();
		return time.getHour() * 100 + time.getMinute();
	}
	
	/**
	 *打刻時間の情報を更新する（出勤→退勤等）
	 */
	@Override
	public void updateSummary(UserEntity userEntity, AttendanceType attendanceType) {
		Optional<AttendanceSummaryEntity> option = summaryRepository.findByUserAndWorkDate(userEntity, LocalDate.now());
		AttendanceSummaryEntity summaryEntity = option.orElse(null);
		
		//データがあるか確認
		if (summaryEntity == null) {
			summaryEntity = new AttendanceSummaryEntity();
			summaryEntity.setUser(userEntity);
			summaryEntity.setWorkDate(LocalDate.now());
		}
		
		//打刻情報をINT型に
		switch (attendanceType) {
			case IN:
				summaryEntity.setWorkStart(getCurrentTimeAsInt());
				break;
			case OUT:
				summaryEntity.setWorkEnd(getCurrentTimeAsInt());
				break;
			case BREAK_IN:
				summaryEntity.setBreakStart(getCurrentTimeAsInt());
				break;
			case BREAK_OUT:
				summaryEntity.setBreakEnd(getCurrentTimeAsInt());
				break;
			default:
				break;
		}
		summaryRepository.save(summaryEntity);
	}
}