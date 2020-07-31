package com.FoodPub.Service;

import com.FoodPub.Model.ContactUs;
import com.FoodPub.Model.Email_Java;
import com.FoodPub.Model.OrderDB;
import com.FoodPub.Model.Response_CNT;
import com.FoodPub.Model.User;
import com.FoodPub.Util.CommonConstants;
import com.FoodPub.Util.EmailUtility;
import com.paypal.api.payments.Order;

public class EmailService implements EmailServiceInterface {

	private static String host = CommonConstants.EMAIL_HOST;
	private static String port = CommonConstants.EMAIL_PORT;
	private static String email = CommonConstants.EMAIL_EMAIL;
	private static String name = CommonConstants.EMAIL_NAME;
	private static String pass = CommonConstants.EMAIL_PASSWORD;

	public void userAccountVerification(String code, User user) {

		String subject = "Account Verification";
		String recipient = user.getEmail();
		// http://localhost:8080/ecommerce/UserActivate?UserID=+ +
		// "&ActivationCode="+code+"
		String redirectUrl = "http://manuka-42212.portmap.host:42212/ecommerce/UserActivate?UserID=" + user.getUserID()
				+ "&ActivationCode=" + code;

		String content = "<table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:#f3f3f3\">\r\n"
				+ "			\r\n" + "<tbody><tr>\r\n"
				+ "	<td align=\"left\" colspan=\"3\" height=\"14\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"1\" height=\"1\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "</tr>\r\n" + "<tr>\r\n"
				+ "	<td align=\"left\" width=\"14\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"14\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "	<td align=\"left\" width=\"572\">\r\n"
				+ "		<table width=\"572\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
				+ "			<tbody><tr>\r\n"
				+ "				<td align=\"left\" height=\"75\" style=\"background:#3d3d3d\"><img src=\"https://ci5.googleusercontent.com/proxy/X-WnXcDEqOL1Cc6h5NKV9qgXCvsLm4Enj-vEVyWp_7nLU4dUqrVx8O9CrkkVaqQrVzlmlnqSWSsDUVqZ=s0-d-e1-ft#http://www.mcdelivery.lk/edm//logo_en.png\" height=\"75\" style=\"display:block;border:none\" alt=\"McDelivery™\" class=\"CToWUd\"></td>\r\n"
				+ "				<td height=\"75\" width=\"572\" style=\"background:#3d3d3d;color:#ffffff;font-family:Helvetica,Arial,sans-serif;font-size:22px;font-weight:bold;padding:0 20px\">You are now registered with McDelivery™</td>\r\n"
				+ "			</tr>\r\n" + "			<tr>\r\n" + "				<td align=\"left\" colspan=\"2\">\r\n"
				+ "					<table width=\"572\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
				+ "						<tbody><tr>\r\n"
				+ "							<td width=\"25\" align=\"left\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"25\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "							<td width=\"522\" align=\"left\">\r\n"
				+ "								<table width=\"522\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
				+ "									<tbody><tr>\r\n"
				+ "										<td height=\"40\" align=\"left\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"40\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td style=\"color:#000001;font-size:20px;font-family:Helvetica,Arial,sans-serif\">Dear  manuka yasas,<br>Welcome to McDelivery™! </td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td align=\"left\" height=\"15\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"15\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td style=\"color:#000001;font-size:14px;font-family:Helvetica,Arial,sans-serif;line-height:20px\">\r\n"
				+ "											Thanks for signing up with us. Here are just some of the benefits you'll enjoy as a registered user:<br><br>\r\n"
				+ "											1. Special deals and promotions, delivered straight to your mailbox.<br>2. A faster, easier checkout experience.<br>3. Quick re-order of your favorite items.<br><br>\r\n"
				+ "											Your username is: <a href=\"mailto:manukayasas94@gmail.com\" target=\"_blank\">manukayasas94@gmail.com</a> <br>\r\n"
				+ "											Activation Code: " + code
				+ "<wbr>										</td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td align=\"left\" height=\"30\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"30\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td height=\"25\"><a style=\"font-size:14px;font-family:Helvetica,Arial,sans-serif\" href=\""
				+ redirectUrl + "\" target=\"_blank\" data-saferedirecturl=\"" + redirectUrl
				+ "\"><img src=\"https://ci6.googleusercontent.com/proxy/qVVqfNhabN3MvSFiW65IipTRfAeKsi2i9tGJT2u1ayRb8HXx4_pimrFKYLQCZggxEiOYJ_RaLmGUQye5vg-NsdAqaOjaWT3eSJ4A1A=s0-d-e1-ft#http://www.mcdelivery.lk/edm//btn-activate-account_en.png\" style=\"display:block;border:none\" alt=\"Activate your account and start ordering\" class=\"CToWUd\"></a></td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td align=\"left\" height=\"20\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"20\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td style=\"color:#000001;font-size:14px;font-family:Helvetica,Arial,sans-serif;line-height:20px\">\r\n"
				+ "											Regards,<br>The McDelivery™ team.										</td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td align=\"left\" height=\"25\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"25\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "									</tr>\r\n"
				+ "									<tr style=\"vertical-align:top\">\r\n"
				+ "										<td style=\"padding:25px 0 0 0;border-top:1px dashed #a2a1a1\">\r\n"
				+ "																																			<img src=\"https://ci6.googleusercontent.com/proxy/znW1j6DCtMOWS6xGdzidKW96NjxNVwtSYlfuG4UnDquTZ-OBdfO0v1rFzU-F0VLGpRXc5XFJ_59OWiNz3Pg=s0-d-e1-ft#http://www.mcdelivery.lk/edm//banner_en.png\" width=\"522\" height=\"159\" style=\"display:block;border:none\" alt=\"McDelivery Promotions\" class=\"CToWUd a6T\" tabindex=\"0\"><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 514px; top: 698.4px;\"><div id=\":p5\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\" role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"><div class=\"aSK J-J5-Ji aYr\"></div></div></div>\r\n"
				+ "																																	</td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td align=\"left\" height=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td style=\"font-family:Helvetica,Arial,sans-serif;font-size:10px;color:#000001;font-family:Helvetica,Arial,sans-serif\">This is a system-generated email. Please do not reply.</td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td align=\"left\" height=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "									</tr>\r\n" + "								</tbody></table>\r\n"
				+ "							</td>\r\n"
				+ "							<td width=\"25\" align=\"left\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"25\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "						</tr>\r\n" + "					</tbody></table>\r\n"
				+ "				</td>\r\n" + "			</tr>\r\n" + "		</tbody></table>\r\n" + "	</td>\r\n"
				+ "	<td align=\"left\" width=\"14\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"14\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "</tr>						<tr><td colspan=\"3\" style=\"background-color:#3d3d3d\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"600\"><tbody><tr><td colspan=\"5\" height=\"20\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"20\" style=\"display:block;border:none\" class=\"CToWUd\"></td></tr><tr><td width=\"40\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"40\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td width=\"358\" style=\"font-size:10px;color:#ffffff;font-family:Helvetica,Arial,sans-serif\"><a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/support-tnc.html\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/support-tnc.html&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNENG9g_yKqg38CM_YWKzQ_jdVne_A\">Terms &amp; Conditions</a> |  <a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/support-privacy.html\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/support-privacy.html&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNHPCYLW5VwvZ0iLQnOLlj0pthaWow\">Privacy Policy</a> |  <a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/support-faq.html\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/support-faq.html&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNF2Gp8wagikOYfGZXHIR3snQSNmyw\">FAQ</a> |  <a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/assets/94/mcdelivery_menu_94.pdf\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/assets/94/mcdelivery_menu_94.pdf&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNFt_c-cA4-zCiTrTqThMBtlgEXvbw\">Download Our Menu</a> |  <a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/changeSkin.html?skin=mobile\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/changeSkin.html?skin%3Dmobile&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNGAUA0gvanE9EX7XQwW-uKgBcVtWA\">Mobile Web</a></td><td width=\"40\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"40\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td width=\"122\" style=\"font-size:10px;color:#ffffff;font-family:Helvetica,Arial,sans-serif\">Follow Us<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"122\"><tbody><tr><td><a style=\"text-decoration:none\" href=\"https://www.facebook.com/mcdsrilanka/?fref=ts\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.facebook.com/mcdsrilanka/?fref%3Dts&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNFzFJ0ZYzWRdpqTQ3GbOEoj609qFg\"><img src=\"https://ci4.googleusercontent.com/proxy/BB-QLl-j9T17jfxNIXZ7FH9Ekb3CPa_QMl1JILAZ_Q2ObQRWVG8cvL0oI0k8W_mywuDI8hxSdCqw6y-n=s0-d-e1-ft#http://www.mcdelivery.lk/edm//icon-fb.png\" width=\"23\" height=\"24\" style=\"display:block;border:none\" class=\"CToWUd\"></a></td><td width=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td><a style=\"text-decoration:none\" href=\"https://lk.rateurvisit.com/\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://lk.rateurvisit.com/&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNHO6OEJyh0zcDAc70Ol4id1zCLo5w\"><img src=\"https://ci4.googleusercontent.com/proxy/BB-QLl-j9T17jfxNIXZ7FH9Ekb3CPa_QMl1JILAZ_Q2ObQRWVG8cvL0oI0k8W_mywuDI8hxSdCqw6y-n=s0-d-e1-ft#http://www.mcdelivery.lk/edm//icon-fb.png\" width=\"23\" height=\"24\" style=\"display:block;border:none\" class=\"CToWUd\"></a></td><td width=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td><img width=\"23\" height=\"24\" style=\"display:block;border:none\" src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" class=\"CToWUd\"></td><td width=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td><img width=\"23\" height=\"24\" style=\"display:block;border:none\" src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" class=\"CToWUd\"></td></tr></tbody></table></td><td width=\"40\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"40\" style=\"display:block;border:none\" class=\"CToWUd\"></td></tr><tr><td colspan=\"5\" height=\"20\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"20\" style=\"display:block;border:none\" class=\"CToWUd\"></td></tr></tbody></table></td></tr>\r\n"
				+ "						\r\n" + "			<tr>\r\n"
				+ "				<td colspan=\"3\" height=\"15\" style=\"background-color:#ffffff\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"15\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "			</tr>\r\n" + "			<tr>\r\n"
				+ "				<td colspan=\"3\" style=\"font-family:Helvetica,Arial,sans-serif;font-size:12px;color:#000001;text-align:center;background:#ffffff;text-transform:uppercase\">Copyright © 2014 All Rights Reserved By McDonald's™<br>The Golden Arches Logo and \"i'm lovin' it\" are trademarks of <br>McDonald's Corporation and its affiliates.</td>\r\n"
				+ "			</tr>\r\n" + "			<tr>\r\n"
				+ "				<td colspan=\"3\" height=\"15\" style=\"background-color:#ffffff\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"15\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "			</tr>\r\n" + "		</tbody></table>";
		try {
			EmailUtility.sendEmail(host, port, email, name, pass, recipient, subject, content);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}

	}

	@Override
	public void respondContactUs(Response_CNT response, ContactUs contactUs) {

		String subject = "Response to your request";
		String recipient = contactUs.getEmail();
		String username = contactUs.getName();
		String message = response.getMessage();
		String subjectBody = contactUs.getSubject();

		String content = "\r\n"
				+ "<table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:#f3f3f3\">\r\n"
				+ "			\r\n" + "<tbody><tr>\r\n"
				+ "	<td align=\"left\" colspan=\"3\" height=\"14\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"1\" height=\"1\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "</tr>\r\n" + "<tr>\r\n"
				+ "	<td align=\"left\" width=\"14\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"14\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "	<td align=\"left\" width=\"572\">\r\n"
				+ "		<table width=\"572\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
				+ "			<tbody><tr>\r\n"
				+ "				<td align=\"left\" height=\"75\" style=\"background:#3d3d3d\"><img src=\"https://ci5.googleusercontent.com/proxy/X-WnXcDEqOL1Cc6h5NKV9qgXCvsLm4Enj-vEVyWp_7nLU4dUqrVx8O9CrkkVaqQrVzlmlnqSWSsDUVqZ=s0-d-e1-ft#http://www.mcdelivery.lk/edm//logo_en.png\" height=\"75\" style=\"display:block;border:none\" alt=\"McDelivery™\" class=\"CToWUd\"></td>\r\n"
				+ "				<td height=\"75\" width=\"572\" style=\"background:#3d3d3d;color:#ffffff;font-family:Helvetica,Arial,sans-serif;font-size:22px;font-weight:bold;padding:0 20px\">"
				+ subjectBody + "</td>\r\n" + "			</tr>\r\n" + "			<tr>\r\n"
				+ "				<td align=\"left\" colspan=\"2\">\r\n"
				+ "					<table width=\"572\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
				+ "						<tbody><tr>\r\n"
				+ "							<td width=\"25\" align=\"left\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"25\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "							<td width=\"522\" align=\"left\">\r\n"
				+ "								<table width=\"522\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
				+ "									<tbody><tr>\r\n"
				+ "										<td height=\"40\" align=\"left\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"40\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td style=\"color:#000001;font-size:20px;font-family:Helvetica,Arial,sans-serif\">Dear "
				+ username + " ,<br>Welcome to McDelivery™! </td>\r\n" + "									</tr>\r\n"
				+ "									<tr>\r\n"
				+ "										<td align=\"left\" height=\"15\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"15\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td style=\"color:#000001;font-size:14px;font-family:Helvetica,Arial,sans-serif;line-height:20px\">\r\n"
				+ "											" + message + "</td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td align=\"left\" height=\"30\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"30\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td height=\"25\"><a style=\"font-size:14px;font-family:Helvetica,Arial,sans-serif\" href=\"https://www.mcdelivery.lk/lk/registerActivate.html?u1=znahxnlnfnf94&amp;u2=tznvy.pbz&amp;activationCode=1775be1386998b6b829bc0ec4b1a26c4\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/registerActivate.html?u1%3Dznahxnlnfnf94%26u2%3Dtznvy.pbz%26activationCode%3D1775be1386998b6b829bc0ec4b1a26c4&amp;source=gmail&amp;ust=1590762581236000&amp;usg=AFQjCNEzSYZgypg-urz9rTzx7O4GQxV5uA\"><img src=\"https://ci6.googleusercontent.com/proxy/qVVqfNhabN3MvSFiW65IipTRfAeKsi2i9tGJT2u1ayRb8HXx4_pimrFKYLQCZggxEiOYJ_RaLmGUQye5vg-NsdAqaOjaWT3eSJ4A1A=s0-d-e1-ft#http://www.mcdelivery.lk/edm//btn-activate-account_en.png\" style=\"display:block;border:none\" alt=\"Activate your account and start ordering\" class=\"CToWUd\"></a></td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td align=\"left\" height=\"20\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"20\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td style=\"color:#000001;font-size:14px;font-family:Helvetica,Arial,sans-serif;line-height:20px\">\r\n"
				+ "											Regards,<br>The McDelivery™ team.										</td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td align=\"left\" height=\"25\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"25\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "									</tr>\r\n"
				+ "									<tr style=\"vertical-align:top\">\r\n"
				+ "										<td style=\"padding:25px 0 0 0;border-top:1px dashed #a2a1a1\">\r\n"
				+ "																																			<img src=\"https://ci6.googleusercontent.com/proxy/znW1j6DCtMOWS6xGdzidKW96NjxNVwtSYlfuG4UnDquTZ-OBdfO0v1rFzU-F0VLGpRXc5XFJ_59OWiNz3Pg=s0-d-e1-ft#http://www.mcdelivery.lk/edm//banner_en.png\" width=\"522\" height=\"159\" style=\"display:block;border:none\" alt=\"McDelivery Promotions\" class=\"CToWUd a6T\" tabindex=\"0\"><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 514px; top: 698.4px;\"><div id=\":p5\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\" role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"><div class=\"aSK J-J5-Ji aYr\"></div></div></div>\r\n"
				+ "																																	</td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td align=\"left\" height=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td style=\"font-family:Helvetica,Arial,sans-serif;font-size:10px;color:#000001;font-family:Helvetica,Arial,sans-serif\">This is a system-generated email. Please do not reply.</td>\r\n"
				+ "									</tr>\r\n" + "									<tr>\r\n"
				+ "										<td align=\"left\" height=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "									</tr>\r\n" + "								</tbody></table>\r\n"
				+ "							</td>\r\n"
				+ "							<td width=\"25\" align=\"left\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"25\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "						</tr>\r\n" + "					</tbody></table>\r\n"
				+ "				</td>\r\n" + "			</tr>\r\n" + "		</tbody></table>\r\n" + "	</td>\r\n"
				+ "	<td align=\"left\" width=\"14\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"14\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "</tr>						<tr><td colspan=\"3\" style=\"background-color:#3d3d3d\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"600\"><tbody><tr><td colspan=\"5\" height=\"20\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"20\" style=\"display:block;border:none\" class=\"CToWUd\"></td></tr><tr><td width=\"40\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"40\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td width=\"358\" style=\"font-size:10px;color:#ffffff;font-family:Helvetica,Arial,sans-serif\"><a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/support-tnc.html\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/support-tnc.html&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNENG9g_yKqg38CM_YWKzQ_jdVne_A\">Terms &amp; Conditions</a> |  <a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/support-privacy.html\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/support-privacy.html&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNHPCYLW5VwvZ0iLQnOLlj0pthaWow\">Privacy Policy</a> |  <a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/support-faq.html\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/support-faq.html&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNF2Gp8wagikOYfGZXHIR3snQSNmyw\">FAQ</a> |  <a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/assets/94/mcdelivery_menu_94.pdf\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/assets/94/mcdelivery_menu_94.pdf&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNFt_c-cA4-zCiTrTqThMBtlgEXvbw\">Download Our Menu</a> |  <a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/changeSkin.html?skin=mobile\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/changeSkin.html?skin%3Dmobile&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNGAUA0gvanE9EX7XQwW-uKgBcVtWA\">Mobile Web</a></td><td width=\"40\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"40\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td width=\"122\" style=\"font-size:10px;color:#ffffff;font-family:Helvetica,Arial,sans-serif\">Follow Us<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"122\"><tbody><tr><td><a style=\"text-decoration:none\" href=\"https://www.facebook.com/mcdsrilanka/?fref=ts\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.facebook.com/mcdsrilanka/?fref%3Dts&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNFzFJ0ZYzWRdpqTQ3GbOEoj609qFg\"><img src=\"https://ci4.googleusercontent.com/proxy/BB-QLl-j9T17jfxNIXZ7FH9Ekb3CPa_QMl1JILAZ_Q2ObQRWVG8cvL0oI0k8W_mywuDI8hxSdCqw6y-n=s0-d-e1-ft#http://www.mcdelivery.lk/edm//icon-fb.png\" width=\"23\" height=\"24\" style=\"display:block;border:none\" class=\"CToWUd\"></a></td><td width=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td><a style=\"text-decoration:none\" href=\"https://lk.rateurvisit.com/\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://lk.rateurvisit.com/&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNHO6OEJyh0zcDAc70Ol4id1zCLo5w\"><img src=\"https://ci4.googleusercontent.com/proxy/BB-QLl-j9T17jfxNIXZ7FH9Ekb3CPa_QMl1JILAZ_Q2ObQRWVG8cvL0oI0k8W_mywuDI8hxSdCqw6y-n=s0-d-e1-ft#http://www.mcdelivery.lk/edm//icon-fb.png\" width=\"23\" height=\"24\" style=\"display:block;border:none\" class=\"CToWUd\"></a></td><td width=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td><img width=\"23\" height=\"24\" style=\"display:block;border:none\" src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" class=\"CToWUd\"></td><td width=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td><img width=\"23\" height=\"24\" style=\"display:block;border:none\" src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" class=\"CToWUd\"></td></tr></tbody></table></td><td width=\"40\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"40\" style=\"display:block;border:none\" class=\"CToWUd\"></td></tr><tr><td colspan=\"5\" height=\"20\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"20\" style=\"display:block;border:none\" class=\"CToWUd\"></td></tr></tbody></table></td></tr>\r\n"
				+ "						\r\n" + "			<tr>\r\n"
				+ "				<td colspan=\"3\" height=\"15\" style=\"background-color:#ffffff\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"15\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "			</tr>\r\n" + "			<tr>\r\n"
				+ "				<td colspan=\"3\" style=\"font-family:Helvetica,Arial,sans-serif;font-size:12px;color:#000001;text-align:center;background:#ffffff;text-transform:uppercase\">Copyright © 2014 All Rights Reserved By McDonald's™<br>The Golden Arches Logo and \"i'm lovin' it\" are trademarks of <br>McDonald's Corporation and its affiliates.</td>\r\n"
				+ "			</tr>\r\n" + "			<tr>\r\n"
				+ "				<td colspan=\"3\" height=\"15\" style=\"background-color:#ffffff\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"15\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n"
				+ "			</tr>\r\n" + "		</tbody></table>";
		try {
			EmailUtility.sendEmail(host, port, email, name, pass, recipient, subject, content);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}

	}

	@Override
	public void emailSendOptionOne(Email_Java email_java) {

		String subject = email_java.getSubject();
		String recipient = email_java.getRecipient();
		String content = "<table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"\r\n"
				+ "	style=\"background-color: #f3f3f3\">\r\n" + "\r\n" + "	<tbody>\r\n" + "		<tr>\r\n"
				+ "			<td align=\"left\" colspan=\"3\" height=\"14\"></td>\r\n" + "		</tr>\r\n"
				+ "		<tr>\r\n" + "			<td align=\"left\" width=\"14\"></td>\r\n"
				+ "			<td align=\"left\" width=\"572\">\r\n"
				+ "				<table width=\"572\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
				+ "					<tbody>\r\n" + "						<tr>\r\n"
				+ "							<td align=\"left\" height=\"75\" style=\"background: #3d3d3d\"><img\r\n"
				+ "								src=\"https://ci5.googleusercontent.com/proxy/X-WnXcDEqOL1Cc6h5NKV9qgXCvsLm4Enj-vEVyWp_7nLU4dUqrVx8O9CrkkVaqQrVzlmlnqSWSsDUVqZ=s0-d-e1-ft#http://www.mcdelivery.lk/edm//logo_en.png\"\r\n"
				+ "								height=\"75\" style=\"display: block; border: none\"\r\n"
				+ "								alt=\"McDelivery™\" class=\"CToWUd\"></td>\r\n"
				+ "							<td height=\"75\" width=\"572\"\r\n"
				+ "								style=\"background: #3d3d3d; color: #ffffff; font-family: Helvetica, Arial, sans-serif; font-size: 22px; font-weight: bold; padding: 0 20px\">"
				+ email_java.getHeader() + "</td>\r\n" + "						</tr>\r\n"
				+ "						<tr>\r\n" + "							<td align=\"left\" colspan=\"2\">\r\n"
				+ "								<table width=\"572\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
				+ "									<tbody>\r\n" + "										<tr>\r\n"
				+ "											<td width=\"25\" align=\"left\"></td>\r\n"
				+ "											<td width=\"522\" align=\"left\">\r\n"
				+ "												<table width=\"522\" cellpadding=\"0\" cellspacing=\"0\"\r\n"
				+ "													border=\"0\" >\r\n"
				+ "													<tbody>\r\n"
				+ "														<tr>\r\n"
				+ "															<td height=\"40\" align=\"left\"></td>\r\n"
				+ "														</tr>\r\n"
				+ "														<tr>\r\n"
				+ "															<td\r\n"
				+ "																style=\"color: #000001; font-size: 20px; font-family: Helvetica, Arial, sans-serif\">Dear\r\n"
				+ "																" + email_java.getUserName()
				+ " ,<br>Welcome to Dhammika Hotel™!\r\n"
				+ "															</td>\r\n"
				+ "														</tr>\r\n"
				+ "														<tr>\r\n"
				+ "															<td align=\"left\" height=\"15\"></td>\r\n"
				+ "														</tr>\r\n"
				+ "														<tr>\r\n"
				+ "															<td\r\n"
				+ "																style=\"color: #000001; font-size: 14px; font-family: Helvetica, Arial, sans-serif; line-height: 20px\">\r\n"
				+ "																" + email_java.getPara1() + " <br>\r\n"
				+ "															<br>\r\n"
				+ "															<br>\r\n"
				+ "															\r\n"
				+ "															</td>\r\n"
				+ "														</tr>\r\n"
				+ "														<tr>\r\n"
				+ "														</tr>\r\n"
				+ "														<tr>\r\n"
				+ "														</tr>\r\n"
				+ "														<tr>\r\n"
				+ "															\r\n"
				+ "														</tr>\r\n"
				+ "														<tr>\r\n"
				+ "															<td\r\n"
				+ "																style=\"color: #000001; font-size: 14px; font-family: Helvetica, Arial, sans-serif; line-height: 20px\">\r\n"
				+ "																Regards,<br>The Dhammika Hotel™ team.\r\n"
				+ "															</td>\r\n"
				+ "														</tr>\r\n"
				+ "														<tr>\r\n"
				+ "														</tr>\r\n"
				+ "														<tr style=\"vertical-align: top\">\r\n"
				+ "															<td\r\n"
				+ "																style=\"padding: 25px 0 0 0; border-top: 1px dashed #a2a1a1\">\r\n"
				+ "																<img\r\n"
				+ "																src=\"https://ci6.googleusercontent.com/proxy/znW1j6DCtMOWS6xGdzidKW96NjxNVwtSYlfuG4UnDquTZ-OBdfO0v1rFzU-F0VLGpRXc5XFJ_59OWiNz3Pg=s0-d-e1-ft#http://www.mcdelivery.lk/edm//banner_en.png\"\r\n"
				+ "																width=\"522\" height=\"159\"\r\n"
				+ "																style=\"display: block; border: none\"\r\n"
				+ "																alt=\"McDelivery Promotions\" class=\"CToWUd a6T\"\r\n"
				+ "																tabindex=\"0\">\r\n"
				+ "															<div class=\"a6S\" dir=\"ltr\"\r\n"
				+ "																	style=\"opacity: 0.01; left: 514px; top: 698.4px;\">\r\n"
				+ "																	<div id=\":p5\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"\r\n"
				+ "																		role=\"button\" tabindex=\"0\"\r\n"
				+ "																		aria-label=\"Download attachment \"\r\n"
				+ "																		data-tooltip-class=\"a1V\" data-tooltip=\"Download\">\r\n"
				+ "																		<div class=\"aSK J-J5-Ji aYr\"></div>\r\n"
				+ "																	</div>\r\n"
				+ "																	<br>\r\n"
				+ "																</div>\r\n"
				+ "															</td>\r\n"
				+ "														</tr>\r\n"
				+ "														<tr>\r\n"
				+ "														\r\n"
				+ "														</tr>\r\n"
				+ "														<tr>\r\n"
				+ "															<td\r\n"
				+ "																style=\"font-family: Helvetica, Arial, sans-serif; font-size: 10px; color: #000001; font-family: Helvetica, Arial, sans-serif\">This\r\n"
				+ "																is a system-generated email. Please do not reply.<br><br></td>\r\n"
				+ "														</tr>\r\n"
				+ "														<tr>\r\n"
				+ "															\r\n"
				+ "														</tr>\r\n"
				+ "													</tbody>\r\n"
				+ "												</table>\r\n"
				+ "											</td>\r\n"
				+ "											\r\n" + "										</tr>\r\n"
				+ "									</tbody>\r\n" + "								</table>\r\n"
				+ "							</td>\r\n" + "						</tr>\r\n"
				+ "					</tbody>\r\n" + "				</table>\r\n" + "			</td>\r\n"
				+ "		</tr>\r\n" + "		<tr>\r\n" + "		</tr>\r\n" + "\r\n" + "		<tr>\r\n"
				+ "			\r\n" + "		</tr>\r\n" + "		<tr>\r\n"
				+ "			<td colspan=\"3\" height=\"72px\" style=\"background-color: #3d3d3d; font-family:Helvetica,Arial,sans-serif;font-size:14px;color:white;text-align:center;text-transform:uppercase\">Copyright\r\n"
				+ "				© 2020 All Rights Reserved By Dhammika Hotel™<br>\r\n" + "			</td>\r\n"
				+ "		</tr>\r\n" + "		<tr>\r\n" + "		</tr>\r\n" + "	</tbody>\r\n" + "</table>";

		try {
			EmailUtility.sendEmail(host, port, email, name, pass, recipient, subject, content);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}

	}

	@Override
	public void registrationSuccessEmail(User user) {

		Email_Java email_java2 = new Email_Java();
		email_java2.setHeader("Hi! " + user.getName() + "Welcome to Dhammika Hotel PVT LMT");
		email_java2.setSubject("Dhammika Hotel: Account registered successfully");
		email_java2.setRecipient(user.getEmail());
		email_java2.setUserName(user.getName());
		email_java2.setPara1(
				"Thanks for signing up with us. Here are just some of the benefits you'll enjoy as a registered user: <br><br>"
						+ "1. Special deals and promotions, delivered straight to your mailbox.<br>"
						+ "2. A faster, easier checkout experience.<br>"
						+ "3. Quick re-order of your favorite items.<br>");

		emailSendOptionOne(email_java2);

	}

	@Override
	public void accountActivationEmail(User user, String code) {

		Email_Java email_java2 = new Email_Java();
		email_java2.setHeader("Account verification code");
		email_java2.setSubject("Dhammika Hotel: Account verification code");
		email_java2.setRecipient(user.getEmail());
		email_java2.setUserName(user.getName());
		String url = CommonConstants.APP_URL + "UserActivate?UserID=" + user.getUserID() + "&ActivationCode="
				+ code;
		email_java2.setPara1("" + "<br><br>\r\n"
				+ "																\r\n"
				+ "																<a\r\n"
				+ "																style=\"font-size: 14px; font-family: Helvetica, Arial, sans-serif\"\r\n"
				+ "																href=\"" + url
				+ "\" target=\"_blank\"\r\n"
				+ "																data-saferedirecturl=\"\"><img\r\n"
				+ "																	src=\"https://ci6.googleusercontent.com/proxy/qVVqfNhabN3MvSFiW65IipTRfAeKsi2i9tGJT2u1ayRb8HXx4_pimrFKYLQCZggxEiOYJ_RaLmGUQye5vg-NsdAqaOjaWT3eSJ4A1A=s0-d-e1-ft#http://www.mcdelivery.lk/edm//btn-activate-account_en.png\"\r\n"
				+ "																	style=\"display: block; border: none\"\r\n"
				+ "																	alt=\"Activate your account and start ordering\"\r\n"
				+ "																	class=\"CToWUd\"></a>");
		emailSendOptionOne(email_java2);

	}

	@Override
	public void orderPlacedEmail(User user, OrderDB order) {

		Email_Java email_java2 = new Email_Java();
		email_java2.setHeader("Your order has been placed successfully");
		email_java2.setSubject("Your order has been placed successfully #" + order.getOrderID());
		email_java2.setRecipient(user.getEmail());
		email_java2.setUserName(user.getName());
		email_java2.setPara1("Your order is placed successfully with Order ID: #" + order.getOrderID() + "This order is "
				+ order.getStatus()
				+ "<br><br>To get more details about this order please do <a href='' > login </a> to your account");
		emailSendOptionOne(email_java2);

	}

	@Override
	public void orderStatusEmail(User user, OrderDB order) {

		Email_Java email_java2 = new Email_Java();
		email_java2.setHeader("Your order is " + order.getStatus());
		email_java2.setSubject("Dhammika Hotel: Order " + order.getStatus());
		email_java2.setRecipient(user.getEmail());
		email_java2.setUserName(user.getName());
		email_java2.setPara1("Your order with Order ID: #" + order.getOrderID() + "is " + order.getStatus()
				+ "<br><br>To get more details about this order please do <a href='' > login </a> to your account");
		emailSendOptionOne(email_java2);

	}

	@Override
	public void profileUpdateEmail(User user, String oldEmail) {

		Email_Java email_java = new Email_Java();
		email_java.setHeader("User Profile was updated successfully");
		email_java.setSubject("Dhammika Hotel: User profile updated");
		email_java.setRecipient(user.getEmail());
		email_java.setUserName(user.getName());
		email_java.setPara1(
				"Your User profile details was updated successfully!<br><br>If this was not you please change your password or reply to this so that we will confirm your identity and get your account back");
		emailSendOptionOne(email_java);

		if (oldEmail != null) {

			Email_Java email_java2 = new Email_Java();
			email_java2.setHeader("User Profile email was changed successfully");
			email_java2.setSubject("Dhammika Hotel: Email Changed ");
			email_java2.setRecipient(user.getEmail());
			email_java2.setUserName(user.getName());
			email_java2.setPara1("Your User profile email was changed updated successfully!<br><br>Your new email is "
					+ user.getEmail()
					+ "If this was not you please change your password or reply to this so that we will confirm your identity and get your account back");

			emailSendOptionOne(email_java2);
		}

	}

	@Override
	public void passwordChangedEmail(User user) {

		Email_Java email_java = new Email_Java();
		email_java.setHeader("Password Changed Successfully");
		email_java.setSubject("Dhammika Hotel: Password Changed");
		email_java.setRecipient(user.getEmail());
		email_java.setUserName(user.getName());
		email_java.setPara1(
				"Your password was changed successfully!<br><br>If this was not you please reply to this so that we will confirm your identity and get your account back");
		emailSendOptionOne(email_java);
	}

	@Override
	public void contactUsEmail(Response_CNT response, ContactUs contactUs) {

		Email_Java email_java = new Email_Java();
		email_java.setHeader("Response for your inquiry");
		email_java.setSubject("Response by Dhammika Hotel");
		email_java.setRecipient(contactUs.getEmail());
		email_java.setUserName(contactUs.getName());
		email_java.setPara1("Your inquiry Details:  <br>" + contactUs.getMessage() + "<br><br>Our Response: "
				+ response.getMessage());
		emailSendOptionOne(email_java);

	}

	@Override
	public void passwordRecoveryEmail(User user, String password) {
		Email_Java email_java2 = new Email_Java();
		email_java2.setHeader("User Profile password was recovered successfully");
		email_java2.setSubject("Dhammika Hotel: Password Recovered ");
		email_java2.setRecipient(user.getEmail());
		email_java2.setUserName(user.getName());
		email_java2.setPara1("Your User profile password was recovered successfully !<br><br>Your new password is "
				+ password + "Please change your password after <a href='' > logged </a> in. Thank you.");

		emailSendOptionOne(email_java2);

	}

	@Override
	public void userAddedPanelEmail(User user, String password) {
		Email_Java email_java2 = new Email_Java();
		email_java2.setHeader("Hi " + user.getName() + " to Dhammika Hotel");
		email_java2.setSubject("Dhammika Hotel: Welcome " + user.getName());
		email_java2.setRecipient(user.getEmail());
		email_java2.setUserName(user.getName());
		email_java2.setPara1(
				"You were successfully registered to dhammika hotel by administrator.<br><br>Your login credentials are; <br>1. User email: "
						+ user.getEmail() + "<br>2.User password: " + password
						+ "Please change your password and update your profile after <a href='' > logged </a>  in. Thank you.");

		emailSendOptionOne(email_java2);
	}

}
