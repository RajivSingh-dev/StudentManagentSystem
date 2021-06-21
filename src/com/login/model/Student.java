package com.login.model;

public class Student {
	
	private Integer id;
	private String studentName;
	private String address;

	public Student(Integer id, String studentName, String address) {
		this.id = id;
		this.studentName = studentName;
		this.address = address;
	}

	public Student(String studentName, String address) {
		this.studentName = studentName;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [student name=" + studentName + ", address=" + address + "]";
	}
}
