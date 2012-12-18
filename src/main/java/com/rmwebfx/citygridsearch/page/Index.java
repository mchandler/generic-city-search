package com.rmwebfx.citygridsearch.page;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.rmwebfx.citygridsearch.core.BasePage;

public class Index extends BasePage {

	private static final long serialVersionUID = 1L;
	
	public Index() {
		add(new Label("greeting", "Why do I always do a Hello World?"));
		
		PageParameters params = new PageParameters();
		params.add("category", "restaurant");
		params.add("pageNumber", 1);
		
		add(new BookmarkablePageLink("link", CategoryPage.class, params));
	}
	
}
