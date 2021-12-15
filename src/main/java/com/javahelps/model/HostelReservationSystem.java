package com.javahelps.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.catalina.Host;

public class HostelReservationSystem {
	private ArrayList<Hostel> Hostels=new ArrayList();
    private ArrayList<Resident> residents=new ArrayList();
    private PersistanceHandler persistancehandler;
    public HostelReservationSystem() {
		// TODO Auto-generated constructor stub
    	persistancehandler=new PersistanceHandler();
    }
    public String login(String username,String password) {
		return validateLogin(username,password);
	}
    private String validateLogin(String username, String password) {
		boolean flag=persistancehandler.getHostelsbyUser(username,password);
		if (flag) {
			flag=persistancehandler.getResidentsbyUser(username,password);
		}
		else {
			return "hostel";
		}
		if(flag) {
			return "resident";
		}
		return "none";
	}
	private boolean validateUser(String username) {
        	return persistancehandler.validateUserName(username);	
	}
    public String setUpProfile(String name,String cnic,String username,String password) {
		if (! validateUser(username) ) {
			return 	"false";
		}
		Resident resi=new Resident();
		resi.setName(username);
		resi.setCnic(cnic);
		resi.setUsername(username);
		resi.setPassword(password);
		resi.setHostelbooked(false);
		resi.setHostelname("");
		resi.setRoomNo(0);
		
		residents.add(resi);
		persistancehandler.saveResident(resi);
		return "success";	
	}
    public boolean validateHostel(String address) {
    	return persistancehandler.validateAddress(address);	
    }
    public boolean validateHostellogin(String login) {
    	return persistancehandler.validateLogin(login);	
    }
    public String enterHostelDetails(String hostelName,String address,int totalRooms,String username,String password) {
    	if (! validateHostel(address) ) {
			return 	"address_false";
		}
    	if (! validateHostellogin(username) ) {
			return 	"login_false";
		}
		Hostel host=new Hostel();
		host.setAddress(address);
		host.setLogin(username);
		host.setPassword(password);
		host.setHostelName(hostelName);
		host.setTotalRooms(totalRooms);
//		host.setFull(false);
		host.setRooms(null);
		Hostels.add(host);
		persistancehandler.saveHostel(host);
		return "success";
    }
    public String enterRoomDetails(String hostelID, int roomNo, int totalBeds, String roomType, int floorNo) {
		// TODO Auto-generated method stub
		Hostels=persistancehandler.getHostels();
		Hostel hos=new Hostel();
		
		for (int i = 0; i < Hostels.size(); i++) {
			if (hostelID.equals(Hostels.get(i).getLogin())) {
				hos=Hostels.get(i);
			}
		}
		if (hos.getTotalRooms()<roomNo) {
			
			return "invalidRoomNo";
		}
		if(hos.getRooms().size()>=hos.getTotalRooms()) {
			return "full";
		}
		else {
			for (int i = 0; i < hos.getRooms().size(); i++) {
				if (hos.getRooms().get(i).getRoomNo()==roomNo) {
					return "same";
				}
				
			}
		}
		Room r=new Room();
		r.setRoomNo(roomNo);
		r.setTotalBeds(totalBeds);
		r.setFloorNo(floorNo);
		r.setFull(false);
		r.setRoomType(roomType);
		r.setBookedBeds(0);
		List<Room> list = hos.enterHostelDetails(roomNo,totalBeds,roomType,floorNo);
    	updateHosteltoDB(hos,list,r);
		return "true";
	}
	private void updateHosteltoDB(Hostel hos,List<Room> list,Room r) {
		// TODO Auto-generated method stub
		persistancehandler.updateHosteltoDB(hos,list,r);
	}
	public ArrayList<Hostel> searchHostel() {
		// TODO Auto-generated method stub
		ArrayList<Hostel> res=persistancehandler.getHostels();
		ArrayList<Hostel> res1=new ArrayList<>();
		
		if(res!=null) {
			for (int i = 0; i < res.size(); i++) {
				for (int j = 0; j < res.get(i).getRooms().size(); j++) {
					res.get(i).getRooms().get(j).setHostel(null);
				}
			}
			for (int i = 0; i < res.size(); i++) {
				
				ArrayList<Room> rooms=new ArrayList<>();
				for (int j = 0; j < res.get(i).getRooms().size(); j++) {
					if (! res.get(i).getRooms().get(j).isFullorNot()) {
						rooms.add(res.get(i).getRooms().get(j));
					}
				}
				if (res.get(i).isFullorNot()) {
					res.get(i).setRooms(rooms);

					res1.add(res.get(i));
				}
			}
		}
		
		
		return res;
	}
	public String bookaBed(String hostelLogin, String username, int roomNo) {
		// TODO Auto-generated method stub
		Hostel hostel=persistancehandler.getHostelsbyLogin(hostelLogin);
		Resident res=persistancehandler.getResidentsbyUsername(username);
		if (res.getRequest()!=null || res.isHostelbooked()) {
			return "false";
		}
		ReservationRequests requests= hostel.selectRoom(hostelLogin,username,roomNo);
		res.setRequest(requests);
		hostel.isFullorNot();
		persistancehandler.updateHostel(hostel,hostelLogin,res,roomNo,requests);
		return "true";
	}
	public ArrayList<Resident> getRequests(String hostelLogin) {
		// TODO Auto-generated method stub
		ArrayList<ReservationRequests> req=persistancehandler.getRequestsbyHostel(hostelLogin);
		residents=persistancehandler.getResidents();
		ArrayList<Resident> res=new ArrayList<>();
		for (int i = 0; i < req.size(); i++) {
			for (int j = 0; j < residents.size(); j++) {
				if(residents.get(j).getUsername().equals(req.get(i).getUsername())) {
					res.add(residents.get(j));
				}
			}
		}
		return res;
	}
	public String sendResponse(String hostelLogin, String username, String status,int roomNo) {
		// TODO Auto-generated method stub
		ArrayList<Resident> res=persistancehandler.getResidents();
		ArrayList<Hostel> hos=persistancehandler.getHostels();
		
//			ArrayList<ReservationRequests> req=persistancehandler.getRequests();
		Resident resident=new Resident();
		Hostel hostel =new Hostel();
		for (int i = 0; i < hos.size(); i++) {
			if (hos.get(i).getLogin().equals(hostelLogin)) {
				hostel=hos.get(i);
			}
		}
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i).getUsername().equals(username)) {
				resident=res.get(i);
			}
			
		}
		if (status.equals("true")) {
			resident.setHostelbooked(true);
			resident.setHostelname(hostel.getHostelName());
			resident.setRoomNo(roomNo);
			System.out.println("truetrue!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			
		}
		else {
			for (int j = 0; j < hostel.getRooms().size(); j++) {
				if (hostel.getRooms().get(j).getRoomNo()==roomNo) {
					hostel.getRooms().get(j).setBookedBeds(hostel.getRooms().get(j).getBookedBeds()-1);
				}
			}
		}
		resident.setRequest(null);
//		break;
		hostel.isFullorNot();
		persistancehandler.updateResident(resident);
		persistancehandler.updateHostelafterBooking(hostel,roomNo);
		persistancehandler.deleteRequest(username);
		return "done";
	}
	public String deleteHostel(String hostelLogin) {
		// TODO Auto-generated method stub
		Hostels=persistancehandler.getHostels();
		Hostel hostel=new Hostel();
		for (int i = 0; i < Hostels.size(); i++) {
			if (hostelLogin.equals(Hostels.get(i).getLogin())) {
				hostel=Hostels.get(i);
			}
		}
		persistancehandler.updateResidentsafterDeletion(hostel);
//		persist
		return "true";
	}
	public Hostel getHostel(String hostelLogin) {
		// TODO Auto-generated method stub
		ArrayList<Hostel> res=persistancehandler.getHostels();
		Hostel hostel=new Hostel();
		for (int j = 0; j < res.size(); j++) {
			if (res.get(j).getLogin().equals(hostelLogin)) {
				hostel=res.get(j);
			}
		}
		for (int j = 0; j < hostel.getRooms().size(); j++) {
			hostel.getRooms().get(j).setHostel(null);
		}
		return hostel;
	}
	
	
}
