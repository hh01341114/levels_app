package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Service.UserService;
import com.example.domain.entity.UserEntity;
import com.example.form.UserDetailForm;

/**
 * ディテールビューコントローラークラス
 * ユーザー詳細画面（表示のみ）を表示する
 */
@Controller
@RequestMapping("/user")
public class DetaileViewController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * ユーザー詳細画面（表示用）のユーザー情報取得
	 * @param form
	 * @param model
	 * @param email
	 * @return user/detailview
	 */
	@GetMapping("/detailview/{email:.+}")
	public String viewUser(UserDetailForm form, Model model, @PathVariable String email) {
		UserEntity userEntity = userService.getUserOne(email);
		
		//formに変換
		form = modelMapper.map(userEntity, UserDetailForm.class);
		
		//Modelに登録
		model.addAttribute("userDetailForm", form);		
		
		return "user/detailview";
	}
}