package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.dto.RequestDto;
import com.example.domain.entity.RequestEntity;
import com.example.domain.entity.UserEntity;
import com.example.service.ApprovalsService;
import com.example.service.RequestService;
import com.example.service.UserService;

@Controller
@RequestMapping("/approvals")
public class ApprovalsController {

	@Autowired
	private UserService userService;

	@Autowired
	private ApprovalsService approvalsService;

	@Autowired
	private RequestService requestService;

	/**
	 * 左側に申請したユーザー表示
	 * 
	 * @param userDetails
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String getApprovals(@AuthenticationPrincipal UserDetails userDetails, Model model) {

		// ログインユーザーの取得
		String email = userDetails.getUsername();
		UserEntity loginUser = userService.getLoginUser(email);

		// 全ユーザーの申請を取得表示
		List<UserEntity> userList = requestService.findDistinctUsersWithRequests();

		// modelに渡す
		model.addAttribute("userList", userList);

		return "approvals/list";

	}

	/**
	 * ユーザーの申請情報を表示
	 * @param userId
	 * @return
	 */
	@GetMapping("/user-requests")
	@ResponseBody
	public List<RequestDto> getUserRequests(@RequestParam("id") Integer userId) {
		UserEntity userEntity = userService.getUserById(userId);
		List<RequestEntity> requests = requestService.getUserRequests(userEntity);
		return requests.stream()
						.map(RequestDto::fromEntity)
						.collect(Collectors.toList());
	}
}