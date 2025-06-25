package com.example.Service;

import java.util.List;

import com.example.domain.entity.AttendanceEntity;
import com.example.enums.AttendanceType;

/**
 * アテンダンスサービスクラス
 * 打刻に関するビジネスロジックを定義するサービスインターフェース
 */
public interface AttendanceService {
	void recordPunch(Integer userId, AttendanceType type);
	
	/**
	 * 勤怠の履歴を取得する
	 * @param userId
	 * @return
	 */
	public List<AttendanceEntity> getAttendanceHistory(Integer userId);
}