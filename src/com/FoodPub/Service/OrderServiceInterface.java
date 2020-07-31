package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Model.OrderDB;
import com.FoodPub.Model.OrderedItems;

public interface OrderServiceInterface {

	public static final Logger log = Logger.getLogger(OrderServiceInterface.class.getName());
	
	public ArrayList<OrderDB> AllOrdersOrByUserID(String userID, String orderID) ;
	public boolean updateOrder(OrderDB Order);
	public boolean deleteOrder(String orderID);
	public boolean insertOrder(OrderDB order);
	public boolean orderValidate(OrderDB order);
	public boolean userPuchasseItemValidate(String userID, String fID);
}
