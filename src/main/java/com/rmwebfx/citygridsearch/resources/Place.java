package com.rmwebfx.citygridsearch.resources;

import com.citygrid.CGException;
import com.citygrid.CityGrid;
import com.citygrid.content.places.detail.CGPlacesDetail;
import com.citygrid.content.places.detail.CGPlacesDetailLocation;
import com.citygrid.content.places.detail.CGPlacesDetailResults;

public class Place extends RemoteResource {
	
	private CGPlacesDetailLocation locationObj;
	
	private int locationId;
	private String name;
	private String phone;
	private String businessHours;
	@SuppressWarnings("unused")
	private String latLon;
	private int reviewCount;
	@SuppressWarnings("unused")
	private String websiteUri;
	
	public Place(int locationId) {
		super();
		
		CGPlacesDetail detail = CityGrid.placesDetail();
		detail.setLocationId(locationId);
		
		try {
			CGPlacesDetailResults results = detail.detail();
			locationObj = results.getLocation();
			
			name = locationObj.getName();
			phone = locationObj.getPhone();
			businessHours = locationObj.getBusinessHours();
			latLon = getLatLon();
			reviewCount = locationObj.getReviews().getCount();
			websiteUri = getWebsite();
			
		} catch (CGException e) {
			// TODO: Handle failures
		}
	}

	public int getLocationId() {
		return locationId;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getBusinessHours() {
		return businessHours;
	}
	
	public String getLatLon() {
		if (locationObj.getLatlon() == null) {
			return "";
		}
		
		String lat = new Double(locationObj.getLatlon().getLatitude()).toString();
		String lon = new Double(locationObj.getLatlon().getLongitude()).toString();
		return lat + ", " + lon;
	}

	public int getReviewCount() {
		return reviewCount;
	}
	
	public String getWebsite() {
		if (locationObj.getUrls().getWebsite() == null) {
			return "";
		}
		
		return locationObj.getUrls().getWebsite().toString();
	}
}
