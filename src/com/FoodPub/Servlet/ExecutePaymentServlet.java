/**
 * ExecutePaymentServlet class - execute payment via PayPal.
 * @author Nam Ha Minh
 * @copyright https://codeJava.net
 */
package com.FoodPub.Servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.FoodPub.Model.FoodItem;
import com.FoodPub.Model.OrderDB;
import com.FoodPub.Service.OrderServiceImplement;
import com.FoodPub.Service.OrderServiceInterface;
import com.FoodPub.Service.PaymentServices;
import com.FoodPub.Util.UniqueIdGenerator;
import com.paypal.api.payments.*;
import com.paypal.base.rest.PayPalRESTException;

@WebServlet("/execute_payment")
public class ExecutePaymentServlet extends HttpServlet {
	
	private OrderServiceInterface OSI = new OrderServiceImplement();
	private static final long serialVersionUID = 1L;

	public ExecutePaymentServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paymentId = request.getParameter("paymentId");
		String payerId = request.getParameter("PayerID");

		try {
			PaymentServices paymentServices = new PaymentServices();
			Payment payment = paymentServices.executePayment(paymentId, payerId);
			
			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(0);
			ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();
			
			ItemList itemList2 = transaction.getItemList();
			
			List<Item> items = new ArrayList<>();
			
			items = itemList2.getItems();
			
			HashMap<FoodItem, Integer> mapp = new HashMap<>();
			
			for (Item item : items) {
				
				FoodItem foodItem = new FoodItem();
				foodItem.setItemID(item.getSku());
				mapp.put(foodItem, Integer.parseInt(item.getQuantity()));
				
			}
			

            System.out.println("sasasasasasasasasasasasaaaattttt" + payment.getId());
            System.out.println("sasasasasasasasasasasasaaaattttt" + payment.getPayer().getPaymentMethod());
            System.out.println("sasasasasasasasasasasasaaaattttt" + payment.getState());
            System.out.println("sasasasasasasasasasasasaaaattttt" + payment.getCreateTime());
            System.out.println("sasasasasasasasasasasasaaaattttt" + payment.getUpdateTime());

			
			OrderDB order = new OrderDB();
			order.setOrderID(transaction.getInvoiceNumber());
			order.setSubTotal(Double.parseDouble(transaction.getAmount().getDetails().getSubtotal()));
			order.setTax(Double.parseDouble(transaction.getAmount().getDetails().getTax()));
			order.setShippingFee(Double.parseDouble(transaction.getAmount().getDetails().getShipping()));
			order.setTotal(Double.parseDouble(transaction.getAmount().getTotal()));
			order.setShippingAddress( shippingAddress.getLine1() + " " + shippingAddress.getCity() + " " + shippingAddress.getState() + " " + shippingAddress.getPostalCode());
			order.setUserID(transaction.getCustom());
			order.setPayment(payment.getState());
			order.setOrderType(payment.getPayer().getPaymentMethod());
			order.setTransactionID(payment.getId());
			order.setdDate(itemList2.getShippingMethod());
			System.out.println(itemList2.getShippingMethod());
			//order.setUserID(payerInfo.getExternalReuserMeId());
			order.setItemList(mapp);
			
			OSI.insertOrder(order);
			
			request.setAttribute("payer", payerInfo);
			request.setAttribute("transaction", transaction);
			//request.getSession().removeAttribute("orderDetail");
			//request.getSession().removeAttribute("customer");
			try {

				HashMap<String, OrderDB> orderIdListnew = (HashMap<String, OrderDB>) request
						.getSession().getAttribute("orderIdList");
				orderIdListnew.remove(order.getOrderID());
				request.getSession().removeAttribute("orderIdList");
				request.getSession().setAttribute("orderIdList", orderIdListnew);

			} catch (Exception e) {
				// TODO: handle exception
			}
			
			response.sendRedirect("GetMyOrders?orderID=" + order.getOrderID());
			
		} catch (PayPalRESTException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
