package com.example.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "daily_attendance_summary")
public class AttendanceSummaryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;
	
	/**
	 * 出勤日
	 */
	@Column(name = "work_data", nullable = false)
	private LocalDate workDate;
	
	/**
	 * 遅刻フラグ
	 */
	@Column(name = "is_late", nullable = false)
	private Boolean isLate = false;
	
	/**
	 * 欠勤フラグ
	 */
	@Column(name = "is_absent", nullable = false)
	private Boolean isAbsent = false;
	
	/**
	 * 勤務開始
	 */
	@Column(name = "work_start")
	private Integer workStart;
	
	/**
	 * 勤務終了
	 */
	@Column(name = "work_end")
	private Integer workEnd;
	
	/**
	 * 休憩開始
	 */
	@Column(name = "break_start")
	private Integer breakStart;
	
	/**
	 * 休憩終了
	 */
	@Column(name = "break_end")
	private Integer breakEnd;
	
	/**
	 * 備考
	 */
	@Column(name = "remarks")
	private String remarks;
}