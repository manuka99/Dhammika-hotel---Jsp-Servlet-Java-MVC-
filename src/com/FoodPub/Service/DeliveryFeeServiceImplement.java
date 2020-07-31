package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Dao.DeliveryFeeDaoImplement;
import com.FoodPub.Dao.DeliveryFeeDaoInterface;
import com.FoodPub.Model.DeliveryFee;
import com.FoodPub.Util.UniqueIdGenerator;

public class DeliveryFeeServiceImplement implements DeliveryFeeServiceInterface {

	private DeliveryFeeDaoInterface DSDI = new DeliveryFeeDaoImplement();

	public static final Logger log = Logger.getLogger(DeliveryFeeServiceImplement.class.getName());

	@Override
	public boolean addDeliveryFee(DeliveryFee deliveryFee) {

		deliveryFee.setId(UniqueIdGenerator.userIDGenerator("fee"));

		return DSDI.addDeliveryFee(deliveryFee);
	}

	@Override
	public boolean updateDeliveryFee(DeliveryFee deliveryFee) {
		return DSDI.updateDeliveryFee(deliveryFee);
	}

	@Override
	public boolean deleteDeliveryFee(String id) {
		return DSDI.deleteDeliveryFee(id);
	}

	@Override
	public double retreiveFee(double total) {
		return DSDI.retreiveFee(total);
	}

	@Override
	public ArrayList<DeliveryFee> retreiveAllDeliveryFee(String did) {
		return DSDI.retreiveAllDeliveryFee(did);
	}

}
