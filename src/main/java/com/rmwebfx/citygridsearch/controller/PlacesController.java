package com.rmwebfx.citygridsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmwebfx.citygridsearch.resources.Place;

@Controller
public class PlacesController {
	
	@RequestMapping(value = "/places/{locationId}/{publicId}")
	public String getPlace(@PathVariable("locationId") int locationId,
			@PathVariable("publicId") String publicId,
			Model model) {
		
		Place place = new Place(locationId);
		model.addAttribute("locationName", place.getName());
		
		return "place";
	}
	
}
