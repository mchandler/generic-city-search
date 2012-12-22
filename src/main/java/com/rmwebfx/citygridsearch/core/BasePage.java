package com.rmwebfx.citygridsearch.core;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;

public class BasePage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	public BasePage() {
		add(new WebMarkupContainer("stylecss"));
	}

}
