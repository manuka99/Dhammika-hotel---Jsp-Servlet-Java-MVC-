package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;
import com.FoodPub.Dao.CategoryDaoImplement;
import com.FoodPub.Dao.CategoryDaoInterface;
import com.FoodPub.Model.Category;
import com.FoodPub.Util.UniqueIdGenerator;

public class CategoryServiceImplement implements CategoryServiceInterface {

	public static final Logger log = Logger.getLogger(CategoryServiceImplement.class.getName());

	private static CategoryDaoInterface categoryDaoInterface = new CategoryDaoImplement();

	public boolean addNewCategory(Category category) {

		if (category.getCategoryID() == null)
			category.setCategoryID(UniqueIdGenerator.userIDGenerator("cat"));

		return categoryDaoInterface.addNewCategory(category);

	}

	public ArrayList<Category> retrieveCategory(String cid) {

		return categoryDaoInterface.retrieveCategory(cid);

	}

	@Override
	public boolean deleteCategory(String cid) {
		// TODO Auto-generated method stub
		return categoryDaoInterface.deleteCategory(cid);
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDaoInterface.updateCategory(category);
	}

}
