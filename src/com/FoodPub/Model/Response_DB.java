package com.FoodPub.Model;

import java.util.List;

public class Response_DB {
	private String responseID;
	private String message;
	private String time;
	private String preetyTime;
	private List<String> images;
	private User user;

	public String getResponseID() {
		return responseID;
	}

	public String getPreetyTime() {
		return preetyTime;
	}

	public void setPreetyTime(String preetyTime) {
		this.preetyTime = preetyTime;
	}

	public void setResponseID(String responseID) {
		this.responseID = responseID;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
