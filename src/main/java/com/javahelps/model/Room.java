package com.javahelps.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roomID;
	
	private String roomType;
    private int roomNo;
    private int floorNo;
    private int totalBeds;
    private boolean isFull;
    private int bookedBeds;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Hostel hostel;
    public Room() {
		// TODO Auto-generated constructor stub
    	totalBeds=0;
    	bookedBeds=0;
    	isFullorNot();
	}
    
	public int getBookedBeds() {
		return bookedBeds;
	}

	public void setBookedBeds(int bookedBeds) {
		this.bookedBeds = bookedBeds;
	}

	public Hostel getHostel() {
		return hostel;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public boolean isFullorNot() {
		if (bookedBeds>=totalBeds) {
			isFull=true;
		}
		isFull=false;
		return isFull;
	}
	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}

	public int getTotalBeds() {
		return totalBeds;
	}

	public void setTotalBeds(int totalBeds) {
		this.totalBeds = totalBeds;
	}

	public void selectbed() {
		// TODO Auto-generated method stub
		bookedBeds++;
		isFullorNot();
	}
	
    
}
