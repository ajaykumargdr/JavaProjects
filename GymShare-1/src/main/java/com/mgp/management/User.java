package com.mgp.management;

import jakarta.persistence.*;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	
	@Id
	@Column(name="userId")
	private String userId;
	
	@Column(name="password", nullable=false)  // optional
	private String password;
	
	@Column(name="name") // optional
	private String name;
	
	@Column(name="phone")
	private String phone;
	
	public User() {
		
	}
	
	public String toString() {
		return ("UserId :"+userId+" Password :"+password+" Name :"+name+" Phone "+phone);
	}
	
	public User(String userId, String password, String name, String phone) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
