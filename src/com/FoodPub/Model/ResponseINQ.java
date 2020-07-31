package com.FoodPub.Model;

public class ResponseINQ extends Response_DB {

	private String inquiryID;

	public ResponseINQ() {
		super();
	}

	public String getInquiryID() {
		return inquiryID;
	}

	public void setInquiryID(String inquiryID) {
		this.inquiryID = inquiryID;
	}

}
