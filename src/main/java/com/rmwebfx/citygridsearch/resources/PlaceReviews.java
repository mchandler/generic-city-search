package com.rmwebfx.citygridsearch.resources;

import java.util.ArrayList;
import java.util.List;

import com.citygrid.CGException;
import com.citygrid.CityGrid;
import com.citygrid.content.reviews.CGReviewsSearch;
import com.citygrid.content.reviews.CGReviewsSearchResults;
import com.citygrid.content.reviews.CGReviewsSearchReview;
import com.rmwebfx.citygridsearch.config.Constants;

public class PlaceReviews extends RemoteResource {
	
	private CGReviewsSearchResults resultsObj;
	private List<SearchReview> reviews;
	
	public PlaceReviews(int locationId, int page) {
		super();
		
		CGReviewsSearch search = CityGrid.reviewsSearch();
		search.setLocationId(locationId);
		search.setResultsPerPage(Constants.REVIEWS_COUNT_PER_PLACE);
		search.setPage(page);
		
		try {
			CGReviewsSearchResults results = search.search();
			resultsObj = results;
			
			setAllReviews();
		} catch (CGException e) {
			// TODO: Handle failures
		}
	}
	
	private void setAllReviews() {
		CGReviewsSearchReview[] allReviews = resultsObj.getReviews();
		reviews = new ArrayList<SearchReview>();
		
		for (int i = 0; i < allReviews.length; i++) {
			SearchReview review = new SearchReview(allReviews[i]);
			reviews.add(review);
		}
	}
	
}
