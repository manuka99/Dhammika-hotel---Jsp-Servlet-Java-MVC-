package com.FoodPub.Util;

/**
 * This is the common constants file for CVSFM Java Web project.
 * 
 * @author manuka yasas, SLIIT
 * @version 1.0
 */
public class CommonConstants {

	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for query tag in VSFM.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in VSFM.xml */
	public static final String ATTRIB_ID = "id";

	/** Constant for comma */
	public static final String COMMA = ",";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";
	
	/** Constant for driver name key of MySQL database in config.properties */
	public static final String APP_URL = "http://manuka-42212.portmap.host:42212/ecommerce/";

	/*
	 * query ids for fooditem
	 */

	/** Constant for query id of insert food in VSFM.xml */
	public static final String QUERY_ID_INSERT_FOOD = "insert_food";

	/** Constant for query id of get an machine in VSFM.xml */
	public static final String QUERY_ID_GET_FOOD = "food_by_id";

	/** Constant for query id of get all machines in VSFM.xml */
	public static final String QUERY_ID_ALL_FOOD = "all_food";

	/** Constant for query id of get an machine in VSFM.xml */
	public static final String QUERY_ID_GET_FOOD_BY_CATEGORY = "food_by_cid";

	/** Constant for query id of get an machine in VSFM.xml */
	public static final String QUERY_ID_GET_NO_FOOD = "no_foods";

	/** Constant for query id of get an machine in VSFM.xml */
	public static final String QUERY_ID_GET_NO_FOOD_CATEGORY = "no_foods_category";

	/** Constant for query id of get an machine in VSFM.xml */
	public static final String QUERY_ID_ALL_FOOD_LIMIT = "limit_food";

	/** Constant for query id of get an machine in VSFM.xml */
	public static final String QUERY_ID_ALL_FOOD_LIMIT_BY_CATEGORY = "limit_food_by_Category";

	/** Constant for query id of get an machine in VSFM.xml */
	public static final String QUERY_ID_GET_SEARCH = "food_by_search";

	/** Constant for query id of get an machine in VSFM.xml */
	public static final String QUERY_ID_GET_FOOD_BY_PRICE_ASC = "order_food_by_price_asc";

	/** Constant for query id of get an machine in VSFM.xml */
	public static final String QUERY_ID_GET_FOOD_BY_PRICE_DESC = "order_food_by_price_desc";

	/** Constant for query id of get an machine in VSFM.xml */
	public static final String QUERY_ID_GET_FOOD_BY_PORTION_ASC = "order_food_by_portion_asc";

	/** Constant for query id of get an machine in VSFM.xml */
	public static final String QUERY_ID_GET_FOOD_BY_PORTION_DESC = "order_food_by_portion_desc";
	
	/** Constant for query id of get an machine in VSFM.xml */
	public static final String QUERY_ID_UPDATE_FOOD = "update_foodItem";
	
	/** Constant for query id of get an machine in VSFM.xml */
	public static final String QUERY_ID_UPDATE_FOOD_WITH_IMAGE = "update_foodItem_with_image";

	/** Constant for query id of get an machine in VSFM.xml */
	public static final String QUERY_ID_DELETE_FOOD = "remove_foodItem";

	/*
	 * query ids for Category
	 */

	/** Constant for query id of insert category in VSFM.xml */
	public static final String QUERY_ID_INSERT_CATEGORY = "insert_category";

	/** Constant for query id of get all category in VSFM.xml */
	public static final String QUERY_ID_All_CATEGORY = "all_categorys";

	/** Constant for query id of get an bill in VSFM.xml */
	public static final String QUERY_ID_GET_CATEGORY = "category_by_id";

	/** Constant for query id of remove a bill in VSFM.xml */
	public static final String QUERY_ID_REMOVE_CATEGORY = "delete_category";

	/** Constant for query id of get all bill ids in EmployeeQuery.xml */
	public static final String QUERY_ID_UPDATE_CATEGORY = "update_category";

	/*
	 * query ids for payments
	 */

	/** Constant for query id of insert payment in VSFM.xml */
	public static final String QUERY_ID_INSERT_PAYMENT = "insert_payment";

	/** Constant for query id of get all payments in VSFM.xml */
	public static final String QUERY_ID_All_PAYMENTS = "all_payments";

	/** Constant for query id of get an payment in VSFM.xml */
	public static final String QUERY_ID_GET_PAYMENT = "payment_by_id";

	/** Constant for query id of remove a payment in VSFM.xml */
	public static final String QUERY_ID_REMOVE_PAYMENT = "remove_payment";

	/*
	 * queries for fuels
	 */

	/** Constant for query id of get all fuel in VSFM.xml */
	public static final String QUERY_ID_All_FUELS = "all_fuels";

	/** Constant for query id of get an fuel in VSFM.xml */
	public static final String QUERY_ID_GET_FUEL = "fuel_by_id";

	/** Constant for query id of update a fuel in VSFM.xml */
	public static final String QUERY_ID_UPDATE_FUEL = "update_fuel";

	/** Constant for query id of get an fuel by type in VSFM.xml */
	public static final String QUERY_ID_GET_FUEL_TYPE = "fuel_by_type";

	/**
	 * Constant for query id of updating the remain fuel after a successful pump in
	 * VSFM.xml
	 */
	public static final String QUERY_ID_UPDATE_FUEL_REMAIN = "update_fuel_remain";

	/*
	 * query ids for admins
	 */

	/** Constant for query id of insert admin in VSFM.xml */
	public static final String QUERY_ID_INSERT_ADMIN = "insert_admin";

	/** Constant for query id of get an admin in VSFM.xml */
	public static final String QUERY_ID_GET_ADMIN = "admin_by_id";

	/** Constant for query id of get all admin in VSFM.xml */
	public static final String QUERY_ID_ALL_ADMINS = "all_admins";

	/** Constant for query id of remove a admin in VSFM.xml */
	public static final String QUERY_ID_REMOVE_ADMIN = "remove_admin";

	/** Constant for query id of update a admin in VSFM.xml */
	public static final String QUERY_ID_UPDATE_ADMIN = "update_admin";

	/** Constant for query id of check admin in VSFM.xml */
	public static final String QUERY_ID_CHECK_ADMIN = "check_admin";

	/*
	 * query ids for user
	 */

	/** Constant for query id of insert user in VSFM.xml */
	public static final String QUERY_RETRIEVE_USERS_BY_USERID = "user_by_id";
	
	/** Constant for query id of insert user in VSFM.xml */
	public static final String QUERY_ID_DELETE_USER = "delete_user";
	
	/** Constant for query id of insert user in VSFM.xml */
	public static final String QUERY_ID_INSERT_USER = "insert_user";

	/** Constant for query id of insert user in VSFM.xml */
	public static final String QUERY_ID_USER_EMAIL_EXSIST = "exsist_user_email";

	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_VALIDATE_USER_LOGIN = "validate_user_login";

	/** Constant for query id of get all user in VSFM.xml */
	public static final String QUERY_ID_ALL_USERS = "all_users";

	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_CHECK_USER = "check_user";

	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_USER_PASSWORD_UPDATE = "user_Password_update";

	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_USER_PROFILE_UPDATE = "update_user_Profile";
	
	
	

	
	
	
	
	

	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_USER_ORDER_DETAILS = "order_Details_by_user";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_USER_ONE_ORDER_DETAILS = "one_user_order_Details";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_ALL_ORDERS = "all_order_Details";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_INSERT_ORDER= "insert_order_details";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_UPDATE_ORDER = "update_order_details";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_DELETE_ORDER = "remove_order_details";
	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_ORDERED_ITEMS_RETRIEVE = "retrieve_ordered_items";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_ORDERED_ITEMS_INSERT= "insert_orderedItems";
	
	
	
	
	
	
	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_CART_INSERT = "insert_cart";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_CART_UPDATE = "update_cart";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_CART_DETAILS_BY_CARTID = "Cart_Details_by_CartID";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_CART_DETAILS_BY_USERID = "Cart_Details_by_UserID";




	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_CART_ITEM_INSERT = "insert_cart_items";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_CART_ITEM_UPDATE = "update_cart_items";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_CART_ITEM_DELETE = "delete_cart_item";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_CART_ITEM_DETAILS_BY_CARTID = "Cart_items_Details_by_CartID";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_CART_ITEM_PRODUCT_VALIDATE = "Cart_items_product_validate";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_PRODUCT_DELIVERY_FEE = "product_delivery_fee";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_PRODUCT_DELIVERY_FEE = "retrieve_delivery_fee";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_PRODUCT_DELIVERY_FEE_BY_ID = "retrieve_delivery_fee_by_id";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_INSERT_PRODUCT_DELIVERY_FEE = "insert_delivery_fee";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_UPDATE_PRODUCT_DELIVERY_FEE = "update_delivery_fee";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_DELETE_PRODUCT_DELIVERY_FEE = "remove_delivery_fee";
	
	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_ROLE_BY_ROLEID = "role_Details_by_roleID";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_ALL_ROLES = "all_role_Details";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_INSERT_ROLE = "insert_role";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_UPDATE_ROLE = "update_role";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_DELETE_ROLE = "remove_role";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_ROLE_USER_BY_USERID = "role_user_Details_by_userID";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_ROLE_USER_BY_ROLEID = "role_user_Details_by_roleID";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_ALL_ROLE_USERS = "all_role_user_Details";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_INSERT_ROLE_USER = "insert_role_user";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_DELETE_ROLE_USER = "remove_role_user";
	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_CONTACTUS_BY_ID = "contactUs_Details_by_ID";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_ALL_CONTACTUS = "all_contactUs_Details";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_INSERT_CONTACTUS = "insert_contactUs";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_DELETE_CONTACTUS = "remove_contactUS";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_RESPONSE_BY_ID = "response_Details_by_ID";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_RESPONSE_BY_CONTACTUSID = "response_Details_by_contactusID";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_ALL_RESPONSES = "all_responses_Details";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_INSERT_RESPONSE = "insert_response";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_DELETE_RESPONSE = "remove_response";	
	
	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_INQUIRY_BY_USERID = "inquiry_details_by_userID";	

	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_INQUIRY_BY_INQUIRYID = "inquiry_Details_by_inquiryID";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_ALL_INQUIRY = "all_inquiry_Details";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_INSERT_INQUIRY = "insert_inquiry";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_DELETE_INQUIRY = "remove_inquiry";	
	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_RESPONDINQ_BY_RESPONSEID = "respondINQ_details_by_respondID";	

	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_RESPONDINQ_BY_INQUIRYID = "respondINQ_Details_by_inquiryID";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_ALL_RESPONDINQ = "all_respondINQ_Details";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_INSERT_RESPONDINQ = "insert_respondINQ";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_DELETE_RESPONDINQ = "remove_respondINQ";	
	
	
	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_VCODE_BY_USERID = "verificationCode_by_userID";	

	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_ADD_VCODE = "insert_verificationCode";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_UPDATE_VCODE = "update_verificationCode";	

	
	
	
	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_NOTIFICATION_MAIN_BY_NOTIFICATIONID = "notification_main_by_NOTIFICATIONID";	

	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_INSERT_NOTIFICATION_MAIN = "insert_notification_main";
	

	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_NOTIFICATION_USER_BY_USERID = "notification_user_by_userID";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_INSERT_NOTIFICATION_USER = "insert_notification_user";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_UPDATE_NOTIFICATION_USER = "update_notification_user";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_DELETE_NOTIFICATION_USER = "remove_notification_user";	
	
	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_FEEDBACK_FEEDBACKID_ITEMID_BY_USERID = "feedback_by_userID_itemID_feedbackID";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_FEEDBACK_ITEMID_BY_USERID = "feedback_by_userID_itemID";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_FEEDBACK_ITEMID = "feedback_by_itemID";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_RETREIVE_FEEDBACK_BY_FEEDBACKID = "feedback_by_feedbackID";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_INSERT_FEEDBACK = "insert_feedback";
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_UPDATE_FEEDBACK= "update_feedback";	
	
	/** Constant for query id of check user in VSFM.xml */
	public static final String QUERY_ID_DELETE_FEEDBACK = "remove_feedback";	
	
	
	
	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;

	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;

	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;

	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;

	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;

	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;

	/** Constant for Column index seven */
	public static final int COLUMN_INDEX_SEVEN = 7;

	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_EIGHT = 8;

	/** Constant for Column index nine */
	public static final int COLUMN_INDEX_NINE = 9;

	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_TEN = 10;

	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_ELEVEN = 11;

	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_TWELVE = 12;
	
	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_THIRTEEN = 13;

	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_FOURTEEN = 14;
	
	/** Constant for Column index eight */
	public static final String EMAIL_PORT = "587";

	/** Constant for Column index eight */
	public static final String EMAIL_HOST = "smtp.gmail.com";

	/** Constant for Column index eight */
	public static final String EMAIL_NAME = "mykeylogger49@gmail.com";

	/** Constant for Column index eight */
	public static final String EMAIL_PASSWORD = "manukar2";

	/** Constant for Column index eight */
	public static final String EMAIL_EMAIL = "mykeylogger49@gmail.com";

}
