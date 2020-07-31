package com.FoodPub.Dao;

import java.util.logging.Logger;

import com.FoodPub.Model.Cart;

public interface CartDaoInterface {

	public static final Logger log = Logger.getLogger(CartDaoInterface.class.getName());

	public Boolean addCart(Cart cart);

	public Boolean updateCart(Cart cart);

	public Cart retreiveCart(String cartID, String userID);

}
