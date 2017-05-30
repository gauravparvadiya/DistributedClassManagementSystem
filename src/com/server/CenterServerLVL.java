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
import com.users.Student;
import com.users.Teacher;

import jdk.nashorn.internal.parser.JSONParser;

public class CenterServerLVL {

	public final HashMap<String, ArrayList<Object>> srtrRecords = new HashMap<String, ArrayList<Object>>();
	public ArrayList<Object> srtrLvl, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;
	JSONParser parser;

	protected CenterServerLVL() throws Exception {
		super();
		addDefaultRecords();
	}

	private void addDefaultRecords() {
		File student = new File("res/student.json");
		File teacher = new File("res/teacher.json");
		Reader reader;
		try {

			srtrLvl = new ArrayList<Object>();
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

			// srtrRecords = new HashMap<String, ArrayList<Object>>();

			reader = new BufferedReader(new FileReader(student.getAbsolutePath()));
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(reader).getAsJsonArray();
			// System.out.println(array);

			if (array != null) {
				for (int i = 4; i < 7; i++) {
					JsonObject object = (JsonObject) array.get(i);
					// System.out.println("\n" +
					// object.get("id").getAsString());
					JsonArray courseList = object.get("coursesRegistered").getAsJsonArray();
					String[] coursesRegistered = new String[courseList.size()];
					for (int j = 0; j < courseList.size(); j++) {
						coursesRegistered[j] = courseList.get(j).getAsString();
					}
					Student s = new Student(object.get("fname").getAsString(), object.get("lname").getAsString(),
							coursesRegistered, object.get("status").getAsString(),
							object.get("statusDueDate").getAsString(), object.get("id").getAsString());
					srtrLvl.add(s);
				}
			}

			reader = new BufferedReader(new FileReader(teacher.getAbsolutePath()));
			array = parser.parse(reader).getAsJsonArray();
			// System.out.println(array);

			if (array != null) {
				for (int i = 4; i < 7; i++) {
					JsonObject object = (JsonObject) array.get(i);
					// System.out.println("\n" +
					// object.get("id").getAsString());
					Teacher t = new Teacher(object.get("fname").getAsString(), object.get("lname").getAsString(),
							object.get("address").getAsString(), object.get("phone").getAsString(),
							object.get("specialization").getAsString(), object.get("location").getAsString(),
							object.get("id").getAsString());
					srtrLvl.add(t);
				}
			}

			for (int ij = 0; ij < srtrLvl.size(); ij++) {
				Student stud;
				Teacher teach;
				Character ch;
				if (srtrLvl.get(ij) instanceof Student) {
					stud = (Student) srtrLvl.get(ij);
					System.out.println(stud.getLname());
					ch = stud.getLname().toUpperCase().charAt(0);
					System.out.println(ch);
				} else {
					teach = (Teacher) srtrLvl.get(ij);
					System.out.println(teach.getLname());
					ch = teach.getLname().toUpperCase().charAt(0);
					System.out.println(ch);
				}
				switch (ch) {
				case 'A':
					a.add(srtrLvl.get(ij));
					break;
				case 'B':
					b.add(srtrLvl.get(ij));
					break;
				case 'C':
					c.add(srtrLvl.get(ij));
					break;
				case 'D':
					d.add(srtrLvl.get(ij));
					break;
				case 'E':
					e.add(srtrLvl.get(ij));
					break;
				case 'F':
					f.add(srtrLvl.get(ij));
					break;
				case 'G':
					g.add(srtrLvl.get(ij));
					break;
				case 'H':
					h.add(srtrLvl.get(ij));
					break;
				case 'I':
					i.add(srtrLvl.get(ij));
					break;
				case 'J':
					j.add(srtrLvl.get(ij));
					break;
				case 'K':
					k.add(srtrLvl.get(ij));
					break;
				case 'L':
					l.add(srtrLvl.get(ij));
					break;
				case 'M':
					m.add(srtrLvl.get(ij));
					break;
				case 'N':
					n.add(srtrLvl.get(ij));
					break;
				case 'O':
					o.add(srtrLvl.get(ij));
					break;
				case 'P':
					p.add(srtrLvl.get(ij));
					break;
				case 'Q':
					q.add(srtrLvl.get(ij));
					break;
				case 'R':
					r.add(srtrLvl.get(ij));
					break;
				case 'S':
					s.add(srtrLvl.get(ij));
					break;
				case 'T':
					t.add(srtrLvl.get(ij));
					break;
				case 'U':
					u.add(srtrLvl.get(ij));
					break;
				case 'V':
					v.add(srtrLvl.get(ij));
					break;
				case 'W':
					w.add(srtrLvl.get(ij));
					break;
				case 'X':
					x.add(srtrLvl.get(ij));
					break;
				case 'Y':
					y.add(srtrLvl.get(ij));
					break;
				case 'Z':
					z.add(srtrLvl.get(ij));
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
			e.printStackTrace();
		}
	}

	public HashMap<String, ArrayList<Object>> getLvlMap() {
		return srtrRecords;
	}

	public static void main(String[] args) throws Exception {
		CenterServerLVL lvl = new CenterServerLVL();
		CenterInmplementation stub = new CenterInmplementation();
		Registry registry = LocateRegistry.createRegistry(1212);
		registry.bind("LVLServer", stub);
		System.out.println("Server started.");
	}

}
