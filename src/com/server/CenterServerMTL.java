package com.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.rmi.CenterInmplementation;

public class CenterServerMTL extends CenterInmplementation {
	protected CenterServerMTL() throws Exception {
		super();
	}

	public static void main(String[] args) throws Exception {

		CenterInmplementation stub=new CenterInmplementation();
		Registry registry=LocateRegistry.createRegistry(2964);
		registry.bind("MTLServer", stub);
		System.out.println("Server started.");
	}

}
