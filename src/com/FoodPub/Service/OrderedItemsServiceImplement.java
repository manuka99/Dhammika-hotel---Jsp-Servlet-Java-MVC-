package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Dao.OrderItemsDaoImplement;
import com.FoodPub.Dao.OrderItemsDaoInterface;
import com.FoodPub.Model.OrderedItems;

public class OrderedItemsServiceImplement implements OrderedItemsServiceInterface{
	
	private OrderItemsDaoInterface OSI = new OrderItemsDaoImplement();

	public static final Logger log = Logger.getLogger(OrderedItemsServiceImplement.class.getName());
	
	@Override
	public boolean insertOrderItem(ArrayList<OrderedItems> orderItems) {
		return OSI.insertOrderItem(orderItems);
	}

	@Override
	public ArrayList<OrderedItems> retreiveOrderedItems(String orderID ) {
		return OSI.retreiveOrderedItems(orderID);
	}

}
