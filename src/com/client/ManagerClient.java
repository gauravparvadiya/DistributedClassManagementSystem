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
import java.rmi.server.ServerNotActiveException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.helper.LogHelper;
import com.rmi.Center;
import com.users.Manager;
import jdk.nashorn.internal.parser.JSONParser;

public class ManagerClient implements Runnable {

	public HashMap<String, ArrayList<Manager>> managerHashMap;
	public ArrayList<Manager> mtl, lvl, ddo;
	JSONParser parser;
	static Registry registry;
	static Logger logger = Logger.getLogger(ManagerClient.class);

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
				// System.out.println(object.get("managerID").getAsString());
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
			managerHashMap.put("MTL", mtl);
			managerHashMap.put("LVL", lvl);
			managerHashMap.put("DDO", ddo);
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
					return true;
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
					return true;
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
					return true;
				}
			}
		} else {
			System.out.println("Manager ID should start with MTL/LVL/DDO");
			return false;
		}
		return false;
	}

	public static void connect_teacher(String managerID, String fn, String ln, String address, String ph, String spec,
			String loc) throws RemoteException, NotBoundException, ServerNotActiveException {
		logger.info("Using createTRecord method.");
		if (managerID.substring(0, 3).equals("MTL")) {
			registry = LocateRegistry.getRegistry(2964);
			Center stub = (Center) registry.lookup("MTLServer");
			if (stub.createTRecord(fn, ln, address, ph, spec, loc, managerID)) {
				System.out.println("Record created successfully. ");
				logger.info("Teacher record created successfully.");
			} else {
				System.out.println("Something went wrong!!! ");
				logger.error("Server returns error creating teacher record.");
			}
		} else if (managerID.substring(0, 3).equals("LVL")) {
			registry = LocateRegistry.getRegistry(1212);
			Center stub = (Center) registry.lookup("LVLServer");
			if (stub.createTRecord(fn, ln, address, ph, spec, loc, managerID)) {
				System.out.println("Record created successfully. ");
				logger.info("Teacher record created successfully.");
			} else {
				System.out.println("Something went wrong!!! ");
				logger.error("Server returns error creating teacher record.");
			}
		} else {
			registry = LocateRegistry.getRegistry(1111);
			Center stub = (Center) registry.lookup("DDOServer");
			if (stub.createTRecord(fn, ln, address, ph, spec, loc, managerID)) {
				System.out.println("Record created successfully. ");
				logger.info("Teacher record created successfully.");
			} else {
				System.out.println("Something went wrong!!! ");
				logger.error("Server returns error creating teacher record.");
			}
		}
	}

	public static void connect_student(String managerID, String fn, String ln, String[] courses, Integer status,
			String statusDate) throws RemoteException, NotBoundException {
		logger.info("Using createSRecord method.");
		if (managerID.substring(0, 3).equals("MTL")) {
			registry = LocateRegistry.getRegistry(2964);
			Center stub = (Center) registry.lookup("MTLServer");
			if (stub.createSRecord(fn, ln, courses, status, statusDate, managerID)) {
				System.out.println("Record created successfully.");
				logger.info("Student record created successfully.");
			} else {
				System.out.println("Something went wrong!!! ");
				logger.error("Server returns error creating student record.");
			}
		} else if (managerID.substring(0, 3).equals("LVL")) {
			registry = LocateRegistry.getRegistry(1212);
			Center stub = (Center) registry.lookup("LVLServer");
			if (stub.createSRecord(fn, ln, courses, status, statusDate, managerID)) {
				System.out.println("Record created successfully.");
				logger.info("Student record created successfully.");
			} else {
				System.out.println("Something went wrong!!! ");
				logger.error("Server returns error creating student record.");
			}
		} else {
			registry = LocateRegistry.getRegistry(1111);
			Center stub = (Center) registry.lookup("DDOServer");
			if (stub.createSRecord(fn, ln, courses, status, statusDate, managerID)) {
				System.out.println("Record created successfully.");
				logger.info("Student record created successfully.");
			} else {
				System.out.println("Something went wrong!!! ");
				logger.error("Server returns error creating student record.");
			}
		}
	}

	public static void connect_edit(String managerID, String fieldname, String[] newvalue, String id)
			throws RemoteException, NotBoundException {
		if (managerID.substring(0, 3).equals("MTL")) {
			registry = LocateRegistry.getRegistry(2964);
			logger.debug("connected to registry 2964");
			Center stub = (Center) registry.lookup("MTLServer");
			logger.debug("connected to Montreal server");
			stub.editRecord(id, fieldname, newvalue, managerID);
		} else if (managerID.substring(0, 3).equals("LVL")) {
			registry = LocateRegistry.getRegistry(1212);
			logger.debug("connected to registry 1212");
			Center stub = (Center) registry.lookup("LVLServer");
			logger.debug("connected to Laval server");
			stub.editRecord(id, fieldname, newvalue, managerID);
		} else {
			registry = LocateRegistry.getRegistry(1111);
			logger.debug("connected to registry 1111");
			Center stub = (Center) registry.lookup("DDOServer");
			logger.debug("connected to Dollard-des-Ormeaux server");
			stub.editRecord(id, fieldname, newvalue, managerID);
		}
		logger.info("Using editRecord method");
	}

	public static void connect_record_count(String managerID) throws RemoteException, NotBoundException {
		logger.info("Using getRecordCount method.");
		if (managerID.substring(0, 3).equals("MTL")) {
			registry = LocateRegistry.getRegistry(2964);
			logger.debug("connected to registry 2964");
			Center stub = (Center) registry.lookup("MTLServer");
			logger.debug("connected to Montreal server");
			String reply = stub.getRecordCounts(managerID);
			System.out.println("Count : \n" + reply);
		} else if (managerID.substring(0, 3).equals("LVL")) {
			registry = LocateRegistry.getRegistry(1212);
			logger.debug("connected to registry 1212");
			Center stub = (Center) registry.lookup("LVLServer");
			logger.debug("connected to Laval server");
			String reply = stub.getRecordCounts(managerID);
			System.out.println("Count : \n" + reply);
		} else {
			registry = LocateRegistry.getRegistry(1111);
			logger.debug("connected to registry 1111");
			Center stub = (Center) registry.lookup("DDOServer");
			logger.debug("connected to Dollard-des-Ormeaux server");
			String reply = stub.getRecordCounts(managerID);
			System.out.println("Count : \n" + reply);
		}
	}

	public static boolean validate_edit(String id, String fieldName, String[] newValue) {

		if (id.length() == 8) {
			if (id.substring(0, 3).equals("MTR") || id.substring(0, 3).equals("LTR")
					|| id.substring(0, 3).equals("DTR")) {
				logger.info("Starting to edit teacher.");
				if (fieldName.equals("address") || fieldName.equals("location") || fieldName.equals("phone")) {
					return true;
				} else {
					System.out.println("Invalid Field");
					return false;
				}
			} else if (id.substring(0, 3).equals("MSR") || id.substring(0, 3).equals("LSR")
					|| id.substring(0, 3).equals("DSR")) {
				logger.info("Starting to edit student.");
				if (fieldName.equals("coursesRegistered") || fieldName.equals("status")
						|| fieldName.equals("statusDueDate")) {
					return true;
				} else {
					System.out.println("Invalid Field");
					return false;
				}
			} else {
				return true;
			}
		} else {
			System.out.println("Please enter valid record ID");
			return false;
		}
	}

	public static void main(String[] args) throws IOException, NotBoundException, ServerNotActiveException {

		ManagerClient managerClient = new ManagerClient();
		Thread t = new Thread(managerClient);
		t.start();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Enter the Manager ID : ");
		String managerID;// = reader.readLine();
		do {
			System.out.println("Enter the Manager ID : ");
			managerID = reader.readLine();
			
			if ( !managerID.equals("") && managerID.length() == 7  && managerClient.managerIdentification(managerClient, managerID)) {
				LogHelper helper = new LogHelper();
				helper.setupLogFile("log/" + managerID + ".log");
				logger.debug("connected to manager client.");
				do {
					System.out.println("\n 1. Create Teacher ");
					System.out.println(" 2. Create Student ");
					System.out.println(" 3. Get Record Counts ");
					System.out.println(" 4. Edit Record ");
					System.out.println(" 5. Exit");

					reader = new BufferedReader(new InputStreamReader(System.in));
					System.out.println("\n Enter your choice : ");

					Scanner s = new Scanner(System.in);
					Integer status;
					String firstName, lastName, address, phone, spec, loc, id, statusDate, fieldName, temp;
					String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
					String[] courses;
					String[] newValue = new String[5];
					Pattern pattern;
					Matcher matcher;

					switch (reader.readLine()) {
					case "1":
						logger.info("Starting to create teacher.");
						System.out.println("Enter Teacher Information");
						System.out.println("First Name : ");
						firstName = s.nextLine();
						System.out.println("Last Name : ");
						lastName = s.nextLine();
						System.out.println("Address : ");
						address = s.nextLine();
						System.out.println("Phone : ");
						phone = s.nextLine();
						System.out.println("Specialization : ");
						spec = s.nextLine();
						System.out.println("Location : ");
						loc = s.nextLine();
						if(!firstName.equals("") && !lastName.equals("") && !address.equals("") && phone.isEmpty() && spec != null && loc != null){
							connect_teacher(managerID, firstName, lastName, address, phone, spec, loc);
						}
						else
							System.out.println("Please enter all values.");
						break;
					case "2":
						logger.info("Starting to create student.");
						System.out.println("Enter Student Information");
						System.out.println("First Name : ");
						firstName = s.nextLine();
						System.out.println("Last Name : ");
						lastName = s.nextLine();
						System.out.println("Courses registered (separated with comma) : ");
						temp = s.nextLine();
						courses = temp.split(",");
						System.out.println("Status : (1 for active & 0 for deactive)");
						status = s.nextInt();
						s.nextLine();
						System.out.println("Status Date : (DD/MM/YYYY)");
						statusDate = s.nextLine();
						pattern = Pattern.compile(DATE_PATTERN);
						matcher = pattern.matcher(statusDate);
						if (firstName != null && lastName != null && courses != null && status != null
								&& statusDate != null) {
							if (matcher.matches() && (status.equals(0) || status.equals(1))) {
								connect_student(managerID, firstName, lastName, courses, status, statusDate);
							} else
								System.out.println("check if you have entered correct status or date or ID");
						} else
							System.out.println("Field can not be blank");
						break;
					case "3":
						connect_record_count(managerID);
						break;
					case "4":
						// logger.info("Starting to edit .");
						System.out.println("Enter information to edit : ");
						System.out.println("ID : (e.g. MTR00001/MSR10001)");
						id = s.nextLine();
						System.out.println("Field Name : ");
						fieldName = s.nextLine();
						System.out.println("New Value : ");
						temp = s.nextLine();
						if (temp.contains(",")) {
							newValue = temp.split(",");
						} else
							newValue[0] = temp;
						if (validate_edit(id, fieldName, newValue)) {
							connect_edit(managerID, fieldName, newValue, id);
						}
						break;
					case "5":
						File file = new File("log/" + managerID + ".log");
						file.delete();
						System.out.println("Bye Bye!!!");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid selection. Please select from given options.");
						break;
					}

				} while (!reader.readLine().equals("5"));
			} else {
				System.out.println("Manager not found.");
			}
		}while(!managerID.equals("exit"));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

}
