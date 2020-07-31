package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.http.Part;

import com.FoodPub.Model.FoodItem;

public interface FoodServiceInteface {

	public static final Logger log = Logger.getLogger(FoodServiceInteface.class.getName());
	
	public boolean addNewFood(FoodItem foodItem, Part image);
	public ArrayList<FoodItem> retrieveFood(String fid, String cid, String search);
	public ArrayList<FoodItem> retrieveFoodPagination(String cid, int thisRecords, int recordsPerPage, String column, String type, int sliderValue);
	public int noOfFoodItems(String cid, int sliderValue);
	public boolean deleteFoodItem(String fid);
	public boolean updateFoodItem(FoodItem foodItem, Part image);	
}
