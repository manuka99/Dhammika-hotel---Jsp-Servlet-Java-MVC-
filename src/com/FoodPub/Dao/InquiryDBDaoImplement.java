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

import com.FoodPub.Model.InquiryDB;
import com.FoodPub.Model.User;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.DBConnectionUtil;
import com.FoodPub.Util.QueryUtil;

public class InquiryDBDaoImplement implements InquiryDBDaoInterface {

	private static Connection connection;

	private PreparedStatement preparedStatement;

	public static final Logger log = Logger.getLogger(InquiryDBDaoImplement.class.getName());

	@Override
	public ArrayList<InquiryDB> RetreiveInquiry(String inquiryID, String userID) {

		ArrayList<InquiryDB> inquiryList = new ArrayList<>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			if (inquiryID != null && userID == null) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_INQUIRY_BY_INQUIRYID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, inquiryID);
			}

			else if (inquiryID == null && userID != null) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_INQUIRY_BY_USERID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
				System.out.println("asdasassas");
			}

			else
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RETREIVE_ALL_INQUIRY));

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				InquiryDB inquiry = new InquiryDB();
				User user = new User();
				List<String> images = new ArrayList<>();

				inquiry.setInquiryID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				user.setUserID(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				inquiry.setSubject(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				inquiry.setMessage(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				inquiry.setTime(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));

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

				inquiry.setUser(user);
				inquiry.setImages(images);
				inquiryList.add(inquiry);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException
				| NullPointerException e) {
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
		return inquiryList;
	}

	@Override
	public boolean deleteInquiry(String inquiryID) {
		boolean rs = false;
		/*
		 * Remove admin query will be retrieved from VSFM.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_INQUIRY));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, inquiryID);
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

	public boolean insertInquiry(InquiryDB inquiry, List<Part> parts) {

		boolean rs = false;

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in VSFM.xml file and use insert_admin key to extract value
			 * of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_INQUIRY));
			connection.setAutoCommit(false);

			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, inquiry.getInquiryID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, inquiry.getUser().getUserID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, inquiry.getSubject());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, inquiry.getMessage());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, inquiry.getTime());

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
