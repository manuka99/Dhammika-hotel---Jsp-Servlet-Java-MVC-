package com.FoodPub.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.Part;

import com.FoodPub.Model.InquiryDB;

public interface InquiryDBDaoInterface {
	
	public static final Logger log = Logger.getLogger(InquiryDBDaoInterface.class.getName());
	
	public ArrayList<InquiryDB> RetreiveInquiry(String inquiryID, String userID) ;
	public boolean deleteInquiry(String inquiryID);
	public boolean insertInquiry(InquiryDB inquiry,List<Part> parts);

}
