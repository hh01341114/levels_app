package com.example.form;

import lombok.Data;

@Data
public class UserDetailForm {
	
	/**
	 * ユーザーid
	 */
	private String email;
	
	/**
	 * パスワード
	 */
	private String password;
	
	/**
	 * ユーザー名
	 */
	private String name;
	
	/**
	 * 部署名
	 */
	private Integer departmentId;
}