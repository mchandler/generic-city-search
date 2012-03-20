package com.rmwebfx.citygridsearch.resources;

import java.util.ArrayList;
import java.util.List;

import com.citygrid.CGException;
import com.citygrid.CityGrid;
import com.citygrid.content.places.search.CGPlacesSearch;
import com.citygrid.content.places.search.CGPlacesSearchLocation;
import com.citygrid.content.places.search.CGPlacesSearchResults;
import com.citygrid.content.places.search.CGPlacesSearchType;
import com.rmwebfx.citygridsearch.config.Constants;

public class PlacesSearch extends RemoteResource {
	
	private List<PlacesSearchMatch> matches;
	private int totalHits;
	private int page;
	private int resultsPerPage;
	
	public PlacesSearch(String searchType, String where) {
		super();
		
		CGPlacesSearch search = CityGrid.placesSearch();
	    search.setType(CGPlacesSearchType.Restaurant); // TODO: Handle search types
	    search.setWhere(where);
	    search.setResultsPerPage(Constants.SEARCH_RESULTS_PER_PAGE);
	    
	    try {
	        CGPlacesSearchResults results = search.search();
	        totalHits = results.getTotalHits();
	        page = results.getPage();
	        resultsPerPage = results.getResultsPerPage();
	        
	        CGPlacesSearchLocation[] locations = results.getLocations();
	        setPlaces(locations);
	    }
	    catch (CGException e) {
	        // TODO: handle failures
	    }
	    
	}
	
	private void setPlaces(CGPlacesSearchLocation[] locations) {
		matches = new ArrayList<PlacesSearchMatch>();
		
		for (CGPlacesSearchLocation location : locations) {
			PlacesSearchMatch match = new PlacesSearchMatch(location);
			matches.add(match);
		}
	}
	
	public List<PlacesSearchMatch> getPlaces() {
		return matches;
	}
	
	public int getTotalHits() {
		return totalHits;
	}
	
	public int getPage() {
		return page;
	}
	
	public int getResultsPerPage() {
		return resultsPerPage;
	}
}
