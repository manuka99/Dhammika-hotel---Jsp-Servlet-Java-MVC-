package com.FoodPub.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.FoodPub.Model.Category;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class CategoryDaoImplement implements CategoryDaoInterface {

	public static final Logger log = Logger.getLogger(CategoryDaoImplement.class.getName());

	private static Connection connection;

	private PreparedStatement preparedStatement;

	public boolean addNewCategory(Category category) {

		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CATEGORY));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, category.getCategoryID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, category.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, category.getDescription());
			/*
			 * Add admin and get the result to display alerts
			 */

			int result = preparedStatement.executeUpdate();

			if (result > 0)
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

	public ArrayList<Category> retrieveCategory(String cid) {

		ArrayList<Category> CategoryList = new ArrayList<Category>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching admin it checks whether admin ID is available
			 */
			if (cid != null) {
				/*
				 * Get admin by ID query will be retrieved from VSFM.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CATEGORY));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cid);
			}
			/*
			 * If admin ID is not provided for get all admin option it display all admins
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_All_CATEGORY));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category();
				category.setCategoryID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				category.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				category.setDescription(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));

				CategoryList.add(category);
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
		return CategoryList;
	}

	@Override
	public boolean deleteCategory(String cid) {

		boolean rs = false;
		/*
		 * Remove admin query will be retrieved from VSFM.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_CATEGORY));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cid);
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
	public boolean updateCategory(Category category) {
		boolean result = false;

		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_CATEGORY));

				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, category.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, category.getDescription());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, category.getCategoryID());

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
