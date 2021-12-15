package com.javahelps.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
public class ReservationRequests {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reqID;
	
	private String hostelLogin;
	private String username;
	private int roomNo;
	
	public ReservationRequests() {
		// TODO Auto-generated constructor stub
	}
	
	public int getReqID() {
		return reqID;
	}

	public void setReqID(int reqID) {
		this.reqID = reqID;
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
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	
}
