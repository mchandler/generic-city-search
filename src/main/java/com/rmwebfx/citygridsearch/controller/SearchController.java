package com.rmwebfx.citygridsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	
	@RequestMapping(value = "/category_results.html")
	public ModelAndView getPlace(@RequestParam("page") int page) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("category_search");
		
		
		
		return view;
	}
	
	@RequestMapping(value = "/search")
	public ModelAndView search() {
		ModelAndView view = new ModelAndView();
		view.setViewName("search");
		return view;
	}
	
}
