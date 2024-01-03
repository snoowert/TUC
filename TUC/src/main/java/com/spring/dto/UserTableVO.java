package com.spring.dto;

public class UserTableVO {
	private String username;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String membership;
	private char isuser;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
	public char getIsuser() {
		return isuser;
	}
	public void setIsuser(char isuser) {
		this.isuser = isuser;
	}
	
}
