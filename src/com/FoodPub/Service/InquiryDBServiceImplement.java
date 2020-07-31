package com.FoodPub.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.Part;

import com.FoodPub.Dao.InquiryDBDaoImplement;
import com.FoodPub.Dao.InquiryDBDaoInterface;
import com.FoodPub.Model.InquiryDB;
import com.FoodPub.Model.Notification_User;
import com.FoodPub.Model.User;
import com.FoodPub.Util.UniqueIdGenerator;

public class InquiryDBServiceImplement implements InquiryDBServiceInterface {

	private InquiryDBDaoInterface IQDI = new InquiryDBDaoImplement();
	private UserServiceInterface MSI = new UserServiceImplement();
	private ResponseINQServiceInterface RQNQSI = new ResponseINQServiceImplement();
	private Notification_UsersServiceInterface NUSI = new Notification_UsersServiceImplement();

	public static final Logger log = Logger.getLogger(InquiryDBServiceImplement.class.getName());

	@Override
	public ArrayList<InquiryDB> RetreiveInquiry(String inquiryID, String userID, String time) {

		ArrayList<InquiryDB> inquiries = IQDI.RetreiveInquiry(inquiryID, userID);

		if (inquiryID != null && inquiries != null) {
			for (InquiryDB inquiryDB : inquiries) {

				User user = MSI.retriveUsers(inquiryDB.getUser().getUserID());
				inquiryDB.setUser(user);

			}

			for (InquiryDB inquiryDB : inquiries) {

				inquiryDB.setResponses(RQNQSI.RetreiveResponse(null, inquiryDB.getInquiryID() , time));

			}
		}

		return inquiries;
	}

	@Override
	public boolean deleteInquiry(String inquiryID) {

		return IQDI.deleteInquiry(inquiryID);
	}

	@Override
	public boolean insertInquiry(InquiryDB inquiry, List<Part> parts) {

		inquiry.setInquiryID(UniqueIdGenerator.userIDGenerator("inq"));

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		inquiry.setTime(dtf.format(now));

		boolean result = IQDI.insertInquiry(inquiry, parts);

		if (result) {
			Notification_User notification = new Notification_User();
			notification.setType("Inquiry");
			notification.setHeader("New User Complain");
			notification.setBody(inquiry.getUser().getName() + "(" + inquiry.getUser().getUserID() + ")" + " have placed a complain please reply to it immediately.");

			notification.setCustomID(inquiry.getInquiryID());

			notification.setMemberSenderID(inquiry.getUser().getUserID());
			notification.setHeaderMember("Your complain was placed successfully");
			notification.setBodyMember(
					"Our intention is to provide our users a efficient service. Our team will assist you as soon as posible.");

			NUSI.insertNotification_Users(notification);
		}

		return result;
	}

}
