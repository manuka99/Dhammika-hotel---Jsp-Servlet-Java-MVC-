package com.FoodPub.Service;

import java.util.logging.Logger;

import com.FoodPub.Model.UserVerificationToken;

public interface VerificationCodeserviceInterface {
	
	public static final Logger log = Logger.getLogger(VerificationCodeserviceInterface.class.getName());
	
	public boolean UserVerificationCodeUpdate(UserVerificationToken UVT);
	public boolean UserVerificationCodeAdd(UserVerificationToken UVT);
	public UserVerificationToken retriveUserVerificationCode(String userID);

}
