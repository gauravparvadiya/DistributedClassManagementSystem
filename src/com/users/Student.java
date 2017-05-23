package com.users;

public class Student {

	private String fname;
	private String lname;
	private String[] coursesRegistered;
	private String status;
	private String statusDueDate;
	
	public Student(String fname, String lname, String[] coursesRegistered, String status,
			String statusDueDate) {
		this.fname = fname;
		this.lname = lname;
		this.coursesRegistered = coursesRegistered;
		this.status = status;
		this.statusDueDate = statusDueDate;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String[] getCoursesRegistered() {
		return coursesRegistered;
	}
	public void setCoursesRegistered(String[] coursesRegistered) {
		this.coursesRegistered = coursesRegistered;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusDueDate() {
		return statusDueDate;
	}
	public void setStatusDueDate(String statusDueDate) {
		this.statusDueDate = statusDueDate;
	}
	
}
