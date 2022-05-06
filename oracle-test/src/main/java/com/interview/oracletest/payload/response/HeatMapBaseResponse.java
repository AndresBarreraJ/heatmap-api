package com.interview.oracletest.payload.response;

import java.util.List;

public class HeatMapBaseResponse {

	private Double minVal = 0.0;
	private Double maxVal;
	private String parameter;
	private List<HeatMapData> heatMapData;
	
	public HeatMapBaseResponse(List<HeatMapData> heatMapData, Double maxVal, String parameter) {
		this.heatMapData = heatMapData;
		this.maxVal = maxVal;
		this.parameter = parameter;
	}
	
	public HeatMapBaseResponse() {
		// TODO Auto-generated constructor stub
	}
	public Double getMinVal() {
		return minVal;
	}
	public void setMinVal(Double minVal) {
		this.minVal = minVal;
	}
	public Double getMaxVal() {
		return maxVal;
	}
	public void setMaxVal(Double maxVal) {
		this.maxVal = maxVal;
	}
	public List<HeatMapData> getHeatMapData() {
		return heatMapData;
	}
	public void setHeatMapData(List<HeatMapData> heatMapData) {
		this.heatMapData = heatMapData;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
	
	
}
