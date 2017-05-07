package com.bean;

public class Criteria {
	
	private Category category;
	private Complexity complexity;
	private int noOfQuestion;

	public Criteria() {
	}

	public Criteria(Category category, Complexity complexity,int noOfQuestion) {
		super();
		this.noOfQuestion = noOfQuestion;
		this.category = category;
		this.complexity = complexity;
	}

	public int getNoOfQuestion() {
		return noOfQuestion;
	}

	public void setNoOfQuestion(int noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Complexity getComplexity() {
		return complexity;
	}

	public void setComplexity(Complexity complexity) {
		this.complexity = complexity;
	}

}
