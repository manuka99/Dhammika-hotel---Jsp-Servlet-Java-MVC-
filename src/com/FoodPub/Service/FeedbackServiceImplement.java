package com.FoodPub.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import org.ocpsoft.prettytime.PrettyTime;

import com.FoodPub.Dao.FeedBackDBDaoImplements;
import com.FoodPub.Dao.FeedBackDBDaoInterface;
import com.FoodPub.Model.FeedBackDB;
import com.FoodPub.Model.Notification_User;
import com.FoodPub.Model.User;
import com.FoodPub.Util.UniqueIdGenerator;

public class FeedbackServiceImplement implements FeedbackServiceInterface {

	private FeedBackDBDaoInterface FDDI = new FeedBackDBDaoImplements();
	private UserServiceInterface MSI = new UserServiceImplement();
	private Notification_UsersServiceInterface NUSI = new Notification_UsersServiceImplement();

	public static final Logger log = Logger.getLogger(FeedbackServiceImplement.class.getName());

	@Override
	public ArrayList<FeedBackDB> retreiveFeedBacks(String feedbackID, String itemID, String userID) {

		ArrayList<FeedBackDB> feedbacks = FDDI.retreiveFeedBacks(feedbackID, itemID, userID);

		if (feedbacks != null && feedbacks.size() > 0) {
			for (FeedBackDB feedBackDB : feedbacks) {

				feedBackDB.setUser(MSI.retriveUsers(feedBackDB.getUserID()));

				try {
					PrettyTime p = new PrettyTime();
					String input = feedBackDB.getTime();
					SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = format.parse(input);
					feedBackDB.setTime(p.format(date));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return feedbacks;

	}

	@Override
	public boolean deleteFeedBack(String feedbackID, String userID) {
		return FDDI.deleteFeedBack(feedbackID, userID);
	}

	@Override
	public boolean updateFeedBack(FeedBackDB feedback) {
		return FDDI.updateFeedBack(feedback);
	}

	@Override
	public boolean insertFeedBack(FeedBackDB feedback) {

		boolean result = false;

		feedback.setFeedbackID(UniqueIdGenerator.userIDGenerator("fb"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		feedback.setTime(dtf.format(now));

		result = FDDI.insertFeedBack(feedback);

		if (result) {

			Notification_User notification = new Notification_User();
			notification.setType("feedback");

			User user = MSI.retriveUsers(feedback.getUserID());

			// for the panel
			notification.setHeader("User has added a feedback");
			notification.setBody(user.getName() + " has added a new feedback, click to view...");

			notification.setCustomID(feedback.getItemID());

			// for the user
			notification.setMemberSenderID(feedback.getUserID());
			notification.setHeaderMember("Your Feedback has been placed successfully");
			notification
					.setBodyMember("Thank you " + user.getName() + " for placing the feedback, hoped you enjoyed it.");

			NUSI.insertNotification_Users(notification);
		}

		return result;
	}

}
