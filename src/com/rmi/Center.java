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
	public Boolean createTRecord(String firstName,String lastName,String address,String phone,String specialization,String location,String managerID) throws RemoteException, ServerNotActiveException;
	
	/**
	 * method to create new Student Record
	 * @param firstName
	 * @param lastName
	 * @param courseRegistered
	 * @param status
	 * @param statusDate
	 * @throws RemoteException
	 */
	public Boolean createSRecord(String firstName,String lastName,String[] courseRegistered,Integer status,String statusDate,String managerID) throws RemoteException;
	
	/**
	 * method to get record counts
	 * @param managerID
	 * @return String number of records with location 
	 * @throws RemoteException
	 */
	public String getRecordCounts(String managerID) throws RemoteException;
	
	/**
	 * method to edit record
	 * @param recordID
	 * @param fieldName
	 * @param newValue
	 * @throws RemoteException
	 */
	public Boolean editRecord (String recordID,String fieldName,String[] newValue,String managerID) throws RemoteException;
	
}
