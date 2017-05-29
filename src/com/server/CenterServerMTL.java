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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rmi.CenterInmplementation;
import com.users.Student;
import com.users.Teacher;

import jdk.nashorn.internal.parser.JSONParser;

public class CenterServerMTL extends CenterInmplementation {

	public final HashMap<String, ArrayList<Object>> srtrRecords = new HashMap<String, ArrayList<Object>>() ;
	public ArrayList<Object> srtrMTL,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
	JSONParser parser;
	
	protected CenterServerMTL() throws Exception {
		super();
		addDefaultRecords();
	}
	
	private void addDefaultRecords () {
		File student = new File("res/student.json");
		File teacher = new File("res/teacher.json");
		Reader reader;
		try {
			
			srtrMTL = new ArrayList<Object>();
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
			
			//srtrRecords = new HashMap<String, ArrayList<Object>>();
			
			reader = new BufferedReader(new FileReader(student.getAbsolutePath()));
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(reader).getAsJsonArray();
			//System.out.println(array);
			
			if (array != null) {
				for (int i = 0; i < 4; i++) {
					JsonObject object = (JsonObject) array.get(i);
					//System.out.println("\n" + object.get("id").getAsString());
					JsonArray courseList = object.get("coursesRegistered").getAsJsonArray();
					String[] coursesRegistered = new String[courseList.size()];
					for (int j = 0; j < courseList.size(); j++) {	
						coursesRegistered[j] = courseList.get(j).getAsString();
					}
					Student s = new Student(object.get("fname").getAsString(), object.get("lname").getAsString(), coursesRegistered, object.get("status").getAsString(), object.get("statusDueDate").getAsString(), object.get("id").getAsString());
					srtrMTL.add(s);
				}
			}
			
			reader = new BufferedReader(new FileReader(teacher.getAbsolutePath()));
			array = parser.parse(reader).getAsJsonArray();
			//System.out.println(array);
			
			if (array != null) {
				for (int i = 0; i < 4; i++) {
					JsonObject object = (JsonObject) array.get(i);
					//System.out.println("\n" + object.get("id").getAsString());
					Teacher t = new Teacher(object.get("fname").getAsString(), object.get("lname").getAsString(), object.get("address").getAsString(), object.get("phone").getAsString(), object.get("specialization").getAsString(), object.get("location").getAsString(), object.get("id").getAsString());
					srtrMTL.add(t);
				}
			}
			
			for (int ij = 0; ij < srtrMTL.size(); ij++) {
				Student stud;
				Teacher teach;
				Character ch;
				if(srtrMTL.get(ij) instanceof Student){
					stud = (Student) srtrMTL.get(ij);
					System.out.println(stud.getLname());
					ch = stud.getLname().toUpperCase().charAt(0);
					System.out.println(ch);
				}
				else {
					teach = (Teacher) srtrMTL.get(ij);
					System.out.println(teach.getLname());
					ch = teach.getLname().toUpperCase().charAt(0);
					System.out.println(ch);
				}
				switch (ch) {
				case 'A':
					a.add(srtrMTL.get(ij));
					break;
				case 'B':
					b.add(srtrMTL.get(ij));
					break;
				case 'C':
					c.add(srtrMTL.get(ij));
					break;
				case 'D':
					d.add(srtrMTL.get(ij));
					break;
				case 'E':
					e.add(srtrMTL.get(ij));
					break;
				case 'F':
					f.add(srtrMTL.get(ij));
					break;
				case 'G':
					g.add(srtrMTL.get(ij));
					break;
				case 'H':
					h.add(srtrMTL.get(ij));
					break;
				case 'I':
					i.add(srtrMTL.get(ij));
					break;
				case 'J':
					j.add(srtrMTL.get(ij));
					break;
				case 'K':
					k.add(srtrMTL.get(ij));
					break;
				case 'L':
					l.add(srtrMTL.get(ij));
					break;
				case 'M':
					m.add(srtrMTL.get(ij));
					break;
				case 'N':
					n.add(srtrMTL.get(ij));
					break;
				case 'O':
					o.add(srtrMTL.get(ij));
					break;
				case 'P':
					p.add(srtrMTL.get(ij));
					break;
				case 'Q':
					q.add(srtrMTL.get(ij));
					break;
				case 'R':
					r.add(srtrMTL.get(ij));
					break;
				case 'S':
					s.add(srtrMTL.get(ij));
					break;
				case 'T':
					t.add(srtrMTL.get(ij));
					break;
				case 'U':
					u.add(srtrMTL.get(ij));
					break;
				case 'V':
					v.add(srtrMTL.get(ij));
					break;
				case 'W':
					w.add(srtrMTL.get(ij));
					break;
				case 'X':
					x.add(srtrMTL.get(ij));
					break;
				case 'Y':
					y.add(srtrMTL.get(ij));
					break;
				case 'Z':
					z.add(srtrMTL.get(ij));
					break;
				default:
					break;
				}		
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
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public HashMap<String, ArrayList<Object>> getMtlMap() {
		return srtrRecords;
	}
	
	public static void main(String[] args) throws Exception {
		
		CenterServerMTL mtl = new CenterServerMTL();
		CenterInmplementation stub = new CenterInmplementation();
		Registry registry = LocateRegistry.createRegistry(2964);
		registry.bind("MTLServer", stub);
		System.out.println("Server started.");
	}

	
	
}
