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

import com.FoodPub.Model.Role;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class RoleDaoImplement implements RoleDaoInterface {

	private static Connection connection;

	private PreparedStatement preparedStatement;
	
	public static final Logger log = Logger.getLogger(OrderDaoImplement.class.getName());

	@Override
	public ArrayList<Role> RetreiveRoles(String roleID) {
		ArrayList<Role> RoleList = new ArrayList<>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			if (roleID != null) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_ROLE_BY_ROLEID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, roleID);
			}

			else
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_ALL_ROLES));

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Role role = new Role();
				role.setRoleID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				role.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				role.setDescription(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				RoleList.add(role);
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
		return RoleList;
	}

	@Override
	public boolean updateRole(Role role) {

		boolean result = false;

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_ROLE));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, role.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, role.getDescription());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, role.getRoleID());
			int rs = preparedStatement.executeUpdate();

			if (rs == 1)
				result = true;

			/*
			 * admin with the above email and password is check and returns a arraylist
			 */

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

		return result;
	}

	@Override
	public boolean deleteRole(String roleID) {
		boolean rs = false;
		/*
		 * Remove admin query will be retrieved from VSFM.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_ROLE));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, roleID);
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
	public boolean insertRole(Role role) {
		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ROLE));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, role.getRoleID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, role.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, role.getDescription());

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
