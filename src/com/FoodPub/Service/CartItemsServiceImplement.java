package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Dao.CartItemDaoImplement;
import com.FoodPub.Dao.CartItemDaoInterface;
import com.FoodPub.Model.CartItems;
import com.FoodPub.Model.FoodItem;

public class CartItemsServiceImplement implements CartItemsServiceInterface {

	private CartItemDaoInterface CDI = new CartItemDaoImplement();
	private FoodServiceInteface FSI = new FoodServiceImplement();

	public static final Logger log = Logger.getLogger(CartItemsServiceImplement.class.getName());

	@Override
	public Boolean addCartItem(CartItems cartItem) {

		boolean result = false;
		ArrayList<FoodItem> FoodList = FSI.retrieveFood(cartItem.getProductID(), null, null);

		if (FoodList.size() == 1) {

			if (FoodList.get(0).isActive()) {

				result = CDI.addCartItem(cartItem);
				CartServiceInterface CSII = new CartServiceImplement();
				if (result == true)
					result = CSII.CalculateUpdateTheCart(cartItem.getCartID());
			}

		}

		return result;
	}

	@Override
	public Boolean updateCartItem(CartItems cartItem) {
		boolean result = false;
		ArrayList<FoodItem> FoodList = FSI.retrieveFood(cartItem.getProductID(), null, null);

		if (FoodList.size() == 1) {

			if (FoodList.get(0).isActive()) {

				result = CDI.updateCartItem(cartItem);
				CartServiceInterface CSII = new CartServiceImplement();
				if (result == true)
					result = CSII.CalculateUpdateTheCart(cartItem.getCartID());

			}

		}

		return result;
	}

	@Override
	public ArrayList<CartItems> retreiveCartItems(String cartID) {
		ArrayList<CartItems> cartItems = CDI.retreiveCartItems(cartID);

		for (CartItems cartItem : cartItems) {

			try {
				cartItem.setFooditem(FSI.retrieveFood(cartItem.getProductID(), null, null).get(0));
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return cartItems;
	}

	@Override
	public boolean deleteCartItems(CartItems cartItem) {
		boolean result = CDI.deleteCartItems(cartItem);
		CartServiceInterface CSII = new CartServiceImplement();
		if (result == true)
			result = CSII.CalculateUpdateTheCart(cartItem.getCartID());

		return result;
	}

	@Override
	public CartItems retreiveCartItem(String cartID, String itemID) {
		return CDI.retreiveCartItem(cartID, itemID);
	}
}
