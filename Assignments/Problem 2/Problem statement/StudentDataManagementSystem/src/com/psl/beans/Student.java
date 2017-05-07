package com.psl.beans;

import java.util.Comparator;

public class Student implements Comparable<Student>{
	private int rollno;
	private String studentName;
	private int age;
	private Address address;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int rollno, String studentName, int age, Address address) {
		super();
		this.rollno = rollno;
		this.studentName = studentName;
		this.age = age;
		this.address = address;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", studentName=" + studentName
				+ ", age=" + age + ", address=" + address + "]";
	}


	
	@Override
	public int compareTo(Student arg0) {
		// TODO Auto-generated method stub
		if(this.getStudentName()==arg0.getStudentName()){
			if(this.getAge()==arg0.getAge()){
				return this.getRollno()-arg0.getRollno();
			}else
				return this.getAge()-arg0.getAge();
		}
		else
			return this.getStudentName().compareTo(arg0.getStudentName());
	}
	
}
