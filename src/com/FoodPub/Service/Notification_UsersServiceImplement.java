package com.FoodPub.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.ocpsoft.prettytime.PrettyTime;

import com.FoodPub.Dao.Notification_UserDaoImplement;
import com.FoodPub.Dao.Notification_UserDaoInterface;
import com.FoodPub.Model.Notification_User;
import com.FoodPub.Model.Role;
import com.FoodPub.Model.Role_User;
import com.FoodPub.Util.UniqueIdGenerator;

public class Notification_UsersServiceImplement implements Notification_UsersServiceInterface {

	public static final Logger log = Logger.getLogger(Notification_UsersServiceImplement.class.getName());

	private Notification_UserDaoInterface NUDI = new Notification_UserDaoImplement();

	private RoleUserServiceInterface RUSI = new RoleUserServiceImplement();

	private RoleServiceInterface RSI = new RoleServiceImplement();

	@Override
	public List<Notification_User> retrieveNotificationUsers(String userID) {

		List<Notification_User> notifications = NUDI.retrieveNotificationUsers(userID);

		for (Notification_User notification : notifications) {

			try {
				PrettyTime p = new PrettyTime();
				String input = notification.getTime();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = format.parse(input);
				notification.setTime(p.format(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return notifications;
	}

	@Override
	public boolean insertNotification_Users(Notification_User notification_User) {
		boolean result = false;

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		if (notification_User.getType().equals("Order")) {

			/*
			 * send member the notification
			 */

			if (notification_User.getMemberSenderID() != null) {

				Notification_User notification = new Notification_User();
				notification.setNotificationID(UniqueIdGenerator.userIDGenerator("noti"));
				notification.setTime(dtf.format(now));
				notification.setUserID(notification_User.getMemberSenderID());

				notification.setHeader(notification_User.getHeaderMember());
				notification.setBody(notification_User.getBodyMember());

				notification.setUrl(
						"GetMyOrders?orderID=" + notification_User.getCustomID());

				result = NUDI.insertNotification_Users(notification);

			}

			List<Role> roles = RSI.RetreiveRoles(null);

			for (Role role : roles) {

				if (role.getName().equals("admin") || role.getName().equals("order_manager")
						|| role.getName().equals("food_manager")) {

					List<Role_User> role_users = RUSI.RetreiveRole_Users(null, role.getRoleID());

					for (Role_User role_user : role_users) {

						if (notification_User.getMemberSenderID() != null
								&& (notification_User.getMemberSenderID().equals(role_user.getUserID()) == false)) {
							Notification_User notification = new Notification_User();

							notification.setNotificationID(UniqueIdGenerator.userIDGenerator("noti"));
							notification.setTime(dtf.format(now));
							notification.setUserID(role_user.getUserID());

							notification.setHeader(notification_User.getHeader());
							notification.setBody(notification_User.getBody());

							notification.setUrl("RetrieveOrdersPanel?oID="
									+ notification_User.getCustomID() + "&userID=" + notification_User.getCustomID2());

							result = NUDI.insertNotification_Users(notification);
						}
					}

				}

			}

		}

		else if (notification_User.getType().equals("ContactUs")) {

			List<Role> roles = RSI.RetreiveRoles(null);

			for (Role role : roles) {

				if (role.getName().equals("admin") || role.getName().equals("customer_service_manager")) {

					List<Role_User> role_users = RUSI.RetreiveRole_Users(null, role.getRoleID());

					for (Role_User role_user : role_users) {
						Notification_User notification = new Notification_User();
						notification.setNotificationID(UniqueIdGenerator.userIDGenerator("noti"));
						notification.setTime(dtf.format(now));
						notification.setUserID(role_user.getUserID());

						notification.setHeader(notification_User.getHeader());
						notification.setBody(notification_User.getBody());

						notification.setUrl("RespondContactUsPanel?cuid="
								+ notification_User.getCustomID());
						result = NUDI.insertNotification_Users(notification);

					}

				}

			}

		}

		else if (notification_User.getType().equals("Inquiry")) {

			if (notification_User.getMemberSenderID() != null) {

				Notification_User notification = new Notification_User();
				notification.setNotificationID(UniqueIdGenerator.userIDGenerator("noti"));
				notification.setTime(dtf.format(now));
				notification.setUserID(notification_User.getMemberSenderID());

				notification.setHeader(notification_User.getHeaderMember());
				notification.setBody(notification_User.getBodyMember());

				notification.setUrl("RetrieveInquiryUser?inquiryID="
						+ notification_User.getCustomID());
				result = NUDI.insertNotification_Users(notification);

			}

			List<Role> roles = RSI.RetreiveRoles(null);

			for (Role role : roles) {

				if (role.getName().equals("admin") || role.getName().equals("customer_service_manager")) {

					List<Role_User> role_users = RUSI.RetreiveRole_Users(null, role.getRoleID());

					for (Role_User role_user : role_users) {

						if (notification_User.getMemberSenderID() != null
								&& (notification_User.getMemberSenderID().equals(role_user.getUserID()) == false)) {

							Notification_User notification = new Notification_User();
							notification.setNotificationID(UniqueIdGenerator.userIDGenerator("noti"));
							notification.setTime(dtf.format(now));
							notification.setUserID(role_user.getUserID());

							notification.setHeader(notification_User.getHeader());
							notification.setBody(notification_User.getBody());

							notification.setUrl("RetrieveInquiryPanel?inquiryID="
									+ notification_User.getCustomID());

							result = NUDI.insertNotification_Users(notification);
						}

					}

				}

			}

		}
		
		else if (notification_User.getType().equals("feedback")) {

			if (notification_User.getMemberSenderID() != null) {

				Notification_User notification = new Notification_User();
				notification.setNotificationID(UniqueIdGenerator.userIDGenerator("noti"));
				notification.setTime(dtf.format(now));
				notification.setUserID(notification_User.getMemberSenderID());

				notification.setHeader(notification_User.getHeaderMember());
				notification.setBody(notification_User.getBodyMember());

				notification.setUrl("product?fID="
						+ notification_User.getCustomID());
				result = NUDI.insertNotification_Users(notification);

			}

			List<Role> roles = RSI.RetreiveRoles(null);

			for (Role role : roles) {

				if (role.getName().equals("admin") || role.getName().equals("food_manager")) {

					List<Role_User> role_users = RUSI.RetreiveRole_Users(null, role.getRoleID());

					for (Role_User role_user : role_users) {

						if (notification_User.getMemberSenderID() != null
								&& (notification_User.getMemberSenderID().equals(role_user.getUserID()) == false)) {

							Notification_User notification = new Notification_User();
							notification.setNotificationID(UniqueIdGenerator.userIDGenerator("noti"));
							notification.setTime(dtf.format(now));
							notification.setUserID(role_user.getUserID());

							notification.setHeader(notification_User.getHeader());
							notification.setBody(notification_User.getBody());

							notification.setUrl("product?fID="
									+ notification_User.getCustomID());

							result = NUDI.insertNotification_Users(notification);
						}

					}

				}

			}

		}

		return result;
	}

	@Override
	public boolean deleteNotification_Users(Notification_User notification_User) {
		return NUDI.deleteNotification_Users(notification_User);
	}

	@Override
	public boolean updateNotification_Users(Notification_User notification_User) {
		return NUDI.updateNotification_Users(notification_User);
	}

}
