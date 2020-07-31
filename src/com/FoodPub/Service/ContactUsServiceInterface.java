package com.FoodPub.Service;

import java.util.List;
import java.util.logging.Logger;

import com.FoodPub.Model.ContactUs;

public interface ContactUsServiceInterface {

	public static final Logger log = Logger.getLogger(ContactUsServiceInterface.class.getName());

	public List<ContactUs> retreiveContactUs(String cid);

	public boolean insertContactUs(ContactUs contactus);

	public boolean deleteContactUs(String id);
	
}
