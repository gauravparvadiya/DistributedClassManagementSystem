package com.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rmi.CenterInmplementation;

import jdk.nashorn.internal.parser.JSONParser;

public class CenterServerMTL extends CenterInmplementation {

	public HashMap<String, ArrayList<Object>> srtrRecords;
	public ArrayList<Object> srtrMTL;
	JSONParser parser;
	
	protected CenterServerMTL() throws Exception {
		super();
		addDefaultRecords();
	}
	
	private void addDefaultRecords () {
		File student = new File("res/student.json");
		Reader reader;
		try {
			reader = new BufferedReader(new FileReader(student.getAbsolutePath()));
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(reader).getAsJsonArray();
			System.out.println(array);
			
			if (array != null) {
				for (int i = 0; i < array.size(); i++) {
					JsonObject object = (JsonObject) array.get(i);
					System.out.println("\n" + object.get("id").getAsString());
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		
		CenterServerMTL mtl = new CenterServerMTL();
		CenterInmplementation stub = new CenterInmplementation();
		Registry registry = LocateRegistry.createRegistry(2964);
		registry.bind("MTLServer", stub);
		System.out.println("Server started.");
	}

	
	
}
