package com.FoodPub.Model;

import java.util.List;

public class InquiryDB {

	private String inquiryID;
	private String subject;
	private String message;
	private String time;
	private User user;
	private List<String> images;
	private List<ResponseINQ> responses;

	public InquiryDB() {
		super();
	}

	public String getInquiryID() {
		return inquiryID;
	}

	public void setInquiryID(String inquiryID) {
		this.inquiryID = inquiryID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<ResponseINQ> getResponses() {
		return responses;
	}

	public void setResponses(List<ResponseINQ> responses) {
		this.responses = responses;
	}

}
