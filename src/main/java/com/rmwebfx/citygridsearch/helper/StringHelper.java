package com.rmwebfx.citygridsearch.helper;

public class StringHelper {
	
	public static String publicIdString(String publicId) {
		String cleanString = publicId.toLowerCase().replaceAll("[^A-Za-z0-9 ]", "");
		return cleanString.replaceAll("[ ]","-");
	}
	
}
