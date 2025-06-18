package com.example.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ダッシュボードコントローラークラス
 */
@Controller
public class DashboardController {


	/** ダッシュボード画面の表示 */
	@GetMapping("/dashboard")
	public String getDashboard(Model model) {

		// 今日の日付
		LocalDate today = LocalDate.now();

		// モデルに値を渡す
		model.addAttribute("today", today);

		// Thymeleafテンプレートに遷移
		return "dashboard";
	}
}