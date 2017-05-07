package com.psl.bean;

import java.util.Date;

public class Post {

	private String postId;
	private Date postDate;
	private String recepientName;
	private String pinCode;

	
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postDate=" + postDate
				+ ", recepientName=" + recepientName + ", pinCode=" + pinCode
				+ "]";
	}
	public Post(String postId, Date postDate, String recepientName,
			String pinCode) {
		super();
		this.postId = postId;
		this.postDate = postDate;
		this.recepientName = recepientName;
		this.pinCode = pinCode;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getRecepientName() {
		return recepientName;
	}

	public void setRecepientName(String recepientName) {
		this.recepientName = recepientName;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}
