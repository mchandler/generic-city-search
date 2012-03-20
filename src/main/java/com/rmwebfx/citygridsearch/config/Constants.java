package com.rmwebfx.citygridsearch.config;

public class Constants {
	
	public static String CITYGRID_PUBLISHER_ID = "10000002304";
	public static String SITEWIDE_CITY_STATE = "Simi Valley, CA";
	
	
	public static String publicIdString(String publicId) {
		String cleanString = publicId.toLowerCase().replaceAll("[^A-Za-z0-9 ]", "");
		return cleanString.replaceAll("[ ]","-");
	}
	
}
