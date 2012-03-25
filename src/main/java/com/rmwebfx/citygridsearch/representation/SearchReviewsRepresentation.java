package com.rmwebfx.citygridsearch.representation;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;

import com.rmwebfx.citygridsearch.resources.SearchReview;

public class SearchReviewsRepresentation {
	
	public static String represents(List<SearchReview> reviews) {
		JSONObject allReviews = toJson(reviews);
		return allReviews.toString();
	}
	
	private static JSONObject toJson(List<SearchReview> reviews) {
		JSONObject json = new JSONObject();
		// TODO: Complete the JSON representation of a SearchReview
		return json;
	}
	
}
