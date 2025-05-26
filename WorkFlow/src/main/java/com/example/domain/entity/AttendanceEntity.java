package com.example.domain.entity;

import java.time.LocalDateTime;

import com.example.enums.AttendanceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 勤務情報（attendanceテーブル）を定義する
 */

@Data
@Entity
@Table(name = "attendance")
public class AttendanceEntity {
	
	/**usersテーブルの主キーを定義*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**UserEntityとのリレーション
	 * 外部キーにuser_idを設定
	 */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	private LocalDateTime at;
	
	/*出退勤の値のリレーション
	 * 文字列型に変換する
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private AttendanceType type;
	
}