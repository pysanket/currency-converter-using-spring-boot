package com.sanket.currency.converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.currency.converter.RestClient.RestGateWay;
import com.sanket.currency.converter.service.CurrencyConverterService;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency/convertor")
@Slf4j
public class CurrencyConverterController {

    @Autowired
    RestGateWay gateWay;
    @Autowired
    CurrencyConverterService service;

    @GetMapping(path = "/{currencyName}/{convertTo}/{value}", produces = "application/json")
    public ResponseEntity<String> getConvertedRate(@PathVariable String currencyName, @PathVariable String convertTo, @PathVariable Double value) {
        log.info("start of controller");
        log.info("provided currency: {} :: converting to: {} :: value: {}", currencyName, convertTo, value);

        BigDecimal convertedResponse = service.convertToUserCurrency(currencyName, convertTo, value);

        log.info("converted value is: {}", convertedResponse);
        log.info("End of controller");

        return ResponseEntity
                .ok(value + " " + currencyName.toUpperCase() + " " +
                        "to " + convertTo.toUpperCase() + " is -> " + convertedResponse + ".");
    }

    @GetMapping(path = "/{currencyName}", produces = "application/json")
    public ResponseEntity<String> getRate(@PathVariable String currencyName) {
        return ResponseEntity.ok(gateWay.getResponseFromApi(currencyName).getBody());
    }

}
