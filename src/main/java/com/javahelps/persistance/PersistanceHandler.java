package com.javahelps.persistance;

import java.util.ArrayList;
import java.util.List;

import com.javahelps.model.Hostel;
import com.javahelps.model.ReservationRequests;
import com.javahelps.model.Resident;
import com.javahelps.model.Room;


public interface PersistanceHandler {



	public boolean validateUserName(String username);
	public boolean validateAddress(String address);
	public void saveResident(Resident person);
	public void saveHostel(Hostel hostel);
	public boolean validateLogin(String login);
	public ArrayList<Hostel> getHostels();
	public ArrayList<Resident> getResidents();
	public void updateHosteltoDB(Hostel hos, List<Room> list, Room room);

	public boolean getHostelsbyUser(String username, String password);
	public boolean getResidentsbyUser(String username, String password);
	public Hostel getHostelsbyLogin(String username);
	public void updateHostel(Hostel hostel,String hostelLogin, Resident res, int roomNo, ReservationRequests req);
	public Resident getResidentsbyUsername(String username);
	public ArrayList<ReservationRequests> getRequestsbyHostel(String hostelLogin);

	public ArrayList<ReservationRequests> getRequests();

	public void updateHostelafterBooking(Hostel hostel,int roomNo);
	public void deleteRequest(String username);
	public void updateResident(Resident resident);

	public void updateResidentsafterDeletion(Hostel hostel);
}
