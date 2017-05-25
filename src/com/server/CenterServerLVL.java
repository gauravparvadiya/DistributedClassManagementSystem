package com.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.rmi.CenterInmplementation;

public class CenterServerLVL {
	protected CenterServerLVL() throws Exception {
		super();
	}

	public static void main(String[] args) throws Exception {

		CenterInmplementation stub=new CenterInmplementation();
		Registry registry=LocateRegistry.createRegistry(1212);
		registry.bind("LVLServer", stub);
		System.out.println("Server started.");
	}

}
