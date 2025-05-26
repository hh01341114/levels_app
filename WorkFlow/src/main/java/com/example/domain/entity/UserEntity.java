package com.example.domain.entity;

import java.util.List;

import com.example.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 社員情報（usersテーブル）を保持するEntity
 * MYSQLのusersテーブルとマッピングされる
 */

@Data
@Entity
@Table(name="users")
public class UserEntity {
	
	//USERSテーブル（主キー）
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String email;
	private String password;
	private String name;
	private String department_id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;
	
	/**
	 * このユーザーに紐づく打刻一覧（attendanceテーブル）
	 * AttendanceEntity 側の `user` フィールドを参照
	 */
	@OneToMany(mappedBy = "user")
	private List<AttendanceEntity> attendanceList;
}