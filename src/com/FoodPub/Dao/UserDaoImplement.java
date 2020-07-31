package com.FoodPub.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.FoodPub.Model.User;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class UserDaoImplement implements UserDaoInterface {

	private static Connection connection;

	private PreparedStatement preparedStatement;

	public static final Logger log = Logger.getLogger(UserDaoImplement.class.getName());

	@Override
	public boolean AddUser(User user) {

		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_USER));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, user.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, user.getEmail());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, user.getPhone());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, user.getPassword());
			preparedStatement.setBoolean(CommonConstants.COLUMN_INDEX_FIVE, user.getStatus());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, user.getDateOfBirth());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, user.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, user.getUserID());

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
	public User checkEmail(String email) {
		User user = new User();

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_USER_EMAIL_EXSIST));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, email);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				user.setUserID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				user.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				user.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				user.setPhone(resultSet.getInt(CommonConstants.COLUMN_INDEX_FOUR));
				user.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				user.setDateOfBirth(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				user.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				user.setStatus(resultSet.getBoolean(CommonConstants.COLUMN_INDEX_EIGHT));
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
		return user;

	}

	@Override
	public User validateUserLogin(String email, String password) {

		User user = new User();

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_VALIDATE_USER_LOGIN));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, email);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				user.setUserID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				user.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				user.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				user.setPhone(resultSet.getInt(CommonConstants.COLUMN_INDEX_FOUR));
				user.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				user.setDateOfBirth(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				user.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				user.setStatus(resultSet.getBoolean(CommonConstants.COLUMN_INDEX_EIGHT));
			}

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

		return user;
	}

	@Override
	public boolean UserPasswordUpdate(User user) {

		boolean result = false;

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_USER_PASSWORD_UPDATE));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, user.getPassword());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, user.getUserID());
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
	public boolean UserProfileUpdate(User user) {
		boolean result = false;

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_USER_PROFILE_UPDATE));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, user.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, user.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, user.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, user.getDateOfBirth());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, user.getPhone());
			preparedStatement.setBoolean(CommonConstants.COLUMN_INDEX_SIX, user.getStatus());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, user.getUserID());
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

	public User retriveUsers(String userID) {
		User user = new User();

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_RETRIEVE_USERS_BY_USERID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				user.setUserID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				user.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				user.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				user.setPhone(resultSet.getInt(CommonConstants.COLUMN_INDEX_FOUR));
				user.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				user.setDateOfBirth(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				user.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				user.setStatus(resultSet.getBoolean(CommonConstants.COLUMN_INDEX_EIGHT));
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
		return user;

	}

	@Override
	public boolean deleteUser(String userID) {
		boolean rs = false;
		/*
		 * Remove admin query will be retrieved from VSFM.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_USER));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
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

}
