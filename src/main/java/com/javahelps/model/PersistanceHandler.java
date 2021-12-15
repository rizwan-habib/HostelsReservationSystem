package com.javahelps.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersistanceHandler {
	private SessionFactory sf;

	public PersistanceHandler() {
		// TODO Auto-generated constructor stub
		Configuration con = new Configuration();
		con.configure().addAnnotatedClass(Resident.class);
		con.configure().addAnnotatedClass(Hostel.class);
		con.configure().addAnnotatedClass(ReservationRequests.class);
		con.configure().addAnnotatedClass(Room.class);
		sf = con.buildSessionFactory();
	}

	public boolean validateUserName(String username) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List residents = session.createQuery("from Resident where username = :user").setParameter("user", username)
				.list();

		trans.commit();
		session.close();
		if (residents.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean validateAddress(String address) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List hostels = session.createQuery("from Hostel where address = :user").setParameter("user", address).list();

		trans.commit();
		session.close();
		if (hostels.isEmpty()) {
			return true;
		}
		return false;
	}

	public void saveResident(Resident person) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		session.save(person);
		trans.commit();
		session.close();
	}

	public void saveHostel(Hostel hostel) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		session.save(hostel);
		trans.commit();
		session.close();
	}

	public boolean validateLogin(String login) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List hostels = session.createQuery("from Hostel where login = :user").setParameter("user", login).list();

		trans.commit();
		session.close();
		if (hostels.isEmpty()) {
			return true;
		}

		return false;
	}

	public ArrayList<Hostel> getHostels() {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List hostels = session.createQuery("from Hostel").list();
		trans.commit();
		session.close();
		ArrayList<Hostel> res = new ArrayList<Hostel>();
		for (Iterator iterator = hostels.iterator(); iterator.hasNext();) {
			res.add((Hostel) iterator.next());
		}
		if (hostels.isEmpty()) {
			return null;
		}
		return res;
	}
	public ArrayList<Resident> getResidents() {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List resident = session.createQuery("from Resident").list();
		trans.commit();
		session.close();
		ArrayList<Resident> res = new ArrayList<Resident>();
		for (Iterator iterator = resident.iterator(); iterator.hasNext();) {
			res.add((Resident) iterator.next());
		}
		if (resident.isEmpty()) {
			return null;
		}
		return res;
	}
	public void updateHosteltoDB(Hostel hos, List<Room> list, Room room) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		Hostel hostel = session.get(Hostel.class, hos.getHostelID());
		hostel.setRooms(list);
//        hostel=hos;
		room.setHostel(hostel);
		session.saveOrUpdate(hostel);
		session.saveOrUpdate(room);
//		for (int i = 0; i < hostel.getRequests().size(); i++) {
//			session.saveOrUpdate(hostel.getRequests().get(i));
//		}
		trans.commit();
		session.close();
	}

	public boolean getHostelsbyUser(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List hostels = session.createQuery("from Hostel where login = :user and password = :pass")
				.setParameter("user", username).setParameter("pass", password).list();

		trans.commit();
		session.close();
		if (hostels.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean getResidentsbyUser(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List residents = session.createQuery("from Resident where username = :user and password = :pass")
				.setParameter("user", username).setParameter("pass", password).list();

		trans.commit();
		session.close();
		if (residents.isEmpty()) {
			return false;
		}
		return true;
	}
	public Hostel getHostelsbyLogin(String username) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List residents = session.createQuery("from Hostel where login = :user")
				.setParameter("user", username).list();
//		Hostel hostel = session.get(Hostel.class, username);

		trans.commit();
		session.close();
		
		return (Hostel) residents.get(0);
	}

	public void updateHostel(Hostel hostel,String hostelLogin, Resident res, int roomNo, ReservationRequests req) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		Hostel hos = session.get(Hostel.class, hostel.getHostelID());
		
        hos.selectRoom(hostelLogin,res.getUsername(), roomNo);
		session.saveOrUpdate(hos);
		for (int i = 0; i < hos.getRooms().size(); i++) {
			session.saveOrUpdate(hos.getRooms().get(i));
		}
		Resident res1 = session.get(Resident.class, res.getResidentID());
		
        res1.setRequest(req);;
		session.saveOrUpdate(res1);
		
		
		trans.commit();
		session.close();
	}

	public Resident getResidentsbyUsername(String username) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List residents = session.createQuery("from Resident where username = :user")
				.setParameter("user", username).list();
//		Hostel hostel = session.get(Hostel.class, username);

		trans.commit();
		session.close();
		
		return (Resident) residents.get(0);
	}

	public ArrayList<ReservationRequests> getRequestsbyHostel(String hostelLogin) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List residents = session.createQuery("from ReservationRequests where hostelLogin = :user")
				.setParameter("user", hostelLogin).list();
//		Hostel hostel = session.get(Hostel.class, username);

		trans.commit();
		session.close();
		ArrayList<ReservationRequests> res = new ArrayList<ReservationRequests>();
		for (Iterator iterator = residents.iterator(); iterator.hasNext();) {
			res.add((ReservationRequests) iterator.next());
		}
		if (residents.isEmpty()) {
			return null;
		}
		return res;
	}

	public ArrayList<ReservationRequests> getRequests() {
		
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List resident = session.createQuery("from ReservationRequests").list();
		trans.commit();
		session.close();
		ArrayList<ReservationRequests> res = new ArrayList<ReservationRequests>();
		for (Iterator iterator = resident.iterator(); iterator.hasNext();) {
			res.add((ReservationRequests) iterator.next());
		}
		if (resident.isEmpty()) {
			return null;
		}
		return res;
	
	}

	public void updateHostelafterBooking(Hostel hostel,int roomNo) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		Hostel hos = session.get(Hostel.class, hostel.getHostelID());
		
		for (int i = 0; i < hos.getRooms().size(); i++) {
			if(hos.getRooms().get(i).getRoomNo()==roomNo) {
				for (int j = 0; j < hostel.getRooms().size(); j++) {
					if (hostel.getRooms().get(j).getRoomNo()==roomNo) {
						hos.getRooms().get(i).setBookedBeds(hostel.getRooms().get(j).getBookedBeds());
//						break;
					}
					
				}
//				break;
			}
			
		}
//        hos.s(hostelLogin,res.getUsername(), roomNo);
		session.saveOrUpdate(hos);
//		for (int i = 0; i < hos.getRooms().size(); i++) {
//			session.saveOrUpdate(hos.getRooms().get(i));
//		}
//		
//		session.saveOrUpdate(hos);
		
		
		trans.commit();
		session.close();

	}

	public void deleteRequest(String username) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List requests = session.createQuery("from ReservationRequests where username = :use").setParameter("use", username).list();
		ReservationRequests res=(ReservationRequests) requests.get(0);
		ReservationRequests hos = session.get(ReservationRequests.class, res.getReqID());
//		
		
		session.delete(hos);
//		ArrayList<ReservationRequests> res = new ArrayList<>();
//		for (Iterator iterator = requests.iterator(); iterator.hasNext();) {
//			res.add((ReservationRequests) iterator.next());
////			System.out.print();
//		}
//		for (int i = 0; i < res.size(); i++) {
//			System.out.println(username);
//		}
		
		
		trans.commit();
		session.close();
		
	}

	public void updateResident(Resident resident) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		Resident hos = session.get(Resident.class, resident.getResidentID());
		
		hos.setHostelbooked(resident.isHostelbooked());
		hos.setHostelname(resident.getHostelname());
		hos.setRoomNo(resident.getRoomNo());
		hos.setRequest(resident.getRequest());
//		System.out.println("truetrue!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		
        session.saveOrUpdate(hos);
		
		
		trans.commit();
		session.close();
	}

	public void updateResidentsafterDeletion(Hostel hostel) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
//		Resident hos = session.get(Resident.class, resident.getResidentID());
		
		String hql = "update Resident set hostelname=null,roomNo=0,hostelbooked=0 where hostelname = :user";
		session.createQuery(hql).setParameter("user", hostel.getHostelName()).executeUpdate();
		
		hql = "delete from Room where hostel_HostelID = :user";
		session.createQuery(hql).setParameter("user", hostel.getHostelID()).executeUpdate();
		
		hql = "delete from Hostel where HostelID = :user";
		session.createQuery(hql).setParameter("user", hostel.getHostelID() ).executeUpdate();
		
		
//		System.out.println("truetrue!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		
//        session.saveOrUpdate(hos);
		
		
		trans.commit();
		session.close();
	}
}
