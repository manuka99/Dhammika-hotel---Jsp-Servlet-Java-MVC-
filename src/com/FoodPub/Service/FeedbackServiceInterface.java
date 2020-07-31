package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Model.FeedBackDB;

public interface FeedbackServiceInterface {

	public static final Logger log = Logger.getLogger(FeedbackServiceInterface.class.getName());

	public ArrayList<FeedBackDB> retreiveFeedBacks(String feedbackID, String itemID, String userID);

	public boolean deleteFeedBack(String feedbackID, String userID);

	public boolean updateFeedBack(FeedBackDB feedback);

	public boolean insertFeedBack(FeedBackDB feedback);

}
