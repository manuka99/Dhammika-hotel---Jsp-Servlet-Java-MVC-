package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Model.ContactUs;
import com.FoodPub.Model.Response_CNT;

public interface ResponseDBServiceInterface {
	
	public static final Logger log = Logger.getLogger(ResponseDBServiceInterface.class.getName());
	
	public ArrayList<Response_CNT> RetreiveResponses(String responseID, String contactUsID) ;
	public boolean deleteResponse(String responseID);
	public boolean insertResponse(Response_CNT response);

}
