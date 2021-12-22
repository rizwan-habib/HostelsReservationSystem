package com.javahelps.restservice.objects;

public class UpdateHostelDetails {
	private String hostelLogin;
	private int roomNo;
	private String prevStatus;
	
	public UpdateHostelDetails() {
		// TODO Auto-generated constructor stub
	}
	public String getHostelLogin() {
		return hostelLogin;
	}
	public void setHostelLogin(String hostelLogin) {
		this.hostelLogin = hostelLogin;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getPrevStatus() {
		return prevStatus;
	}
	public void setPrevStatus(String prevStatus) {
		this.prevStatus = prevStatus;
	}
	
}
