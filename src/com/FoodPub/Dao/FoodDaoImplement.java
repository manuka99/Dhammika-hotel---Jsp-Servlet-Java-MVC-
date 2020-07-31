package com.FoodPub.Dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.Part;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.FoodPub.Model.FoodItem;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class FoodDaoImplement implements FoodDaoInterface {

	public static final Logger log = Logger.getLogger(FoodDaoImplement.class.getName());

	private static Connection connection;

	private PreparedStatement preparedStatement;

	@Override
	public boolean addNewFood(FoodItem foodItem, Part image) {

		boolean rs = false;

		try {

			InputStream inputStream = image.getInputStream();

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_FOOD));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, foodItem.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, foodItem.getDescription());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, foodItem.getPortion());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_FOUR, foodItem.getPrice());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, foodItem.getCatergoryID());
			preparedStatement.setBlob(CommonConstants.COLUMN_INDEX_SIX, inputStream);
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SEVEN, foodItem.getTax());
			preparedStatement.setBoolean(CommonConstants.COLUMN_INDEX_EIGHT,foodItem.isActive());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,foodItem.getItemID());
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
/*
	public ArrayList<FoodItem> retrieveFood0(int fid, int cid, String search, int thisRecords, int recordsPerPage) {

		ArrayList<FoodItem> FoodList = new ArrayList<FoodItem>();
		try {
			connection = DBConnectionUtil.getDBConnection();
		
			if (fid != 0 && cid == 0) {
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_FOOD));
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, fid);
			}

			else if (fid == 0 && cid != 0 && recordsPerPage == 0) {
			
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_FOOD_BY_CATEGORY));
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, cid);
			}

			else if (search.isEmpty() == false) {
			
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SEARCH));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, search);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, search);
			}

			else if (recordsPerPage != 0 && cid != 0) {
			
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_FOOD_LIMIT_BY_CATEGORY));
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, cid);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, thisRecords);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, recordsPerPage);
			}

			else if (recordsPerPage != 0 && cid == 0) {

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_FOOD_LIMIT));
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, thisRecords);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, recordsPerPage);
			}

	
			else {
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_FOOD));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				FoodItem fooditem = new FoodItem();
				fooditem.setItemID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				fooditem.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				fooditem.setDescription(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				fooditem.setPortion(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				fooditem.setPrice(resultSet.getDouble(CommonConstants.COLUMN_INDEX_FIVE));
				fooditem.setCatergoryID(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				Blob blob = resultSet.getBlob(CommonConstants.COLUMN_INDEX_SEVEN);
				fooditem.setTax(resultSet.getDouble(CommonConstants.COLUMN_INDEX_EIGHT));
				fooditem.setActive(resultSet.getBoolean(CommonConstants.COLUMN_INDEX_NINE));

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();

				fooditem.setImage(base64Image);

				FoodList.add(fooditem);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
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
		return FoodList;
	}
	*/

	@Override
	public ArrayList<FoodItem> retrieveFood(String fid, String cid, String search) {

		ArrayList<FoodItem> FoodList = new ArrayList<FoodItem>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching admin it checks whether admin ID is available
			 */
			if (fid != null && cid == null && search == null) {
				/*
				 * Get admin by ID query will be retrieved from VSFM.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_FOOD));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, fid);
			}

			else if (fid == null && cid != null && search == null) {
				/*
				 * Get admin by ID query will be retrieved from VSFM.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_FOOD_BY_CATEGORY));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cid);
			}

			else if (search != null && fid == null && cid != null) {
				/*
				 * Get admin by ID query will be retrieved from VSFM.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SEARCH));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, search);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, search);
			}

			else {
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_FOOD));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				FoodItem fooditem = new FoodItem();
				fooditem.setItemID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				fooditem.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				fooditem.setDescription(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				fooditem.setPortion(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				fooditem.setPrice(resultSet.getDouble(CommonConstants.COLUMN_INDEX_FIVE));
				fooditem.setCatergoryID(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				Blob blob = resultSet.getBlob(CommonConstants.COLUMN_INDEX_SEVEN);
				fooditem.setTax(resultSet.getDouble(CommonConstants.COLUMN_INDEX_EIGHT));
				fooditem.setActive(resultSet.getBoolean(CommonConstants.COLUMN_INDEX_NINE));

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();

				fooditem.setImage(base64Image);

				FoodList.add(fooditem);
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
		return FoodList;
	}

	@Override
	public ArrayList<FoodItem> retrieveFoodPagination(String cid, int thisRecords, int recordsPerPage, String column,
			String type, int sliderValue) {

		ArrayList<FoodItem> FoodList = new ArrayList<FoodItem>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			if (cid != null && (column == null || column.isEmpty()) && (type == null || type.isEmpty())) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_FOOD_LIMIT_BY_CATEGORY));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cid);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, sliderValue);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, thisRecords);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, recordsPerPage);
			}

			/*
			 * If admin ID is not provided for get all admin option it display all admins
			 */

			else if (cid != null && column.contentEquals("price") && type.equals("asc")) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_FOOD_BY_PRICE_ASC));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cid);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, sliderValue);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, thisRecords);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, recordsPerPage);
			}

			else if (cid != null && column.equals("price") && type.equals("desc")) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_FOOD_BY_PRICE_DESC));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cid);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, sliderValue);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, thisRecords);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, recordsPerPage);
			}

			else if (cid != null && column.equals("portion") && type.equals("asc")) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_FOOD_BY_PORTION_ASC));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cid);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, sliderValue);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, thisRecords);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, recordsPerPage);
			}

			else if (cid != null && column.equals("portion") && type.equals("desc")) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_FOOD_BY_PORTION_DESC));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cid);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, sliderValue);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, thisRecords);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, recordsPerPage);

			}

			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_FOOD_LIMIT));
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, thisRecords);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, recordsPerPage);

			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				FoodItem fooditem = new FoodItem();
				fooditem.setItemID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				fooditem.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				fooditem.setDescription(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				fooditem.setPortion(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				fooditem.setPrice(resultSet.getDouble(CommonConstants.COLUMN_INDEX_FIVE));
				fooditem.setCatergoryID(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				Blob blob = resultSet.getBlob(CommonConstants.COLUMN_INDEX_SEVEN);
				fooditem.setTax(resultSet.getDouble(CommonConstants.COLUMN_INDEX_EIGHT));
				fooditem.setActive(resultSet.getBoolean(CommonConstants.COLUMN_INDEX_NINE));

				System.out.println(fooditem.getPortion());

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();

				fooditem.setImage(base64Image);

				FoodList.add(fooditem);
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
		return FoodList;
	}

	@Override
	public int noOfFoodItems(String cid, int sliderValue) {

		int no = 0;
		try {
			connection = DBConnectionUtil.getDBConnection();

			if (cid != null) {
				/*
				 * Get admin by ID query will be retrieved from VSFM.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_NO_FOOD_CATEGORY));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cid);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, sliderValue);

			}

			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_NO_FOOD));
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, sliderValue);
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				no = resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE);
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
		return no;
	}

	@Override
	public boolean deleteFoodItem(String fid) {
		
		boolean rs = false;
		/*
		 * Remove admin query will be retrieved from VSFM.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_FOOD));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, fid);
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
	public boolean updateFoodItem(FoodItem foodItem, Part image) {
		boolean result = false;
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			if(image != null) {
				InputStream inputStream = image.getInputStream();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_FOOD_WITH_IMAGE));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, foodItem.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, foodItem.getDescription());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, foodItem.getPortion());
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_FOUR, foodItem.getPrice());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, foodItem.getCatergoryID());
				preparedStatement.setBlob(CommonConstants.COLUMN_INDEX_SIX, inputStream);
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SEVEN, foodItem.getTax());
				preparedStatement.setBoolean(CommonConstants.COLUMN_INDEX_EIGHT,foodItem.isActive());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,foodItem.getItemID());
				
			}
			
			else if(image == null) {
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_FOOD));
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, foodItem.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, foodItem.getDescription());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, foodItem.getPortion());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_FOUR, foodItem.getPrice());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, foodItem.getCatergoryID());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SIX, foodItem.getTax());
			preparedStatement.setBoolean(CommonConstants.COLUMN_INDEX_SEVEN,foodItem.isActive());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT,foodItem.getItemID());
			}
			
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
