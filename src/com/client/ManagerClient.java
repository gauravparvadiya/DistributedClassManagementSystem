package com.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;

import com.rmi.Center;
import com.users.Manager;

public class ManagerClient {

	
	
	/**
	 * 
	 */
	public ManagerClient() {
		Manager manager1 = new Manager("MTL0001","Gaurav","Parvadiya");
		Manager manager2 = new Manager("LVL0002","Hirangi","Naik");
		Manager manager3 = new Manager("DDO0003","Jack","Reacher");
		
		ArrayList<Manager> mtl = new ArrayList<Manager>();
		mtl.add(manager1);
		
		ArrayList<Manager> lvl = new ArrayList<Manager>();
		lvl.add(manager2);
		
		ArrayList<Manager> ddo = new ArrayList<Manager>();
		ddo.add(manager3);
		
		HashMap<String, ArrayList<Manager>> managerList = new HashMap<String, ArrayList<Manager>>();
		managerList.put("MTL", mtl);
		managerList.put("LVL", lvl);
		managerList.put("DDO", ddo);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {  
	         // Getting the registry 
	         Registry registry = LocateRegistry.getRegistry(null); 
	    
	         // Looking up the registry for the remote object 
	         Center stub = (Center) registry.lookup("Center"); 
	    
	         // Calling the remote method using the obtained object 
	         stub.createSRecord("Gaurav", "Parvadiya",null , "Active", "23/05/2017"); 
	         
	         // System.out.println("Remote method invoked"); 
	      } catch (Exception e) {
	         System.err.println("Client exception: " + e.toString()); 
	         e.printStackTrace(); 
	      } 
		
	}

}
