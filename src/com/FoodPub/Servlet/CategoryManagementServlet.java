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

import com.FoodPub.Model.Category;
import com.FoodPub.Service.CategoryServiceImplement;
import com.FoodPub.Service.CategoryServiceInterface;

/**
 * Servlet implementation class CategoryManagementServlet
 */
@WebServlet("/CategoryManagementServlet")
public class CategoryManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CategoryServiceInterface CSI = new CategoryServiceImplement();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryManagementServlet() {
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

		if (action.equals("/RetrieveCategoryToolsPanel")) {

			String cid = null;

			System.out.println("aasasasasas");

			if (request.getParameter("cid") != null)
				cid = request.getParameter("cid");

			ArrayList<Category> catagoryList = CSI.retrieveCategory(cid);

			if (catagoryList.size() > 1) {
				request.setAttribute("catagoryList", catagoryList);
				System.out.println("asa33333");
			} else
				request.setAttribute("catagory", catagoryList.get(0));

			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/admin/panel/catergoryTools.jsp");
			dis.forward(request, response);

		}

		else if (action.equals("/updateCategoryToolPanel")) {

			Category category = new Category();

			category.setCategoryID(request.getParameter("cid"));
			category.setName(request.getParameter("name"));
			category.setDescription(request.getParameter("description"));

			boolean result = CSI.updateCategory(category);

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}

		else if (action.equals("/DeletePanelCategoryTool")) {

			String[] cids = request.getParameterValues("cids[]");
			
			boolean result = false;

			for (String cid : cids) {

				result = CSI.deleteCategory(cid);

			}

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}
		
		else if (action.equals("/AddPanelCategoryTool")) {

			Category category = new Category();

			category.setName(request.getParameter("name"));
			category.setDescription(request.getParameter("description"));

			boolean result = CSI.addNewCategory(category);

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}

	}

}
