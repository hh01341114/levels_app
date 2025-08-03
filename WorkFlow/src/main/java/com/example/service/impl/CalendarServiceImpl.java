package com.example.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.entity.CalendarEntity;
import com.example.repository.CalendarRepository;
import com.example.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService {
	
	@Autowired
	private CalendarRepository calendarRepository;

	public List<CalendarEntity> getCalendar(LocalDate start, LocalDate end) {
		return calendarRepository.findByEventDateBetween(start, end);
	}
}