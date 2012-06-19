package com.rmwebfx.citygridsearch.resources;

import java.util.ArrayList;
import java.util.List;

import com.citygrid.CGBaseReview;
import com.citygrid.CGException;
import com.citygrid.CityGrid;
import com.citygrid.content.places.detail.CGPlacesDetail;
import com.citygrid.content.places.detail.CGPlacesDetailLocation;
import com.citygrid.content.places.detail.CGPlacesDetailResults;
import com.rmwebfx.citygridsearch.config.Constants;
import com.rmwebfx.citygridsearch.helper.StringHelper;

public class Place extends RemoteResource {
	
	private CGPlacesDetailLocation locationObj;
	
	private int locationId;
	private String name;
	private PlaceAddress address;
	private String phone;
	private String businessHours;
	private int reviewCount;
	private List<Review> reviews;
	
	public Place() {
		super();
	}
	
	public Place(int locationId) {
		super();
		
		CGPlacesDetail detail = CityGrid.placesDetail();
		detail.setLocationId(locationId);
		
		detail.setReviewCount(Constants.REVIEWS_COUNT_PER_PLACE);
		
		try {
			CGPlacesDetailResults results = detail.detail();
			initializeByLocationObj(results.getLocation());
		} catch (CGException e) {
			name = e.getMessage();
		}
	}

	public void initializeByLocationObj(CGPlacesDetailLocation locationObj) {
		this.locationObj = locationObj;
		
		name = locationObj.getName();
		phone = locationObj.getPhone();
		businessHours = locationObj.getBusinessHours();
		reviewCount = locationObj.getReviews().getCount();
		
		setAddress();
		setAllReviews();
	}
	
	public boolean isSameLocation(Place otherPlace) {
		return (otherPlace.getLatLon().equals(this.getLatLon())) ? true : false;
	}
	
	public int getLocationId() {
		return locationId;
	}
	
	public String getPublicId() {
		return StringHelper.publicIdString(getName());
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
	
	public int getRating() {
		return locationObj.getRating();
	}
	
	public String getWebsite() {
		if (locationObj.getUrls().getWebsite() == null) {
			return "";
		}
		
		return locationObj.getUrls().getWebsite().toString();
	}
	
	private void setAddress() {
		if (locationObj.getAddress() == null) {
			return;
		}
		
		address = new PlaceAddress(locationObj.getAddress());
	}
	
	public PlaceAddress getAddress() {
		return address;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public void setAllReviews() {
		CGBaseReview[] allReviews = locationObj.getReviews().getReviews();
		reviews = new ArrayList<Review>();
		
		for (int i = 0; i < allReviews.length; i++) {
			Review review = new Review(allReviews[i]);
			reviews.add(review);
		}
	}
}
