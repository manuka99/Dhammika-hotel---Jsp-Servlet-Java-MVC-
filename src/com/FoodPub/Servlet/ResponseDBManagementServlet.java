package com.FoodPub.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FoodPub.Model.Response_CNT;
import com.FoodPub.Model.User;
import com.FoodPub.Service.ResponseDBServiceImplement;
import com.FoodPub.Service.ResponseDBServiceInterface;

/**
 * Servlet implementation class ResponseDBManagementServlet
 */
@WebServlet("/ResponseDBManagementServlet")
public class ResponseDBManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResponseDBServiceInterface RDBSI = new ResponseDBServiceImplement();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResponseDBManagementServlet() {
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
		PrintWriter pwt = response.getWriter();

		if (action.equals("/InsertResponseForm")) {

			User user = (User) request.getSession().getAttribute("user");

			Response_CNT responseDB = new Response_CNT();

			System.out.println("msgsasasasa" + request.getParameter("message"));
			responseDB.setMessage(request.getParameter("message"));
			responseDB.setContactUsID(request.getParameter("contactUsID"));
			responseDB.setUser(user);

			boolean result = RDBSI.insertResponse(responseDB);
			pwt.print(result);
			pwt.flush();
			pwt.close();

		}

		else if (action.equals("/DeletePanelResponseDB")) {

			boolean result = RDBSI.deleteResponse(request.getParameter("responseID"));

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}

	}

}
