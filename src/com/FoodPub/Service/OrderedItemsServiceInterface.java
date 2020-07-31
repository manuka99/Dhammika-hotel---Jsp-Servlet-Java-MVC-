package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Model.OrderedItems;

public interface OrderedItemsServiceInterface {
	
	public static final Logger log = Logger.getLogger(OrderedItemsServiceInterface.class.getName());
	
	public boolean insertOrderItem(ArrayList<OrderedItems> orderItems);

	public ArrayList<OrderedItems> retreiveOrderedItems(String orderID );


}
