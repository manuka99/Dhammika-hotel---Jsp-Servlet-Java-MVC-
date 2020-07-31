package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.FoodPub.Dao.UserDaoImplement;
import com.FoodPub.Dao.UserDaoInterface;
import com.FoodPub.Model.Cart;
import com.FoodPub.Model.Role;
import com.FoodPub.Model.Role_User;
import com.FoodPub.Model.User;
import com.FoodPub.Model.UserVerificationToken;
import com.FoodPub.Util.UniqueIdGenerator;
import com.FoodPub.Util.VerificationCode;
import com.FoodPub.Util.bCryptPassword;

public class UserServiceImplement implements UserServiceInterface {

	private UserDaoInterface MSI = new UserDaoImplement();
	private CartServiceInterface CSI = new CartServiceImplement();
	private RoleServiceInterface RSI = new RoleServiceImplement();
	private RoleUserServiceInterface RUSI = new RoleUserServiceImplement();
	private EmailServiceInterface ESI = new EmailService();
	private VerificationCodeserviceInterface VCSI = new VerificationCodeServiceImplement();
	private OrderServiceInterface OSI = new OrderServiceImplement();
	private Notification_UsersServiceInterface NUSI = new Notification_UsersServiceImplement();

	public static final Logger log = Logger.getLogger(UserServiceImplement.class.getName());

	@Override
	public boolean AddUser(User user, String[] roleIDs, boolean panel) {

		String userID = UniqueIdGenerator.userIDGenerator("User");
		user.setUserID(userID);

		String un_encryptedPass = user.getPassword();

		user.setPassword(bCryptPassword.hashPassword(user.getPassword()));
		String code = VerificationCode.getAlphaNumericString(26);

		boolean result = MSI.AddUser(user);

		if (result == true) {

			Cart cart = new Cart();
			cart.setCartID(UniqueIdGenerator.userIDGenerator("Cart"));
			cart.setUserID(userID);
			CSI.addCart(cart);

			UserVerificationToken uvt = new UserVerificationToken();
			uvt.setToken(code);
			uvt.setUserID(userID);
			VCSI.UserVerificationCodeAdd(uvt);

			ESI.registrationSuccessEmail(user);
			ESI.accountActivationEmail(user, code);

			if (panel == true)
				ESI.userAddedPanelEmail(user, un_encryptedPass);

			result = addUpdateRolesOfUsers(roleIDs, user);

		}

		return result;

	}

	@Override
	public User checkEmail(String email) {
		User user = MSI.checkEmail(email);
		user.setRoles(getUserRoleNames(user.getUserID()));
		return user;
	}

	@Override
	public User validateUserLogin(String email, String password) {

		User user = MSI.checkEmail(email);

		System.out.println(user.getPassword());

		boolean result = bCryptPassword.checkPassword(password, user.getPassword());

		if (result == true) {

			user = retriveUsers(user.getUserID());

			return user;
		} else
			return new User();
	}

	@Override
	public User activateUser(String userID, String code) {

		User user = new User();

		UserVerificationToken uvtEx = VCSI.retriveUserVerificationCode(userID);

		if (uvtEx != null && uvtEx.getToken().equals(code)) {

			user = MSI.retriveUsers(uvtEx.getUserID());
			user.setStatus(true);
			MSI.UserProfileUpdate(user);

		}

		return user;
	}

	@Override
	public boolean resendUseractivatecode(User user) {

		boolean result = false;

		UserVerificationToken uvtEx = VCSI.retriveUserVerificationCode(user.getUserID());

		if (uvtEx != null) {
			String code = VerificationCode.getAlphaNumericString(26);
			uvtEx.setToken(code);
			uvtEx.setUserID(user.getUserID());
			result = VCSI.UserVerificationCodeUpdate(uvtEx);

			if (result == true)
				ESI.accountActivationEmail(user, code);
		}

		return result;
	}

	@Override
	public boolean UserPasswordRecovery(User user) {

		String password = UniqueIdGenerator.userIDGenerator("pass");
		user.setPassword(bCryptPassword.hashPassword(password));

		boolean result = MSI.UserPasswordUpdate(user);

		if (result = true)
			ESI.passwordRecoveryEmail(user, password);

		return result;

	}

	@Override
	public boolean UserProfileUpdate(User user, String oldEmail) {

		boolean result = MSI.UserProfileUpdate(user);

		if (user.getStatus() == false && result == true) {

			ESI.profileUpdateEmail(user, oldEmail);

			UserVerificationToken uvt = new UserVerificationToken();
			UserVerificationToken uvtEx = VCSI.retriveUserVerificationCode(user.getUserID());

			if (uvtEx.getUserID() == null) {
				System.out.println("w3223");
				String code = VerificationCode.getAlphaNumericString(26);
				uvt.setToken(code);
				uvt.setUserID(user.getUserID());
				boolean result2 = VCSI.UserVerificationCodeAdd(uvt);

				if (result2 == true)
					ESI.accountActivationEmail(user, code);
			}

			else {
				System.out.println("w3223");
				String code = VerificationCode.getAlphaNumericString(26);
				uvt.setToken(code);
				uvt.setUserID(user.getUserID());
				uvt.setId(uvtEx.getId());
				VCSI.UserVerificationCodeUpdate(uvt);
			}

		}

		return MSI.UserProfileUpdate(user);
	}

	@Override
	public boolean UserPasswordUpdate(User user) {

		user.setPassword(bCryptPassword.hashPassword(user.getPassword()));

		return MSI.UserPasswordUpdate(user);
	}

	public List<Role> getUserRoleNames(String userID) {

		List<Role_User> roles_user = RUSI.RetreiveRole_Users(userID, null);
		List<Role> roles = new ArrayList<>();

		for (Role_User role : roles_user) {

			List<Role> role_List = RSI.RetreiveRoles(role.getRoleID());

			for (Role role2 : role_List) {

				roles.add(role2);

			}

		}

		return roles;
	}

	@Override
	public ArrayList<User> retrieveUsersBasedOnRole(String userID, String roleID) {

		ArrayList<Role_User> role_userList = RUSI.RetreiveRole_Users(userID, roleID);

		ArrayList<User> userList = new ArrayList<>();

		for (Role_User role_User : role_userList) {

			User user = new User();

			user = retriveUsers(role_User.getUserID());

			userList.add(user);
		}

		return userList;
	}

	@Override
	public User retriveUsers(String userID) {

		User user = new User();

		user = MSI.retriveUsers(userID);

		if (user != null) {
			user.setRoles(getUserRoleNames(user.getUserID()));
			//user.setCart(CSI.retreiveCart(null, user.getUserID()));
			//user.setOrders(OSI.AllOrdersOrByUserID(user.getUserID(), null));
			//user.setNotifications(NUSI.retrieveNotificationUsers(user.getUserID()));
		}

		return user;
	}

	@Override
	public boolean deleteUser(String userID) {
		return MSI.deleteUser(userID);
	}

	public boolean addUpdateRolesOfUsers(String[] roleIDs, User user) {

		boolean result = false;

		List<Role> rolesList = RSI.RetreiveRoles(null);

		// delete existing roles

		List<Role_User> CurrentUserrolesList = RUSI.RetreiveRole_Users(user.getUserID(), null);

		if (CurrentUserrolesList != null) {

			for (Role_User role_User : CurrentUserrolesList) {

				result = RUSI.deleteRole_User(role_User);
			}
		}

		// add roles

		try {

			if (roleIDs != null && roleIDs.length != 0) {

				for (String roleID : roleIDs) {

					for (Role role : rolesList) {

						if (role.getRoleID().equals(roleID)) {

							Role_User role_user = new Role_User();
							role_user.setRoleID(role.getRoleID());
							role_user.setUserID(user.getUserID());
							result = RUSI.insertRole_User(role_user);

						}

					}

				}
			} else {

				for (Role role : rolesList) {

					if (role.getName().equals("member")) {

						Role_User role_user = new Role_User();
						role_user.setRoleID(role.getRoleID());
						role_user.setUserID(user.getUserID());
						result = RUSI.insertRole_User(role_user);

					}

				}

			}

		} catch (NullPointerException e) {
			// if the exceptions are true
			System.out.println("there was a null point exception at line 212 ");
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public boolean UserUpdatePanel(User user2, String[] roleIDs, String oldEmail) {

		boolean result = false;
		User user = retriveUsers(user2.getUserID());

		user.setDateOfBirth(user2.getDateOfBirth());
		user.setPhone(user2.getPhone());
		user.setEmail(user2.getEmail());
		user.setName(user2.getName());
		user.setAddress(user2.getAddress());
		user.setStatus(user2.getStatus());

		result = UserProfileUpdate(user, oldEmail);

		if (result == true) {

			result = addUpdateRolesOfUsers(roleIDs, user);

		}

		return result;
	}

}
