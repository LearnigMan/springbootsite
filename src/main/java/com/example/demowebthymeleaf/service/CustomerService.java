package com.example.demowebthymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demowebthymeleaf.domain.Customer;
import com.example.demowebthymeleaf.domain.User;
import com.example.demowebthymeleaf.repository.CustomerRepository;

@Service //@Componentと同じDIのクラス...Repositoryを呼び出しまっせ
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> findAll(){
		return customerRepository.findAll();
	}

	public Customer findOne(Integer id) {
		return customerRepository.findOne(id);
	}

	public Customer create(Customer customer,User user) {
		customer.setUser(user);
		return customerRepository.save(customer);
	}

	public Customer update(Customer customer,User user) {
		customer.setUser(user);
		return customerRepository.save(customer);
	}

	public void delete(Integer id) {
		customerRepository.delete(id);
	}
}
