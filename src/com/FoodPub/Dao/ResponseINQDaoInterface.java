package com.FoodPub.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.Part;

import com.FoodPub.Model.ResponseINQ;


public interface ResponseINQDaoInterface {
	
	public static final Logger log = Logger.getLogger(InquiryDBDaoInterface.class.getName());
	
	public ArrayList<ResponseINQ> RetreiveResponse(String responseID, String inquiryID, String time) ;
	public boolean deleteResponse(String responseID);
	public boolean insertResponse(ResponseINQ response,List<Part> parts);

}
