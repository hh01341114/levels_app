package com.example.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.domain.entity.UserEntity;
import com.example.service.UserService;

/**
 * コントロールアドバイスクラス
 * コントローラーの共通化をする
 */
@ControllerAdvice
public class ControllAdvice {
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public UserEntity currentUser(@AuthenticationPrincipal UserDetails details) {
		if (details != null) {
			return userService.getUserOne(details.getUsername());
		}
		return null;
	}
}