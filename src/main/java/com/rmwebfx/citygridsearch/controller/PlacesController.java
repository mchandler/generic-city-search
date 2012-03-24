package com.rmwebfx.citygridsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rmwebfx.citygridsearch.resources.Place;

@Controller
public class PlacesController {
	
	@RequestMapping(value = "/places/{locationId}/{publicId}")
	public ModelAndView getPlace(@PathVariable("locationId") int locationId,
			@PathVariable("publicId") String publicId) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("place");
		
		Place place = new Place(locationId);
		view.addObject("place", place);
		view.addObject("totalReviews", place.getReviewCount());
		
		return view;
	}
	
}
