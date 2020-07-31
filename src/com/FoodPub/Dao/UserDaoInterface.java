package com.FoodPub.Dao;

import java.util.logging.Logger;

import com.FoodPub.Model.User;

public interface UserDaoInterface {
	
	public static final Logger log = Logger.getLogger(UserDaoInterface.class.getName());

	public boolean AddUser(User user);
	
	
	public User checkEmail(String email);
	
	
	public User validateUserLogin(String email, String password);
	
	
	//public User activateUser(String userID, String code);
	
	
	//public boolean resendUseractivatecode(User user, String code);
	
	public boolean UserPasswordUpdate(User user);
	public boolean UserProfileUpdate(User user);
	public User retriveUsers(String userID);
	public boolean deleteUser(String userID);
}
