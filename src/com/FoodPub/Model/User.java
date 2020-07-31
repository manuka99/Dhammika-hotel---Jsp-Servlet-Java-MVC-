package com.FoodPub.Model;

import java.util.List;

public class User {

	private String userID;
	private String name;
	private String email;
	private int phone;
	private String password;
	private Boolean status;
	// private String verifyCode;
	private String dateOfBirth;
	private String address;
	private List<Role> roles;
	private Cart cart;
	private List<OrderDB> orders;
	private List<Notification_User> notifications;

	public User() {
		status = false;
	}

	public String getUserID() {
		return userID;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<OrderDB> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDB> orders) {
		this.orders = orders;
	}

	public List<Notification_User> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification_User> notifications) {
		this.notifications = notifications;
	}

}
