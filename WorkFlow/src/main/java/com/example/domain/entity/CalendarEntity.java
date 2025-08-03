package com.example.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.domain.enums.CalendarEnum;

import lombok.Data;

@Entity
@Table(name = "holidays")
@Data
public class CalendarEntity {

	/**
	 * 主キー
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * イベントの日付
	 */
	@Column(name = "event_date", nullable = false)
	private LocalDate eventDate;
	
	/**
	 * イベントの名称（祝日の名前とか）
	 */
	@Column(name = "event_title", nullable = false)
	private String eventTitle;
	
	/**
	 * 勤務種類ステータス（出勤日、休日、祝日）
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "event_type", nullable = false)
	private CalendarEnum eventType;
	
	
}