package com.rmwebfx.citygridsearch.resources;

import com.citygrid.CGAddress;

public class PlaceAddress {
	
	private String street;
	private String city;
	private String state;
	private String postal;
	
	public PlaceAddress(CGAddress addressObj) {
		street = addressObj.getStreet();
		city = addressObj.getCity();
		state = addressObj.getState();
		postal = addressObj.getZip();
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getPostal() {
		return postal;
	}
	
	public String toString() {
		return street + ", " + city + ", " + state + " " + postal;
	}
	
}
