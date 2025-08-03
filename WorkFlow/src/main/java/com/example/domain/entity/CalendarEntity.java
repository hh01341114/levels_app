package com.example.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "holidays")
@Data
public class CalendarEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "event_date", nullable = false)
	private LocalDate eventDate;
	
	@Column(name = "event_title", nullable = false)
	private LocalDate eventTitle;
	
	@Column(name = "event_type", nullable = false)
	private LocalDate eventType;
	
	
}