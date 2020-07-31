package com.FoodPub.Dao;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Model.Category;

public interface CategoryDaoInterface {

	public static final Logger log = Logger.getLogger(CategoryDaoInterface.class.getName());
	public boolean addNewCategory(Category category);
	public ArrayList<Category> retrieveCategory(String cid);
	public boolean deleteCategory(String cid);
	public boolean updateCategory(Category category);
	
}
