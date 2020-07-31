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
import com.FoodPub.Model.CartItems;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class CartItemDaoImplement implements CartItemDaoInterface {

	public static final Logger log = Logger.getLogger(CartItemDaoImplement.class.getName());
	private static Connection connection;

	private PreparedStatement preparedStatement;

	@Override
	public Boolean addCartItem(CartItems cartItem) {
		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CART_ITEM_INSERT));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cartItem.getCartID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, cartItem.getProductID());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, cartItem.getQuantity());

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
	public Boolean updateCartItem(CartItems cartItem) {
		boolean result = false;

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CART_ITEM_UPDATE));
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, cartItem.getQuantity());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, cartItem.getCartID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, cartItem.getProductID());
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
	public ArrayList<CartItems> retreiveCartItems(String cartID) {
		ArrayList<CartItems> CartItem = new ArrayList<CartItems>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CART_ITEM_DETAILS_BY_CARTID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cartID);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				CartItems item = new CartItems();
				//FoodItem food = new FoodItem();
				item.setCartID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				item.setProductID(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				item.setQuantity(resultSet.getInt(CommonConstants.COLUMN_INDEX_THREE));
				//item.setItem(food);
				CartItem.add(item);
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

		return CartItem;
	}

	@Override
	public boolean deleteCartItems(CartItems cartItem) {

		boolean rs = false;
		/*
		 * Remove admin query will be retrieved from VSFM.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CART_ITEM_DELETE));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cartItem.getCartID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, cartItem.getProductID());
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
	public CartItems retreiveCartItem(String cartID, String itemID) {

		CartItems item = new CartItems();

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CART_ITEM_PRODUCT_VALIDATE));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cartID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, itemID);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
			
				item.setCartID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				item.setProductID(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				item.setQuantity(resultSet.getInt(CommonConstants.COLUMN_INDEX_THREE));
			
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

		return item;
	}

}
