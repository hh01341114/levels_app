package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Service.AttendanceService;
import com.example.Service.UserService;
import com.example.domain.entity.AttendanceEntity;
import com.example.domain.entity.UserEntity;
import com.example.enums.AttendanceType;

/**
 * アテンダンスコントローラー
 * 勤怠打刻を管理する
 */
@Controller
@RequestMapping("/attendance")
public class AttendanceController {
	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 打刻情報を扱う
	 * 打刻したログインユーザーの取得
	 * @param type
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/punch")
	public String punch(
			@RequestParam("type") String type, 
			@AuthenticationPrincipal UserDetails userDetails
			) {
		String email = userDetails.getUsername();
		UserEntity loginUser = userService.getLoginUser(email);
		
		//String型からenum型に変換して渡す
		AttendanceType attendanceType = AttendanceType.valueOf(type);
		attendanceService.recordPunch(loginUser.getId(), attendanceType);
		
		return "redirect:/attendance/history";
	}
	
	@GetMapping("/history")
	public String getHistory(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		String email = userDetails.getUsername();
		UserEntity loginUser = userService.getLoginUser(email);
		
		List<AttendanceEntity> history = attendanceService.getAttendanceHistory(loginUser.getId());
		
		model.addAttribute("history", history);
		
		return "attendance/history";
	}
}