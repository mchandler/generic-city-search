package com.rmwebfx.citygridsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rmwebfx.citygridsearch.config.Constants;
import com.rmwebfx.citygridsearch.resources.PlacesSearch;

@Controller
public class SearchController {
	
	@RequestMapping(value = "/category_results.html")
	public ModelAndView getPlace(@RequestParam("page") int page) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("category_results");
		
		PlacesSearch search = new PlacesSearch("Restaurant", Constants.SITEWIDE_CITY_STATE, "", page);
		view.addObject("matches", search.getPlaces());
		
		return view;
	}
	
	@RequestMapping(value = "/search")
	public ModelAndView search() {
		ModelAndView view = new ModelAndView();
		view.setViewName("search");
		return view;
	}
	
}
