package com.rmwebfx.citygridsearch.page;

import org.apache.wicket.markup.html.basic.Label;

import com.rmwebfx.citygridsearch.core.BasePage;

public class Index extends BasePage {

	private static final long serialVersionUID = 1L;
	
	public Index() {
		add(new Label("greeting", "Why do I always do a Hello World?"));
	}
	
}
