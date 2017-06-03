package com.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;

public interface Center extends Remote{
	/**
	 * method to create new Teacher Record
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param phone
	 * @param specialization
	 * @param location
	 * @throws RemoteException
	 */
	public Boolean createTRecord(String firstName,String lastName,String address,String phone,String specialization,String location) throws RemoteException, ServerNotActiveException;
	
	/**
	 * method to create new Student Record
	 * @param firstName
	 * @param lastName
	 * @param courseRegistered
	 * @param status
	 * @param statusDate
	 * @throws RemoteException
	 */
	public Boolean createSRecord(String firstName,String lastName,String[] courseRegistered,Integer status,String statusDate) throws RemoteException;
	
	/**
	 * method to get record counts
	 * @return String number of records with location 
	 * @throws RemoteException
	 */
	public String getRecordCounts() throws RemoteException;
	
	/**
	 * method to edit record
	 * @param recordID
	 * @param fieldName
	 * @param newValue
	 * @throws RemoteException
	 */
	public void editRecord (String recordID,String fieldName,String[] newValue) throws RemoteException;
	
}
