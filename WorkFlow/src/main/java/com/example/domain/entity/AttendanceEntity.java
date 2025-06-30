package com.example.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.domain.enums.AttendanceType;

import lombok.Data;
import lombok.ToString;

/**
 * 勤務情報（attendanceテーブル）を定義する
 */
@Data
@ToString(exclude = "userEntity")
@Entity
@Table(name = "attendance")
public class AttendanceEntity {

	/**
	 * usersテーブルの主キーを定義
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * UserEntityとのリレーション (外部キーにid)を設定
	 */
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity userEntity;

	private LocalDateTime at;
	
	/**
	 * 日付
	 * 打刻の追加更新用の日付
	 */
	@Column(name = "work_date", nullable = false)
	private LocalDate workDate;

	/*
	 * 出退勤の値のリレーション 文字列型に変換する
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private AttendanceType type;
}