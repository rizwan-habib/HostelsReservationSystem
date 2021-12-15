package com.javahelps.restservice.entity;

public class SendResponse {
	private String hostelLogin;
	private String username;
	private String status;
	private int roomNo;
	public SendResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getHostelLogin() {
		return hostelLogin;
	}
	public void setHostelLogin(String hostelLogin) {
		this.hostelLogin = hostelLogin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
