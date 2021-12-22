package com.javahelps.restservice.objects;

public class enterRoomDetails {
	private String hostelID;
	private int roomNo;
	private int totalBeds;
	private String roomType;
	private int floorNo;
	
	public enterRoomDetails(String hostelID, int roomNo, int totalBeds, String roomType, int floorNo) {
		super();
		this.hostelID = hostelID;
		this.roomNo = roomNo;
		this.totalBeds = totalBeds;
		this.roomType = roomType;
		this.floorNo = floorNo;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public enterRoomDetails() {
		// TODO Auto-generated constructor stub
	}
	public String getHostelID() {
		return hostelID;
	}
	public void setHostelID(String hostelID) {
		this.hostelID = hostelID;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getTotalBeds() {
		return totalBeds;
	}
	public void setTotalBeds(int totalBeds) {
		this.totalBeds = totalBeds;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
}
