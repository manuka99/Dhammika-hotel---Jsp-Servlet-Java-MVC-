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

import com.FoodPub.Model.OrderedItems;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class OrderItemsDaoImplement implements OrderItemsDaoInterface{

	private static Connection connection;

	private PreparedStatement preparedStatement;
	
	public static final Logger log = Logger.getLogger(OrderItemsDaoImplement.class.getName());


	@Override
	public boolean insertOrderItem(ArrayList<OrderedItems> orderItems) {
		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();

			for (OrderedItems orderedItems : orderItems) {
				
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ORDERED_ITEMS_INSERT));
				connection.setAutoCommit(false);

				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, orderedItems.getOrderID());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, orderedItems.getProductID());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, orderedItems.getQuantity());

				int result = preparedStatement.executeUpdate();
				if (result == 1)
					rs = true;
				
				else {
					rs = false;
					break;
				}
					
				
			}

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
	public ArrayList<OrderedItems> retreiveOrderedItems(String orderID ) {
		
		ArrayList<OrderedItems> orderedItemsList = new ArrayList<>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ORDERED_ITEMS_RETRIEVE));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, orderID);
				

			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				OrderedItems orderedItems = new OrderedItems();
				orderedItems.setOrderID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				orderedItems.setProductID(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				orderedItems.setQuantity(resultSet.getInt(CommonConstants.COLUMN_INDEX_THREE));
				orderedItemsList.add(orderedItems);
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
		return orderedItemsList;
	}

}
