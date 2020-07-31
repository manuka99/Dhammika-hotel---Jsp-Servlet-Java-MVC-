package com.FoodPub.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FoodPub.Model.ContactUs;
import com.FoodPub.Service.ContactUsServiceImplement;
import com.FoodPub.Service.ContactUsServiceInterface;

/**
 * Servlet implementation class ContactUsManagementServlet
 */
@WebServlet("/ContactUsManagementServlet")
public class ContactUsManagementServlet extends HttpServlet {

	private ContactUsServiceInterface CUSI = new ContactUsServiceImplement();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactUsManagementServlet() {
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

		if (action.equals("/InsertContactUsForm")) {

			ContactUs contactUs = new ContactUs();
			contactUs.setName(request.getParameter("name"));
			contactUs.setEmail(request.getParameter("email"));
			contactUs.setPhone(request.getParameter("phone"));
			contactUs.setSubject(request.getParameter("subject"));
			contactUs.setMessage(request.getParameter("message"));

			boolean result = CUSI.insertContactUs(contactUs);

			if (result == true)
				pwt.print("success");

			pwt.flush();
			pwt.close();

		}

		else if (action.equals("/RetrieveContactUsPanel")) {

			String cuid = null;

			System.out.println("aasasasasas");

			if (request.getParameter("cuid") != null)
				cuid = request.getParameter("cuid");

			List<ContactUs> contactUsList = CUSI.retreiveContactUs(cuid);

			if (contactUsList.size() > 0)
				request.setAttribute("contactUs", contactUsList.get(0));

			request.setAttribute("contactUsList", contactUsList);

			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/admin/panel/ContactUsPanel.jsp");
			dis.forward(request, response);

		}
		
		else if (action.equals("/RespondContactUsPanel")) {

			String cuid = null;

			if (request.getParameter("cuid") != null)
				cuid = request.getParameter("cuid");

			List<ContactUs> contactUsList = CUSI.retreiveContactUs(cuid);

			if (contactUsList.size() > 0)
				request.setAttribute("contactUs", contactUsList.get(0));

			request.setAttribute("contactUsList", contactUsList);

			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/admin/panel/supportEmail.jsp");
			dis.forward(request, response);

		}

		else if (action.equals("/DeletePanelContactUs")) {

			String[] cuids = request.getParameterValues("cuids[]");

			boolean result = false;
			
			System.out.println("cameeecdddfdf");

			for (String cuid : cuids) {

				System.out.println("cameeecdddfdf");
				
				result = CUSI.deleteContactUs(cuid);

			}

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}

	}

}
