package com.example.form;

import java.time.LocalDate;

import lombok.Data;

/**
 * リクエストフォームクラス
 * 有給申請フォーム画面のDTO
 */
@Data
public class RequestForm {
	
	/**
	 * ユーザー名
	 */
	private String name;
	
	/**
	 * 申請対象日
	 */
	private LocalDate targetDate;
	
	/**
	 * 申請理由
	 */
	private String comment;
}