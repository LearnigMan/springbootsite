package itako.okazu.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@SpringBootApplication
public class DemoWebThymeleafApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoWebThymeleafApplication.class, args);
		String password = "しばうら";
		System.out.println(password);
		System.out.println(":::::::::::::::");
		System.out.println(new Pbkdf2PasswordEncoder().encode(password));
	}

}
