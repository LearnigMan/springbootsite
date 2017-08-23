package com.example.demowebthymeleaf.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //JAPのエンティティ
@Table(name="users") //テーブル名指定
@NoArgsConstructor // JPA 引き数のないコンストラクタ
// Lombokを使用しSetter/Getterをセット
@ToString(exclude="customers") // JPA 引き数のないコンストラクタ
@Data
@AllArgsConstructor
public class User implements Serializable{

	@Id
	private String username;
	@JsonIgnore
	private String encodedPassword;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY ,mappedBy="user")
	// 1対多
	private List<Customer> customers;

}
