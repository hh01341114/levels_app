package com.example.service;

import java.time.LocalDate;
import java.util.List;

import com.example.domain.entity.CalendarEntity;

public interface CalendarService {
	
	/**
	 * カレンダーのイベントリストを取得
	 * @param start
	 * @param end
	 * @return
	 */
	List<CalendarEntity> getCalendar(LocalDate start, LocalDate end);
}