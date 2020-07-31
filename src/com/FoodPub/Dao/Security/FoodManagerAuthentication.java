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
 * Servlet Filter implementation class FoodManagerAuthentication
 */
@WebFilter("/FoodManagerAuthentication")
public class FoodManagerAuthentication implements Filter {

	/**
	 * Default constructor.
	 */
	public FoodManagerAuthentication() {
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

			for (Role role : user.getRoles()) {

				userRolesNames.add(role.getName());

			}
		}
		if (user != null && (userRolesNames.contains("admin") || userRolesNames.contains("food_manager")))
			chain.doFilter(request, response);

		else
			httpResponse.sendRedirect("LoginPanel");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
