package com.user;

public class User {
	private String name;
	private String password;
	private String passwordSure;
	private String id;
	private String  authory;
	private String  department;
	
	public User(){}
	
	
	public User(String name, String password, String passwordSure, String id,
			String authory, String department) {
		super();
		this.name = name;
		this.password = password;
		this.passwordSure = passwordSure;
		this.id = id;
		this.authory = authory;
		this.department = department;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthory() {
		return authory;
	}
	public void setAuthory(String authory) {
		this.authory = authory;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPasswordSure() {
		return passwordSure;
	}
	public void setPasswordSure(String passwordSure) {
		this.passwordSure = passwordSure;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
