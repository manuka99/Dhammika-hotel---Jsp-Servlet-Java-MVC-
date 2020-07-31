package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.Part;

import com.FoodPub.Model.InquiryDB;

public interface InquiryDBServiceInterface {
	
	public static final Logger log = Logger.getLogger(InquiryDBServiceInterface.class.getName());
	
	public ArrayList<InquiryDB> RetreiveInquiry(String inquiryID, String userID, String time) ;
	public boolean deleteInquiry(String inquiryID);
	public boolean insertInquiry(InquiryDB inquiry,List<Part> parts);

}
