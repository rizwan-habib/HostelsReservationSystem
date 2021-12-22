package com.javahelps.model;

import java.util.ArrayList;



public class Controller {
	private static Controller INSTANCE = null;
	HostelReservationSystem system;
	private Controller() {
		// TODO Auto-generated constructor stub
		system=new HostelReservationSystem();
	}
	public static Controller getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Controller();

		return INSTANCE;
	}
	public static void setINSTANCE(Controller iNSTANCE) {
		INSTANCE = iNSTANCE;
	}
	public String login(String username,String password) {
		return system.login(username, password);
	}
	public String setUpProfile(String name,String cnic,String username,String password) {
			return system.setUpProfile(name, cnic, username, password);
	}
	public String enterHostelDetails(String hostelName,String address,int totalRooms,String username,String password) {
		return system.enterHostelDetails(hostelName, address,totalRooms ,username, password);
	}
	
	public String enterRoomDetails(String hostelID, int roomNo, int totalBeds, String roomType, int floorNo) {
		// TODO Auto-generated method stub
		return system.enterRoomDetails(hostelID, roomNo, totalBeds, roomType, floorNo);
	}
	public ArrayList<Hostel> searchHostel() {
		
		return system.searchHostel();
	}
	public String bookaBed(String hostelLogin, String username, int roomNo) {
		// TODO Auto-generated method stub
		return system.bookaBed(hostelLogin,username,roomNo);
	}
	public ArrayList<Resident> getRequests(String hostelLogin) {
		// TODO Auto-generated method stub
		return system.getRequests(hostelLogin);
	}
	public String sendResponse(String hostelLogin, String username, String status, int roomNo) {
		// TODO Auto-generated method stub
		return system.sendResponse(hostelLogin,username,status,roomNo);
	}
	public String deleteHostel(String hostelLogin) {
		// TODO Auto-generated method stub
		return system.deleteHostel(hostelLogin);
	}
	public Hostel getHostel(String hostelLogin) {
		// TODO Auto-generated method stub
		return system.getHostel(hostelLogin);
	}
}
