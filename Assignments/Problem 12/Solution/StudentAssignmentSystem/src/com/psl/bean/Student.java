package com.psl.bean;

import java.util.Date;


public class Student {

	private int rollNumber;
	private String studentname;
	private String subject;
	private java.util.Date submissionDate;
	private int marksObtained;
	private int numberOfDays;
	private boolean defaulter;
	
	
	
	
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", studentname="
				+ studentname + ", subject=" + subject + ", submissionDate="
				+ submissionDate + ", marksObtained=" + marksObtained
				+ ", numberOfDays=" + numberOfDays + ", defaulter=" + defaulter
				+ "]";
	}
	public Student(int rollNumber, String studentname, String subject,
			Date submissionDate, int marksObtained, int numberOfDays,
			boolean defaulter) {
		super();
		this.rollNumber = rollNumber;
		this.studentname = studentname;
		this.subject = subject;
		this.submissionDate = submissionDate;
		this.marksObtained = marksObtained;
		this.numberOfDays = numberOfDays;
		this.defaulter = defaulter;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public java.util.Date getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(java.util.Date submissionDate) {
		this.submissionDate = submissionDate;
	}
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	
	
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public boolean isDefaulter() {
		return defaulter;
	}
	public void setDefaulter(boolean defaulter) {
		this.defaulter = defaulter;
	}
	
	
}
