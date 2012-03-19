package com.rmwebfx.citygridsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmwebfx.citygridsearch.resources.Place;
import com.rmwebfx.citygridsearch.resources.PlacesSearch;

@Controller
public class Test {
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		PlacesSearch search = new PlacesSearch("Restaurant","Simi Valley, CA");
		
		model.addAttribute("matches", search.getPlaces());
		return "home";
	}
	
	@RequestMapping(value = "/about-us")
	public String aboutUs() {
		return "about-us";
	}
	
}
