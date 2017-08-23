package com.example.demowebthymeleaf.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demowebthymeleaf.domain.Customer;
import com.example.demowebthymeleaf.service.CustomerService;
import com.example.demowebthymeleaf.service.LoginUserDetail;

@Controller
@RequestMapping("customers") // APIのパス指定
public class CustomerController {
	@Autowired
	CustomerService customerService;

	//Formの初期化 モデルはあくまで表示するものを格納する場所
	@ModelAttribute
	CustomerForm setUpform() {
		return  new CustomerForm();
	}

	//リスト画面
	@GetMapping
	String list(Model model){
	List<Customer> customers = customerService.findAll();
	model.addAttribute("customers", customers);
	return "customers/list";
	}

	//リスト画面
	@GetMapping(value = "/create")
	String create(Model model){
		return "customers/register";
	}

	@PostMapping(path="create")
	String create(@Validated CustomerForm form,BindingResult result,Model model,
			@AuthenticationPrincipal  LoginUserDetail userDetails) {
		if(result.hasErrors()) {
			return create(model);
		}
		Customer customer = new Customer();
		// 他にもDozerやModelMapperがある
		// フォームの内容をエンティティクラスへコピー
		BeanUtils.copyProperties(form,customer);
		customerService.create(customer,userDetails.getUser());
		return "redirect:/customers";
	}

	// 編集画面は、FROMから作成する。新規画面は、MODELから作成する。
	@GetMapping(path="edit" ,params ="form")
	String editForm(@RequestParam Integer id,CustomerForm form) {
		Customer customer = customerService.findOne(id);
		BeanUtils.copyProperties(customer,form);
		return "customers/edit";
	}

	@PostMapping(path="edit")
	String edit(@RequestParam Integer id,
			    @Validated CustomerForm form,
			    BindingResult result,Model model,
			    @AuthenticationPrincipal  LoginUserDetail userDetails) {

		if(result.hasErrors()) {
			return editForm(id,form);
		}
		Customer customer = new Customer();
		// 他にもDozerやModelMapperがある
		// フォームの内容をエンティティクラスへコピー
		BeanUtils.copyProperties(form,customer);
		customer.setId(id);
		customerService.update(customer,userDetails.getUser());
		return "redirect:/customers";
	}

	@GetMapping(path="edit" ,params ="top")
	String goToTop() {
		return "customers/edit";
	}

	@PostMapping(path="delete")
	String delete(@RequestParam Integer id) {
		customerService.delete(id);
		return "redirect:/customers";
	}

	//
	/*
	//1件取得
	@GetMapping(path = "{id}")
	Customer getCustomer(@PathVariable Integer id) {
		Customer customer = customerService.findOne(id);
		return customer;
	}

	//POST登録
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Customer postCustomers(@RequestBody Customer customer) {
		return customerService.create(customer);
	}

	//POST更新
	@PostMapping(path = "{id}")
	Customer postCustomer(@PathVariable Integer id,@RequestBody Customer customer) {
		customer.setId(id);
		return customerService.update(customer);
	}

	//POST削除
	@DeleteMapping(path = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteCustomer(@PathVariable Integer id) {
		customerService.delete(id);
	}

*/


}
