package com.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.rmi.CenterInmplementation;

public class CenterServerDDO {
	protected CenterServerDDO() throws Exception {
		super();
	}

	public static void main(String[] args) throws Exception {

		CenterInmplementation stub=new CenterInmplementation();
		Registry registry=LocateRegistry.createRegistry(1111);
		registry.bind("DDOServer", stub);
		System.out.println("Server started.");
	}
}
