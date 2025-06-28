package com.example.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.entity.UserEntity;
import com.example.service.UserService;

/**
 * ダッシュボードコントローラークラス
 */
@Controller
public class DashboardController {
	
	@Autowired
	private UserService userService;

	/** ダッシュボード画面の表示 */
	@GetMapping("/dashboard")
	public String getDashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		
		//ログインユーザー取得
		String email = userDetails.getUsername();
		UserEntity loginUser = userService.getLoginUser(email);

		// 今日の日付
		LocalDate today = LocalDate.now();

		// モデルに値を渡す
		model.addAttribute("today", today);
		model.addAttribute("loginUser", loginUser);

		// Thymeleafテンプレートに遷移
		return "dashboard";
	}
}