package com.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.rmi.Center;
import com.rmi.CenterInmplementation;

public class CenterServerMTL extends CenterInmplementation {
	public static void main(String[] args) {
		try {
			CenterInmplementation centerimple = new CenterInmplementation();

			Center stub = (Center) UnicastRemoteObject.exportObject(centerimple, 1099);
			Registry registry = LocateRegistry.getRegistry();

			registry.bind("Center", stub);
			System.out.println("server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

}
