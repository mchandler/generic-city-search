package com.rmwebfx.citygridsearch.core;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import com.rmwebfx.citygridsearch.page.Index;

public class CitygridApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return Index.class;
	}

}
