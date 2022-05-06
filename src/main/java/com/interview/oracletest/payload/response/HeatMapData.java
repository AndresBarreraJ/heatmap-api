package com.interview.oracletest.payload.response;

import com.interview.oracletest.payload.locations.LocationsResult;

public class HeatMapData {

	private Double x;
	private Double y;
	private Double value;
	
	public HeatMapData(LocationsResult locationsResult) {
		this.x = locationsResult.getCoordinates().getLatitude();
		this.y = locationsResult.getCoordinates().getLongitude();
		this.value = locationsResult.getParameters().get(0).getAverage();
	}
	
	public Double getLatitude() {
		return x;
	}
	public void setLatitude(Double latitude) {
		this.x = latitude;
	}
	public Double getLongitude() {
		return y;
	}
	public void setLongitude(Double longitude) {
		this.y = longitude;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
