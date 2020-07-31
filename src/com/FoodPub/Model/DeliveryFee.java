package com.FoodPub.Model;

public class DeliveryFee {

	private String id;
	private double total;
	private double fee;

	public DeliveryFee() {
		super();
	}

	public DeliveryFee(String id, double total, double fee) {
		super();
		this.id = id;
		this.total = total;
		this.fee = fee;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

}
