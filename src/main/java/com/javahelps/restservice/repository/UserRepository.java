package com.javahelps.restservice.repository;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javahelps.model.Controller;
import com.javahelps.model.Hostel;
import com.javahelps.model.Resident;
import com.javahelps.restservice.objects.LoginDetails;
import com.javahelps.restservice.objects.LoginReturn;
import com.javahelps.restservice.objects.SendResponse;
import com.javahelps.restservice.objects.SetUpProfileDetails;
import com.javahelps.restservice.objects.bookaBedDetails;
import com.javahelps.restservice.objects.enterHostelDetails;
import com.javahelps.restservice.objects.enterRoomDetails;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserRepository {
	Controller systemController;
	
	public UserRepository() {
		super();
		this.systemController = Controller.getInstance();
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginReturn login(@RequestBody LoginDetails loginDetails) {
		LoginReturn ret =new LoginReturn();
		ret.setType(systemController.login(loginDetails.getUsername(),loginDetails.getPassword()));
		ret.setUsername(loginDetails.getUsername());
		return ret;

	}
	
	@RequestMapping(value = "/setUpProfile", method = RequestMethod.POST)
	public String setUpProfile(@RequestBody SetUpProfileDetails obj) {
		return systemController.setUpProfile(obj.getName(), obj.getCnic(), obj.getUsername(), obj.getPassword());	
	}
	
	@RequestMapping(value = "/enterHostelDetails", method = RequestMethod.POST)
	public String enterHostelDetails(@RequestBody enterHostelDetails obj) {
		return systemController.enterHostelDetails(obj.getHostelName(), obj.getAddress(),obj.getTotalRooms(), obj.getLogin(), obj.getPassword());	
	}
	
	@RequestMapping(value = "/enterRoomDetails", method = RequestMethod.POST)
	public String enterRoomDetails(@RequestBody enterRoomDetails obj) {
		return systemController.enterRoomDetails(obj.getHostelID(), obj.getRoomNo(),obj.getTotalBeds(), obj.getRoomType(),obj.getFloorNo());	
	}
	
	@RequestMapping(value = "/searchHostel", method = RequestMethod.POST)
	public ArrayList<Hostel>  searchHostel() {
		ArrayList<Hostel> ret =systemController.searchHostel();
		return ret;
	}
	@RequestMapping(value = "/bookABed", method = RequestMethod.POST)
	public String bookABed(@RequestBody bookaBedDetails obj) {
		return systemController.bookaBed(obj.getHostelLogin(),obj.getUsername(),obj.getRoomNo());
	}
	@RequestMapping(value = "/getRequests", method = RequestMethod.POST)
	public ArrayList<Resident> getRequests(@RequestBody bookaBedDetails obj) {
		return systemController.getRequests(obj.getHostelLogin());
	}
	@RequestMapping(value = "/sendResponse", method = RequestMethod.POST)
	public String sendResponse(@RequestBody SendResponse obj) {
		return systemController.sendResponse(obj.getHostelLogin(),obj.getUsername(),obj.getStatus(),obj.getRoomNo());
	}
	
	@RequestMapping(value = "/deleteHostel", method = RequestMethod.POST)
	public String deleteHostel(@RequestBody SendResponse obj) {
		return systemController.deleteHostel(obj.getHostelLogin());
	}
	
//	@RequestMapping(value = "/deleteHostel", method = RequestMethod.POST)
//	public String updateHostel(@RequestBody UpdateHostelDetails obj) {
//		return systemController.deleteHostel(obj.getHostelLogin(),obj.getRoomNo(),obj.getPrevStatus());
//	}
	
}