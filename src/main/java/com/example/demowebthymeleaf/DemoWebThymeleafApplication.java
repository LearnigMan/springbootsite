package com.example.demowebthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@SpringBootApplication
public class DemoWebThymeleafApplication {
//public class DemoWebThymeleafApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println(new Pbkdf2PasswordEncoder().encode("demo"));
		SpringApplication.run(DemoWebThymeleafApplication.class, args);
	}
}
