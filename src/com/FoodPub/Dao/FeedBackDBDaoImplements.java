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

import com.FoodPub.Model.FeedBackDB;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class FeedBackDBDaoImplements implements FeedBackDBDaoInterface {

	private static Connection connection;

	private PreparedStatement preparedStatement;

	public static final Logger log = Logger.getLogger(FeedBackDBDaoImplements.class.getName());

	@Override
	public ArrayList<FeedBackDB> retreiveFeedBacks(String feedbackID, String itemID, String userID) {
		ArrayList<FeedBackDB> feedbackList = new ArrayList<FeedBackDB>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			if (feedbackID != null && itemID != null && userID != null) {
				preparedStatement = connection.prepareStatement(
						QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_FEEDBACK_FEEDBACKID_ITEMID_BY_USERID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, itemID);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, feedbackID);
			}
			
			else if (feedbackID != null && itemID == null && userID == null) {
				preparedStatement = connection.prepareStatement(
						QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_FEEDBACK_BY_FEEDBACKID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, feedbackID);
			}
			
			else if (feedbackID == null && itemID != null && userID != null) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_FEEDBACK_ITEMID_BY_USERID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, itemID);
			}

			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_FEEDBACK_ITEMID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemID);
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				FeedBackDB feedback = new FeedBackDB();
				feedback.setFeedbackID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				feedback.setUserID(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				feedback.setItemID(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				feedback.setRating(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				feedback.setReview(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				feedback.setTime(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				feedbackList.add(feedback);
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
		return feedbackList;
	}

	@Override
	public boolean deleteFeedBack(String feedbackID, String userID) {
		boolean rs = false;
		/*
		 * Remove admin query will be retrieved from VSFM.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_FEEDBACK));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, feedbackID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, userID);
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
	public boolean updateFeedBack(FeedBackDB feedback) {
		boolean result = false;

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_FEEDBACK));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, feedback.getRating());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, feedback.getReview());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, feedback.getFeedbackID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, feedback.getUserID());

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
	public boolean insertFeedBack(FeedBackDB feedback) {
		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_FEEDBACK));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, feedback.getFeedbackID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, feedback.getUserID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, feedback.getItemID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, feedback.getRating());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, feedback.getReview());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, feedback.getTime());
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
