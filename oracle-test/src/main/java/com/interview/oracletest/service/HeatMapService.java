package com.interview.oracletest.service;

import com.interview.oracletest.payload.response.HeatMapBaseResponse;
import com.interview.oracletest.payload.response.HeatMapCountryResponse;

public interface HeatMapService {
	
	public HeatMapCountryResponse getHeatMapData(String country, String measuredParameter) throws Exception;
	public HeatMapBaseResponse getHeatMapData(String coords, String measuredParameter, Integer radius) throws Exception;
}
