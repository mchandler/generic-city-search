package com.rmwebfx.citygridsearch.helper;

import com.citygrid.content.places.search.CGPlacesSearchType;

public class CategoryHelper {
	
	public static CGPlacesSearchType category(int type) {
		CGPlacesSearchType catType;
		
		switch (type) {
		case 1:
			catType = CGPlacesSearchType.BarClub;
			break;
			
		case 2:
			catType = CGPlacesSearchType.Hotel;
			break;
			
		case 3:
			catType = CGPlacesSearchType.Movie;
			break;
			
		case 4:
			catType = CGPlacesSearchType.MovieTheater;
			break;
			
		case 5:
			catType = CGPlacesSearchType.Restaurant;
			break;
			
		case 6:
			catType = CGPlacesSearchType.Shopping;
			break;
			
		case 7:
			catType = CGPlacesSearchType.SpaBeauty;
			break;
			
		case 8:
			catType = CGPlacesSearchType.Travel;
			break;
			
		default:
			catType = CGPlacesSearchType.Unknown;
			break;
		}
		
		return catType;
	}
	
	public static int getCategory(String category) {
		if (category.toLowerCase().equals("barclub")) {
			return 1;
		}
		
		if (category.toLowerCase().equals("hotel")) {
			return 2;
		}
		
		if (category.toLowerCase().equals("restaurant")) {
			return 5;
		}
		
		if (category.toLowerCase().equals("shopping")) {
			return 6;
		}
		
		if (category.toLowerCase().equals("spabeauty")) {
			return 7;
		}
		
		if (category.toLowerCase().equals("travel")) {
			return 8;
		}
		
		return 5;
	}
	
}
