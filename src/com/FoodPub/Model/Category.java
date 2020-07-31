package com.FoodPub.Model;

public class Category {

	private String categoryID;
	private String name;
	private String description;

	public Category() {
		super();
	}

	public Category(String categoryID, String name, String description) {
		super();
		this.categoryID = categoryID;
		this.name = name;
		this.description = description;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
