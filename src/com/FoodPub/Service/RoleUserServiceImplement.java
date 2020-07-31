package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Dao.RoleUserDaoImplement;
import com.FoodPub.Dao.RoleUserDaoInterface;
import com.FoodPub.Model.Role_User;

public class RoleUserServiceImplement implements RoleUserServiceInterface{

	private RoleUserDaoInterface RUDI = new RoleUserDaoImplement();
	public static final Logger log = Logger.getLogger(RoleUserServiceImplement.class.getName());
	
	@Override
	public ArrayList<Role_User> RetreiveRole_Users(String userID, String roleID) {
		return RUDI.RetreiveRole_Users(userID, roleID);
	}

	@Override
	public boolean deleteRole_User(Role_User role_user) {
		return RUDI.deleteRole_User(role_user);
	}

	@Override
	public boolean insertRole_User(Role_User role_user) {
		return RUDI.insertRole_User(role_user);
	}

}
