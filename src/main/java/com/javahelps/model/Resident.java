package com.javahelps.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
public class Resident {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ResidentID;
	private String name;
    private String password;
    private String username;
    private String cnic;
    private boolean hostelbooked;
    private String hostelname;
    private int roomNo;
    @OneToOne(cascade = CascadeType.ALL)
    private ReservationRequests request;
    public Resident() {
		// TODO Auto-generated constructor stub
    	this.request=null;
    }
	public Resident(String name, String password, String username, String cnic, boolean hostelbooked, String hostelname,
			int roomNo) {
		super();
		this.name = name;
		this.password = password;
		this.username = username;
		this.cnic = cnic;
		this.hostelbooked = hostelbooked;
		this.hostelname = hostelname;
		this.roomNo = roomNo;
		this.request=null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getResidentID() {
		return ResidentID;
	}
	public void setResidentID(int residentID) {
		ResidentID = residentID;
	}
	public ReservationRequests getRequest() {
		return request;
	}
	
	public void setRequest(ReservationRequests request) {
		this.request = request;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public boolean isHostelbooked() {
		return hostelbooked;
	}
	public void setHostelbooked(boolean hostelbooked) {
		this.hostelbooked = hostelbooked;
	}
	public String getHostelname() {
		return hostelname;
	}
	public void setHostelname(String hostelname) {
		this.hostelname = hostelname;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
    
}
