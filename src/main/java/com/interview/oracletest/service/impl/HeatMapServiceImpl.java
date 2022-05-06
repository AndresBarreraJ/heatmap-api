package com.interview.oracletest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.InvalidAttributeValueException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.interview.oracletest.payload.locations.LocationsParameters;
import com.interview.oracletest.payload.locations.LocationsResponse;
import com.interview.oracletest.payload.locations.LocationsResult;
import com.interview.oracletest.payload.parameters.ParametersResponse;
import com.interview.oracletest.payload.parameters.ParametersResult;
import com.interview.oracletest.payload.response.HeatMapBaseResponse;
import com.interview.oracletest.payload.response.HeatMapCountryResponse;
import com.interview.oracletest.payload.response.HeatMapData;
import com.interview.oracletest.service.HeatMapService;
import com.interview.oracletest.utils.ValidationUtils;

@Service
public class HeatMapServiceImpl implements HeatMapService {

	private String LOCATIONS_URI = "https://u50g7n0cbj.execute-api.us-east-1.amazonaws.com/v2/locations";
	private String PARAMETERS_URI = "https://u50g7n0cbj.execute-api.us-east-1.amazonaws.com/v2/parameters";

	//For data with country and measurement parameter as parameters
	@Override
	public HeatMapCountryResponse getHeatMapData(String country, String parameter) throws Exception {
		
		if(!ValidationUtils.validateRegex(country, "^[a-zA-z]{2}$")) { 
			throw new Exception("Incorrect country format"); 
		}
		//parameter query does not work neither with the id or name, so had to filter with map method
		String queryUri = LOCATIONS_URI + "?country_id=" + country;
		LocationsResponse locations = callLocationsEndpoint(queryUri);
		
		return new HeatMapCountryResponse(country, getHeatMapResponseFromFitleredLocations(locations, parameter));
		
	}

	//For data with coordinates, radius and measurement parameter as parameters
	@Override
	public HeatMapBaseResponse getHeatMapData(String coords, String parameter, Integer radius) throws Exception {

		if(!ValidationUtils.validateRegex(coords, "^-?\\d{1,2}\\.?\\d{0,8},-?1?\\d{1,2}\\.?\\d{0,8}$")) { 
			throw new InvalidAttributeValueException("Incorrect coords format."); 
		}
		
		if(radius > 100000) {
			throw new Exception("Radius value out of range.");
		}
		//parameter query does not work neither with the id or name, so had to filter with map method
		String queryUri = LOCATIONS_URI + "?coordinates=" + coords + "&radius=" + radius;
		LocationsResponse locations = callLocationsEndpoint(queryUri);
				
		return getHeatMapResponseFromFitleredLocations(locations, parameter);
	}
	
	private HeatMapBaseResponse getHeatMapResponseFromFitleredLocations(LocationsResponse locations, String parameter) throws Exception{
		//I think max value for parameters come from paramters endpoint, property maxColorValue
		Double maxValue = callParametersEndpoint(parameter);
		
		List<HeatMapData> heatMapDataList = new ArrayList<>();
		for(LocationsResult result : locations.getResults()) {
			//Filter locations data to only include corresponding measurement parameter
			List<LocationsParameters> parameters = result.getParameters().stream().filter(p -> p.getParameter().equals(parameter)).collect(Collectors.toList());
			result.setParameters(parameters);
			//Only add parameters with values after filtered
			if(!parameters.isEmpty() && parameters.size() > 0) {
				heatMapDataList.add(new HeatMapData(result));
				maxValue = (maxValue < parameters.get(0).getAverage()) ? parameters.get(0).getAverage() : maxValue;
			}
		}
		return new HeatMapBaseResponse(heatMapDataList, maxValue, parameter);
	}
	
	//Get Locations data from locations end point
	private LocationsResponse callLocationsEndpoint(String uri) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		LocationsResponse response = restTemplate.getForObject(uri, LocationsResponse.class);
		if(response==null || response.getResults().isEmpty()) {
			throw new Exception("No Data found");
		}
		return response;
	}
	
	//Get Parameters data from parameters end point
	private Double callParametersEndpoint(String name) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		ParametersResponse response = restTemplate.getForObject(PARAMETERS_URI, ParametersResponse.class);
		
		//filter by parameter wanted, and validate, return 0 if max value null
		List<ParametersResult> results = response.getResults().stream().filter(res -> res.getName().equals(name)).collect(Collectors.toList());
		if(results==null || results.isEmpty()) {
			throw new Exception("Parameter specified not valid.");
		}
		
		return (results.get(0).getMaxColorValue() == null) ? 0 : results.get(0).getMaxColorValue();
	}

}
