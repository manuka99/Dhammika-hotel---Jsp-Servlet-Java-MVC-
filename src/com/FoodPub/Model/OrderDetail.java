package com.FoodPub.Model;

public class OrderDetail {
	private String productName;
	private float subtotal;
	private float shipping;
	private float tax;
	private float total;
	private float subTotal;

	public OrderDetail() {
		super();
	}

	public OrderDetail(String productName, float subtotal, float shipping, float tax, float total, float subTotal2) {
		super();
		this.productName = productName;
		this.subtotal = subtotal;
		this.shipping = shipping;
		this.tax = tax;
		this.total = total;
		subTotal = subTotal2;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public void setShipping(float shipping) {
		this.shipping = shipping;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getProductName() {
		return productName;
	}

	public String getSubtotal() {
		return String.format("%.2f", subtotal);
	}

	public String getShipping() {
		return String.format("%.2f", shipping);
	}

	public String getTax() {
		return String.format("%.2f", tax);
	}

	public String getTotal() {
		return String.format("%.2f", total);
	}
}
