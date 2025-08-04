package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * セキュリティコンフィグクラス
 * Spring Securityの設定用クラス
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * パスワードを暗号化する
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
				.antMatchers("/webjars/**")
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/h2-console/**");
	}
	
	/**
	 *セキュリティの各種設定
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//ログイン不要のページ
		http
			.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/user/signup").permitAll()
				.anyRequest().authenticated();
		http
			.formLogin()
			.loginProcessingUrl("/login")
			.loginPage("/login")
			.failureUrl("/login?error")
			.usernameParameter("email")
			.passwordParameter("password")
			.defaultSuccessUrl("/dashboard", true);
		
		http.csrf().disable();
	}
}