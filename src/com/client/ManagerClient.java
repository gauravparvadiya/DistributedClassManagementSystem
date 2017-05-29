package com.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rmi.Center;
import com.users.Manager;

import jdk.nashorn.internal.parser.JSONParser;

public class ManagerClient {

	public HashMap<String, ArrayList<Manager>> managerHashMap;
	public ArrayList<Manager> mtl, lvl, ddo;
	JSONParser parser;
	static Registry registry;
	
	public ManagerClient() throws FileNotFoundException {

		File f = new File("res/manager.json");
		Reader reader = new BufferedReader(new FileReader(f.getAbsolutePath())); // new
																					// FileReader("com/res/Manager.json");
		JsonParser parser = new JsonParser();
		JsonArray array = parser.parse(reader).getAsJsonArray();

		mtl = new ArrayList<Manager>();
		lvl = new ArrayList<Manager>();
		ddo = new ArrayList<Manager>();

		managerHashMap = new HashMap<String, ArrayList<Manager>>();

		if (array != null) {
			for (int i = 0; i < array.size(); i++) {
				JsonObject object = (JsonObject) array.get(i);
				//System.out.println(object.get("managerID").getAsString());
				Manager manager = new Manager(object.get("managerID").toString(), object.get("fname").toString(),
						object.get("lname").toString());
				if (object.get("managerID").getAsString().substring(0, 3).equals("MTL")) {
					mtl.add(manager);
				} else if (object.get("managerID").getAsString().substring(0, 3).equals("LVL")) {
					lvl.add(manager);
				} else if (object.get("managerID").getAsString().substring(0, 3).equals("DDO")) {
					ddo.add(manager);
				}
			}
			//System.out.println(mtl);
			//System.out.println(lvl);
			//System.out.println(ddo);
			managerHashMap.put("MTL", mtl);
			managerHashMap.put("LVL", lvl);
			managerHashMap.put("DDO", ddo);
			// System.out.println(managerHashMap);
		}
	}

	private Boolean managerIdentification(ManagerClient managerClient, String managerID)
			throws RemoteException, NotBoundException {

		if (managerID.substring(0, 3).equals("MTL")) {
			for (int i = 0; i < managerClient.managerHashMap.get("MTL").size(); i++) {

				Manager manager = managerClient.managerHashMap.get("MTL").get(i);
				if (manager.getManagerID().substring(1, 8).equals(managerID)) {

					String fname = manager.getFname();
					String lname = manager.getLname();
					System.out.println("Welcome , " + fname.substring(1, fname.length() - 1) + " "
							+ lname.substring(1, lname.length() - 1));
					//Registry registry = LocateRegistry.getRegistry(2964);
					//Center stub = (Center) registry.lookup("MTLServer");
					//stub.createSRecord("Hirangi", "Naik", "DSD", "ready", "4/5/17","sr01");
					return true;
				} else {
					return false;
				}
			}
		} else if (managerID.substring(0, 3).equals("LVL")) {
			for (int i = 0; i < managerClient.managerHashMap.get("LVL").size(); i++) {
				Manager manager = managerClient.managerHashMap.get("LVL").get(i);
				if (manager.getManagerID().substring(1, 8).equals(managerID)) {

					String fname = manager.getFname();
					String lname = manager.getLname();
					System.out.println("Welcome , " + fname.substring(1, fname.length() - 1) + " "
							+ lname.substring(1, lname.length() - 1));
					//Registry registry = LocateRegistry.getRegistry(1212);
					//Center stub = (Center) registry.lookup("LVLServer");
					//stub.createSRecord("Hirangi", "Naik", "DSD", "ready", "4/5/17","sr01");
					return true;

				} else {
					return false;
				}

			}
		} else if (managerID.substring(0, 3).equals("DDO")) {
			for (int i = 0; i < managerClient.managerHashMap.get("DDO").size(); i++) {
				Manager manager = managerClient.managerHashMap.get("DDO").get(i);
				if (manager.getManagerID().substring(1, 8).equals(managerID)) {

					String fname = manager.getFname();
					String lname = manager.getLname();
					System.out.println("Welcome , " + fname.substring(1, fname.length() - 1) + " "
							+ lname.substring(1, lname.length() - 1));
					//Registry registry = LocateRegistry.getRegistry(1111);
					//Center stub = (Center) registry.lookup("DDOServer");
					//stub.createSRecord("Hirangi", "Naik", "DSD", "ready", "4/5/17","sr01");
					return true;
				} else {
					return false;
				}

			}
		} else {
			System.out.println("Manager ID should start with MTL/LVL/DDO");
			return false;
		}
		return false;
	}

	public static void connect_teacher(String managerID,String fn,String ln,String address,String ph,String spec,String loc,String id) throws RemoteException, NotBoundException {
		if(managerID.substring(0, 3).equals("MTL")){
			registry = LocateRegistry.getRegistry(2964);
			Center stub = (Center) registry.lookup("MTLServer");
			stub.createTRecord(fn,ln,address,ph,spec,loc,id);
		}
		else if(managerID.substring(0, 3).equals("LVL")){
			registry = LocateRegistry.getRegistry(1212);
			Center stub = (Center) registry.lookup("LVLServer");
			stub.createTRecord(fn,ln,address,ph,spec,loc,id);
		}
		else
		{
			registry = LocateRegistry.getRegistry(1111);
			Center stub = (Center) registry.lookup("DDOServer");
			stub.createTRecord(fn,ln,address,ph,spec,loc,id);
		}
	}
	
	public static void connect_student(String managerID,String fn,String ln,String[] courses,String status,String statusDate,String id) throws RemoteException, NotBoundException{
		if(managerID.substring(0, 3).equals("MTL")){
			registry = LocateRegistry.getRegistry(2964);
			Center stub = (Center) registry.lookup("MTLServer");
			stub.createSRecord(fn,ln,courses,status,statusDate,id);
			System.out.println(courses.length);
		}
		else if(managerID.substring(0, 3).equals("LVL")){
			registry = LocateRegistry.getRegistry(1212);
			Center stub = (Center) registry.lookup("LVLServer");
			stub.createSRecord(fn,ln,courses,status,statusDate,id);
		}
		else
		{
			registry = LocateRegistry.getRegistry(1111);
			Center stub = (Center) registry.lookup("DDOServer");
			stub.createSRecord(fn,ln,courses,status,statusDate,id);
		}
	}
	
	public static void main(String[] args) throws IOException, NotBoundException {

		ManagerClient managerClient = new ManagerClient();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Manager ID : ");
		String managerID = reader.readLine();
		
		
		if (managerClient.managerIdentification(managerClient, managerID)) {
			
			do {

				System.out.println("\n 1. Create Teacher ");
				System.out.println(" 2. Create Student ");
				System.out.println(" 3. Get Record Counts ");
				System.out.println(" 4. Edit Record ");
				System.out.println(" 5. Exit");

				reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("\n Enter your choice : ");

				Scanner s=new Scanner(System.in);
				String firstName,lastName,address,phone,spec,loc,id,status,statusDate;
				String[] courses;
				
				switch (reader.readLine()) {
				case "1":
					System.out.println("Enter Teacher Information");
					System.out.println("First Name : ");
					firstName=s.nextLine();
					System.out.println("Last Name : ");
					lastName=s.nextLine();
					System.out.println("Address : ");
					address=s.nextLine();
					System.out.println("Phone : ");
					phone=s.nextLine();
					System.out.println("Specialization : ");
					spec=s.nextLine();
					System.out.println("Location : ");
					loc=s.nextLine();
					System.out.println("Id : ");
					id=s.nextLine();
					connect_teacher(managerID,firstName,lastName,address,phone,spec,loc,id);
					break;
				case "2":
					System.out.println("Enter Student Information");
					System.out.println("First Name : ");
					firstName=s.nextLine();
					System.out.println("Last Name : ");
					lastName=s.nextLine();
					System.out.println("Courses registered (separated with comma) : ");
					String temp=s.nextLine();
					courses=temp.split(",");
					System.out.println("Status : ");
					status=s.nextLine();
					System.out.println("Status Date : ");
					statusDate=s.nextLine();
					System.out.println("Id : ");
					id=s.nextLine();
					connect_student(managerID,firstName,lastName,courses,status,statusDate,id);
					break;
				case "3":
					System.out.println("3");
					break;
				case "4":
					System.out.println("4");
					break;
				case "5":
					System.out.println("Bye Bye!!!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid selection. Please select from given options.");
					break;
				}
				
			} while (!reader.readLine().equals("5"));
		}
		
	}

	
}
