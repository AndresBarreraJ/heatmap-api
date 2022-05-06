package com.interview.oracletest.payload.locations;

import java.util.List;

public class LocationsResult {
	
	private String country;
	private List<LocationsParameters> parameters;
	private LocationsCoordinates coordinates;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<LocationsParameters> getParameters() {
		return parameters;
	}
	public void setParameters(List<LocationsParameters> parameters) {
		this.parameters = parameters;
	}
	public LocationsCoordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(LocationsCoordinates coordinates) {
		this.coordinates = coordinates;
	}

	
	
}
