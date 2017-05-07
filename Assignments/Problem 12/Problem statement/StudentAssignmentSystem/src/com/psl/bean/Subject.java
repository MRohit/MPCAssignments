package com.psl.bean;

import java.sql.Date;

public class Subject {

	private String subjectName;
	private java.util.Date assignmentIssueDate;
	private int numberOfSubmissions;
	
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Subject){
			Subject subject=(Subject)obj;
			return this.subjectName.equals(subject.getSubjectName());
		}
		return false;
	}
	@Override
	public int hashCode() {
		return this.subjectName.hashCode();
	}
	@Override
	public String toString() {
		return "Subject [subjectName=" + subjectName + ", assignmentIssueDate="
				+ assignmentIssueDate + ", numberOfSubmissions="
				+ numberOfSubmissions + "]";
	}
	public Subject(String subjectName, java.util.Date assignmentIssueDate,
			int numberOfSubmissions) {
		super();
		this.subjectName = subjectName;
		this.assignmentIssueDate = assignmentIssueDate;
		this.numberOfSubmissions = numberOfSubmissions;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public java.util.Date getAssignmentIssueDate() {
		return assignmentIssueDate;
	}
	public void setAssignmentIssueDate(Date assignmentIssueDate) {
		this.assignmentIssueDate = assignmentIssueDate;
	}
	public int getNumberOfSubmissions() {
		return numberOfSubmissions;
	}
	public void setNumberOfSubmissions(int numberOfSubmissions) {
		this.numberOfSubmissions = numberOfSubmissions;
	}
	
	
	
}
