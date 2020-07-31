package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Dao.RoleDaoImplement;
import com.FoodPub.Dao.RoleDaoInterface;
import com.FoodPub.Model.Role;
import com.FoodPub.Util.UniqueIdGenerator;

public class RoleServiceImplement implements RoleServiceInterface {

	private RoleDaoInterface RDI = new RoleDaoImplement();
	public static final Logger log = Logger.getLogger(RoleServiceInterface.class.getName());

	@Override
	public ArrayList<Role> RetreiveRoles(String roleID) {
		return RDI.RetreiveRoles(roleID);
	}

	@Override
	public boolean updateRole(Role role) {
		return RDI.updateRole(role);
	}

	@Override
	public boolean deleteRole(String roleID) {
		return RDI.deleteRole(roleID);
	}

	@Override
	public boolean insertRole(Role role) {
		role.setRoleID(UniqueIdGenerator.userIDGenerator("role"));
		return RDI.insertRole(role);
	}

}
