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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.Part;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.FoodPub.Model.ResponseINQ;
import com.FoodPub.Model.User;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class ResponseINQDaoImplement implements ResponseINQDaoInterface {
	private static Connection connection;

	private PreparedStatement preparedStatement;

	public static final Logger log = Logger.getLogger(ResponseINQDaoImplement.class.getName());

	@Override
	public ArrayList<ResponseINQ> RetreiveResponse(String responseID, String inquiryID , String time) {

		ArrayList<ResponseINQ> ResponseList = new ArrayList<>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			if (responseID != null && inquiryID == null) {
				preparedStatement = connection.prepareStatement(
						QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_RESPONDINQ_BY_RESPONSEID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, responseID);
			}

			else if (responseID == null && inquiryID != null) {
				preparedStatement = connection.prepareStatement(
						QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_RESPONDINQ_BY_INQUIRYID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, inquiryID);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, time);
			}

			else
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_ALL_RESPONDINQ));

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ResponseINQ response = new ResponseINQ();
				User user = new User();
				List<String> images = new ArrayList<>();

				response.setResponseID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				response.setInquiryID(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				user.setUserID(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				response.setMessage(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				response.setTime(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));

				List<Blob> blobImages = new ArrayList<>();

				blobImages.add(resultSet.getBlob(CommonConstants.COLUMN_INDEX_SIX));
				blobImages.add(resultSet.getBlob(CommonConstants.COLUMN_INDEX_SEVEN));
				blobImages.add(resultSet.getBlob(CommonConstants.COLUMN_INDEX_EIGHT));

				for (Blob blob : blobImages) {

					if (blob != null) {

						InputStream inputStream = blob.getBinaryStream();

						ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
						byte[] buffer = new byte[4096];
						int bytesRead = -1;

						while ((bytesRead = inputStream.read(buffer)) != -1) {
							outputStream.write(buffer, 0, bytesRead);
						}

						byte[] imageBytes = outputStream.toByteArray();
						String base64Image = Base64.getEncoder().encodeToString(imageBytes);
						images.add(base64Image);
						inputStream.close();
						outputStream.close();

					}

				}

				response.setUser(user);
				response.setImages(images);
				ResponseList.add(response);
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
		return ResponseList;
	}

	@Override
	public boolean deleteResponse(String responseID) {
		boolean rs = false;
		/*
		 * Remove admin query will be retrieved from VSFM.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_RESPONDINQ));
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
	public boolean insertResponse(ResponseINQ response, List<Part> parts) {

		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_RESPONDINQ));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, response.getResponseID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, response.getInquiryID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, response.getUser().getUserID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, response.getMessage());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, response.getTime());

			int j = 6;

			for (Part part : parts) {

				if (part != null) {

					InputStream inputStream = part.getInputStream();
					preparedStatement.setBlob(j, inputStream);

				} else
					preparedStatement.setNull(j, java.sql.Types.BLOB);

				j++;

			}
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
}
