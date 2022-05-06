package com.interview.oracletest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interview.oracletest.exceptions.CustomException;
import com.interview.oracletest.payload.response.HeatMapBaseResponse;
import com.interview.oracletest.payload.response.HeatMapCountryResponse;
import com.interview.oracletest.service.HeatMapService;

@RestController
@RequestMapping("/heatmap")
public class HeatMapController {
	
	@Autowired
	private HeatMapService heatMapService;
	
	//For country and and measurement parameter parameters 
	@GetMapping(path = "/country", produces = {"application/json"})
	public HeatMapCountryResponse getHeatMapDataForCountry(@RequestParam String country, @RequestParam String parameter) throws Exception{
		return heatMapService.getHeatMapData(country, parameter);
		
	}
	//For coordinates, radius and measurement parameter parameters 
	@GetMapping(path = "/coords", produces = {"application/json"})
	public HeatMapBaseResponse getHeatMapDataForCountry(@RequestParam String coordinates, @RequestParam String parameter, @RequestParam Integer radius) throws Exception {
		return heatMapService.getHeatMapData(coordinates, parameter, radius);
	}
	
	@ExceptionHandler
	public CustomException handleException(Exception e) {
		return new CustomException("Error: " + e.getMessage());
	}
}
