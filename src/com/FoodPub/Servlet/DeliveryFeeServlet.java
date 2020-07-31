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

import com.FoodPub.Model.DeliveryFee;
import com.FoodPub.Service.DeliveryFeeServiceImplement;
import com.FoodPub.Service.DeliveryFeeServiceInterface;

/**
 * Servlet implementation class DeliveryFeeServlet
 */
@WebServlet("/DeliveryFeeServlet")
public class DeliveryFeeServlet extends HttpServlet {
	
	private DeliveryFeeServiceInterface DFSI = new DeliveryFeeServiceImplement();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryFeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String action = request.getServletPath();

		if (action.equals("/RetrieveDeliveryFeePanel")) {

			String did = null;

			if (request.getParameter("did") != null)
				did = request.getParameter("did");

			ArrayList<DeliveryFee> deliveryFeeList = DFSI.retreiveAllDeliveryFee(did);

			if (deliveryFeeList.size() > 1) {
				request.setAttribute("deliveryFeeList", deliveryFeeList);
			} else
				request.setAttribute("deliveryFee", deliveryFeeList.get(0));

			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/admin/panel/deliveryFee.jsp");
			dis.forward(request, response);

		}

		else if (action.equals("/updateDeliveryFeePanel")) {

			DeliveryFee deliveryFee = new DeliveryFee();

			deliveryFee.setId(request.getParameter("did"));
			deliveryFee.setTotal(Double.parseDouble(request.getParameter("total")));
			deliveryFee.setFee(Double.parseDouble(request.getParameter("fee")));

			boolean result = DFSI.updateDeliveryFee(deliveryFee);

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}

		else if (action.equals("/DeletePanelDeliveryFee")) {

			String[] dids = request.getParameterValues("dids[]");
			
			boolean result = false;

			for (String did : dids) {

				result = DFSI.deleteDeliveryFee(did);

			}

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}
		
		else if (action.equals("/AddPanelDeliveryFee")) {

			DeliveryFee deliveryFee = new DeliveryFee();

			deliveryFee.setTotal(Double.parseDouble(request.getParameter("total")));
			deliveryFee.setFee(Double.parseDouble(request.getParameter("fee")));

			boolean result = DFSI.addDeliveryFee(deliveryFee);

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		}
	}

}
