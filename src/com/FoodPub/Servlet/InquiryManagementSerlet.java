package com.FoodPub.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.FoodPub.Model.InquiryDB;
import com.FoodPub.Model.ResponseINQ;
import com.FoodPub.Model.Role;
import com.FoodPub.Model.User;
import com.FoodPub.Service.InquiryDBServiceImplement;
import com.FoodPub.Service.InquiryDBServiceInterface;
import com.FoodPub.Service.ResponseINQServiceImplement;
import com.FoodPub.Service.ResponseINQServiceInterface;

/**
 * Servlet implementation class InquiryManagementSerlet
 */
@WebServlet("/InquiryManagementSerlet")
@MultipartConfig(maxFileSize = 16177215)
public class InquiryManagementSerlet extends HttpServlet {

	private InquiryDBServiceInterface INQSI = new InquiryDBServiceImplement();
	private ResponseINQServiceInterface RINQSI = new ResponseINQServiceImplement();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InquiryManagementSerlet() {
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

		PrintWriter pwt = response.getWriter();
		String action = request.getServletPath();

		if (action.equals("/RetrieveInquiryPanel")) {
			RequestDispatcher dis = null;
			String inquiryID = null;
			String userID = null;
			String time = "";

			if (request.getParameter("inquiryID") != null) {
				inquiryID = request.getParameter("inquiryID");
			}

			if (request.getParameter("userID") != null) {
				userID = request.getParameter("userID");
			}

			if (request.getParameter("time") != null) {
				time = request.getParameter("time");
			}

			ArrayList<InquiryDB> InquiryDBList = INQSI.RetreiveInquiry(inquiryID, userID, time);

			System.out.println(inquiryID + "inquiryIDinquiryIDinquiryIDinquiryIDinquiryID");
			if (inquiryID != null && InquiryDBList != null) {
				request.setAttribute("Inquiry", InquiryDBList.get(0));
				dis = request.getRequestDispatcher("/WEB-INF/views/admin/panel/inquiry.jsp");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				request.getSession().setAttribute("responsesLastTime", dtf.format(now));
			} else {
				request.setAttribute("InquiryDBList", InquiryDBList);
				dis = request.getRequestDispatcher("/WEB-INF/views/admin/panel/inquiries.jsp");
			}
			dis.forward(request, response);
		}

		else if (action.equals("/RetrieveNewInquiryResponsesPanel")) {
			RequestDispatcher dis = null;
			String inquiryID = null;
			String time = "";

			if (request.getParameter("inquiryID") != null)
				inquiryID = request.getParameter("inquiryID");

			if (request.getSession().getAttribute("responsesLastTime") != null)
				time = (String) request.getSession().getAttribute("responsesLastTime");

			ArrayList<InquiryDB> InquiryDBList = INQSI.RetreiveInquiry(inquiryID, null, time);

			System.out.println(inquiryID + "inquiryIDinquiryIDinquiryIDinquiryIDinquiryID" + time);
			if (inquiryID != null && InquiryDBList != null) {
				request.setAttribute("Inquiry", InquiryDBList.get(0));
				dis = request.getRequestDispatcher("/WEB-INF/views/admin/panel/inquiry.jsp");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				request.getSession().setAttribute("responsesLastTime", dtf.format(now));
			}

			dis.forward(request, response);
		}

		else if (action.equals("/DeletePanelInquiry")) {

			String[] iqids = request.getParameterValues("iqids[]");

			boolean result = false;

			for (String iqid : iqids) {

				result = INQSI.deleteInquiry(iqid);

			}

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}

		else if (action.equals("/InsertInquiryUser")) {

			User user = (User) request.getSession().getAttribute("user");

			InquiryDB Inquiry = new InquiryDB();
			Inquiry.setUser(user);
			System.out.println(request.getParameter("subject") + request.getParameter("message") + "23232323dcd");
			Inquiry.setSubject(request.getParameter("subject"));
			Inquiry.setMessage(request.getParameter("message"));
			List<Part> parts = new ArrayList<>();

			Part img1 = null;
			Part img2 = null;
			Part img3 = null;

			if (request.getPart("img1") != null)
				img1 = request.getPart("img1");

			if (request.getPart("img2") != null)
				img2 = request.getPart("img2");

			if (request.getPart("img3") != null)
				img3 = request.getPart("img3");

			parts.add(img1);
			parts.add(img2);
			parts.add(img3);

			boolean result = INQSI.insertInquiry(Inquiry, parts);

			pwt.print(result);
			pwt.flush();
			pwt.close();

		}

		else if (action.equals("/DeletePanelResponse")) {

			String resid = request.getParameter("resid");

			boolean result = RINQSI.deleteResponse(resid);

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}

		else if (action.equals("/InsertResponseINQ")) {

			boolean haveAccess = false;
			boolean result = false;

			// String message = (String) request.getAttribute("message");
			String message = request.getParameter("message");
			User user = (User) request.getSession().getAttribute("user");

			String inqID = request.getParameter("inqID");

			Part img1 = null;
			Part img2 = null;
			Part img3 = null;

			if (request.getPart("img1") != null)
				img1 = request.getPart("img1");

			if (request.getPart("img2") != null)
				img2 = request.getPart("img2");

			if (request.getPart("img3") != null)
				img3 = request.getPart("img3");

			for (Role role : user.getRoles()) {

				if (role.getName().equals("member") == false)
					haveAccess = true;

			}

			if (haveAccess == false) {

				ArrayList<InquiryDB> InquiryDBList = INQSI.RetreiveInquiry(null, user.getUserID(), "");

				for (InquiryDB inquiryDB : InquiryDBList) {

					if (inquiryDB.getInquiryID().equals(inqID))
						haveAccess = true;

				}

			}

			if (haveAccess == true) {

				ResponseINQ responseINQ = new ResponseINQ();
				responseINQ.setUser(user);
				responseINQ.setMessage(message);
				responseINQ.setInquiryID(inqID);

				List<Part> parts = new ArrayList<>();
				parts.add(img1);
				parts.add(img2);
				parts.add(img3);
				result = RINQSI.insertResponse(responseINQ, parts);

			}

			System.out.println(haveAccess);
			pwt.print(result);
			pwt.flush();
			pwt.close();

		}

		else if (action.equals("/RetrieveInquiryUser")) {

			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/profile/inquiries.jsp");

			User user = (User) request.getSession().getAttribute("user");
			String inquiryID = null;
			String userID = user.getUserID();
			if (request.getParameter("inquiryID") != null) {
				inquiryID = request.getParameter("inquiryID");

				ArrayList<InquiryDB> InquiryDBList = INQSI.RetreiveInquiry(inquiryID, null, "");

				if (InquiryDBList != null && inquiryID != null && InquiryDBList.size() == 1) {
					if (userID.equals(InquiryDBList.get(0).getUser().getUserID())) {
						request.setAttribute("Inquiry", InquiryDBList.get(0));
						dis = request.getRequestDispatcher("/WEB-INF/views/profile/inquiry.jsp");
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
						LocalDateTime now = LocalDateTime.now();
						request.getSession().setAttribute("responsesLastTime", dtf.format(now));
					}
				}

			}

			else {
				ArrayList<InquiryDB> InquiryDBList = INQSI.RetreiveInquiry(null, userID, "");
				request.setAttribute("InquiryDBList", InquiryDBList);
			}
			dis.forward(request, response);
		}

		else if (action.equals("/RetrieveNewInquiryResponsesUser")) {

			User user = (User) request.getSession().getAttribute("user");
			String userID = user.getUserID();

			RequestDispatcher dis = null;
			String inquiryID = null;
			String time = "";

			if (request.getParameter("inquiryID") != null)
				inquiryID = request.getParameter("inquiryID");

			if (request.getSession().getAttribute("responsesLastTime") != null)
				time = (String) request.getSession().getAttribute("responsesLastTime");

			ArrayList<InquiryDB> InquiryDBList = INQSI.RetreiveInquiry(inquiryID, null, time);

			System.out.println(inquiryID + "inquiryIDinquiryIDinquiryIDinquiryIDinquiryID" + time);
			if (inquiryID != null && InquiryDBList != null) {
				if (userID.equals(InquiryDBList.get(0).getUser().getUserID())) {
					request.setAttribute("Inquiry", InquiryDBList.get(0));
					dis = request.getRequestDispatcher("/WEB-INF/views/profile/inquiry.jsp");
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					request.getSession().setAttribute("responsesLastTime", dtf.format(now));
				}
			}

			dis.forward(request, response);
		}
	}

}
