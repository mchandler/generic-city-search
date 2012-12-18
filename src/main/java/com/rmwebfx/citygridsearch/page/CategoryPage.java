package com.rmwebfx.citygridsearch.page;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.rmwebfx.citygridsearch.config.Constants;
import com.rmwebfx.citygridsearch.core.BasePage;
import com.rmwebfx.citygridsearch.helper.CategoryHelper;
import com.rmwebfx.citygridsearch.resources.PlacesSearch;
import com.rmwebfx.citygridsearch.resources.PlacesSearchMatch;

public class CategoryPage extends BasePage {

	private static final long serialVersionUID = 1L;
	private int pageNumber = 1;
	private int categoryId = 1;
	
	public CategoryPage(PageParameters params) {
		//pageNumber = params.get("pageNumber").toInt();
		//categoryId = CategoryHelper.getCategory(params.get("category").toString());
		
		System.out.println("pageNumber: " + params.get("pageNumber").toString());
		System.out.println("category: " + params.get("category").toString());
		
		LoadableDetachableModel<PlacesSearch> places = loadPlaces();
		LoadableDetachableModel<List<PlacesSearchMatch>> matches = getMatches(places);
		
		PageableListView listView = loadListView(matches);
		
		add(listView);
		
	}
	
	private LoadableDetachableModel<PlacesSearch> loadPlaces() {
		LoadableDetachableModel<PlacesSearch> places = new LoadableDetachableModel<PlacesSearch>() {

			private static final long serialVersionUID = 1L;

			@Override
			protected PlacesSearch load() {
				return new PlacesSearch(categoryId, Constants.SITEWIDE_CITY_STATE, "", pageNumber);
			}
			
		};
		
		return places;
	}
	
	private LoadableDetachableModel<List<PlacesSearchMatch>> getMatches(final IModel places) {
		LoadableDetachableModel<List<PlacesSearchMatch>> matches = new LoadableDetachableModel<List<PlacesSearchMatch>>() {

			private static final long serialVersionUID = 1L;

			@Override
			protected List<PlacesSearchMatch> load() {
				return ((PlacesSearch) places.getObject()).getPlaces();
			}
			
		};
		return matches;
	}
	
	private PageableListView loadListView(LoadableDetachableModel<List<PlacesSearchMatch>> matches) {
		@SuppressWarnings("unchecked")
		PageableListView<PlacesSearchMatch> results = new PageableListView("results", matches, 10) {

			@Override
			protected void populateItem(ListItem item) {
				PlacesSearchMatch match = (PlacesSearchMatch) item.getModelObject();
				item.add(new Label("placeName",match.getName()));
				item.add(new Label("categories",match.getCategories()));
				item.add(new Label("address", match.getAddress().toString()));
			}
			
		};
		
		return results;
	}

}
