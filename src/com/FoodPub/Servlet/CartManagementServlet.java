package com.FoodPub.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FoodPub.Model.Cart;
import com.FoodPub.Model.CartItems;
import com.FoodPub.Model.FoodItem;
import com.FoodPub.Model.User;
import com.FoodPub.Service.CartItemsServiceImplement;
import com.FoodPub.Service.CartItemsServiceInterface;
import com.FoodPub.Service.CartServiceImplement;
import com.FoodPub.Service.CartServiceInterface;
import com.FoodPub.Service.FoodServiceImplement;
import com.FoodPub.Service.FoodServiceInteface;
import com.FoodPub.Service.UserServiceImplement;
import com.FoodPub.Service.UserServiceInterface;

/**
 * Servlet implementation class CartManagementServlet
 */
@WebServlet("/CartManagementServlet")
public class CartManagementServlet extends HttpServlet {

	private CartServiceInterface CSI = new CartServiceImplement();
	private CartItemsServiceInterface CISI = new CartItemsServiceImplement();
	private static final UserServiceInterface MSI = new UserServiceImplement();
	private FoodServiceInteface FSI = new FoodServiceImplement();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartManagementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		
		
		if (action.equals("/cart")) {

			User user = (User) request.getSession().getAttribute("user");

			Cart myCart = CSI.retreiveCart(null, user.getUserID());
			
			if (request.getSession().getAttribute("CartDetails") != null) {
				request.getSession().removeAttribute("CartDetails");
			}
			
			request.getSession().setAttribute("CartDetails", myCart);
			request.getRequestDispatcher("/WEB-INF/views/profile/myCart.jsp").forward(request, response);
		}

		else if (action.equals("/UpdateMyCartItem")) {

			String msg = "";

			User user = (User) request.getSession().getAttribute("user");

			String itemID = request.getParameter("itemID");
			int newQty = Integer.parseInt(request.getParameter("newQty"));

			Cart myCart = CSI.retreiveCart(null, user.getUserID());

			CartItems cartItem = new CartItems();
			
			cartItem = CISI.retreiveCartItem(myCart.getCartID(), itemID);

			if (cartItem.getCartID() != null && newQty < 4 && newQty > 0) {

				cartItem.setCartID(myCart.getCartID());
				cartItem.setProductID(itemID);
				cartItem.setQuantity(newQty);

				boolean result = CISI.updateCartItem(cartItem);

				if (result == true) {

					if (request.getSession().getAttribute("CartDetails") != null) {
						request.getSession().removeAttribute("CartDetails");
					}
					Cart myCartnew = CSI.retreiveCart(null, user.getUserID());
					request.getSession().setAttribute("CartDetails", myCartnew);

					msg = "success";
				}

				else
					msg = "failed";

			} else {
				msg = "changed";
			}

			PrintWriter out = response.getWriter();
			out.print(msg);
			out.flush();
			out.close();

		} else if (action.equals("/RemoveCartItem")) {

			String msg = "";

			User user = (User) request.getSession().getAttribute("user");

			Cart myCart = CSI.retreiveCart(null, user.getUserID());

			String itemID = request.getParameter("itemID");

			CartItems cartItem = new CartItems();

			cartItem = CISI.retreiveCartItem(myCart.getCartID(), itemID);

			if (cartItem.getProductID().isEmpty() == false) {

				boolean result = CISI.deleteCartItems(cartItem);

				if (result == true) {
					msg = "success";
					
					if (request.getSession().getAttribute("CartDetails") != null) {
						request.getSession().removeAttribute("CartDetails");
					}
					
					Cart myCartnew = CSI.retreiveCart(null, user.getUserID());
					request.getSession().setAttribute("CartDetails", myCartnew);
				} else {
					msg = "failed";
				}

			} else {
				msg = "changed";
			}

			PrintWriter out = response.getWriter();
			out.print(msg);
			out.flush();
			out.close();

		}

		else if (action.equals("/AddCartItem")) {

			String msg = "noAccess";
			String text = "";
			boolean result = false;
			int quantity = 1;

			try {
				if (request.getParameter("qty") != null)
					quantity = Integer.parseInt(request.getParameter("qty"));

			} catch (Exception e) {
				quantity = 1;
			}

			User user = (User) request.getSession().getAttribute("user");

			String itemID = request.getParameter("itemID");

					CartItems cartItem = new CartItems();

					Cart myCart = CSI.retreiveCart(null, user.getUserID());

					cartItem = CISI.retreiveCartItem(myCart.getCartID(), itemID);
					if (cartItem.getCartID() != null) {

						if (cartItem.getQuantity() + quantity < 4 && quantity > 0) {

							text = "updated";
							cartItem.setQuantity(cartItem.getQuantity() + quantity);

							result = CISI.updateCartItem(cartItem);
						}
					}

					else if (cartItem.getCartID() == null) {
						if (quantity < 4 && quantity > 0) {
							text = "added";
							cartItem.setCartID(myCart.getCartID());
							cartItem.setProductID(itemID);
							cartItem.setQuantity(quantity);
							result = CISI.addCartItem(cartItem);
						}
					}

				

			

			if (result == true) {

				msg = text;
				Cart myCartnew = CSI.retreiveCart(null, user.getUserID());
				
				if (request.getSession().getAttribute("CartDetails") != null) {
					request.getSession().removeAttribute("CartDetails");
				}
				
				request.getSession().setAttribute("CartDetails", myCartnew);

			}

			else if (result == false) {
				msg = "failed";
			}

			PrintWriter out = response.getWriter();
			out.print(msg);
			out.flush();
			out.close();

		}
	}

}
