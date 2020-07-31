package com.FoodPub.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.FoodPub.Model.Role_User;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class RoleUserDaoImplement implements RoleUserDaoInterface{

	private static Connection connection;

	private PreparedStatement preparedStatement;
	
	public static final Logger log = Logger.getLogger(RoleUserDaoImplement.class.getName());
	
	@Override
	public ArrayList<Role_User> RetreiveRole_Users(String userID, String roleID) {
		ArrayList<Role_User> Role_UserList = new ArrayList<>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			if (userID != null && roleID == null) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_ROLE_USER_BY_USERID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
			}
			
			else if (userID == null && roleID != null) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_ROLE_USER_BY_ROLEID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, roleID);		
				
			}

			else
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_ALL_ROLE_USERS));

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Role_User role_User = new Role_User();
				role_User.setRoleID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				role_User.setUserID(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				Role_UserList.add(role_User);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return Role_UserList;
	}

	@Override
	public boolean deleteRole_User(Role_User role_user) {
		boolean rs = false;
		/*
		 * Remove admin query will be retrieved from VSFM.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_ROLE_USER));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, role_user.getRoleID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, role_user.getUserID());
			int result = preparedStatement.executeUpdate();
			/*
			 * after a user is removed the result is send to the data panel and it will
			 * display respective alerts
			 */
			if (result > 0)
				rs = true;

			else
				rs = false;

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());

			}

		}

		return rs;
	}

	@Override
	public boolean insertRole_User(Role_User role_user) {
		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ROLE_USER));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, role_user.getRoleID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, role_user.getUserID());

			int result = preparedStatement.executeUpdate();

			if (result == 1)
				rs = true;

			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return rs;
	}
	
	

}
