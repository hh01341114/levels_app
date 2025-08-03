package com.example.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.entity.CalendarEntity;
import com.example.service.CalendarService;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {

	@Autowired
	private CalendarService calendarService;

	/**
	 * 表示用イベントを取得
	 * ダッシュボードカレンダーに表示
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	@GetMapping("/events")
	public List<Map<String, Object>> getEvents(@RequestParam("start") String start, @RequestParam("end") String end) {

		LocalDate startDate = LocalDate.parse(start, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		LocalDate endDate = LocalDate.parse(end, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		
		List<CalendarEntity> events = calendarService.getCalendar(startDate, endDate);

		// 表示用イベントのリスト(JSON変換)
		List<Map<String, Object>> eventList = new ArrayList<>();
		
		//calendar.js用のリストに変換
		for (CalendarEntity clList : events) {
			Map<String, Object> map = new HashMap<>();
			map.put("title", clList.getEventTitle());
			map.put("start", clList.getEventDate().toString());
			eventList.add(map);
		}

		return eventList;
	}
}