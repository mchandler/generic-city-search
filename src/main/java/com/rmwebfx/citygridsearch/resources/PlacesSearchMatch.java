package com.rmwebfx.citygridsearch.resources;

import com.citygrid.content.places.search.CGPlacesSearchLocation;
import com.rmwebfx.citygridsearch.helper.StringHelper;

public class PlacesSearchMatch {
	
	private CGPlacesSearchLocation locationObj;
	
	private String name;
	private PlaceAddress address;
	private String tagline;
	private int locationId;
	
	public PlacesSearchMatch(CGPlacesSearchLocation location) {
		this.locationObj = location;
		
		name = locationObj.getName();
		address = new PlaceAddress(locationObj.getAddress());
		tagline = locationObj.getTagline();
		locationId = locationObj.getLocationId();
	}
	
	public String getName() {
		return name;
	}

	public PlaceAddress getAddress() {
		return address;
	}

	public String getTagline() {
		return tagline;
	}

	public int getLocationId() {
		return locationId;
	}

	public String getPublicId() {
		return StringHelper.publicIdString(getName());
	}
	
	public int getReviewsCount() {
		return locationObj.getReviews();
	}
	
	public String getImage() {
		return locationObj.getImage().toString();
	}
	
	public String getCategories() {
		StringBuilder cats = new StringBuilder();
		String[] categories = locationObj.getCategories();
		
		if (categories.length == 0) {
			return "";
		}
		
		for (int i = 0; i < categories.length; i++) {
			if (i > 0) {
				cats.append(", ");
			}
			
			cats.append(categories[i]);
		}
		
		return cats.toString();
	}

}
