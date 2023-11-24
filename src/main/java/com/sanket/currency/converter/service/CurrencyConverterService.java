package com.sanket.currency.converter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanket.currency.converter.RestClient.RestGateWay;
import com.sanket.currency.converter.exception.JsonParsingException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class CurrencyConverterService {

    @Autowired
    RestGateWay gateway;

    JSONObject jsonArray;

    ObjectMapper mapper;
    Map<String, Double> conversionRate;

    private static final String DATA = "data";

    public BigDecimal convertToUserCurrency(String userCurrency, String convertTo, Double value) {
        log.info("START - CurrencyConverterService - userCurrency: {}, convertTo: {}, value: {}", userCurrency, convertTo, value);
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        BigDecimal finalValue = null;

        conversionRate = new HashMap<>();

        String response = gateway.getResponseFromApi(userCurrency).getBody();
        JSONObject data = new JSONObject(response);

        jsonArray = data.getJSONObject(DATA);
        conversionRate = getValuesFromJson(jsonArray);

        if (conversionRate.containsKey(convertTo.toUpperCase()))
            finalValue = BigDecimal.valueOf(conversionRate.get(convertTo.toUpperCase()) * value);

        log.info("END - CurrencyConverterService - finalValue: {}", finalValue);

        return finalValue;
    }

    private HashMap<String, Double> getValuesFromJson(JSONObject jsonArray) {
        TypeReference<HashMap<String, Double>> typeRef = new TypeReference<>() {
        };
        HashMap<String, Double> jsonToMap;

        try {
            jsonToMap = mapper.readValue(jsonArray.toString(), typeRef);
        } catch (JsonProcessingException e) {
            log.error("----JsonProcessingException----");
            throw new JsonParsingException(e.getMessage());
        }

        return jsonToMap;
    }
}
