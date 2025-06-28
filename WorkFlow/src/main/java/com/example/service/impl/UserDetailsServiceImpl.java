package com.example.service.impl;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.example.domain.entity.UserEntity;
import com.example.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity user = userService.getLoginUser(email);
		if (user == null) {
			throw new UsernameNotFoundException("Not found: " + email);
		}

		// Roleが Enum型の場合、toString()がROLE_GENERALなどを返しているか確認
		String role = "ROLE_" + user.getRole().name();

		return User.builder()
				.username(user.getEmail())
				.password(user.getPassword())
				.authorities(Collections.singletonList(new SimpleGrantedAuthority(role)))
				.build();
	}
}