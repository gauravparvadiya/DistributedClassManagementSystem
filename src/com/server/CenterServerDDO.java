package com.server;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rmi.Center;
import com.users.Student;
import com.users.Teacher;

import jdk.nashorn.internal.parser.JSONParser;

public class CenterServerDDO extends UnicastRemoteObject implements Center, Runnable {

	public final HashMap<String, ArrayList<Object>> srtrRecords = new HashMap<String, ArrayList<Object>>();
	public ArrayList<Object> srtrDdo;
	public ArrayList<Object> a;
	public ArrayList<Object> b;
	public ArrayList<Object> c;
	public ArrayList<Object> d;
	public ArrayList<Object> e;
	public ArrayList<Object> f;
	public ArrayList<Object> g;
	public ArrayList<Object> h;
	public ArrayList<Object> i;
	public ArrayList<Object> j;
	public ArrayList<Object> k;
	public ArrayList<Object> l;
	public ArrayList<Object> m;
	public ArrayList<Object> n;
	public ArrayList<Object> o;
	public ArrayList<Object> p;
	public ArrayList<Object> q;
	public ArrayList<Object> r;
	public ArrayList<Object> s;
	public ArrayList<Object> t;
	public ArrayList<Object> u;
	public ArrayList<Object> v;
	public ArrayList<Object> w;
	public ArrayList<Object> x;
	public ArrayList<Object> y;
	public ArrayList<Object> z;
	JSONParser parser;
	String lastSRecordId = new String();
	String lastTRecordId = new String();

	protected CenterServerDDO() throws Exception {
		super();

		srtrDdo = new ArrayList<Object>();
		a = new ArrayList<Object>();
		b = new ArrayList<Object>();
		c = new ArrayList<Object>();
		d = new ArrayList<Object>();
		e = new ArrayList<Object>();
		f = new ArrayList<Object>();
		g = new ArrayList<Object>();
		h = new ArrayList<Object>();
		i = new ArrayList<Object>();
		j = new ArrayList<Object>();
		k = new ArrayList<Object>();
		l = new ArrayList<Object>();
		m = new ArrayList<Object>();
		n = new ArrayList<Object>();
		o = new ArrayList<Object>();
		p = new ArrayList<Object>();
		q = new ArrayList<Object>();
		r = new ArrayList<Object>();
		s = new ArrayList<Object>();
		t = new ArrayList<Object>();
		u = new ArrayList<Object>();
		v = new ArrayList<Object>();
		w = new ArrayList<Object>();
		x = new ArrayList<Object>();
		y = new ArrayList<Object>();
		z = new ArrayList<Object>();
	}

	private void addToMap(Object obj) {

		Student stud;
		Teacher teach;
		Character ch;

		if (obj instanceof Student) {
			stud = (Student) obj;
			ch = stud.getLname().toUpperCase().charAt(0);
		} else {
			teach = (Teacher) obj;
			ch = teach.getLname().toUpperCase().charAt(0);
		}
		switch (ch) {
		case 'A':
			a.add(obj);
			break;
		case 'B':
			b.add(obj);
			break;
		case 'C':
			c.add(obj);
			break;
		case 'D':
			d.add(obj);
			break;
		case 'E':
			e.add(obj);
			break;
		case 'F':
			f.add(obj);
			break;
		case 'G':
			g.add(obj);
			break;
		case 'H':
			h.add(obj);
			break;
		case 'I':
			i.add(obj);
			break;
		case 'J':
			j.add(obj);
			break;
		case 'K':
			k.add(obj);
			break;
		case 'L':
			l.add(obj);
			break;
		case 'M':
			m.add(obj);
			break;
		case 'N':
			n.add(obj);
			break;
		case 'O':
			o.add(obj);
			break;
		case 'P':
			p.add(obj);
			break;
		case 'Q':
			q.add(obj);
			break;
		case 'R':
			r.add(obj);
			break;
		case 'S':
			s.add(obj);
			break;
		case 'T':
			t.add(obj);
			break;
		case 'U':
			u.add(obj);
			break;
		case 'V':
			v.add(obj);
			break;
		case 'W':
			w.add(obj);
			break;
		case 'X':
			x.add(obj);
			break;
		case 'Y':
			y.add(obj);
			break;
		case 'Z':
			z.add(obj);
			break;
		default:
			break;
		}

		srtrRecords.put("A", a);
		srtrRecords.put("B", b);
		srtrRecords.put("C", c);
		srtrRecords.put("D", d);
		srtrRecords.put("E", e);
		srtrRecords.put("F", f);
		srtrRecords.put("G", g);
		srtrRecords.put("H", h);
		srtrRecords.put("I", i);
		srtrRecords.put("J", j);
		srtrRecords.put("K", k);
		srtrRecords.put("L", l);
		srtrRecords.put("M", m);
		srtrRecords.put("N", n);
		srtrRecords.put("O", o);
		srtrRecords.put("P", p);
		srtrRecords.put("Q", q);
		srtrRecords.put("R", r);
		srtrRecords.put("S", s);
		srtrRecords.put("T", t);
		srtrRecords.put("U", u);
		srtrRecords.put("V", v);
		srtrRecords.put("W", w);
		srtrRecords.put("X", x);
		srtrRecords.put("Y", y);
		srtrRecords.put("Z", z);
	}

	private void addDefaultRecords() {
		File student = new File("res/student.json");
		File teacher = new File("res/teacher.json");
		Reader reader;
		try {

			reader = new BufferedReader(new FileReader(student.getAbsolutePath()));
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(reader).getAsJsonArray();

			if (array != null) {
				for (int i = 7; i < 10; i++) {
					JsonObject object = (JsonObject) array.get(i);
					JsonArray courseList = object.get("coursesRegistered").getAsJsonArray();
					String[] coursesRegistered = new String[courseList.size()];
					for (int j = 0; j < courseList.size(); j++) {
						coursesRegistered[j] = courseList.get(j).getAsString();
					}
					Student s = new Student(object.get("fname").getAsString(), object.get("lname").getAsString(),
							coursesRegistered, Integer.parseInt(object.get("status").getAsString()),
							object.get("statusDueDate").getAsString(), object.get("id").getAsString());
					srtrDdo.add(s);
					lastSRecordId = object.get("id").getAsString();
				}
			}

			reader = new BufferedReader(new FileReader(teacher.getAbsolutePath()));
			array = parser.parse(reader).getAsJsonArray();

			if (array != null) {
				for (int i = 7; i < 10; i++) {
					JsonObject object = (JsonObject) array.get(i);
					Teacher t = new Teacher(object.get("fname").getAsString(), object.get("lname").getAsString(),
							object.get("address").getAsString(), object.get("phone").getAsString(),
							object.get("specialization").getAsString(), object.get("location").getAsString(),
							object.get("id").getAsString());
					srtrDdo.add(t);
					lastTRecordId = object.get("id").getAsString();
				}
			}

			for (int ij = 0; ij < srtrDdo.size(); ij++) {
				addToMap(srtrDdo.get(ij));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createTRecord(String firstName, String lastName, String address, String phone, String specialization,
			String location) throws RemoteException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(lastTRecordId.substring(3, 8));
		System.out.println(id);
		lastTRecordId = "DTR" + "" + ++id;
		System.out.println(lastTRecordId);
		Teacher t = new Teacher(firstName, lastName, address, phone, specialization, location, lastTRecordId);
		// Student s = new Student(firstName, lastName, courseRegistered,
		// status, statusDate, lastSRecordId);
		addToMap(t);

	}

	@Override
	public void createSRecord(String firstName, String lastName, String[] courseRegistered, Integer status,
			String statusDate) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(a);
		int id = Integer.parseInt(lastSRecordId.substring(3, 8));
		System.out.println(id);
		lastSRecordId = "DSR" + "" + ++id;
		System.out.println(lastSRecordId);
		Student s = new Student(firstName, lastName, courseRegistered, status, statusDate, lastSRecordId);
		addToMap(s);
	}

	@Override
	public String getRecordCounts() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editRecord(String recordID, String fieldName, String[] newValue) throws RemoteException {
		// TODO Auto-generated method stub

	}
	
	private int getCount() {
		int counter = 0;
		if (srtrRecords.size() > 0) {
			for (int i = 65; i < 91; i++) {
				String key = Character.toString((char)i);
				ArrayList<Object> array = srtrRecords.get(key);
				counter += array.size();
			}
			return counter;
		} else {
			return 0;
		}
		
	}

	public static void main(String[] args) throws Exception {
		CenterServerDDO ddo = new CenterServerDDO();
		ddo.addDefaultRecords();
		Registry registry = LocateRegistry.createRegistry(1111);
		registry.bind("DDOServer", ddo);
		System.out.println("Server started.");

		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(1111);
			byte[] buffer = new byte[1];
			DatagramPacket request = new DatagramPacket(buffer, buffer.length);
			socket.receive(request);
			String replyStr = "DDO : " + ddo.getCount();
			byte[] buffer1 = replyStr.getBytes();
			DatagramPacket reply = new DatagramPacket(buffer1, buffer1.length, request.getAddress(), request.getPort());
			socket.send(reply);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
