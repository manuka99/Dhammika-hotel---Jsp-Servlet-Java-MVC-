package com.FoodPub.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.Part;

/**
 * This is the common utility class to load all property details at once when it
 * is initializing .
 * 
 * @author Manuka yasas, SLIIT
 * @version 1.0
 */
	public class CommonUtil {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(CommonUtil.class.getName());
	
	public static final Properties properties = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/*
	 * generate unique id to add a bill to the database
	 */
	public static Integer generateIDs(ArrayList<Integer> arrayList) {

		Integer id;
		int next = arrayList.size();
		next++;
		id = next;
		if (arrayList.contains(id)) {
			next++;
			id = next;
		}
		return id;
	}
	
	
	/*
	 * when a part(file uploaded ) is give this function will return the name of the 
	 * file/part uploaded
	 */
	public static String extractFileName(Part part) {
		
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for(String s: items) {
			
			if(s.trim().startsWith("filename")) {
				
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
				
			}
		}
		
		return ""; 

	}

}
