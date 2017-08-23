package com.example.demowebthymeleaf.service;

import org.springframework.security.core.authority.AuthorityUtils;

import com.example.demowebthymeleaf.domain.User;

import lombok.Data;

@Data
public class LoginUserDetail extends org.springframework.security.core.userdetails.User {
	private final User user;

	public LoginUserDetail(User user) {
		super(user.getUsername(),user.getEncodedPassword(),AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}
}
