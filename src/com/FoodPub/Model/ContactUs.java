package com.FoodPub.Model;

import java.util.List;

public class ContactUs {

	private String contactUsID;
	private String name;
	private String email;
	private String phone;
	private String subject;
	private String message;
	private String time;
	private List<Response_CNT> responses;

	public ContactUs() {
		super();
	}

	public List<Response_CNT> getResponses() {
		return responses;
	}

	public void setResponses(List<Response_CNT> responses) {
		this.responses = responses;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContactUsID() {
		return contactUsID;
	}

	public void setContactUsID(String contactUsID) {
		this.contactUsID = contactUsID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

}
