package com.FoodPub.Dao;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Model.OrderDB;

public interface OrderDaoInterface {
	
	public static final Logger log = Logger.getLogger(OrderDaoInterface.class.getName());
	
	public ArrayList<OrderDB> AllOrdersOrByUserID(String userID, String orderID) ;
	public boolean updateOrder(OrderDB Order);
	public boolean deleteOrder(String orderID);
	public boolean insertOrder(OrderDB order);

}
