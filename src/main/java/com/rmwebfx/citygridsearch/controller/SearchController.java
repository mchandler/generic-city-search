package com.rmwebfx.citygridsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rmwebfx.citygridsearch.config.Constants;
import com.rmwebfx.citygridsearch.helper.CategoryHelper;
import com.rmwebfx.citygridsearch.resources.PlacesSearch;

@Controller
public class SearchController {
	
	@RequestMapping(value = "/category/{category}")
	public ModelAndView getPlaceNoPage(@PathVariable("category") String category) {
		return getPlace(category, 1);
	}
	
	@RequestMapping(value = "/category/{category}/{page}")
	public ModelAndView getPlace(@PathVariable("category") String category, @PathVariable("page") int page) {
		int categoryId = CategoryHelper.getCategory(category);
		return doSearch(categoryId, page);
	}
	
	@RequestMapping(value = "/search")
	public ModelAndView search() {
		ModelAndView view = new ModelAndView();
		view.setViewName("search");
		return view;
	}
	
	private ModelAndView doSearch(int categoryId, int page) {
		ModelAndView view = new ModelAndView();
		view.setViewName("category_results");
		
		PlacesSearch search = new PlacesSearch(categoryId, Constants.SITEWIDE_CITY_STATE, "", page);
		view.addObject("matches", search.getPlaces());
		view.addObject("totalPages", search.getTotalPages());
		view.addObject("totalMatches", search.getTotalHits());
		
		return view;
	}
	
}
