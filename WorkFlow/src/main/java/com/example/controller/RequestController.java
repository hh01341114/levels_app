package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.entity.UserEntity;
import com.example.domain.enums.RequestKind;
import com.example.form.RequestForm;
import com.example.service.RequestService;
import com.example.service.UserService;

@Controller
@RequestMapping("/requests")
public class RequestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RequestService requestService;
	
	/**
	 * 申請種類選択
	 * @param kind
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/kind")
	public String kind(
			@RequestParam("kind") String kind, 
			@AuthenticationPrincipal UserDetails userDetails, 
			Model model
			) {
		String email = userDetails.getUsername();
		UserEntity loginUser = userService.getLoginUser(email);
		
		//String型からENUM型に変換して渡す
		RequestKind requestKind = RequestKind.valueOf(kind);
		
		model.addAttribute("requestKind", requestKind);
		model.addAttribute("loginUser", loginUser);
		
		return "requests/kind";
	}
	
	@PostMapping("paidleave")
	public String paidLeave(
			@ModelAttribute RequestForm requestForm,
			@AuthenticationPrincipal UserDetails userDetails) {
		
		String email = userDetails.getUsername();
		UserEntity loginUser = userService.getLoginUser(email);
		
		requestService.savePaidLeaveRequest(loginUser, requestForm);
		
		return "redirect:/requests/kind";
	}
}