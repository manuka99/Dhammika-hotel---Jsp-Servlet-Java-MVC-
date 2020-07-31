package com.FoodPub.Dao;

import java.util.logging.Logger;

import com.FoodPub.Model.UserVerificationToken;


public interface VerificationCodeDaoInterface {

	public static final Logger log = Logger.getLogger(VerificationCodeDaoInterface.class.getName());
	
	public boolean UserVerificationCodeUpdate(UserVerificationToken UVT);
	public boolean UserVerificationCodeAdd(UserVerificationToken UVT);
	public UserVerificationToken retriveUserVerificationCode(String userID);
}
