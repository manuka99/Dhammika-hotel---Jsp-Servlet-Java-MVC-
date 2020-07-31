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

import com.FoodPub.Model.ContactUs;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class ContactUsDaoImplement implements ContactUsDaoInterface {

	private static Connection connection;

	private PreparedStatement preparedStatement;

	public static final Logger log = Logger.getLogger(ContactUsDaoImplement.class.getName());

	@Override
	public List<ContactUs> retreiveContactUs(String cid) {

		ArrayList<ContactUs> contactUsList = new ArrayList<>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			if (cid != null) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_CONTACTUS_BY_ID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cid);
			}

			else
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_ALL_CONTACTUS));

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				ContactUs contactUs = new ContactUs();
				contactUs.setContactUsID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				contactUs.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				contactUs.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				contactUs.setPhone(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				contactUs.setSubject(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				contactUs.setMessage(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				contactUs.setTime(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));

				contactUsList.add(contactUs);
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
		return contactUsList;
	}

	@Override
	public boolean insertContactUs(ContactUs contactus) {
		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CONTACTUS));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, contactus.getContactUsID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, contactus.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, contactus.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, contactus.getPhone());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, contactus.getSubject());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, contactus.getMessage());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, contactus.getTime());

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
	public boolean deleteContactUs(String cuid) {
		boolean rs = false;
		/*
		 * Remove admin query will be retrieved from VSFM.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_CONTACTUS));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, "con39814960039198721");
			System.out.println(cuid);
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
