package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Model.Role_User;

public interface RoleUserServiceInterface {

	public static final Logger log = Logger.getLogger(RoleUserServiceInterface.class.getName());
	
	public ArrayList<Role_User> RetreiveRole_Users(String userID, String roleID) ;
	public boolean deleteRole_User(Role_User role_user);
	public boolean insertRole_User(Role_User role_user);
	
}
