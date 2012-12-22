package com.rmwebfx.citygridsearch.core;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import com.rmwebfx.citygridsearch.page.Index;
import com.rmwebfx.citygridsearch.page.CategoryPage;
import com.rmwebfx.citygridsearch.page.PlaceDetails;

public class CitygridApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return Index.class;
	}
	
	@Override
	public void init() {
		super.init();
		
		mountPages();
	}
	
	private void mountPages() {
		mountPage("/search/${category}/${pageNumber}", CategoryPage.class);
		mountPage("/place/${locationId}/${publicId}", PlaceDetails.class);
	}

}
