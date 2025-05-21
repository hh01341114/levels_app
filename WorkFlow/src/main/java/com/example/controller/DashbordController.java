package com.example.controller;

import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Service.UserService;

@Controller
public class DashbordController {
	
	@Autowired
	private UserService userService;
	
	//ダッシュボードからのリクエストを受け取る
	@GetMapping("/dashboard")
	public String getDashbord(Model model) {
		
		//dashbord.htmlに画面遷移
		return "dashboard";
	}

}