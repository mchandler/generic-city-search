package com.rmwebfx.citygridsearch.representation;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.rmwebfx.citygridsearch.resources.SearchReview;

public class SearchReviewsRepresentation {
	
	public static String represents(List<SearchReview> reviews) throws JSONException {
		JSONObject allReviews = toJson(reviews);
		return allReviews.toString();
	}
	
	private static JSONObject toJson(List<SearchReview> reviewsList) throws JSONException {
		JSONObject json = new JSONObject();
		JSONArray reviews = new JSONArray();
		
		// Add all reviews to a JSONArray
		for (SearchReview review : reviewsList) {
			JSONObject thisReview = new JSONObject();
			thisReview.put("title", review.getTitle());
			thisReview.put("text", review.getText());
			// TODO: Complete the representation
			reviews.put(thisReview);
		}
		
		// JSON Object consists of an array of reviews called 'reviews'
		json.put("reviews", reviews);
		
		return json;
	}
	
}
