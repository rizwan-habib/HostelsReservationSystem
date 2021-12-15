package com.javahelps.restservice.entity;

import java.util.List;

import com.javahelps.model.Room;

public class enterHostelDetails {
	private int totalRooms;
    
	private String address;
	    
	private String hostelName;
	
	private String login;
	    
	private String password;
	public enterHostelDetails() {
		// TODO Auto-generated constructor stub
	}
	public int getTotalRooms() {
		return totalRooms;
	}
	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHostelName() {
		return hostelName;
	}
	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
