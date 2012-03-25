package com.rmwebfx.citygridsearch.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;

import com.rmwebfx.citygridsearch.representation.SearchReviewsRepresentation;
import com.rmwebfx.citygridsearch.resources.PlaceReviews;

@Path("/reviews")
public class ReviewResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{locationId}/{page}")
	public String reviewsByLocation(@PathParam("locationId") int locationId,
			@PathParam("page") int page) {
		
		String jsonResponse;
		
		PlaceReviews review = new PlaceReviews(44544412, page);
		try {
			String json = SearchReviewsRepresentation.represents(review.getReviews());
			jsonResponse = json;
		} catch (JSONException e) {
			jsonResponse = e.getMessage();
		}
		
		return jsonResponse;
	}
}