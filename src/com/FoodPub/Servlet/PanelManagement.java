package com.FoodPub.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ocpsoft.prettytime.PrettyTime;

import com.FoodPub.Model.Category;
import com.FoodPub.Model.FoodItem;
import com.FoodPub.Model.Notification_User;
import com.FoodPub.Model.OrderDB;
import com.FoodPub.Model.User;
import com.FoodPub.Service.CategoryServiceImplement;
import com.FoodPub.Service.CategoryServiceInterface;
import com.FoodPub.Service.Notification_UsersServiceImplement;
import com.FoodPub.Service.Notification_UsersServiceInterface;
import com.FoodPub.Service.OrderServiceImplement;
import com.FoodPub.Service.OrderServiceInterface;
import com.FoodPub.Service.RoleServiceImplement;
import com.FoodPub.Service.RoleServiceInterface;
import com.FoodPub.Service.UserServiceImplement;
import com.FoodPub.Service.UserServiceInterface;
import com.google.gson.Gson;

@WebServlet("/PanelManagement")
public class PanelManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryServiceInterface CSI = new CategoryServiceImplement();
	private RoleServiceInterface RSI = new RoleServiceImplement();
	private OrderServiceInterface OSI = new OrderServiceImplement();
	private UserServiceInterface MSI = new UserServiceImplement();
	private Notification_UsersServiceInterface NUSI = new Notification_UsersServiceImplement();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		if (action.equals("/RetreivePanelCategory")) {

			ArrayList<Category> CategoryList = CSI.retrieveCategory(null);
			request.setAttribute("CategoryList", CategoryList);

			System.out.println("sdsdsdsdsdcccc");
			for (Category category : CategoryList) {

				System.out.println(category.getName());
			}

			request.setAttribute("RoleList", RSI.RetreiveRoles(null));

			RequestDispatcher dis1 = request.getRequestDispatcher("/WEB-INF/views/admin/panel/home/header.jsp");
			dis1.forward(request, response);

		}

		else if (action.equals("/PanelDashBoard")) {

			RequestDispatcher dis1 = request.getRequestDispatcher("/WEB-INF/views/admin/panel/index.jsp");
			dis1.forward(request, response);

		}

		else if (action.equals("/listAllAboutUs")) {

			RequestDispatcher dis1 = request.getRequestDispatcher("/WEB-INF/views/admin/panel/about.jsp");
			dis1.forward(request, response);

		}

		else if (action.equals("/listDeveloper")) {

			RequestDispatcher dis1 = request.getRequestDispatcher("/WEB-INF/views/admin/panel/developer.jsp");
			dis1.forward(request, response);

		}

		else if (action.equals("/NotificationsPanel")) {

			User user = (User) request.getSession().getAttribute("user");

			List<Notification_User> notifications = NUSI.retrieveNotificationUsers(user.getUserID());

			Collections.reverse(notifications);

			request.setAttribute("notifications", notifications);
			RequestDispatcher dis1 = request.getRequestDispatcher("/WEB-INF/views/admin/panel/notifications.jsp");
			dis1.forward(request, response);

		}

		else if (action.equals("/NotificationsUnread")) {

			User user = (User) request.getSession().getAttribute("user");
			int count = 0;
			for (Notification_User notificationsUnread : NUSI.retrieveNotificationUsers(user.getUserID())) {
				if (notificationsUnread.isSeen() == false)
					++count;
			}
			System.out.println(count);
			PrintWriter out = response.getWriter();
			out.print(count);
			out.flush();
			out.close();

		}

		else if (action.equals("/Panel_NotificationDelete")) {

			User user = (User) request.getSession().getAttribute("user");

			Notification_User notification_User = new Notification_User();
			notification_User.setNotificationID(request.getParameter("notificationID"));
			notification_User.setUserID(user.getUserID());
			boolean result = NUSI.deleteNotification_Users(notification_User);

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();

		}

		else if (action.equals("/Panel_NotificationUpdate")) {

			User user = (User) request.getSession().getAttribute("user");

			Notification_User notification_User = new Notification_User();
			notification_User.setUserID(user.getUserID());
			notification_User.setNotificationID(request.getParameter("notificationID"));
			notification_User.setSeen(true);

			boolean result = NUSI.updateNotification_Users(notification_User);
			PrintWriter out = response.getWriter();

			out.print(result);
			out.flush();
			out.close();
		}

		else if (action.equals("/PanelOrdersChart")) {

			Date date = new Date();
			LocalDate lDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			// int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 6
			// int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH); // 17
			// int dayOfYear = cal.get(Calendar.DAY_OF_YEAR); //169
			// int month = cal.get(Calendar.MONTH); // 5
			// int year = cal.get(Calendar.YEAR); // 2016

			int yearNow = Year.now().getValue();
			int monthNow = lDate.getMonthValue();

			Double TotalsalesAmount = 0.00;
			int sales = 0;

			Double TotalsalesCompleted = 0.00;
			int totalCompleted = 0;
			Double TotalsalesCancelled = 0.00;
			int totalCancelled = 0;

			try {
				if (request.getParameter("year").equals("") == false)
					yearNow = Integer.parseInt(request.getParameter("year"));

				if (request.getParameter("month").equals("") == false)
					monthNow = Integer.parseInt(request.getParameter("month"));
			} catch (Exception e) {
				// TODO: handle exception
			}

			int[] ordersBymonth = new int[12];
			int[] ordersCompleted = new int[12];
			int[] ordersCancelled = new int[12];
			int[] ordersType = new int[3];
			int[] ordersTypeCompleted = new int[3];

			ArrayList<OrderDB> orderList = OSI.AllOrdersOrByUserID(null, null);

			if (orderList != null) {
				for (OrderDB orderDB : orderList) {

					String input = orderDB.getpDate();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					LocalDate localDate = LocalDate.parse(input, formatter);

					int yearOrder = localDate.getYear();
					int month = localDate.getMonthValue();
					// int dayOfMonth = localDate.getDayOfMonth();

					if (yearNow == yearOrder) {

						ordersBymonth[month - 1] = 1 + ordersBymonth[month - 1];
						TotalsalesAmount += orderDB.getTotal();
						++sales;

					}

					if (yearNow == yearOrder && orderDB.getStatus().equals("completed")) {

						ordersCompleted[month - 1] = 1 + ordersCompleted[month - 1];
						TotalsalesCompleted += orderDB.getTotal();
						++totalCompleted;

					}

					if (yearNow == yearOrder && orderDB.getStatus().equals("cancelled")) {

						ordersCancelled[month - 1] = 1 + ordersCancelled[month - 1];
						TotalsalesCancelled += orderDB.getTotal();
						++totalCancelled;

					}

					if (monthNow == month && yearNow == yearOrder == true) {

						if (orderDB.getOrderType().equals("COD"))
							ordersType[2] = 1 + ordersType[2];

						if (orderDB.getOrderType().equals("paypal"))
							ordersType[0] = 1 + ordersType[0];

						if (orderDB.getOrderType().equals("payhere"))
							ordersType[1] = 1 + ordersType[1];

					}

					if (monthNow == month && yearNow == yearOrder && orderDB.getStatus().equals("completed")) {

						if (orderDB.getOrderType().equals("COD"))
							ordersTypeCompleted[2] = 1 + ordersTypeCompleted[2];

						if (orderDB.getOrderType().equals("paypal"))
							ordersTypeCompleted[0] = 1 + ordersTypeCompleted[0];

						if (orderDB.getOrderType().equals("payhere"))
							ordersTypeCompleted[1] = 1 + ordersTypeCompleted[1];

					}

				}

			}

			String json1 = new Gson().toJson(ordersBymonth);
			String json2 = new Gson().toJson(TotalsalesAmount);
			String json3 = new Gson().toJson(sales);

			String json4 = new Gson().toJson(ordersCompleted);
			String json5 = new Gson().toJson(TotalsalesCompleted);
			String json6 = new Gson().toJson(totalCompleted);

			String json7 = new Gson().toJson(ordersCancelled);
			String json8 = new Gson().toJson(TotalsalesCancelled);
			String json9 = new Gson().toJson(totalCancelled);

			String json10 = new Gson().toJson(ordersType);
			String json11 = new Gson().toJson(ordersTypeCompleted);

			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			String bothJson = "[" + json1 + "," + json2 + "," + json3 + " , " + json4 + " , " + json5 + " , " + json6
					+ " , " + json7 + " , " + json8 + " , " + json9 + " , " + json10 + " , " + json11 + " ]"; // Put
																												// both
																												// objects
																												// in an
			// array of 2 elements
			response.getWriter().write(bothJson);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			// System.out.println(Arrays.toString(ordersBymonth));

		}

		else if (action.equals("/PanelOrdersChartProduct")) {

			Date date = new Date();
			LocalDate lDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			int yearNow = Year.now().getValue();
			int monthNow = lDate.getMonthValue();

			try {
				if (request.getParameter("year").equals("") == false)
					yearNow = Integer.parseInt(request.getParameter("year"));

				if (request.getParameter("month").equals("") == false)
					monthNow = Integer.parseInt(request.getParameter("month"));
			} catch (Exception e) {
				// TODO: handle exception
			}

			ArrayList<OrderDB> orderList = OSI.AllOrdersOrByUserID(null, "null");

			ArrayList<String> productIDOrderChart = new ArrayList<String>();
			ArrayList<Integer> productQuantityOrderChart = new ArrayList<Integer>();

			Map<String, Integer> mapFood = new HashMap<>();

			if (orderList != null) {
				for (OrderDB orderDB : orderList) {

					String input = orderDB.getpDate();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					LocalDate localDate = LocalDate.parse(input, formatter);

					int yearOrder = localDate.getYear();
					int month = localDate.getMonthValue();

					if (orderDB != null && monthNow == month && yearNow == yearOrder) {

						if (orderDB.getItemList() != null) {
							System.out.println(orderDB.getItemList().keySet());

							for (FoodItem x : orderDB.getItemList().keySet()) {

								// System.out.println(x + "\t" + orderDB.getItemList().get(x));

								if (mapFood.containsKey(x.getItemID())) {
									Integer valueOfKey = mapFood.get(x.getItemID());
									valueOfKey += orderDB.getItemList().get(x);
									mapFood.put(x.getItemID(), valueOfKey);
								}

								else
									mapFood.put(x.getItemID(), orderDB.getItemList().get(x));

							}

						}

					}
				}
			}

			Set<Map.Entry<String, Integer>> newSetList = mapFood.entrySet();

			for (Map.Entry<String, Integer> mapInt : newSetList) {

				productIDOrderChart.add(mapInt.getKey());
				productQuantityOrderChart.add(mapInt.getValue());

			}

			String json1 = new Gson().toJson(productIDOrderChart);
			String json2 = new Gson().toJson(productQuantityOrderChart);

			System.out.println(json1 + json2);

			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			String bothJson = "[" + json1 + "," + json2 + "]";
			response.getWriter().write(bothJson);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

		}

	}

}
