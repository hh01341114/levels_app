package com.example.mapper;

import java.time.format.DateTimeFormatter;

import com.example.domain.dto.AttendanceSummaryDto;
import com.example.domain.entity.AttendanceSummaryEntity;
import com.example.logic.WorkTimeCalculator;

/**
 * 勤怠履歴情報を表示用に変換するクラス
 */
public class AttendanceSummaryMapper {
	
	/**
	 * 出退勤時間用関数
	 * 分（例：510）→ HH:mm（08:30）に変換する
	 * @param minutes
	 * @return
	 */
	private static String formatTime(Integer minutes) {
		if (minutes == null) return "-";
		int h = minutes / 60;
		int m = minutes % 60;
		
		return String.format("%02d:%02d", h, m);
	}
	
	/**
	 * 勤務時間用関数
	 * 分 → "HH:mm"形式に変換（例：555 → 09:15）
	 * @param minutes
	 * @return
	 */
	private static String formatMinutes(Integer minutes) {
		int h = minutes / 60;
		int m = minutes % 60;
		
		return String.format("%d時間%d分", h, m);
	}
	
	/**
	 * AttendanceSummaryEntityからDTOに変換する
	 * @param attendanceSummaryEntity
	 * @return
	 */
	public static AttendanceSummaryDto toSummaryDto(AttendanceSummaryEntity attendanceSummaryEntity) {
		//日付の表示フォーマットの定義
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		String workDate = attendanceSummaryEntity.getWorkDate().format(dateFormatter);
		String workStart = formatTime(attendanceSummaryEntity.getWorkStart());
		String workEnd = formatTime(attendanceSummaryEntity.getWorkEnd());
		
		//分 → "X時間Y分" に変換
		String workingMinutes = formatMinutes(WorkTimeCalculator.calculateWorkingTime(attendanceSummaryEntity));
		String breakMinutes = formatMinutes(WorkTimeCalculator.calculateBreakMinutes(attendanceSummaryEntity));
		
		return new AttendanceSummaryDto(workDate, workStart, workEnd, workingMinutes, breakMinutes);
	}
}