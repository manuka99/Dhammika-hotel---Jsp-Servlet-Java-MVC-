package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Model.Role;

public interface RoleServiceInterface {
	
	public static final Logger log = Logger.getLogger(RoleServiceInterface.class.getName());
	
	public ArrayList<Role> RetreiveRoles(String roleID) ;
	public boolean updateRole(Role role);
	public boolean deleteRole(String roleID);
	public boolean insertRole(Role role);

}
