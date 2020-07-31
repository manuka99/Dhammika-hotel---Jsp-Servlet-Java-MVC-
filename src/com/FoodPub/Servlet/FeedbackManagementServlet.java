package com.FoodPub.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FoodPub.Model.FeedBackDB;
import com.FoodPub.Model.Role;
import com.FoodPub.Model.User;
import com.FoodPub.Service.FeedbackServiceImplement;
import com.FoodPub.Service.FeedbackServiceInterface;
import com.FoodPub.Service.OrderServiceImplement;
import com.FoodPub.Service.OrderServiceInterface;

/**
 * Servlet implementation class FeedbackManagementServlet
 */
@WebServlet("/FeedbackManagementServlet")
public class FeedbackManagementServlet extends HttpServlet {

	private FeedbackServiceInterface DDSI = new FeedbackServiceImplement();
	private OrderServiceInterface OSI = new OrderServiceImplement();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FeedbackManagementServlet() {
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

		if (action.equals("/deleteFeedback")) {

			boolean result = false;
			boolean access = false;
			String feedBackID = "";

			if (request.getParameter("feedbackID") != null)
				feedBackID = request.getParameter("feedbackID");

			User user = (User) request.getSession().getAttribute("user");

			/*
			 * admin can delete any feedback
			 */
			for (Role role : user.getRoles()) {

				if (role.getName().equals("admin") || role.getName().equals("food_manager"))
					access = true;

			}

			if (access) {

				try {
					result = DDSI.deleteFeedBack(feedBackID,
							DDSI.retreiveFeedBacks(feedBackID, null, null).get(0).getUserID());
				} catch (Exception e) {
					// TODO: handle exception
				}

			} else
				result = DDSI.deleteFeedBack(feedBackID, user.getUserID());

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}

		else if (action.equals("/insertFeedback")) {

			User user = (User) request.getSession().getAttribute("user");

			String itemID = "";

			boolean result = false;

			if (request.getParameter("itemID") != null)
				itemID = request.getParameter("itemID");

			System.out.println(request.getParameter("itemID"));
			System.out.println(request.getParameter("review"));
			System.out.println(request.getParameter("rating"));

			if (OSI.userPuchasseItemValidate(user.getUserID(), itemID)) {

				FeedBackDB feedback = new FeedBackDB();

				feedback.setItemID(itemID);
				feedback.setUserID(user.getUserID());
				feedback.setReview(request.getParameter("review"));
				feedback.setRating(request.getParameter("rating"));

				result = DDSI.insertFeedBack(feedback);

				System.out.println(result + "fw344");

			}

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();

		} else if (action.equals("/updateFeedback")) {

			User user = (User) request.getSession().getAttribute("user");

			String itemID = "";
			String feedbackID = "";
			boolean result = false;

			if (request.getParameter("itemID") != null)
				itemID = request.getParameter("itemID");

			if (request.getParameter("feedbackID") != null)
				feedbackID = request.getParameter("feedbackID");

			if (DDSI.retreiveFeedBacks(feedbackID, itemID, user.getUserID()).size() > 0) {

				FeedBackDB feedback = new FeedBackDB();

				System.out.println(feedbackID + itemID);

				feedback.setItemID(itemID);
				feedback.setFeedbackID(feedbackID);
				feedback.setUserID(user.getUserID());
				feedback.setReview(request.getParameter("review"));
				feedback.setRating(request.getParameter("rating"));

				result = DDSI.updateFeedBack(feedback);

			}

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();

		} else if (action.equals("/editFeedback")) {

			User user = (User) request.getSession().getAttribute("user");

			String itemID = "";
			String feedbackID = "";

			if (request.getParameter("itemID") != null)
				itemID = request.getParameter("itemID");

			if (request.getParameter("feedbackID") != null)
				feedbackID = request.getParameter("feedbackID");

			if (DDSI.retreiveFeedBacks(feedbackID, itemID, user.getUserID()).size() > 0) {

				request.setAttribute("editFeedback",
						DDSI.retreiveFeedBacks(feedbackID, itemID, user.getUserID()).get(0));
				request.getRequestDispatcher("/WEB-INF/views/products/product.jsp").forward(request, response);

			}

		}

	}

}
