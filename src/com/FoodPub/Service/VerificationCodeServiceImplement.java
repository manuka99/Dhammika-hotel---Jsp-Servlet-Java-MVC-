package com.FoodPub.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Logger;

import com.FoodPub.Dao.VerificationCodeDaoImplemention;
import com.FoodPub.Dao.VerificationCodeDaoInterface;
import com.FoodPub.Model.UserVerificationToken;
import com.FoodPub.Util.UniqueIdGenerator;

public class VerificationCodeServiceImplement implements VerificationCodeserviceInterface {

	private VerificationCodeDaoInterface VCDI = new VerificationCodeDaoImplemention();

	public static final Logger log = Logger.getLogger(VerificationCodeServiceImplement.class.getName());

	@Override
	public boolean UserVerificationCodeUpdate(UserVerificationToken UVT) {
		UVT.setExpiryDate(String.valueOf(calculateExpiryDate(60)));
		return VCDI.UserVerificationCodeUpdate(UVT);
	}

	@Override
	public boolean UserVerificationCodeAdd(UserVerificationToken UVT) {
		UVT.setId(UniqueIdGenerator.userIDGenerator("VID"));
		UVT.setExpiryDate(String.valueOf(calculateExpiryDate(60)));		
		
		return VCDI.UserVerificationCodeAdd(UVT);
	}

	@Override
	public UserVerificationToken retriveUserVerificationCode(String userID) {
		return VCDI.retriveUserVerificationCode(userID);
	}

	public Date calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Timestamp(cal.getTime().getTime()));
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}

}
