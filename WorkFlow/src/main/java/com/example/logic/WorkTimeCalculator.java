package com.example.logic;

import com.example.domain.entity.AttendanceSummaryEntity;

import lombok.Data;

/**
 * 実働時間と休憩時間を計算するクラス
 */
@Data
public class WorkTimeCalculator {
	
	/**
	 * 実働時間を計算する（分単位）
	 * @param summaryEntity
	 * @return
	 */
	public static int calculateWorkingTime(AttendanceSummaryEntity summaryEntity) {
		// 出勤または退勤の打刻がない場合は実働時間は未計算（0分）とする
		if (summaryEntity.getWorkStart() == null || summaryEntity.getWorkEnd() == null) return 0;
		
		int totalTime = summaryEntity.getWorkEnd() - summaryEntity.getWorkStart();
		int breakMinutes = calculateBreakMinutes(summaryEntity);
		
		return totalTime - breakMinutes;
	}
	
	/**
	 * 休憩時間を計算する（分単位）
	 * @param summaryEntity
	 * @return
	 */
	public static int calculateBreakMinutes(AttendanceSummaryEntity summaryEntity) {
		// 出勤または退勤の打刻がない場合は実働時間は未計算（0分）とする
		if (summaryEntity.getBreakStart() == null || summaryEntity.getBreakEnd() == null) return 0;
		
		return summaryEntity.getBreakEnd() - summaryEntity.getBreakStart();
	}
}