package com.FoodPub.Dao;

import java.util.List;
import java.util.logging.Logger;

import com.FoodPub.Model.ContactUs;

public interface ContactUsDaoInterface {

	public static final Logger log = Logger.getLogger(ContactUsDaoInterface.class.getName());

	public List<ContactUs> retreiveContactUs(String cid);

	public boolean insertContactUs(ContactUs contactus);

	public boolean deleteContactUs(String id);

}
