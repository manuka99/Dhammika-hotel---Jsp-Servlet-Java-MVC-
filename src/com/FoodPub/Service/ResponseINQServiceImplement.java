package com.FoodPub.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.Part;

import org.ocpsoft.prettytime.PrettyTime;

import com.FoodPub.Dao.ResponseINQDaoImplement;
import com.FoodPub.Dao.ResponseINQDaoInterface;
import com.FoodPub.Model.InquiryDB;
import com.FoodPub.Model.Notification_User;
import com.FoodPub.Model.ResponseINQ;
import com.FoodPub.Util.UniqueIdGenerator;

public class ResponseINQServiceImplement implements ResponseINQServiceInterface {

	private UserServiceInterface MSI = new UserServiceImplement();
	private ResponseINQDaoInterface RINQ = new ResponseINQDaoImplement();
	private Notification_UsersServiceInterface NUSI = new Notification_UsersServiceImplement();

	public static final Logger log = Logger.getLogger(ResponseINQServiceImplement.class.getName());

	@Override
	public ArrayList<ResponseINQ> RetreiveResponse(String responseID, String inquiryID, String time) {
		ArrayList<ResponseINQ> responseList = RINQ.RetreiveResponse(responseID, inquiryID, time);
		for (ResponseINQ responseINQ : responseList) {
			
			try {
				PrettyTime p = new PrettyTime();
				String input = responseINQ.getTime();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = format.parse(input);
				responseINQ.setPreetyTime(p.format(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			responseINQ.setUser(MSI.retriveUsers(responseINQ.getUser().getUserID()));

		}

		return responseList;
	}

	@Override
	public boolean deleteResponse(String responseID) {
		// TODO Auto-generated method stub
		return RINQ.deleteResponse(responseID);
	}

	@Override
	public boolean insertResponse(ResponseINQ response, List<Part> parts) {
		response.setResponseID(UniqueIdGenerator.userIDGenerator("resINq"));

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		response.setTime(dtf.format(now));

		InquiryDBServiceInterface ISI = new InquiryDBServiceImplement();

		boolean result = RINQ.insertResponse(response, parts);

		if (result) {
			Notification_User notification = new Notification_User();
			notification.setType("Inquiry");
			notification.setCustomID(response.getInquiryID());

			ArrayList<InquiryDB> inquiries = ISI.RetreiveInquiry(response.getInquiryID(), null, "");

			if (inquiries != null) {
				notification.setMemberSenderID(inquiries.get(0).getUser().getUserID());
				notification.setCustomID2(inquiries.get(0).getUser().getUserID());

				if (inquiries.get(0).getUser().getUserID().equals(response.getUser().getUserID())) {

					notification.setHeaderMember("Your Response was placed successfully");
					notification.setBodyMember("Thank you " + inquiries.get(0).getUser().getName()
							+ " for responding to the inquiry you placed. Our team will respond to you immediately.");

					notification.setHeader("Response - Inquiry #" + inquiries.get(0).getInquiryID() + " (User Responded)");
					notification.setBody(response.getUser().getName() + " responded to inquiry which "
							+ inquiries.get(0).getUser().getName() + " placed on " + inquiries.get(0).getTime() + ".");

				}
				
				else {

					notification.setHeaderMember("There is Response to the complain you placed");
					notification.setBodyMember(
							inquiries.get(0).getUser().getName()+ " write back to us our team is waiting for your response. Thank you.");

					notification.setHeader("Response - Inquiry #" + inquiries.get(0).getInquiryID());
					notification.setBody(response.getUser().getName() + " responded to inquiry which "
							+ inquiries.get(0).getUser().getName() + " placed on " + inquiries.get(0).getTime() + ".");

				}

			}

			NUSI.insertNotification_Users(notification);
		}

		return result;
	}

}
