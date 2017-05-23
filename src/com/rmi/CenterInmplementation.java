package com.rmi;

import java.rmi.RemoteException;

public class CenterInmplementation implements Center {

	@Override
	public void createTRecord(String firstName, String lastName, String address, String phone, String specialization,
			String location) throws RemoteException {
		System.out.println("cretae teacher");

	}

	@Override
	public void createSRecord(String firstName, String lastName, String[] courseRegistered, String status,
			String statusDate) throws RemoteException {
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
