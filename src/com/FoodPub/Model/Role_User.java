package com.FoodPub.Model;

public class Role_User {

	private String roleID;
	private String userID;

	public Role_User() {
		super();
	}

	public Role_User(String roleID, String userID) {
		super();
		this.roleID = roleID;
		this.userID = userID;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

}
