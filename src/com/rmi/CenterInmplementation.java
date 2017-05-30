package com.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.server.CenterServerMTL;
import com.users.Student;
import com.users.Teacher;

public class CenterInmplementation extends UnicastRemoteObject implements Center {
	
	public CenterInmplementation() throws Exception {
		super();
	}

	@Override
	public void createTRecord(String firstName, String lastName, String address, String phone, String specialization,
			String location,String id) throws RemoteException {
		System.out.println("create teacher");
	}

	@Override
	public void createSRecord(String firstName, String lastName, String[] courseRegistered, String status,
			String statusDate,String id) throws RemoteException {
		System.out.println("create student");
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
