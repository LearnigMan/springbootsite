package itako.okazu.web.service;

import org.springframework.security.core.authority.AuthorityUtils;

import itako.okazu.web.entity.Quiz;

public class LoginUserDetail extends org.springframework.security.core.userdetails.User {

	private final Quiz quiz;

	public LoginUserDetail(Quiz quiz) {
		super(quiz.id.toString(), quiz.encodedPassword, AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.quiz = quiz;
	}
}
