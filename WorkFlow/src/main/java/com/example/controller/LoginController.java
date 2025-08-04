package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ログインコントローラークラス
 * ログイン画面用のコントローラークラス
 */
@Controller
public class LoginController {
	
	/**
	 * ログイン画面を表示
	 * @return
	 */
	@GetMapping("/login")
	public String getLogin() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String postLogin() {
		return "redirect:/user/dashboard";
	}
}