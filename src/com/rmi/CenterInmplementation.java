package com.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

import com.server.CenterServerMTL;

public class CenterInmplementation extends UnicastRemoteObject implements Center {
		
	public CenterInmplementation() throws Exception {
		super();
	}
	
	@Override
	public void createTRecord(String firstName, String lastName, String address, String phone, String specialization,
			String location) {
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
