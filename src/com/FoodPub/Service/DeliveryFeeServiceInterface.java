package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Model.DeliveryFee;

public interface DeliveryFeeServiceInterface {

	public static final Logger log = Logger.getLogger(DeliveryFeeServiceInterface.class.getName());

	public boolean addDeliveryFee(DeliveryFee deliveryFee);
	public boolean updateDeliveryFee(DeliveryFee deliveryFee);
	public boolean deleteDeliveryFee(String did);
	public double retreiveFee(double total);
	public ArrayList<DeliveryFee> retreiveAllDeliveryFee(String did);
	
}
