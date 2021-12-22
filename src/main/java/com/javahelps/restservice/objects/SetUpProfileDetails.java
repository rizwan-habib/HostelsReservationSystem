package com.javahelps.restservice.objects;

public class SetUpProfileDetails {
	private String username;
	private String password;
	private String name;
	private String cnic;
	public SetUpProfileDetails() {
		// TODO Auto-generated constructor stub
	}
	public SetUpProfileDetails(String username, String password, String name, String cnic) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.cnic = cnic;
	}
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
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	
}
