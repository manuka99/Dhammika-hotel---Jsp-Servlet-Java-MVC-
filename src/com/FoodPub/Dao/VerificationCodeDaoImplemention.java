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

import com.FoodPub.Model.UserVerificationToken;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class VerificationCodeDaoImplemention implements VerificationCodeDaoInterface {

	private static Connection connection;

	private PreparedStatement preparedStatement;

	public static final Logger log = Logger.getLogger(VerificationCodeDaoImplemention.class.getName());

	@Override
	public boolean UserVerificationCodeUpdate(UserVerificationToken UVT) {

		boolean result = false;

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_VCODE));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, UVT.getToken());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, UVT.getExpiryDate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, UVT.getId());
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
	public boolean UserVerificationCodeAdd(UserVerificationToken UVT) {
		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_VCODE));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, UVT.getId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, UVT.getUserID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, UVT.getToken());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, UVT.getExpiryDate());

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
	public UserVerificationToken retriveUserVerificationCode(String userID) {

		UserVerificationToken VCT = new UserVerificationToken();

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_VCODE_BY_USERID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				VCT.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				VCT.setUserID(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				VCT.setToken(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				VCT.setExpiryDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
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

		return VCT;

	}

}
