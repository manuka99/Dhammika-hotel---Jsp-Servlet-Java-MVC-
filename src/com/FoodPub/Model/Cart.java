package com.FoodPub.Model;

import java.util.HashMap;
import java.util.List;

public class Cart {

	private String cartID;
	private String userID;
	private int itemCount;
	private double productPriceTotal;
	//private HashMap<FoodItem, Integer> cartItems;
	private double tax;
	private double shippingFee;
	private double total;
	private List<CartItems> cartItemList;

	public Cart() {
		super();
	}

	public List<CartItems> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItems> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public String getCartID() {
		return cartID;
	}

	public void setCartID(String cartID) {
		this.cartID = cartID;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public double getProductPriceTotal() {
		return productPriceTotal;
	}

	public void setProductPriceTotal(double productPriceTotal) {
		this.productPriceTotal = productPriceTotal;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

}
