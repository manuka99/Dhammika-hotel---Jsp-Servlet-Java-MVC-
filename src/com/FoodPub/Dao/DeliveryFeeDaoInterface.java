package com.FoodPub.Dao;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Model.DeliveryFee;

public interface DeliveryFeeDaoInterface {
	
	public static final Logger log = Logger.getLogger(DeliveryFeeDaoInterface.class.getName());

	public boolean addDeliveryFee(DeliveryFee deliveryFee);
	public boolean updateDeliveryFee(DeliveryFee deliveryFee);
	public boolean deleteDeliveryFee(String id);
	public double retreiveFee(double total);
	public ArrayList<DeliveryFee> retreiveAllDeliveryFee(String id);
	
}
