package com.example.controller;

import java.security.PublicKey;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Service.UserService;
import com.example.domain.entity.UserEntity;

/**
 * homare
 */
@Controller
public class DashboardController {

    @Autowired
    private UserService userService;

    /** ダッシュボード画面の表示 */
    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        
        // 仮のログインユーザー（ID: 1）
        UserEntity loginUser = userService.getUserById(1);  // 仮

        // 今日の日付
        LocalDate today = LocalDate.now();

        // モデルに値を渡す
        model.addAttribute("user", loginUser);
        model.addAttribute("today", today);

        // Thymeleafテンプレートに遷移
        return "dashboard";
    }
}