package com.FoodPub.Dao;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.FoodPub.Model.Response_CNT;

public interface ResponseDBDaoInterface {
	
	public static final Logger log = Logger.getLogger(ResponseDBDaoInterface.class.getName());
	
	public ArrayList<Response_CNT> RetreiveResponses(String responseID, String contactUsID) ;
	public boolean deleteResponse(String responseID);
	public boolean insertResponse(Response_CNT response);
	

}
