package com.FoodPub.Service;


import java.util.logging.Logger;

import com.FoodPub.Model.Cart;
public interface CartServiceInterface {
	
	public static final Logger log = Logger.getLogger(CartServiceInterface.class.getName());
	
	public Boolean addCart(Cart cart);

	public Cart retreiveCart(String cartID, String userID);
	
	public boolean CalculateUpdateTheCart(String cartID);
}
