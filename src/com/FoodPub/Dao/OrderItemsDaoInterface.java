package com.FoodPub.Dao;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Model.OrderedItems;

public interface OrderItemsDaoInterface {

	public static final Logger log = Logger.getLogger(OrderItemsDaoInterface.class.getName());

	public boolean insertOrderItem(ArrayList<OrderedItems> orderItems);

	public ArrayList<OrderedItems> retreiveOrderedItems(String orderID );

}
