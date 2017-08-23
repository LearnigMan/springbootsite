package com.example.demowebthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demowebthymeleaf.domain.User;

//@Repository
public interface UserRepository extends JpaRepository<User,String>{
}
