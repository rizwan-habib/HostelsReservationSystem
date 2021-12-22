package com.javahelps.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Hostel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int HostelID;
//	@OneToMany()
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER,  mappedBy="hostel")
	private List<Room> Rooms;
	@Transient
	private ArrayList<ReservationRequests> Requests=new ArrayList<>();
    
    private int totalRooms;
    
    private String address;
    
    private String hostelName;

//    private boolean isFull;
    
    private String login;
    
    private String password;
    
    public Hostel() {
		// TODO Auto-generated constructor stub
//    	isFullorNot();
	}
    
	public Hostel(int hostelID, List<Room> rooms, int totalRooms, String address, String hostelName,
			String login, String password) {
		super();
		HostelID = hostelID;
		Rooms = rooms;
		this.totalRooms = totalRooms;
		this.address = address;
		this.hostelName = hostelName;
//		this.isFull = isFull;
		this.login = login;
		this.password = password;
	}

	public int getHostelID() {
		return HostelID;
	}

	public void setHostelID(int hostelID) {
		HostelID = hostelID;
	}

	public List<Room> getRooms() {
		return Rooms;
	}

	public void setRooms(List<Room> rooms) {
		Rooms = rooms;
	}

	public int getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}

	public List<ReservationRequests> getRequests() {
		return Requests;
	}

	public void setRequests(ArrayList<ReservationRequests> requests) {
		Requests = requests;
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

	
	public boolean isFullorNot() {
		boolean flag=true;
		for (int i = 0; i < Rooms.size(); i++) {
			if(Rooms.get(i).isFullorNot()) {
				flag=false;
			}
		}
		return flag;
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

	@SuppressWarnings("rawtypes")
	public List<Room> enterHostelDetails(int roomNo, int totalBeds, String roomType, int floorNo) {
		// TODO Auto-generated method stub
		ArrayList<Room> res=new ArrayList<Room>();
        for (Iterator iterator = Rooms.iterator(); iterator.hasNext();) {
			res.add((Room) iterator.next());      	
		}
		Room room=new Room();
		room.setRoomNo(roomNo);
		room.setFloorNo(floorNo);
		room.setFull(false);
		room.setRoomType(roomType);
		room.setTotalBeds(totalBeds);
		res.add(room);
		setRooms(res);
		return Rooms;
	}

	public ReservationRequests selectRoom(String hostelLogin, String username, int roomNo) {
		// TODO Auto-generated method stub
		Room room =new Room();
		for (int i = 0; i < Rooms.size(); i++) {
			if(Rooms.get(i).getRoomNo()==roomNo) {
				room=Rooms.get(i);
			}
		}
		room.selectbed();
		return sendReservationRequest(hostelLogin,username,roomNo);
	}

	private ReservationRequests sendReservationRequest(String hostelLogin, String username, int roomNo) {
		// TODO Auto-generated method stub
		ReservationRequests req=new ReservationRequests();
		req.setHostelLogin(hostelLogin);
		req.setUsername(username);
		req.setRoomNo(roomNo);
		Requests.add(req);
		return req;
	}
    
    
}
