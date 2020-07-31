package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.FoodPub.Model.User;

public interface UserServiceInterface {

	public static final Logger log = Logger.getLogger(UserServiceInterface.class.getName());

	public boolean AddUser(User user, String[] roleIDs, boolean panel);
	public User checkEmail(String email);
	public User validateUserLogin(String email, String password);
	public User activateUser(String userID, String code);
	public boolean resendUseractivatecode(User user);
	public boolean UserPasswordRecovery(User user);
	public boolean UserPasswordUpdate(User user);
	public boolean UserProfileUpdate(User user, String oldEmail);
	public ArrayList<User> retrieveUsersBasedOnRole(String userID, String roleID);
	public User retriveUsers(String userID);
	public boolean deleteUser(String userID);
	public boolean UserUpdatePanel(User user, String[] roleIDs , String oldEmail);
	
}
