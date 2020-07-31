package com.FoodPub.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

import com.FoodPub.Dao.ContactUsDaoImplement;
import com.FoodPub.Dao.ContactUsDaoInterface;
import com.FoodPub.Model.ContactUs;
import com.FoodPub.Model.Notification_User;
import com.FoodPub.Util.UniqueIdGenerator;

public class ContactUsServiceImplement implements ContactUsServiceInterface {

	private ContactUsDaoInterface CUDI = new ContactUsDaoImplement();
	private Notification_UsersServiceInterface NUSI = new Notification_UsersServiceImplement();

	public static final Logger log = Logger.getLogger(ContactUsServiceImplement.class.getName());

	@Override
	public List<ContactUs> retreiveContactUs(String cid) {

		ResponseDBServiceInterface RSI = new ResponseDBServiceImplement();
		List<ContactUs> contactUsList = CUDI.retreiveContactUs(cid);

		if (cid != null && contactUsList != null) {
			for (ContactUs contactUs : contactUsList) {

				contactUs.setResponses(RSI.RetreiveResponses(null, contactUs.getContactUsID()));

			}
		}
		return contactUsList;
	}

	@Override
	public boolean insertContactUs(ContactUs contactus) {
		contactus.setContactUsID(UniqueIdGenerator.userIDGenerator("con"));

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		contactus.setTime(dtf.format(now));

		boolean result = CUDI.insertContactUs(contactus);

		if (result) {
			Notification_User notification = new Notification_User();
			notification.setType("ContactUs");
			notification.setHeader(contactus.getName() + " needs support");
			notification.setCustomID(contactus.getContactUsID());
			notification.setBody(contactus.getName() + " Needs assistence! . Hurry up and assist " + contactus.getName() + "...!" );
			NUSI.insertNotification_Users(notification);
		}
		return result;
	}

	@Override
	public boolean deleteContactUs(String id) {
		return CUDI.deleteContactUs(id);
	}

}
