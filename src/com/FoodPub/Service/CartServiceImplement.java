package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import com.FoodPub.Dao.CartDaoImplement;
import com.FoodPub.Dao.CartDaoInterface;
import com.FoodPub.Model.Cart;
import com.FoodPub.Model.CartItems;
import com.FoodPub.Model.FoodItem;

public class CartServiceImplement implements CartServiceInterface {

	private CartDaoInterface CDI = new CartDaoImplement();
	private CartItemsServiceInterface CISI = new CartItemsServiceImplement();
	private FoodServiceInteface FSI = new FoodServiceImplement();
	private DeliveryFeeServiceInterface DFSI = new DeliveryFeeServiceImplement();

	public static final Logger log = Logger.getLogger(CartServiceImplement.class.getName());

	@Override
	public Boolean addCart(Cart cart) {
		return CDI.addCart(cart);
	}

	@Override
	public Cart retreiveCart(String cartID, String userID) {

		Cart cart = CDI.retreiveCart(cartID, userID);

		if (CalculateUpdateTheCart(cart.getCartID())) {
			cart = CDI.retreiveCart(cartID, userID);
			ArrayList<CartItems> cartItems = CISI.retreiveCartItems(cart.getCartID());
			cart.setCartItemList(cartItems);
		}

		// HashMap<FoodItem, Integer> cartItemsSet = new HashMap<FoodItem, Integer>();

		/*
		 * for (CartItems cartItem : cartItems) {
		 * 
		 * System.out.println("dqaw223232323ggg xdfs   fdffdfdfdf");
		 * 
		 * if (cartItem.getProductID().isEmpty() == false) {
		 * 
		 * System.out.println("adade4444342hfgfg" + cartItem.getProductID() +
		 * cartItem.getQuantity());
		 * 
		 * ArrayList<FoodItem> foodItem = FSI.retrieveFood(cartItem.getProductID(),
		 * null, null); cartItemsSet.put(foodItem.get(0), cartItem.getQuantity());
		 * 
		 * }
		 * 
		 * }
		 */

		// cart.setCartItems(cartItemsSet);

		return cart;
	}

	@Override
	public boolean CalculateUpdateTheCart(String cartID) {

		Cart cart = CDI.retreiveCart(cartID, null);
		cart.setCartItemList(CISI.retreiveCartItems(cart.getCartID()));

		int count = 0;
		Double productPriceTotal = 0.00;
		double tax = 0.00;

		if (cart != null) {

			/*
			 * for (FoodItem item : cart.getCartItems().keySet()) {
			 * 
			 * count += cart.getCartItems().get(item); productPriceTotal += item.getPrice()
			 * * cart.getCartItems().get(item); tax += item.getTax() *
			 * cart.getCartItems().get(item);
			 * 
			 * }
			 */

			count += cart.getCartItemList().size();

			for (CartItems cartItem : cart.getCartItemList()) {

				try {
					if (cartItem.getFooditem().isActive()) {

						productPriceTotal += cartItem.getFooditem().getPrice() * cartItem.getQuantity();
						tax += cartItem.getFooditem().getTax() * cartItem.getQuantity();

					}
				} catch (Exception e) {
					// TODO: handle exception
				}

			}

		}

		productPriceTotal = Double.parseDouble(String.format("%.2f", productPriceTotal));
		double shippingFee = DFSI.retreiveFee(productPriceTotal);
		tax = Double.parseDouble(String.format("%.2f", tax));
		double total = Double.parseDouble(String.format("%.2f", (productPriceTotal + tax + shippingFee)));

		cart.setItemCount(count);
		cart.setProductPriceTotal(productPriceTotal);
		cart.setShippingFee(DFSI.retreiveFee(productPriceTotal));
		cart.setTax(tax);
		cart.setTotal(total);

		return CDI.updateCart(cart);
	}

}
