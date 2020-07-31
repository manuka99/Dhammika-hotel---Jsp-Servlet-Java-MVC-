package com.FoodPub.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import com.FoodPub.Dao.OrderDaoImplement;
import com.FoodPub.Dao.OrderDaoInterface;
import com.FoodPub.Model.FoodItem;
import com.FoodPub.Model.Notification_User;
import com.FoodPub.Model.OrderDB;
import com.FoodPub.Model.OrderedItems;
import com.FoodPub.Model.User;
import com.FoodPub.Util.UniqueIdGenerator;

public class OrderServiceImplement implements OrderServiceInterface {

	private FoodServiceInteface FSI = new FoodServiceImplement();
	private OrderedItemsServiceInterface OISI = new OrderedItemsServiceImplement();
	private OrderDaoInterface ODI = new OrderDaoImplement();
	private EmailServiceInterface ESI = new EmailService();
	private Notification_UsersServiceInterface NUSI = new Notification_UsersServiceImplement();

	public static final Logger log = Logger.getLogger(OrderServiceImplement.class.getName());

	@Override
	public ArrayList<OrderDB> AllOrdersOrByUserID(String userID, String orderID) {

		ArrayList<OrderDB> orders = ODI.AllOrdersOrByUserID(userID, orderID);

		if (orders != null && orderID != null) {

			for (OrderDB order : orders) {

				ArrayList<OrderedItems> orderedItems = new ArrayList<>();
				HashMap<FoodItem, Integer> ItemsSet = new HashMap<FoodItem, Integer>();

				orderedItems = OISI.retreiveOrderedItems(order.getOrderID());

				for (OrderedItems item : orderedItems) {

					if (item.getProductID().isEmpty() == false) {

						ArrayList<FoodItem> foodItem = FSI.retrieveFood(item.getProductID(), null, null);

						ItemsSet.put(foodItem.get(0), item.getQuantity());

					}

				}

				order.setItemList(ItemsSet);

			}

		}

		return orders;
	}

	@Override
	public boolean updateOrder(OrderDB Order) {

		boolean result = ODI.updateOrder(Order);
		UserServiceInterface MSI = new UserServiceImplement();
		if (result == true) {
			ESI.orderStatusEmail(MSI.retriveUsers(Order.getUserID()), Order);
			Notification_User notification = new Notification_User();
			notification.setType("Order");

			// for the panel
			notification.setHeader("Order has been " + Order.getStatus());
			notification.setBody(Order.getStatus() + " Order has been" + Order.getStatus());

			notification.setCustomID(Order.getOrderID());
			notification.setCustomID2(Order.getUserID());

			// for the user
			notification.setMemberSenderID(Order.getUserID());
			notification.setHeaderMember("Your Order has been " + Order.getStatus());
			notification.setBodyMember(Order.getStatus() + " Order has been" + Order.getStatus());

			NUSI.insertNotification_Users(notification);
		}
		return result;
	}

	@Override
	public boolean deleteOrder(String orderID) {
		return ODI.deleteOrder(orderID);
	}

	@Override
	public boolean insertOrder(OrderDB order) {

		boolean result = false;

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		order.setpDate(dtf.format(now));
		// order.setEstimatedDate(dtf.format(now.plusDays(1)));

		order.setStatus("processing");

		result = ODI.insertOrder(order);

		if (result == true) {
			ArrayList<OrderedItems> OrderedItemsList = new ArrayList<OrderedItems>();

			// order.setOrderID(UniqueIdGenerator.userIDGenerator("ord"));

			for (FoodItem foodItem : order.getItemList().keySet()) {
				OrderedItems orderedItem = new OrderedItems();
				orderedItem.setOrderID(order.getOrderID());
				orderedItem.setProductID(foodItem.getItemID());
				orderedItem.setQuantity(order.getItemList().get(foodItem));

				OrderedItemsList.add(orderedItem);
			}

			result = OISI.insertOrderItem(OrderedItemsList);
			UserServiceInterface MSI = new UserServiceImplement();
			ESI.orderPlacedEmail(MSI.retriveUsers(order.getUserID()), order);

			Notification_User notification = new Notification_User();
			notification.setType("Order");

			// for the panel
			notification.setHeader("New Order");
			notification.setBody(order.getUserID() + " placed a new order. Hurry up and deliver!.");

			notification.setCustomID(order.getOrderID());
			notification.setCustomID2(order.getUserID());

			// for the user
			notification.setMemberSenderID(order.getUserID());
			notification.setHeaderMember("Your Order has been placed successfully ");
			notification.setBodyMember(" Your Order will be deliverd on time.");

			NUSI.insertNotification_Users(notification);

		}

		return result;
	}

	@Override
	public boolean orderValidate(OrderDB order) {

		DeliveryFeeServiceInterface DFSI = new DeliveryFeeServiceImplement();

		boolean result = false;

		// calculate the order prices from the database
		double productTotal = 0;
		double tax = 0;
		double total = 0;
		double shippingFee = 0;
		HashMap<FoodItem, Integer> itemList = order.getItemList();

		for (FoodItem food : itemList.keySet()) {

			try {

				FoodItem foodFromDB = FSI.retrieveFood(food.getItemID(), null, null).get(0);

				if (foodFromDB.isActive()) {

					double value = foodFromDB.getPrice() * itemList.get(food);
					productTotal += value;

					double value2 = foodFromDB.getTax() * itemList.get(food);
					tax += value2;
				}
			} catch (Exception e) {
			}

		}

		shippingFee = DFSI.retreiveFee(productTotal);

		total = productTotal + tax + shippingFee;

		productTotal = Double.parseDouble(String.format("%.2f", productTotal));
		tax = Double.parseDouble(String.format("%.2f", tax));
		shippingFee = Double.parseDouble(String.format("%.2f", shippingFee));
		total = Double.parseDouble(String.format("%.2f", total));

		try {

			System.out.println(productTotal + " sdsdsdsd " + order.getSubTotal());
			System.out.println(tax + " sdsdsdsd " + order.getTax());
			System.out.println(shippingFee + " sdsdsdsd " + order.getShippingFee());
			System.out.println(total + " sdsdsdsd " + order.getTotal());

			if (productTotal == order.getSubTotal() && tax == order.getTax() && shippingFee == order.getShippingFee()
					&& total == order.getTotal())
				result = true;
		} catch (Exception e) {
		}

		System.out.println(result);
		return result;
	}

	@Override
	public boolean userPuchasseItemValidate(String userID, String fID) {

		boolean result = false;

		ArrayList<OrderDB> orders = ODI.AllOrdersOrByUserID(userID, null);

		if (orders != null && userID != null) {

			for (OrderDB order : orders) {

				ArrayList<OrderedItems> orderedItems = new ArrayList<>();

				orderedItems = OISI.retreiveOrderedItems(order.getOrderID());

				for (OrderedItems item : orderedItems) {

					if (item.getProductID().equals(fID))
						result = true;

				}

			}

		}

		return result;
	}

}
