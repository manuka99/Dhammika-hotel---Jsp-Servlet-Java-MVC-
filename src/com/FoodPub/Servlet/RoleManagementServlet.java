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

import com.FoodPub.Model.Role;
import com.FoodPub.Service.RoleServiceImplement;
import com.FoodPub.Service.RoleServiceInterface;

/**
 * Servlet implementation class RoleManagementServlet
 */
@WebServlet("/RoleManagementServlet")
public class RoleManagementServlet extends HttpServlet {
	private static RoleServiceInterface RSI = new RoleServiceImplement();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoleManagementServlet() {
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

		if (action.equals("/RetrieveRolesToolPanel")) {

			String rid = null;

			if (request.getParameter("rid") != null)
				rid = request.getParameter("rid");

			ArrayList<Role> roleList = RSI.RetreiveRoles(rid);

			if (roleList.size() > 1) {
				request.setAttribute("roleList", roleList);
			} else
				request.setAttribute("role", roleList.get(0));

			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/admin/panel/userTools.jsp");
			dis.forward(request, response);

		}

		else if (action.equals("/updateRolesToolPanel")) {

			Role role = new Role();

			role.setRoleID(request.getParameter("rid"));
			role.setName(request.getParameter("name"));
			role.setDescription(request.getParameter("description"));

			boolean result = RSI.updateRole(role);

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}

		else if (action.equals("/DeletePanelRolesTool")) {

			String[] rids = request.getParameterValues("rids[]");

			boolean result = false;

			for (String rid : rids) {

				result = RSI.deleteRole(rid);

			}

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}

		else if (action.equals("/AddPanelRolesTool")) {

			Role role = new Role();

			role.setName(request.getParameter("name"));
			role.setDescription(request.getParameter("description"));


			boolean result = RSI.insertRole(role);

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}

	}

}
