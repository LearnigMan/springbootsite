package com.example.demowebthymeleaf.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //JAPのエンティティ
@Table(name="customers") //テーブル名指定
@NoArgsConstructor // JPA 引き数のないコンストラクタ
// Lombokを使用しSetter/Getterをセット
@Data
@AllArgsConstructor
public class Customer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue//自動採番
	private Integer id;
	@Column(nullable = false)//NULL制約
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable = true,name = "username")
	private User user;

}
