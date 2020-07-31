package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;
import javax.servlet.http.Part;

import com.FoodPub.Dao.FoodDaoImplement;
import com.FoodPub.Dao.FoodDaoInterface;
import com.FoodPub.Model.FoodItem;
import com.FoodPub.Util.UniqueIdGenerator;


public class FoodServiceImplement implements FoodServiceInteface {

	private FoodDaoInterface foodDaoInterface = new FoodDaoImplement();

	public static final Logger log = Logger.getLogger(FoodServiceImplement.class.getName());

	public boolean addNewFood(FoodItem foodItem, Part image) {

		foodItem.setItemID(UniqueIdGenerator.userIDGenerator("food"));
		
		
		return foodDaoInterface.addNewFood(foodItem, image);

	}

	public ArrayList<FoodItem> retrieveFood(String fid, String cid, String search) {

		return foodDaoInterface.retrieveFood(fid, cid, search);
	}

	public ArrayList<FoodItem> retrieveFoodPagination(String cid, int thisRecords, int recordsPerPage, String column,
			String type, int sliderValue){
		System.out.println("asasas");
		return foodDaoInterface.retrieveFoodPagination(cid, thisRecords, recordsPerPage, column, type, sliderValue);
		
	}

	public int noOfFoodItems(String cid, int sliderValue) {
		
		return foodDaoInterface.noOfFoodItems(cid, sliderValue);
		
	}

	@Override
	public boolean deleteFoodItem(String fid) {
		return foodDaoInterface.deleteFoodItem(fid);
	}

	@Override
	public boolean updateFoodItem(FoodItem foodItem, Part image) {
		return foodDaoInterface.updateFoodItem(foodItem, image);
	}

}
