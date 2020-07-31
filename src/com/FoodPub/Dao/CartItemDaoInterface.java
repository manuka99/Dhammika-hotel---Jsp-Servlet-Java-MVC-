package com.FoodPub.Dao;

import java.util.ArrayList;
import java.util.logging.Logger;
import com.FoodPub.Model.CartItems;

public interface CartItemDaoInterface {
	
	public static final Logger log = Logger.getLogger(CartItemDaoInterface.class.getName());

	public Boolean addCartItem(CartItems cartItem);

	public Boolean updateCartItem(CartItems cartItem);

	public ArrayList<CartItems> retreiveCartItems(String cartID);
	
	public boolean deleteCartItems(CartItems cartItem);

	public CartItems retreiveCartItem(String cartID, String itemID);
}
