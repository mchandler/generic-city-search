package com.rmwebfx.citygridsearch.resources;

import com.citygrid.CityGrid;
import com.rmwebfx.citygridsearch.config.Constants;

public class RemoteResource {
	
	public RemoteResource() {
		CityGrid.setPublisher(Constants.CITYGRID_PUBLISHER_ID);
		CityGrid.setSimulation(false);
	}
	
}
