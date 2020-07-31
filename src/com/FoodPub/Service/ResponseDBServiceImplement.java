package com.FoodPub.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Dao.ResponseDBDaoImplement;
import com.FoodPub.Dao.ResponseDBDaoInterface;
import com.FoodPub.Model.ContactUs;
import com.FoodPub.Model.Notification_User;
import com.FoodPub.Model.Response_CNT;
import com.FoodPub.Util.UniqueIdGenerator;

public class ResponseDBServiceImplement implements ResponseDBServiceInterface {

	private ResponseDBDaoInterface RDI = new ResponseDBDaoImplement();
	private EmailServiceInterface ESI = new EmailService();
	private ContactUsServiceInterface CUSI = new ContactUsServiceImplement();
	private UserServiceInterface MSI = new UserServiceImplement();
	private Notification_UsersServiceInterface NUSI = new Notification_UsersServiceImplement();

	public static final Logger log = Logger.getLogger(ResponseDBServiceImplement.class.getName());

	@Override
	public ArrayList<Response_CNT> RetreiveResponses(String responseID, String contactUsID) {

		ArrayList<Response_CNT> responsesList = RDI.RetreiveResponses(responseID, contactUsID);

		for (Response_CNT responseDB : responsesList) {

			responseDB.setUser(MSI.retrieveUsersBasedOnRole(responseDB.getUser().getUserID(), null).get(0));

		}

		return responsesList;
	}

	@Override
	public boolean deleteResponse(String responseID) {
		return RDI.deleteResponse(responseID);
	}

	@Override
	public boolean insertResponse(Response_CNT response) {

		boolean result = false;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		response.setTime(dtf.format(now));
		response.setResponseID(UniqueIdGenerator.userIDGenerator("Res"));
		ContactUs contactUs = CUSI.retreiveContactUs(response.getContactUsID()).get(0);

		if (contactUs != null) {
			ESI.contactUsEmail(response, contactUs);
			result = RDI.insertResponse(response);
		}
		
		if (result) {
			Notification_User notification = new Notification_User();
			notification.setType("ContactUs");
			notification.setHeader("Responded to contactUs");
			notification.setCustomID(response.getContactUsID());
			notification.setBody(response.getUser().getUserID() + " responded to the contactus with id " + response.getContactUsID() + " ...!" );
			NUSI.insertNotification_Users(notification);
		}

		return result;
	}

}
