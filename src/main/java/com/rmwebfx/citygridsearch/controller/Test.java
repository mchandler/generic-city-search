package com.rmwebfx.citygridsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citygrid.CGException;
import com.citygrid.CityGrid;
import com.citygrid.content.places.detail.CGPlacesDetail;
import com.citygrid.content.places.detail.CGPlacesDetailLocation;
import com.citygrid.content.places.detail.CGPlacesDetailResults;
import com.rmwebfx.citygridsearch.config.Constants;

@Controller
public class Test {
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		CityGrid.setPublisher(Constants.CITYGRID_PUBLISHER_ID);
		CityGrid.setSimulation(false);
		CGPlacesDetail detail = CityGrid.placesDetail();
		detail.setLocationId(664259190);
		
		String locationName;
		
		try {
			CGPlacesDetailResults results = detail.detail();
			CGPlacesDetailLocation location = results.getLocation();
			locationName = location.getName();
		} catch (CGException e) {
			// TODO: Handle failures
			locationName = e.getMessage();
		}
		model.addAttribute("locationName", locationName);
		return "home";
	}
	
	@RequestMapping(value = "/about-us")
	public String aboutUs() {
		return "about-us";
	}
	
}
