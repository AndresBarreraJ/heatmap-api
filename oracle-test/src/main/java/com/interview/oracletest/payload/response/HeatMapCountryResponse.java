package com.interview.oracletest.payload.response;

import java.util.List;

public class HeatMapCountryResponse extends HeatMapBaseResponse{
	
	private String country;
	
	public HeatMapCountryResponse(String country, List<HeatMapData> heatMapData, Double maxVal, String parameter) {
		super(heatMapData, maxVal, parameter);
		this.country = country;
	}
	
	public HeatMapCountryResponse(String country, HeatMapBaseResponse heatMapResponse) {
		super(heatMapResponse.getHeatMapData(), heatMapResponse.getMaxVal(), heatMapResponse.getParameter());
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
