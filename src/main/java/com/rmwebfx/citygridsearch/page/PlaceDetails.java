package com.rmwebfx.citygridsearch.page;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.rmwebfx.citygridsearch.core.BasePage;
import com.rmwebfx.citygridsearch.resources.Place;

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
		
	}

}
