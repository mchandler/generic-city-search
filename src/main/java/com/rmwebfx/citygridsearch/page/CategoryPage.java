package com.rmwebfx.citygridsearch.page;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
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
	private String category = "restaurant";
	private int categoryId = 1;
	private int totalPages;
	
	public CategoryPage(PageParameters params) {
		pageNumber = (params.get("pageNumber").toString().length() == 0) ? 1 : params.get("pageNumber").toInt();
		categoryId = CategoryHelper.getCategory(params.get("category").toString());
		category = params.get("category").toString();
		
		LoadableDetachableModel<PlacesSearch> places = loadPlaces();
		totalPages = places.getObject().getTotalPages();
		
		PageableListView listView = loadListView(places);
		
		add(new Label("catTitle",CategoryHelper.getCategoryString(categoryId)));
		add(listView);
		
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		
		response.render(JavaScriptHeaderItem.forScript("var pageId = " + pageNumber + ";", "pageid"));
		response.render(JavaScriptHeaderItem.forScript("var cat = '" + category + "';", "cat"));
		response.render(JavaScriptHeaderItem.forScript("var tp = '" + totalPages + "';", "tp"));
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
	
	private PageableListView loadListView(LoadableDetachableModel<PlacesSearch> places) {
		@SuppressWarnings("unchecked")
		PageableListView<PlacesSearchMatch> results = new PageableListView("results", places.getObject().getPlaces(), 10) {

			@Override
			protected void populateItem(ListItem item) {
				PlacesSearchMatch match = (PlacesSearchMatch) item.getModelObject();
				
				PageParameters params = new PageParameters();
				params.add("locationId", match.getLocationId());
				params.add("publicId", match.getPublicId());
				BookmarkablePageLink placeLink = new BookmarkablePageLink("placeLink", PlaceDetails.class, params);
				
				placeLink.add(new Label("placeName", match.getName()));
				
				item.add(placeLink);
				item.add(new Label("categories",match.getCategories()));
				item.add(new Label("address", match.getAddress().toString()));
			}
			
		};
		
		return results;
	}

}
