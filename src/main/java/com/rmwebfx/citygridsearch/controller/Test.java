package com.rmwebfx.citygridsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmwebfx.citygridsearch.resources.Place;

@Controller
public class Test {
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		Place place = new Place(664259190);
		
		model.addAttribute("locationName", place.getName());
		return "home";
	}
	
	@RequestMapping(value = "/about-us")
	public String aboutUs() {
		return "about-us";
	}
	
}
