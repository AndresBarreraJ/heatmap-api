package com.interview.oracletest.payload.locations;

import java.util.List;

public class LocationsResponse {

	
	private List<LocationsResult> results;

	public List<LocationsResult> getResults() {
		return results;
	}

	public void setResults(List<LocationsResult> results) {
		this.results = results;
	}
}
