package com.example.demowebthymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demowebthymeleaf.domain.User;
import com.example.demowebthymeleaf.repository.UserRepository;

@Service
public class LoginUserDetailSerivce implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user  = userRepository.findOne(username);
		if(user == null) {
			throw new UsernameNotFoundException("The requested user is no found");
		}
		return new LoginUserDetail(user);


	}


}
