package com.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import com.server.CenterServerMTL;
import com.users.Student;
import com.users.Teacher;

public class CenterInmplementation extends UnicastRemoteObject implements Center {
	
	
	public CenterInmplementation() throws Exception {
		super();
	}

	private boolean checkStudentIdAvailability (HashMap <String, ArrayList<Object>> map , String id ) {
		
		Student s = new Student();
		System.out.println(map);
		for (int i = 65; i <= 90; i++) {
			ArrayList <Object> array =  map.get(Character.toString((char)i));
			System.out.println(array.size() + "" + array);
			if (array.size() > 0) {
				for (int j = 0; j < array.size(); j++) {
					if (array.get(j) instanceof Student) {
						s = (Student) array.get(j);
						if (s.getId().equals(id)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	@Override
	public void createTRecord(String firstName, String lastName, String address, String phone, String specialization,
			String location,String id) throws RemoteException {
		System.out.println("create teacher");		
	}
	
	@Override
	public void createSRecord(String firstName, String lastName, String[] courseRegistered, Integer status,
			String statusDate,String id) throws RemoteException {
		System.out.println("create student");
		try {
			CenterServerMTL centerServerMTL = new CenterServerMTL();
			if (checkStudentIdAvailability(centerServerMTL.getMtlMap(), id)) {
				System.out.println("id validated");
			} else {
				System.out.println("Student id already available.");
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getRecordCounts() throws RemoteException {
		System.out.println("get record");
		return null;
	}

	@Override
	public void editRecord(String recordID, String fieldName, String[] newValue) throws RemoteException {
		System.out.println("edit");
	}

}
