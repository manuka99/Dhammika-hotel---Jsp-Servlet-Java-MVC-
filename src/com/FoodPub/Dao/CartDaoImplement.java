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

import com.FoodPub.Model.Cart;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class CartDaoImplement implements CartDaoInterface {

	public static final Logger log = Logger.getLogger(CartDaoImplement.class.getName());
	private static Connection connection;

	private PreparedStatement preparedStatement;

	@Override
	public Boolean addCart(Cart cart) {
		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CART_INSERT));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cart.getCartID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, cart.getUserID());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, cart.getItemCount());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_FOUR, cart.getTotal());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_FIVE, cart.getProductPriceTotal());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SIX, cart.getTax());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SEVEN, cart.getShippingFee());

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
	public Boolean updateCart(Cart cart) {

		boolean result = false;

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CART_UPDATE));
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, cart.getItemCount());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_TWO, cart.getTotal());		
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_THREE, cart.getProductPriceTotal());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_FOUR, cart.getTax());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_FIVE, cart.getShippingFee());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, cart.getCartID());
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
	public Cart retreiveCart(String cartID, String userID) {

		Cart cart = new Cart();

		try {
			
			connection = DBConnectionUtil.getDBConnection();

			if(cartID == null && userID != null) {
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CART_DETAILS_BY_USERID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
			}
			
			else {
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CART_DETAILS_BY_CARTID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cartID);
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				cart.setCartID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				cart.setUserID(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				cart.setItemCount(resultSet.getInt(CommonConstants.COLUMN_INDEX_THREE));
				cart.setTotal(resultSet.getDouble(CommonConstants.COLUMN_INDEX_FOUR));
				cart.setProductPriceTotal(resultSet.getDouble(CommonConstants.COLUMN_INDEX_FIVE));
				cart.setTax(resultSet.getDouble(CommonConstants.COLUMN_INDEX_SIX));
				cart.setShippingFee(resultSet.getDouble(CommonConstants.COLUMN_INDEX_SEVEN));
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

		return cart;
	}

}
