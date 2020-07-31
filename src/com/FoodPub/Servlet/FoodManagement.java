package com.FoodPub.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.FoodPub.Model.Category;
import com.FoodPub.Model.FoodItem;
import com.FoodPub.Model.Role;
import com.FoodPub.Model.User;
import com.FoodPub.Service.CategoryServiceImplement;
import com.FoodPub.Service.CategoryServiceInterface;
import com.FoodPub.Service.FeedbackServiceImplement;
import com.FoodPub.Service.FeedbackServiceInterface;
import com.FoodPub.Service.FoodServiceImplement;
import com.FoodPub.Service.FoodServiceInteface;
import com.FoodPub.Service.OrderServiceImplement;
import com.FoodPub.Service.OrderServiceInterface;

/**
 * Servlet implementation class FoodManagement
 */
@WebServlet("/FoodManagement")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class FoodManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FoodServiceInteface FSI = new FoodServiceImplement();
	private CategoryServiceInterface CSI = new CategoryServiceImplement();
	private FeedbackServiceInterface DDSI = new FeedbackServiceImplement();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		/*
		 * if (action.equals("/ListALLFood")) {
		 * 
		 * PrintWriter out = response.getWriter(); Gson gson = new Gson();
		 * FoodServiceInteface FSI = new FoodServiceImplement();
		 * out.print(gson.toJson(FSI.retrieveFood(0))); out.flush(); out.close();
		 * 
		 * }
		 */

		if (action.equals("/RetrievePanelFood")) {

			String fid = null;
			String cid = null;
			String search = null;

			if (request.getParameter("fid") != null) {
				fid = request.getParameter("fid");
			}

			if (request.getParameter("cid") != null) {
				cid = request.getParameter("cid");
			}

			if (request.getParameter("search") != null) {
				search = request.getParameter("search");
			}

			try {

				FoodServiceInteface FSI = new FoodServiceImplement();
				ArrayList<FoodItem> FoodList = FSI.retrieveFood(fid, cid, search);

				if (FoodList != null) {
					request.setAttribute("FoodList", FoodList);
					request.setAttribute("fid", fid);
					request.setAttribute("cid", cid);

					ArrayList<Category> catagory = CSI.retrieveCategory(cid);

					if (catagory.size() > 1)
						request.setAttribute("categoryInfoName", "All Categories");
					else
						request.setAttribute("categoryInfoName", catagory.get(0).getName());

					request.setAttribute("search", search);
					request.setAttribute("catagoryList", catagory);
					request.setAttribute("Food", FoodList.get(0));
					RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/admin/panel/panel_food.jsp");
					dis.forward(request, response);
				}

				else {
					PrintWriter out = response.getWriter();
					out.print("error");
					out.flush();
					out.close();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		else if (action.equals("/DeletePanelFood")) {

			String[] fids = {};
			boolean result = false;
			String msg = "error";

			if (request.getParameter("fids[]") != null) {
				fids = request.getParameterValues("fids[]");
			}

			for (String fid : fids) {

				result = FSI.deleteFoodItem(fid);

			}

			if (result == true)
				msg = "success";

			PrintWriter out = response.getWriter();
			out.print(msg);
			out.flush();
			out.close();

		}

		else if (action.equals("/UpdatePanelFood")) {

			String msg = "error";
			Part image = null;
			FoodItem foodItem = new FoodItem();

			foodItem.setItemID(request.getParameter("itemID"));
			foodItem.setName(request.getParameter("name"));
			foodItem.setDescription(request.getParameter("description"));
			foodItem.setPortion(request.getParameter("portion"));
			foodItem.setPrice(Double.parseDouble(request.getParameter("price")));
			foodItem.setTax(Double.parseDouble(request.getParameter("tax")));
			foodItem.setActive(Boolean.parseBoolean(request.getParameter("active")));
			foodItem.setCatergoryID(request.getParameter("catID"));

			if (request.getPart("fileImage") != null)
				image = request.getPart("fileImage");

			boolean result = FSI.updateFoodItem(foodItem, image);

			if (result == true)
				msg = "success";

			PrintWriter out = response.getWriter();
			out.print(msg);
			out.flush();
			out.close();

		}
		/*
		 * else if (action.equals("/ListALLFoodByCatergory")) {
		 * 
		 * FoodServiceInteface FSI = new FoodServiceImplement(); ArrayList<FoodItem>
		 * FoodList = FSI.retrieveFood(null, request.getParameter("categoryID"), null);
		 * request.setAttribute("FoodList", FoodList);
		 * 
		 * CategoryServiceInterface CSI = new CategoryServiceImplement();
		 * ArrayList<Category> CategoryList = CSI.retrieveCategory(null);
		 * request.setAttribute("CategoryList", CategoryList);
		 * 
		 * // RequestDispatcher dis1 = //
		 * request.getRequestDispatcher("/WEB-INF/views/home/Menu_Content.jsp");
		 * RequestDispatcher dis1 =
		 * request.getRequestDispatcher("/WEB-INF/views/home/card.jsp");
		 * dis1.forward(request, response);
		 * 
		 * }
		 */

		else if (action.equals("/AddNewPanelFoodItem")) {

			String msg = "error";
			Part image = null;

			FoodItem foodItem = new FoodItem();
			foodItem.setName(request.getParameter("name"));
			foodItem.setDescription(request.getParameter("description"));
			foodItem.setPortion(request.getParameter("portion"));
			foodItem.setPrice(Double.parseDouble(request.getParameter("price")));
			foodItem.setTax(Double.parseDouble(request.getParameter("tax")));
			foodItem.setActive(Boolean.parseBoolean(request.getParameter("active")));
			foodItem.setCatergoryID(request.getParameter("catID"));

			if (request.getPart("fileImage") != null)
				image = request.getPart("fileImage");

			boolean result = FSI.addNewFood(foodItem, image);

			if (result == true)
				msg = "success";

			PrintWriter out = response.getWriter();
			out.print(msg);
			out.flush();
			out.close();

		}

		else if (action.equals("/search")) {

			FoodServiceInteface FSI = new FoodServiceImplement();
			ArrayList<FoodItem> FoodList = FSI.retrieveFood(null, null, request.getParameter("findMe"));
			request.setAttribute("FoodList", FoodList);

			CategoryServiceInterface CSI = new CategoryServiceImplement();
			ArrayList<Category> CategoryList = CSI.retrieveCategory(null);
			request.setAttribute("CategoryList", CategoryList);

			RequestDispatcher dis1 = request.getRequestDispatcher("/WEB-INF/views/home/category.jsp");
			dis1.forward(request, response);

		}

		else if (action.equals("/menu")) {
			String catergoryID = null;
			int page = 1;
			int recordsPerPage = 11;
			String column = null;
			String type = null;
			int sliderValue = 0;

			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}

			if (request.getParameter("cID") != null) {
				catergoryID = request.getParameter("cID");
			}

			if (request.getParameter("column") != null) {
				column = request.getParameter("column");
			}

			if (request.getParameter("type") != null) {
				type = request.getParameter("type");
			}

			if (request.getParameter("sliderValue") != null) {
				sliderValue = Integer.parseInt(request.getParameter("sliderValue"));
			}

			System.out.println(catergoryID);
			System.out.println(column);
			System.out.println(type);
			System.out.println(page);

			int offset = ((page - 1) * recordsPerPage);

			ArrayList<FoodItem> FoodList = FSI.retrieveFoodPagination(catergoryID, offset, recordsPerPage, column, type,
					sliderValue);
			int noOfRecords = FSI.noOfFoodItems(catergoryID, sliderValue);

			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			ArrayList<Category> CategoryList = CSI.retrieveCategory(null);

			request.setAttribute("CategoryList", CategoryList);
			request.setAttribute("FoodList", FoodList);
			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);
			request.setAttribute("categoryID", catergoryID);
			request.setAttribute("column", column);
			request.setAttribute("type", type);
			request.setAttribute("sliderValue", sliderValue);

			RequestDispatcher dis1 = request.getRequestDispatcher("/WEB-INF/views/products/items.jsp");
			dis1.forward(request, response);

		}

		else if (action.equals("/product")) {
			String fID = null;
			boolean access = false;

			if (request.getParameter("fID") != null) {
				fID = request.getParameter("fID");
			}

			ArrayList<FoodItem> FoodList = FSI.retrieveFood(fID, null, null);

			if (FoodList != null && fID != null && FoodList.size() == 1) {

				User user = (User) request.getSession().getAttribute("user");
				OrderServiceInterface OSI = new OrderServiceImplement();

				// admin can delete any feedback

				if (user != null) {
					for (Role role : user.getRoles()) {

						if (role.getName().equals("admin") || role.getName().equals("food_manager"))
							access = true;

					}
				}
				if (access)
					request.setAttribute("admin", access);

				if (user != null)
					request.setAttribute("canReview", OSI.userPuchasseItemValidate(user.getUserID(), fID));

				request.setAttribute("Food", FoodList.get(0));
				request.setAttribute("feedbacks", DDSI.retreiveFeedBacks(null, fID, null));
				request.setAttribute("FoodCat", CSI.retrieveCategory(FoodList.get(0).getCatergoryID()).get(0));
				request.getRequestDispatcher("/WEB-INF/views/products/product.jsp").forward(request, response);

			}

			else
				response.sendRedirect("menu");

		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * PrintWriter out = resp.getWriter(); Gson gson = new Gson();
		 * FoodServiceInteface FSI = new FoodServiceImplement();
		 * out.print(gson.toJson(FSI.retrieveFood(0))); out.flush(); out.close();
		 */

		doPost(req, resp);
	}

}
