package com.in28Minutes.microservices.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(
			@PathVariable String from ,@PathVariable
			String to,@PathVariable BigDecimal quantity) {
		
		Map<String ,String> uriVariables = new HashMap<>();
		
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
	CurrencyConversionBean responseEntity =	new RestTemplate().getForObject(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversionBean.class, uriVariables);
		
		return new CurrencyConversionBean(responseEntity.getId(),responseEntity.getFrom(),
				responseEntity.getTo(),responseEntity.getConversionMultiple(),
				quantity,quantity.multiply(responseEntity.getConversionMultiple())
				,responseEntity.getPort());
	}
	
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(
			@PathVariable String from ,@PathVariable
			String to,@PathVariable BigDecimal quantity) {
	
	
	CurrencyConversionBean responseEntity = proxy.retreiveExchangeValue(from, to);
	
	logger.info("{}",responseEntity);
	
		return new CurrencyConversionBean(responseEntity.getId(),responseEntity.getFrom(),
				responseEntity.getTo(),responseEntity.getConversionMultiple(),
				quantity,quantity.multiply(responseEntity.getConversionMultiple())
				,responseEntity.getPort());
	}
}
