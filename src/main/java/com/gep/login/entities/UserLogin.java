package com.gep.login.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
public class UserLogin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String user_name;
	private String password;
	private String role;
	public UserLogin(int id, String user_name, String password, String role) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
		this.role = role;
	}
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
	
}
