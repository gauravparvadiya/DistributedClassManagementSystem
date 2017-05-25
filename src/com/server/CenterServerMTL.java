package com.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.rmi.Center;
import com.rmi.CenterInmplementation;

public class CenterServerMTL extends CenterInmplementation {
	protected CenterServerMTL() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		/*try {
			CenterInmplementation centerimple = new CenterInmplementation();
			Center stub = (Center) UnicastRemoteObject.exportObject(centerimple, 65535);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Center", stub);

			System.out.println("server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}*/
		
		CenterInmplementation stub=new CenterInmplementation();
		Registry registry=LocateRegistry.createRegistry(2964);
		registry.bind("MTLServer", stub);
		System.out.println("Server started.");
	}

}
