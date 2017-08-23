package com.example.demowebthymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@EnableWebSecurity //SpringSecurityの設定
public class SecurityConfig extends WebSecurityConfigurerAdapter{ //追加部分だけOverride

	@Override
	// configureで特定部分のセキュリティ無視（静的リソース）
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/webjars/**","/css/**");
	}

	@Override
	// ログインの設定
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/loginForm").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginProcessingUrl("/login")
		 .loginPage("/loginForm")
		 .failureUrl("/loginForm?error")
		 .defaultSuccessUrl("/customers",true)
		 .usernameParameter("username").passwordParameter("password")
		.and()
		 .logout()
		  .logoutSuccessUrl("/loginForm");
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new Pbkdf2PasswordEncoder();
	}
}

