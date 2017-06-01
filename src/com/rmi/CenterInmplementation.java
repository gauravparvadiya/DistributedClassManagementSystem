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
	
	@Override
	public void createTRecord(String firstName, String lastName, String address, String phone, String specialization,
			String location) throws RemoteException {
		System.out.println("create teacher");		
	}
	
	@Override
	public void createSRecord(String firstName, String lastName, String[] courseRegistered, Integer status,
			String statusDate) throws RemoteException {
		System.out.println("create student");
		try {
			CenterServerMTL centerServerMTL = new CenterServerMTL();
						
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
