package com.FoodPub.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import com.FoodPub.Model.OrderDB;
import com.FoodPub.Service.CartServiceImplement;
import com.FoodPub.Service.CartServiceInterface;
import com.FoodPub.Service.DeliveryFeeServiceImplement;
import com.FoodPub.Service.DeliveryFeeServiceInterface;
import com.FoodPub.Service.FoodServiceImplement;
import com.FoodPub.Service.FoodServiceInteface;
import com.FoodPub.Service.OrderServiceImplement;
import com.FoodPub.Service.OrderServiceInterface;
import com.FoodPub.Service.PaymentServices;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.UniqueIdGenerator;
import com.google.gson.Gson;
import com.paypal.base.rest.PayPalRESTException;

/**
 * Servlet implementation class OrderManagementServlet
 */
@WebServlet("/OrderManagementServlet")
public class OrderManagementServlet extends HttpServlet {

	private OrderServiceInterface OSI = new OrderServiceImplement();
	private FoodServiceInteface FSI = new FoodServiceImplement();
	private DeliveryFeeServiceInterface DFSI = new DeliveryFeeServiceImplement();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderManagementServlet() {
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

		if (action.equals("/RetrieveOrdersPanel")) {

			String orderID = null;
			String userID = null;
			String oID = null;
			RequestDispatcher dis = null;

			if (request.getParameter("orderID") != null)
				orderID = request.getParameter("orderID");

			if (request.getParameter("userID") != null)
				userID = request.getParameter("userID");

			if (request.getParameter("oID") != null) {
				orderID = request.getParameter("oID");
				oID = orderID;
			}

			System.out.println(orderID + "ssds222223232sdsd");
			ArrayList<OrderDB> orderList = OSI.AllOrdersOrByUserID(userID, orderID);

			if (orderList != null && oID != null) {
				request.setAttribute("orderList", orderList);
				dis = request.getRequestDispatcher("/WEB-INF/views/admin/panel/order.jsp");
			} else {

				System.out.println("dad2232323232323232");
				if (orderList != null && orderID != null)
					request.setAttribute("orderReq", orderList.get(0));

				request.setAttribute("orderList", orderList);
				dis = request.getRequestDispatcher("/WEB-INF/views/admin/panel/orderManagement.jsp");

			}

			dis.forward(request, response);

		}

		else if (action.equals("/updateOrdersPanel")) {

			OrderDB order = new OrderDB();

			order.setOrderID(request.getParameter("orderID"));
			order.setUserID(request.getParameter("userID"));
			order.setdDate(request.getParameter("dDate"));
			order.setStatus(request.getParameter("status"));
			order.setPayment(request.getParameter("payment"));

			boolean result = OSI.updateOrder(order);

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}

		else if (action.equals("/updateOrdersUser")) {

			OrderDB order = new OrderDB();

			order.setOrderID(request.getParameter("orderID"));
			order.setdDate(request.getParameter("dDate"));
			order.setStatus(request.getParameter("status"));
			order.setPayment(request.getParameter("payment"));

			boolean result = OSI.updateOrder(order);

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}

		else if (action.equals("/CancelOrderUser")) {

			String orderID = request.getParameter("orderID");

			User user = (User) request.getSession().getAttribute("user");

			boolean result = false;

			ArrayList<OrderDB> OrderList = OSI.AllOrdersOrByUserID(user.getUserID(), orderID);

			if (OrderList != null) {

				for (OrderDB orderDB : OrderList) {

					// if the order state is processing we can cancel the order else if it is in
					// cancelled stage or dilivered stage or packing stage or completed stage
					if (orderDB.getOrderID().equals(orderID) && orderDB.getStatus().equals("processing")) {

						orderDB.setStatus("cancelled");
						result = OSI.updateOrder(orderDB);

					}

				}

			}

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}

		else if (action.equals("/GetMyOrders")) {

			RequestDispatcher dis = null;

			String orderID = null;

			User user = (User) request.getSession().getAttribute("user");

			if (request.getParameter("orderID") != null) {

				orderID = request.getParameter("orderID");

			}

			ArrayList<OrderDB> OrderList = OSI.AllOrdersOrByUserID(user.getUserID(), orderID);

			request.setAttribute("OrderList", OrderList);

			if (orderID != null)
				dis = request.getRequestDispatcher("/WEB-INF/views/profile/order.jsp");

			else
				dis = request.getRequestDispatcher("/WEB-INF/views/profile/myOrders.jsp");

			dis.forward(request, response);

		} else if (action.equals("/placeCOD")) {

			RequestDispatcher dis = null;

			OrderDB order = (OrderDB) request.getSession().getAttribute("orderDetail");

			if (request.getParameter("address2").isEmpty() == false && request.getParameter("address2") != null)
				order.setShippingAddress(request.getParameter("address2"));

			order.setPayment("not paid");
			order.setOrderType("COD");

			OSI.insertOrder(order);
			request.getSession().removeAttribute("orderDetail");
			request.getSession().removeAttribute("customer");
			dis = request.getRequestDispatcher("/WEB-INF/views/profile/profile.jsp");

			dis.forward(request, response);

		}

		else if (action.equals("/checkOut")) {

			User user = (User) request.getSession().getAttribute("user");

			HashMap<String, OrderDB> orderIdList = new HashMap<>();

			if (request.getSession().getAttribute("orderIdList") != null)
				orderIdList = (HashMap<String, OrderDB>) request.getSession().getAttribute("orderIdList");

			OrderDB orderDetail = new OrderDB();
			CartServiceInterface CSI = new CartServiceImplement();

			Cart myCart = CSI.retreiveCart(null, user.getUserID());

			HashMap<FoodItem, Integer> map = new HashMap<FoodItem, Integer>();

			for (CartItems cartItem : myCart.getCartItemList()) {

				try {
					if (cartItem.getFooditem().isActive())
						map.put(cartItem.getFooditem(), cartItem.getQuantity());
				} catch (Exception e) {
					// TODO: handle exception
				}

			}

			String orderID = UniqueIdGenerator.userIDGenerator("ord");
			orderDetail.setOrderID(orderID);
			orderDetail.setUserID(user.getUserID());
			orderDetail.setItemList(map);
			orderDetail.setShippingAddress(user.getAddress());
			orderDetail.setShippingFee(myCart.getShippingFee());
			orderDetail.setTax(myCart.getTax());
			orderDetail.setSubTotal(myCart.getProductPriceTotal());
			orderDetail.setTotal(myCart.getTotal());
			orderDetail.setCustomer(user);

			orderIdList.put(orderID, orderDetail);

			request.getSession().setAttribute("orderIdList", orderIdList);
			response.sendRedirect("ExpressV2?orderID=" + orderID);
			// request.getRequestDispatcher("ExpressV2?orderID=" + orderID).forward(request,
			// response);

		}

		else if (action.equals("/BuyNow")) {

			User user = (User) request.getSession().getAttribute("user");

			HashMap<String, OrderDB> orderIdList = new HashMap<>();

			if (request.getSession().getAttribute("orderIdList") != null)
				orderIdList = (HashMap<String, OrderDB>) request.getSession().getAttribute("orderIdList");

			String productId = request.getParameter("productID");
			Integer quantity = Integer.parseInt(request.getParameter("quantity"));
			ArrayList<FoodItem> FoodList = FSI.retrieveFood(productId, null, null);

			if (FoodList.size() == 1) {
				if (FoodList.get(0).isActive()) {
					OrderDB orderDetail = new OrderDB();

					double total = FoodList.get(0).getPrice() * quantity;
					double tax = FoodList.get(0).getTax() * quantity;
					HashMap<FoodItem, Integer> map = new HashMap<>();
					map.put(FoodList.get(0), quantity);

					double shippingFee = DFSI.retreiveFee(total);

					String orderID = UniqueIdGenerator.userIDGenerator("ord");
					orderDetail.setOrderID(orderID);
					orderDetail.setUserID(user.getUserID());
					orderDetail.setItemList(map);
					orderDetail.setShippingAddress(user.getAddress());
					orderDetail.setShippingFee(Double.parseDouble(String.format("%.2f", shippingFee)));
					orderDetail.setTax(Double.parseDouble(String.format("%.2f", tax)));
					orderDetail.setSubTotal(Double.parseDouble(String.format("%.2f", total)));
					orderDetail.setTotal(Double.parseDouble(String.format("%.2f", total + tax + shippingFee)));
					orderDetail.setCustomer(user);
					
					orderIdList.put(orderID, orderDetail);

					request.getSession().setAttribute("orderIdList", orderIdList);
					response.sendRedirect("ExpressV2?orderID=" + orderID);
				}
			} else
				response.sendRedirect("error");
		}

		else if (action.equals("/placeOrder")) {

			String orderID = request.getParameter("orderID");

			System.out.println("sdsdsdsdsd");
			
			if (request.getSession().getAttribute("orderIdList") != null) {

				System.out.println("sdsdsdsdsd");
				
				
				HashMap<String, OrderDB> orderIdList = (HashMap<String, OrderDB>) request.getSession()
						.getAttribute("orderIdList");

				if (orderIdList.containsKey(orderID)) {
					
					System.out.println("sdsdsdsdsd");

					OrderDB order = orderIdList.get(orderID);

					if (OSI.orderValidate(order)) {
						
						System.out.println("sdsdsdsdsd");

						User customer = order.getCustomer();

						if (request.getParameter("address2").isEmpty() == false
								&& request.getParameter("address2") != null)
							order.setShippingAddress(request.getParameter("address2"));

						order.setEstimatedDate(request.getParameter("dDate"));

						if (request.getParameter("orderType").equals("payhere")) {

							request.getSession().setAttribute("orderDetail", order);

							Map<String, Object> map = new HashMap<>();

							map.put("sandbox", true);
							map.put("merchant_id", "1214373");
							map.put("return_url", CommonConstants.APP_URL + "GetMyOrders?orderID=" + order.getOrderID());
							map.put("cancel_url", CommonConstants.APP_URL + "ExpressV2?orderID=" + orderID);
							map.put("notify_url", CommonConstants.APP_URL + "notifyPayhere");
							map.put("order_id", order.getOrderID());
							map.put("items", "not Required");
							map.put("amount", order.getTotal());
							map.put("currency", "LKR");
							map.put("first_name", customer.getName());
							map.put("last_name", "");
							map.put("email", customer.getEmail());
							map.put("phone", customer.getPhone());
							map.put("address", customer.getAddress());
							map.put("city", "Colombo");
							map.put("country", "Sri Lanka");
							map.put("delivery_address", order.getShippingAddress());
							map.put("delivery_city", "");
							map.put("delivery_country", "Sri Lanka");

							System.out.println(CommonConstants.APP_URL + "GetMyOrders?orderID=" + order.getOrderID());
							
							response.setContentType("application/json");
							response.setCharacterEncoding("UTF-8");
							response.getWriter().write(new Gson().toJson(map));

						}

						else if (request.getParameter("orderType").equals("paypal")) {

							try {
								PaymentServices paymentServices = new PaymentServices();
								System.out.println(order.getdDate() + "sdsdsdsdsdsdsdsd");
								String approvalLink = paymentServices.authorizePayment(order);

								response.sendRedirect(approvalLink);

							} catch (PayPalRESTException ex) {
								request.setAttribute("errorMessage", ex.getMessage());
								ex.printStackTrace();
								request.getRequestDispatcher("error.jsp").forward(request, response);
							}

						}

						else if (request.getParameter("orderType").equals("COD")) {

							order.setPayment("not paid");
							order.setOrderType("COD");

							OSI.insertOrder(order);

							try {

								HashMap<String, OrderDB> orderIdListnew = (HashMap<String, OrderDB>) request
										.getSession().getAttribute("orderIdList");
								orderIdListnew.remove(orderID);
								request.getSession().removeAttribute("orderIdList");
								request.getSession().setAttribute("orderIdList", orderIdListnew);

							} catch (Exception e) {
								// TODO: handle exception
							}

							response.sendRedirect("GetMyOrders?orderID=" + order.getOrderID());

						}
					} else {
						try {

							HashMap<String, OrderDB> orderIdListnew = (HashMap<String, OrderDB>) request.getSession()
									.getAttribute("orderIdList");
							orderIdListnew.remove(orderID);
							request.getSession().removeAttribute("orderIdList");
							request.getSession().setAttribute("orderIdList", orderIdListnew);

						} catch (Exception e) {
							// TODO: handle exception
						}

					}
				}
			}

		}

		else if (action.equals("/notifyPayhere")) {
			
			
			System.out.println("sdsdsdsdsdsdsdwew43434342ddfdgff  vdfdfd");

			String merchant_id = request.getParameter("merchant_id");
			String order_id = request.getParameter("order_id");
			String payhere_amount = request.getParameter("payhere_amount");
			String payhere_currency = request.getParameter("payhere_currency");
			String status_code = request.getParameter("status_code");
			String md5sig = request.getParameter("md5sig");
			String method = request.getParameter("method ");
			String status = "";

			OrderDB order = new OrderDB();
			CartServiceInterface CSI = new CartServiceImplement();

			order.setOrderID(order_id);
			order.setTotal(Double.parseDouble(payhere_amount));

			order.setPayment("not paid");

			if (status_code.equals("0"))
				status = "pending";

			else if (status_code.equals("-3"))
				status = "chargedback";

			else if (status_code.equals("2"))
				status = "success";

			else if (status_code.equals("-1"))
				status = "canceled";

			else
				status = "failed";

			order.setPayment(status);
			order.setOrderType("payhere");

			OSI.insertOrder(order);
			request.getSession().removeAttribute(order_id);
			response.sendRedirect("profile");

		}

	}

}
