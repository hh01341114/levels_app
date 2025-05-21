package com.example.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}