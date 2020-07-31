package com.FoodPub.Dao.Security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FoodPub.Model.Role;
import com.FoodPub.Model.User;

/**
 * Servlet Filter implementation class PanelLoginAuthentication
 */
@WebFilter("/PanelLoginAuthentication")
public class PanelLoginAuthentication implements Filter {

	/**
	 * Default constructor.
	 */
	public PanelLoginAuthentication() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		HttpSession session = req.getSession();

		User user = (User) session.getAttribute("user");

		ArrayList<String> userRolesNames = new ArrayList<>();

		if (user != null) {

			if (user.getRoles() != null) {
				for (Role role : user.getRoles()) {

					userRolesNames.add(role.getName());

				}
			}
		}
		if (user != null && (userRolesNames.contains("admin") || userRolesNames.contains("food_manager")
				|| userRolesNames.contains("order_manager") || userRolesNames.contains("account_manager")))
			httpResponse.sendRedirect("PanelDashBoard");

		else
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
