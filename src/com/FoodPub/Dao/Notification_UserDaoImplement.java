package com.FoodPub.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.FoodPub.Model.Notification_User;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class Notification_UserDaoImplement implements Notification_UserDaoInterface {

	private static Connection connection;

	private PreparedStatement preparedStatement;

	public static final Logger log = Logger.getLogger(Notification_UserDaoImplement.class.getName());

	@Override
	public List<Notification_User> retrieveNotificationUsers(String userID) {
		ArrayList<Notification_User> Notification_UserList = new ArrayList<>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection.prepareStatement(
					QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_NOTIFICATION_USER_BY_USERID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Notification_User notification_User = new Notification_User();
				notification_User.setNotificationID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				notification_User.setUserID(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				notification_User.setHeader(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				notification_User.setBody(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				notification_User.setTime(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				notification_User.setUrl(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				notification_User.setSeen(resultSet.getBoolean(CommonConstants.COLUMN_INDEX_SEVEN));
				Notification_UserList.add(notification_User);
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
		return Notification_UserList;
	}

	@Override
	public boolean insertNotification_Users(Notification_User notification_User) {
		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_NOTIFICATION_USER));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, notification_User.getNotificationID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, notification_User.getUserID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, notification_User.getHeader());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, notification_User.getBody());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, notification_User.getTime());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, notification_User.getUrl());
			preparedStatement.setBoolean(CommonConstants.COLUMN_INDEX_SEVEN, notification_User.isSeen());
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

	@Override
	public boolean deleteNotification_Users(Notification_User notification_User) {
		boolean rs = false;

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_NOTIFICATION_USER));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, notification_User.getNotificationID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, notification_User.getUserID());
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
	public boolean updateNotification_Users(Notification_User notification_User) {
		boolean result = false;

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_NOTIFICATION_USER));
			preparedStatement.setBoolean(CommonConstants.COLUMN_INDEX_ONE, notification_User.isSeen());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, notification_User.getNotificationID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, notification_User.getUserID());
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

}
