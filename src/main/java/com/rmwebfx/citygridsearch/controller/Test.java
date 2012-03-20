package com.rmwebfx.citygridsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rmwebfx.citygridsearch.config.Constants;
import com.rmwebfx.citygridsearch.resources.PlacesSearch;

@Controller
public class Test {
	
	@RequestMapping(value = "/")
	public ModelAndView home() {
		PlacesSearch search = new PlacesSearch("Restaurant", Constants.SITEWIDE_CITY_STATE);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("home");
		view.addObject("matches", search.getPlaces());
		return view;
	}
	
	@RequestMapping(value = "/about-us")
	public ModelAndView aboutUs() {
		ModelAndView view = new ModelAndView();
		view.setViewName("about-us");
		return view;
	}
	
}
