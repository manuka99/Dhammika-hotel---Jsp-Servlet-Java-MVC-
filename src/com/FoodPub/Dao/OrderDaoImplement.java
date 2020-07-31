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
import com.FoodPub.Model.OrderDB;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class OrderDaoImplement implements OrderDaoInterface {

	public static final Logger log = Logger.getLogger(OrderDaoImplement.class.getName());

	private static Connection connection;

	private PreparedStatement preparedStatement;

	@Override
	public ArrayList<OrderDB> AllOrdersOrByUserID(String userID, String orderID) {

		ArrayList<OrderDB> OrderList = new ArrayList<OrderDB>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			
			if (userID != null && orderID != null) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_USER_ONE_ORDER_DETAILS));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, orderID);
			}

			else if (userID != null) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_USER_ORDER_DETAILS));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
			}

			else
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_ALL_ORDERS));

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				OrderDB order = new OrderDB();
				order.setOrderID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				order.setShippingAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				order.setUserID(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				order.setpDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				order.setdDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				order.setEstimatedDate(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				order.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				order.setTax(resultSet.getDouble(CommonConstants.COLUMN_INDEX_EIGHT));
				order.setShippingFee(resultSet.getDouble(CommonConstants.COLUMN_INDEX_NINE));
				order.setSubTotal(resultSet.getDouble(CommonConstants.COLUMN_INDEX_TEN));
				order.setTotal(resultSet.getDouble(CommonConstants.COLUMN_INDEX_ELEVEN));
				order.setPayment(resultSet.getString(CommonConstants.COLUMN_INDEX_TWELVE));
				order.setOrderType(resultSet.getString(CommonConstants.COLUMN_INDEX_THIRTEEN));
				order.setTransactionID(resultSet.getString(CommonConstants.COLUMN_INDEX_FOURTEEN));
				OrderList.add(order);
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
		return OrderList;
	}

	@Override
	public boolean updateOrder(OrderDB Order) {
		boolean result = false;

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_ORDER));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, Order.getdDate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, Order.getStatus());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, Order.getPayment());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, Order.getOrderID());
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
	public boolean deleteOrder(String orderID) {
		boolean rs = false;
		/*
		 * Remove admin query will be retrieved from VSFM.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_ORDER));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, orderID);
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
	public boolean insertOrder(OrderDB order) {
		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ORDER));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, order.getOrderID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, order.getShippingAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, order.getUserID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, order.getpDate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, order.getEstimatedDate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, order.getStatus());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SEVEN, order.getTax());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_EIGHT, order.getShippingFee());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_NINE, order.getSubTotal());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_TEN, order.getTotal());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, order.getPayment());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWELVE, order.getOrderType());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THIRTEEN, order.getTransactionID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOURTEEN, order.getdDate());

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
