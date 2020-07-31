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

import com.FoodPub.Model.Response_CNT;
import com.FoodPub.Model.User;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class ResponseDBDaoImplement implements ResponseDBDaoInterface {

	private static Connection connection;

	private PreparedStatement preparedStatement;

	public static final Logger log = Logger.getLogger(ResponseDBDaoImplement.class.getName());

	@Override
	public ArrayList<Response_CNT> RetreiveResponses(String responseID, String contactUsID) {

		ArrayList<Response_CNT> responsesList = new ArrayList<>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			if (responseID != null && contactUsID == null) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_RESPONSE_BY_ID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, responseID);
			}
			
			else if (responseID == null && contactUsID != null) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_RESPONSE_BY_CONTACTUSID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, contactUsID);
			}


			else
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_ALL_RESPONSES));

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Response_CNT response = new Response_CNT();
				User user = new User();
				response.setResponseID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				response.setContactUsID(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				user.setUserID(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				response.setMessage(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				response.setTime(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				response.setUser(user);
				responsesList.add(response);
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
		return responsesList;
	}

	@Override
	public boolean deleteResponse(String responseID) {
		boolean rs = false;
		/*
		 * Remove admin query will be retrieved from VSFM.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_RESPONSE));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, responseID);
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
	public boolean insertResponse(Response_CNT response) {
		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_RESPONSE));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, response.getResponseID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, response.getContactUsID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, response.getUser().getUserID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, response.getMessage());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, response.getTime());

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
