package com.FoodPub.Model;

public class FoodItem {
	
	private String itemID;
	private String name;
	private String image;
	private String description; 
	private double price;
	private double tax;
	private String catergoryID;	
	private String portion;
	private boolean active;

	public FoodItem() {
		super();
	}

	public FoodItem(String itemID, String name, String image, String description, double price, double tax,
			String catergoryID, String portion, boolean active) {
		super();
		this.itemID = itemID;
		this.name = name;
		this.image = image;
		this.description = description;
		this.price = price;
		this.tax = tax;
		this.catergoryID = catergoryID;
		this.portion = portion;
		this.active = active;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public String getCatergoryID() {
		return catergoryID;
	}

	public void setCatergoryID(String catergoryID) {
		this.catergoryID = catergoryID;
	}

	public String getPortion() {
		return portion;
	}

	public void setPortion(String portion) {
		this.portion = portion;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}