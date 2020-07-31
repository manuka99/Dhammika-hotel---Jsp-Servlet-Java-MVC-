package com.FoodPub.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FoodPub.Model.Cart;
import com.FoodPub.Model.Notification_User;
import com.FoodPub.Model.Role;
import com.FoodPub.Model.User;
import com.FoodPub.Service.CartServiceImplement;
import com.FoodPub.Service.CartServiceInterface;
import com.FoodPub.Service.Notification_UsersServiceImplement;
import com.FoodPub.Service.Notification_UsersServiceInterface;
import com.FoodPub.Service.RoleServiceImplement;
import com.FoodPub.Service.RoleServiceInterface;
import com.FoodPub.Service.UserServiceImplement;
import com.FoodPub.Service.UserServiceInterface;
import com.FoodPub.Util.bCryptPassword;

/**
 * Servlet implementation class UserManagementServlet
 */
@WebServlet("/UserManagementServlet")
public class UserManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartServiceInterface CSI = new CartServiceImplement();
	private static RoleServiceInterface RSI = new RoleServiceImplement();
	private static final UserServiceInterface MSI = new UserServiceImplement();
	private static Notification_UsersServiceInterface NUSI = new Notification_UsersServiceImplement();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManagementServlet() {
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

		if (action.equals("/RetreivePanelUsers")) {

			String roleID = request.getParameter("roleID");
			String userID = request.getParameter("userID");

			ArrayList<User> userList = new ArrayList<>();
			User user = new User();

			if (roleID != null) {
				userList = MSI.retrieveUsersBasedOnRole(null, roleID);
				request.setAttribute("userListInfoName", RSI.RetreiveRoles(roleID).get(0).getName());
				request.setAttribute("userList", userList);
			}

			else if (userID != null) {
				user = MSI.retriveUsers(userID);
				request.setAttribute("user", user);
				request.setAttribute("RoleList", RSI.RetreiveRoles(null));
				System.out.println("im innnn" + user.getEmail());
			}

			else
				request.setAttribute("RoleList", RSI.RetreiveRoles(null));

			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/admin/panel/PanelUsers.jsp");

			dis.forward(request, response);

		}

		else if (action.equals("/DeletePanelUsers")) {

			String msg = "error";
			boolean result = false;

			String[] uids = request.getParameterValues("uids[]");

			for (String userID : uids) {

				System.out.println(userID);
				result = MSI.deleteUser(userID);

			}

			if (result == true)
				msg = "success";

			PrintWriter out = response.getWriter();
			out.print(msg);
			out.flush();
			out.close();

		}

		else if (action.equals("/UpdatePanelUsers")) {

			User user = new User();
			String msg = "error";

			user.setUserID(request.getParameter("userID"));
			user.setDateOfBirth(request.getParameter("dateOfBirth"));
			try {
				user.setPhone(Integer.parseInt(request.getParameter("phone")));

			} catch (Exception e) {
				// TODO: handle exception
			}
			user.setEmail(request.getParameter("email"));
			user.setName(request.getParameter("name"));
			user.setAddress(request.getParameter("address"));
			user.setStatus(Boolean.parseBoolean(request.getParameter("status")));

			String[] roles = request.getParameterValues("roles[]");

			String newEmail = request.getParameter("email");
			String oldEmail = user.getEmail();
			String oldEmailEmail = null;

			if (oldEmail.equals(newEmail) == false) {

				user.setStatus(false);
				request.getSession().invalidate();
				oldEmailEmail = oldEmail;
			}

			boolean result = MSI.UserUpdatePanel(user, roles, oldEmailEmail);

			if (oldEmail.equals(newEmail) && result == true) {
				request.getSession().removeAttribute("user");
				request.getSession().setAttribute("user", user);
			}

			if (result == true)
				msg = "success";

			PrintWriter out = response.getWriter();
			out.print(msg);
			out.flush();
			out.close();

		}

		else if (action.equals("/updatePanelUserPassword")) {

			boolean result = false;

			User user = MSI.retriveUsers(request.getParameter("userID"));

			if (user.getUserID() != null) {

				result = MSI.UserPasswordRecovery(user);

			}
			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();

		}

		else if (action.equals("/AddNewUserPanel")) {

			User user = new User();
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setDateOfBirth(request.getParameter("dateOfBirth"));
			try {
				user.setPhone(Integer.parseInt(request.getParameter("phone")));
			} catch (Exception e) {

				e.printStackTrace();

			}
			user.setAddress(request.getParameter("address"));

			user.setStatus(Boolean.parseBoolean(request.getParameter("status")));

			boolean result = MSI.AddUser(user, request.getParameterValues("roles[]"), true);

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();

		}

		else if (action.equals("/userProfile")) {

			User user = (User) request.getSession().getAttribute("user");

			request.setAttribute("userProfile", MSI.retriveUsers(user.getUserID()));
			RequestDispatcher dis1 = request.getRequestDispatcher("/WEB-INF/views/admin/panel/profile.jsp");
			dis1.forward(request, response);

		}

		else if (action.equals("/UserLoginValidationPanel")) {


			User user = MSI.validateUserLogin(request.getParameter("email"), request.getParameter("password"));

			boolean administrator = false;

			if (user != null) {

				if (user.getRoles() != null) {

					for (Role user_role : user.getRoles()) {
						
						if (user_role.getName().equals("admin") || user_role.getName().equals("food_manager")
								|| user_role.getName().equals("order_manager")) {

							administrator = true;

						}

					}

				}

			}

			if (administrator == true) {
				request.getSession().setAttribute("user", user);
				//request.getSession().setMaxInactiveInterval(600);
				Cart CartDetails = CSI.retreiveCart(null, user.getUserID());
				request.getSession().setAttribute("CartDetails", CartDetails);
				response.sendRedirect("PanelDashBoard");
			}
			
			else
				response.sendRedirect("LoginPanel");

		}

		else if (action.equals("/UserRegistration")) {

			User user = new User();
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setDateOfBirth(request.getParameter("dateOfBirth"));
			try {
				user.setPhone(Integer.parseInt(request.getParameter("phone")));
			} catch (Exception e) {

				e.printStackTrace();

			}
			user.setAddress(request.getParameter("address"));

			user.setStatus(false);

			boolean result = MSI.AddUser(user, null, false);

			if (result == true)
				response.sendRedirect("login");

			else
				response.sendRedirect("register");

		}

		else if (action.equals("/CheckUserEmail")) {

			boolean result = false;

			User user = MSI.checkEmail(request.getParameter("email"));

			if (user.getUserID() != null) {

				result = true;
			}
			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();

		}

		else if (action.equals("/UserLoginValidation")) {

			String msg = "alreadyloggedin";

			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();

			if (session.getAttribute("user") == null) {

				User user = MSI.validateUserLogin(request.getParameter("email"), request.getParameter("password"));

				if (user.getName() != null) {
					session.setAttribute("user", user);
					//request.getSession().setMaxInactiveInterval(600);
					Cart CartDetails = CSI.retreiveCart(null, user.getUserID());
					session.setAttribute("CartDetails", CartDetails);
					msg = "valid";

				}

				else if (user.getName() == null) {
					msg = "invalid";

				}
			}

			else
				;

			out.print(msg);
			out.flush();
			out.close();

		}

		else if (action.equals("/UserLogOut")) {

			HttpSession session = request.getSession();

			if (session.getAttribute("user") != null) {

				session.invalidate();
			}

			RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
			dis.forward(request, response);

		}

		else if (action.equals("/UserActivate")) {

			String userID = request.getParameter("UserID");
			String code = request.getParameter("ActivationCode");
			User user = MSI.activateUser(userID, code);

			HttpSession session = request.getSession();

			if (user.getUserID() != null) {

				if (request.getSession().getAttribute("user") != null) {
					request.getSession().removeAttribute("user");
					request.getSession().setAttribute("user", user);
				}

				session.setAttribute("user", user);
			}

			response.sendRedirect("index.jsp");

		}

		else if (action.equals("/ResendActivationCode")) {

			String msg = "error";

			PrintWriter out = response.getWriter();

			if (request.getSession().getAttribute("user") != null) {

				User user = (User) request.getSession().getAttribute("user");
				boolean result = MSI.resendUseractivatecode(user);

				if (result == true) {

					msg = "success";
					request.getSession().removeAttribute("user");
					request.getSession().setAttribute("user", user);

				}
			}

			out.print(msg);
			out.flush();
			out.close();
		}

		else if (action.equals("/ForgotPasswordUser")) {

			boolean result = false;

			User user = MSI.checkEmail(request.getParameter("email"));

			if (user.getUserID() != null) {

				result = MSI.UserPasswordRecovery(user);

			}
			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();

		}

		else if (action.equals("/basicDetails")) {

			User user = (User) request.getSession().getAttribute("user");

			request.setAttribute("basicDetails", user);
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/profile/userProfile.jsp");

			dis.forward(request, response);

		}

		else if (action.equals("/UpdateUserProfile")) {

			User user = (User) request.getSession().getAttribute("user");

			String newEmail = request.getParameter("email");
			String oldEmail = user.getEmail();

			user.setUserID(user.getUserID());
			user.setDateOfBirth(request.getParameter("dateOfBirth"));
			user.setPhone(Integer.parseInt(request.getParameter("phone")));
			user.setEmail(newEmail);
			user.setName(request.getParameter("name"));
			user.setAddress(request.getParameter("address"));
			user.setStatus(user.getStatus());

			String oldEmailEmail = null;

			if (oldEmail.equals(newEmail) == false) {

				user.setStatus(false);
				request.getSession().invalidate();
				oldEmailEmail = oldEmail;
			}

			boolean result = MSI.UserProfileUpdate(user, oldEmailEmail);

			if (oldEmail.equals(newEmail) && result == true) {
				request.getSession().removeAttribute("user");
				request.getSession().setAttribute("user", user);
			}

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();

		}

		else if (action.equals("/UpdateUserPassword")) {

			String msg = "error";

			User user = (User) request.getSession().getAttribute("user");

			boolean result = bCryptPassword.checkPassword(request.getParameter("currentPassword"), user.getPassword());

			if (result == true) {

				user.setPassword(request.getParameter("newPassword"));

				boolean result2 = MSI.UserPasswordUpdate(user);

				if (result2 == true) {
					HttpSession session = request.getSession();
					session.invalidate();
					msg = "success";
				}

			}

			else
				msg = "incorrect";

			PrintWriter out = response.getWriter();
			out.print(msg);
			out.flush();
			out.close();

		}
		
		else if (action.equals("/Notifications")) {

			User user = (User) request.getSession().getAttribute("user");

			List<Notification_User> notifications = NUSI.retrieveNotificationUsers(user.getUserID());

			Collections.reverse(notifications);

			request.setAttribute("notifications", notifications);
			RequestDispatcher dis1 = request.getRequestDispatcher("/WEB-INF/views/profile/notification.jsp");
			dis1.forward(request, response);

		}
		
		else if (action.equals("/NotificationsUnreadUser")) {

			User user = (User) request.getSession().getAttribute("user");
			int count = 0;
			for (Notification_User notificationsUnread : NUSI.retrieveNotificationUsers(user.getUserID())) {
				if (notificationsUnread.isSeen() == false)
					++count;
			}
			System.out.println(count);
			PrintWriter out = response.getWriter();
			out.print(count);
			out.flush();
			out.close();

		}

		else if (action.equals("/NotificationDelete")) {

			User user = (User) request.getSession().getAttribute("user");

			Notification_User notification_User = new Notification_User();
			notification_User.setNotificationID(request.getParameter("notificationID"));
			notification_User.setUserID(user.getUserID());
			boolean result = NUSI.deleteNotification_Users(notification_User);

			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();

		}

		else if (action.equals("/NotificationUpdate")) {

			User user = (User) request.getSession().getAttribute("user");

			Notification_User notification_User = new Notification_User();
			notification_User.setUserID(user.getUserID());
			notification_User.setNotificationID(request.getParameter("notificationID"));
			notification_User.setSeen(true);

			boolean result = NUSI.updateNotification_Users(notification_User);
			PrintWriter out = response.getWriter();

			out.print(result);
			out.flush();
			out.close();
		}

	}

}
