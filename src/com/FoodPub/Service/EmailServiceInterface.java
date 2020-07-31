package com.FoodPub.Service;

import java.util.logging.Logger;

import com.FoodPub.Model.ContactUs;
import com.FoodPub.Model.Email_Java;
import com.FoodPub.Model.OrderDB;
import com.FoodPub.Model.Response_CNT;
import com.FoodPub.Model.User;
import com.paypal.api.payments.Order;

public interface EmailServiceInterface {

	public static final Logger log = Logger.getLogger(EmailServiceInterface.class.getName());

	public void userAccountVerification(String code, User user);
	
	public void emailSendOptionOne(Email_Java email_java);

	public void respondContactUs(Response_CNT response, ContactUs contactUs);

	public void registrationSuccessEmail(User user);

	public void accountActivationEmail(User user, String code);

	public void orderPlacedEmail(User user, OrderDB order);

	public void orderStatusEmail(User user, OrderDB order);

	public void profileUpdateEmail(User user, String oldEmail);
	
	public void passwordChangedEmail(User user) ;
	
	public void passwordRecoveryEmail(User user, String password) ;
	
	public void userAddedPanelEmail(User user, String password) ;
	
	public void contactUsEmail(Response_CNT response, ContactUs contactUs) ;
}
