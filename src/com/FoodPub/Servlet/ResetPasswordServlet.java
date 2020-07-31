package com.FoodPub.Servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.FoodPub.Util.EmailUtility;
 
/**
 * A Java Servlet to handle requests to reset password for customer
 *
 * @author www.codejava.net
 *
 */
@WebServlet("/reset_password")
public class ResetPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    private String host;
    private String port;
    private String email;
    private String name;
    private String pass;
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        email = context.getInitParameter("email");
        name = context.getInitParameter("name");
        pass = context.getInitParameter("pass");
    }
 
    public ResetPasswordServlet() {
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String page = "reset_password.jsp";
        request.getRequestDispatcher(page).forward(request, response);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String recipient = "manukamad@gmail.com";
        String subject = "Your Password has been reset";
 
        String content = "<table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:#f3f3f3\">\r\n" + 
        		"			\r\n" + 
        		"<tbody><tr>\r\n" + 
        		"	<td align=\"left\" colspan=\"3\" height=\"14\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"1\" height=\"1\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n" + 
        		"</tr>\r\n" + 
        		"<tr>\r\n" + 
        		"	<td align=\"left\" width=\"14\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"14\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n" + 
        		"	<td align=\"left\" width=\"572\">\r\n" + 
        		"		<table width=\"572\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n" + 
        		"			<tbody><tr>\r\n" + 
        		"				<td align=\"left\" height=\"75\" style=\"background:#3d3d3d\"><img src=\"https://ci5.googleusercontent.com/proxy/X-WnXcDEqOL1Cc6h5NKV9qgXCvsLm4Enj-vEVyWp_7nLU4dUqrVx8O9CrkkVaqQrVzlmlnqSWSsDUVqZ=s0-d-e1-ft#http://www.mcdelivery.lk/edm//logo_en.png\" height=\"75\" style=\"display:block;border:none\" alt=\"McDelivery™\" class=\"CToWUd\"></td>\r\n" + 
        		"				<td height=\"75\" width=\"572\" style=\"background:#3d3d3d;color:#ffffff;font-family:Helvetica,Arial,sans-serif;font-size:22px;font-weight:bold;padding:0 20px\">You are now registered with McDelivery™</td>\r\n" + 
        		"			</tr>\r\n" + 
        		"			<tr>\r\n" + 
        		"				<td align=\"left\" colspan=\"2\">\r\n" + 
        		"					<table width=\"572\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n" + 
        		"						<tbody><tr>\r\n" + 
        		"							<td width=\"25\" align=\"left\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"25\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n" + 
        		"							<td width=\"522\" align=\"left\">\r\n" + 
        		"								<table width=\"522\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n" + 
        		"									<tbody><tr>\r\n" + 
        		"										<td height=\"40\" align=\"left\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"40\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n" + 
        		"									</tr>\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td style=\"color:#000001;font-size:20px;font-family:Helvetica,Arial,sans-serif\">Dear  manuka yasas,<br>Welcome to McDelivery™! </td>\r\n" + 
        		"									</tr>\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td align=\"left\" height=\"15\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"15\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n" + 
        		"									</tr>\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td style=\"color:#000001;font-size:14px;font-family:Helvetica,Arial,sans-serif;line-height:20px\">\r\n" + 
        		"											Thanks for signing up with us. Here are just some of the benefits you'll enjoy as a registered user:<br><br>\r\n" + 
        		"											1. Special deals and promotions, delivered straight to your mailbox.<br>2. A faster, easier checkout experience.<br>3. Quick re-order of your favorite items.<br><br>\r\n" + 
        		"											Your username is: <a href=\"mailto:manukayasas94@gmail.com\" target=\"_blank\">manukayasas94@gmail.com</a> <br>\r\n" + 
        		"											Activation Code: 1775be1386998b6b829bc0ec4b1a26<wbr>c4 										</td>\r\n" + 
        		"									</tr>\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td align=\"left\" height=\"30\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"30\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n" + 
        		"									</tr>\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td height=\"25\"><a style=\"font-size:14px;font-family:Helvetica,Arial,sans-serif\" href=\"https://www.mcdelivery.lk/lk/registerActivate.html?u1=znahxnlnfnf94&amp;u2=tznvy.pbz&amp;activationCode=1775be1386998b6b829bc0ec4b1a26c4\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/registerActivate.html?u1%3Dznahxnlnfnf94%26u2%3Dtznvy.pbz%26activationCode%3D1775be1386998b6b829bc0ec4b1a26c4&amp;source=gmail&amp;ust=1590762581236000&amp;usg=AFQjCNEzSYZgypg-urz9rTzx7O4GQxV5uA\"><img src=\"https://ci6.googleusercontent.com/proxy/qVVqfNhabN3MvSFiW65IipTRfAeKsi2i9tGJT2u1ayRb8HXx4_pimrFKYLQCZggxEiOYJ_RaLmGUQye5vg-NsdAqaOjaWT3eSJ4A1A=s0-d-e1-ft#http://www.mcdelivery.lk/edm//btn-activate-account_en.png\" style=\"display:block;border:none\" alt=\"Activate your account and start ordering\" class=\"CToWUd\"></a></td>\r\n" + 
        		"									</tr>\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td align=\"left\" height=\"20\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"20\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n" + 
        		"									</tr>\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td style=\"color:#000001;font-size:14px;font-family:Helvetica,Arial,sans-serif;line-height:20px\">\r\n" + 
        		"											Regards,<br>The McDelivery™ team.										</td>\r\n" + 
        		"									</tr>\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td align=\"left\" height=\"25\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"25\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n" + 
        		"									</tr>\r\n" + 
        		"									<tr style=\"vertical-align:top\">\r\n" + 
        		"										<td style=\"padding:25px 0 0 0;border-top:1px dashed #a2a1a1\">\r\n" + 
        		"																																			<img src=\"https://ci6.googleusercontent.com/proxy/znW1j6DCtMOWS6xGdzidKW96NjxNVwtSYlfuG4UnDquTZ-OBdfO0v1rFzU-F0VLGpRXc5XFJ_59OWiNz3Pg=s0-d-e1-ft#http://www.mcdelivery.lk/edm//banner_en.png\" width=\"522\" height=\"159\" style=\"display:block;border:none\" alt=\"McDelivery Promotions\" class=\"CToWUd a6T\" tabindex=\"0\"><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 514px; top: 698.4px;\"><div id=\":p5\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\" role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"><div class=\"aSK J-J5-Ji aYr\"></div></div></div>\r\n" + 
        		"																																	</td>\r\n" + 
        		"									</tr>\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td align=\"left\" height=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n" + 
        		"									</tr>\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td style=\"font-family:Helvetica,Arial,sans-serif;font-size:10px;color:#000001;font-family:Helvetica,Arial,sans-serif\">This is a system-generated email. Please do not reply.</td>\r\n" + 
        		"									</tr>\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td align=\"left\" height=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n" + 
        		"									</tr>\r\n" + 
        		"								</tbody></table>\r\n" + 
        		"							</td>\r\n" + 
        		"							<td width=\"25\" align=\"left\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"25\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n" + 
        		"						</tr>\r\n" + 
        		"					</tbody></table>\r\n" + 
        		"				</td>\r\n" + 
        		"			</tr>\r\n" + 
        		"		</tbody></table>\r\n" + 
        		"	</td>\r\n" + 
        		"	<td align=\"left\" width=\"14\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"14\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n" + 
        		"</tr>						<tr><td colspan=\"3\" style=\"background-color:#3d3d3d\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"600\"><tbody><tr><td colspan=\"5\" height=\"20\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"20\" style=\"display:block;border:none\" class=\"CToWUd\"></td></tr><tr><td width=\"40\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"40\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td width=\"358\" style=\"font-size:10px;color:#ffffff;font-family:Helvetica,Arial,sans-serif\"><a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/support-tnc.html\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/support-tnc.html&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNENG9g_yKqg38CM_YWKzQ_jdVne_A\">Terms &amp; Conditions</a> |  <a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/support-privacy.html\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/support-privacy.html&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNHPCYLW5VwvZ0iLQnOLlj0pthaWow\">Privacy Policy</a> |  <a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/support-faq.html\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/support-faq.html&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNF2Gp8wagikOYfGZXHIR3snQSNmyw\">FAQ</a> |  <a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/assets/94/mcdelivery_menu_94.pdf\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/assets/94/mcdelivery_menu_94.pdf&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNFt_c-cA4-zCiTrTqThMBtlgEXvbw\">Download Our Menu</a> |  <a style=\"color:#ffffff;text-decoration:none\" href=\"https://www.mcdelivery.lk/lk/changeSkin.html?skin=mobile\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.mcdelivery.lk/lk/changeSkin.html?skin%3Dmobile&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNGAUA0gvanE9EX7XQwW-uKgBcVtWA\">Mobile Web</a></td><td width=\"40\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"40\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td width=\"122\" style=\"font-size:10px;color:#ffffff;font-family:Helvetica,Arial,sans-serif\">Follow Us<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"122\"><tbody><tr><td><a style=\"text-decoration:none\" href=\"https://www.facebook.com/mcdsrilanka/?fref=ts\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.facebook.com/mcdsrilanka/?fref%3Dts&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNFzFJ0ZYzWRdpqTQ3GbOEoj609qFg\"><img src=\"https://ci4.googleusercontent.com/proxy/BB-QLl-j9T17jfxNIXZ7FH9Ekb3CPa_QMl1JILAZ_Q2ObQRWVG8cvL0oI0k8W_mywuDI8hxSdCqw6y-n=s0-d-e1-ft#http://www.mcdelivery.lk/edm//icon-fb.png\" width=\"23\" height=\"24\" style=\"display:block;border:none\" class=\"CToWUd\"></a></td><td width=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td><a style=\"text-decoration:none\" href=\"https://lk.rateurvisit.com/\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://lk.rateurvisit.com/&amp;source=gmail&amp;ust=1590762581237000&amp;usg=AFQjCNHO6OEJyh0zcDAc70Ol4id1zCLo5w\"><img src=\"https://ci4.googleusercontent.com/proxy/BB-QLl-j9T17jfxNIXZ7FH9Ekb3CPa_QMl1JILAZ_Q2ObQRWVG8cvL0oI0k8W_mywuDI8hxSdCqw6y-n=s0-d-e1-ft#http://www.mcdelivery.lk/edm//icon-fb.png\" width=\"23\" height=\"24\" style=\"display:block;border:none\" class=\"CToWUd\"></a></td><td width=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td><img width=\"23\" height=\"24\" style=\"display:block;border:none\" src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" class=\"CToWUd\"></td><td width=\"10\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"10\" style=\"display:block;border:none\" class=\"CToWUd\"></td><td><img width=\"23\" height=\"24\" style=\"display:block;border:none\" src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" class=\"CToWUd\"></td></tr></tbody></table></td><td width=\"40\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" width=\"40\" style=\"display:block;border:none\" class=\"CToWUd\"></td></tr><tr><td colspan=\"5\" height=\"20\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"20\" style=\"display:block;border:none\" class=\"CToWUd\"></td></tr></tbody></table></td></tr>\r\n" + 
        		"						\r\n" + 
        		"			<tr>\r\n" + 
        		"				<td colspan=\"3\" height=\"15\" style=\"background-color:#ffffff\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"15\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n" + 
        		"			</tr>\r\n" + 
        		"			<tr>\r\n" + 
        		"				<td colspan=\"3\" style=\"font-family:Helvetica,Arial,sans-serif;font-size:12px;color:#000001;text-align:center;background:#ffffff;text-transform:uppercase\">Copyright © 2014 All Rights Reserved By McDonald's™<br>The Golden Arches Logo and \"i'm lovin' it\" are trademarks of <br>McDonald's Corporation and its affiliates.</td>\r\n" + 
        		"			</tr>\r\n" + 
        		"			<tr>\r\n" + 
        		"				<td colspan=\"3\" height=\"15\" style=\"background-color:#ffffff\"><img src=\"https://ci3.googleusercontent.com/proxy/eScrmdj2C4o6szNyYymD0s8PUibydx5HL5noQJWQKCbqV2rxA88Ry7YZ88yrc0Q2z4OOAtdJgXfxltE=s0-d-e1-ft#http://www.mcdelivery.lk/edm//spacer.gif\" height=\"15\" style=\"display:block;border:none\" class=\"CToWUd\"></td>\r\n" + 
        		"			</tr>\r\n" + 
        		"		</tbody></table>";
 
        String message = "";
        try {
            EmailUtility.sendEmail(host, port, email, name, pass,
                    recipient, subject, content);
            message = "Your password has been reset. Please check your e-mail.";
        } catch (Exception ex) {
        	System.out.println("errrororororor");
            ex.printStackTrace();
            message = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("message", message);
            request.getRequestDispatcher("message.jsp").forward(request, response);
        }
    }
 
}