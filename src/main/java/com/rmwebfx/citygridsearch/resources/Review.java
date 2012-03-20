package com.rmwebfx.citygridsearch.resources;

import java.util.Date;

import com.citygrid.CGBaseReview;

public class Review {
	
	private CGBaseReview reviewObj;
	
	public Review(CGBaseReview review) {
		reviewObj = review;
	}
	
	public String getTitle() {
		return reviewObj.getTitle();
	}
	
	public String getUrl() {
		return reviewObj.getUrl().toString();
	}
	
	public String getText() {
		return reviewObj.getText();
	}
	
	public Date getDate() {
		return reviewObj.getDate();
	}
	
	public int getRating() {
		return reviewObj.getRating();
	}
	
	public int getHelpful() {
		return reviewObj.getHelpful();
	}
}
