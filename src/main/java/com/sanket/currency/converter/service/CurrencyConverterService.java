package com.sanket.currency.converter.service;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanket.currency.converter.RestClient.RestGateWay;

@Service
public class CurrencyConverterService {
	
	@Autowired
	RestGateWay gateway;
	
	JSONObject jsonArray;
	Double finalValue;
	ObjectMapper mapper = new ObjectMapper();
	Map<String,Double> conversionRate = new HashMap<>(); 
	
	public Double convertToUserCurrency(String userCurrency, String convertTo, Double value){
		String response = gateway.getResponseFromApi(userCurrency).getBody();
		JSONObject data = new JSONObject(response);
		jsonArray = data.getJSONObject("data");
		conversionRate = getValuesFromJson(jsonArray);
		if (conversionRate.containsKey(convertTo.toUpperCase())) {
			finalValue = conversionRate.get(convertTo.toUpperCase())*value;
		}
		return finalValue;
	}
	
	private HashMap<String, Double> getValuesFromJson(JSONObject jsonArray)  {
		TypeReference<HashMap<String, Double>> typeRef = new TypeReference<>() {};
		HashMap<String, Double> jsonToMap = null;
		try {
			jsonToMap = mapper.readValue(jsonArray.toString(), typeRef);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonToMap;
	}
}
