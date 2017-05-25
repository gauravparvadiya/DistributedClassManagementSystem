package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
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
		
		HashMap<String, ArrayList<Manager>> managerHashMap = new HashMap<String, ArrayList<Manager>>();
		managerHashMap.put("MTL", mtl);
		managerHashMap.put("LVL", lvl);
		managerHashMap.put("DDO", ddo);
		
	}

	public static void main(String[] args) throws IOException, NotBoundException {
		
		/*try {  
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
		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Manager ID : ");
		String managerID=reader.readLine();
		if(managerID.substring(0, 3).equals("MTL")){
			System.out.println("in loop");
			Registry registry = LocateRegistry.getRegistry(2964);
			System.out.println("got registry");
			Center stub=(Center)registry.lookup("MTLServer");
			System.out.println("lookup done");
		    stub.createSRecord("Hirangi", "Naik", "DSD", "ready", "4/5/17");
		}
		
	}

}
