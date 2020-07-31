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

import com.FoodPub.Model.DeliveryFee;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class DeliveryFeeDaoImplement implements DeliveryFeeDaoInterface {

	private static Connection connection;

	private PreparedStatement preparedStatement;

	public static final Logger log = Logger.getLogger(DeliveryFeeDaoImplement.class.getName());

	@Override
	public boolean addDeliveryFee(DeliveryFee deliveryFee) {
		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_PRODUCT_DELIVERY_FEE));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, deliveryFee.getId());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_TWO, deliveryFee.getTotal());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_THREE, deliveryFee.getFee());

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
	public boolean updateDeliveryFee(DeliveryFee deliveryFee) {
		boolean result = false;

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_PRODUCT_DELIVERY_FEE));
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_ONE, deliveryFee.getTotal());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_TWO, deliveryFee.getFee());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, deliveryFee.getId());
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
	public double retreiveFee(double total) {

		Double fee = 0.00;

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_PRODUCT_DELIVERY_FEE));
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_ONE, total);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				fee = resultSet.getDouble(CommonConstants.COLUMN_INDEX_ONE);
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

		return fee;
	}

	@Override
	public ArrayList<DeliveryFee> retreiveAllDeliveryFee(String id) {

		ArrayList<DeliveryFee> DeliveryFeeList = new ArrayList<DeliveryFee>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			if (id != null) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_PRODUCT_DELIVERY_FEE_BY_ID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, id);
			}

			else
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_PRODUCT_DELIVERY_FEE));

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				DeliveryFee deliveryFee = new DeliveryFee();
				deliveryFee.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				deliveryFee.setTotal(resultSet.getDouble(CommonConstants.COLUMN_INDEX_TWO));
				deliveryFee.setFee(resultSet.getDouble(CommonConstants.COLUMN_INDEX_THREE));

				DeliveryFeeList.add(deliveryFee);
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
		return DeliveryFeeList;
	}

	@Override
	public boolean deleteDeliveryFee(String id) {

		boolean rs = false;
		/*
		 * Remove admin query will be retrieved from VSFM.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_PRODUCT_DELIVERY_FEE));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, id);
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
