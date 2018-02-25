package com.blkchain.app.construct;

public class Address {
	private String streetName;
	private String appartment;
	private String state;
	private String city;
	private String county;
	private int pincode;
	
	public Address(){
		
	}
	public Address(String streetName, String appartment, String state, String city, String county, int pincode) {
		this.streetName = streetName;
		this.appartment = appartment;
		this.state = state;
		this.city = city;
		this.county = county;
		this.pincode = pincode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAppartment() {
		return appartment;
	}

	public void setAppartment(String appartment) {
		this.appartment = appartment;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
