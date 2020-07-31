package com.FoodPub.Model;

public class Notification_User {

	private String notificationID;
	private String userID;
	private String customID;
	private String customID2;
	private String string1;
	private String string2;
	private String memberSenderID;
	private String type;
	private String header;
	private String headerMember;
	private String body;
	private String bodyMember;
	private String time;
	private String url;
	private boolean seen;

	public Notification_User() {
		super();
		this.seen = false;
	}

	public String getHeaderMember() {
		return headerMember;
	}

	public void setHeaderMember(String headerMember) {
		this.headerMember = headerMember;
	}

	public String getBodyMember() {
		return bodyMember;
	}

	public void setBodyMember(String bodyMember) {
		this.bodyMember = bodyMember;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	public String getCustomID() {
		return customID;
	}

	public String getMemberSenderID() {
		return memberSenderID;
	}

	public void setMemberSenderID(String memberSenderID) {
		this.memberSenderID = memberSenderID;
	}

	public void setCustomID(String customID) {
		this.customID = customID;
	}

	public String getCustomID2() {
		return customID2;
	}

	public void setCustomID2(String customID2) {
		this.customID2 = customID2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(String notificationID) {
		this.notificationID = notificationID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
