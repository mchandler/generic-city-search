package com.rmwebfx.citygridsearch.page;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.rmwebfx.citygridsearch.core.BasePage;
import com.rmwebfx.citygridsearch.resources.Place;
import com.rmwebfx.citygridsearch.resources.Review;

public class PlaceDetails extends BasePage{

	private static final long serialVersionUID = 1L;
	private int locationId;
	
	public PlaceDetails(PageParameters params) {
		locationId = params.get("locationId").toInt();
		
		LoadableDetachableModel<Place> place = new LoadableDetachableModel<Place>() {

			private static final long serialVersionUID = 1L;

			@Override
			protected Place load() {
				return new Place(locationId);
			}
			
		};
		
		add(new Label("placeName",place.getObject().getName()));
		add(new Label("street",place.getObject().getAddress().getStreet()));
		add(new Label("city",place.getObject().getAddress().getCity()));
		add(new Label("state",place.getObject().getAddress().getState()));
		add(new Label("postal",place.getObject().getAddress().getPostal()));
		add(new Label("businessHours",place.getObject().getBusinessHours()));
		add(new Label("totalReviews",new Integer(place.getObject().getReviewCount()).toString()));
		
		add(getAllReviews(place));
		
	}
	
	private ListView<Review> getAllReviews(LoadableDetachableModel<Place> place) {
		List<Review> reviews = place.getObject().getReviews();
		
		ListView<Review> listView = new ListView<Review>("reviews", reviews){
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Review> item) {
				Review review = item.getModelObject();
				item.add(new ExternalLink("reviewLink", review.getUrl(), review.getTitle()));
				item.add(new Label("reviewContent", review.getText()));
				item.add(new Label("reviewDate",review.getDate().toString()));
				//item.add(new Label("reviewRating", new Integer(review.getRating()).toString()));
				//item.add(new Label("reviewHelpful", new Integer(review.getHelpful()).toString()));
			}
			
		};
		
		return listView;
	}

}
