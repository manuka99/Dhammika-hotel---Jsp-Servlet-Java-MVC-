package com.FoodPub.Service;

import java.util.List;
import java.util.logging.Logger;

import com.FoodPub.Model.Notification_User;

public interface Notification_UsersServiceInterface {
	
	public static final Logger log = Logger.getLogger(Notification_UsersServiceInterface.class.getName());

	public List<Notification_User> retrieveNotificationUsers(String userID);

	public boolean insertNotification_Users(Notification_User notification_User);

	public boolean deleteNotification_Users(Notification_User notification_User);

	public boolean updateNotification_Users(Notification_User notification_User);

}
