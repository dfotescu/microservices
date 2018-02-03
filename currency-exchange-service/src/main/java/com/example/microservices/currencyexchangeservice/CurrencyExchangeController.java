package com.example.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	CurrencyExchangeRepository currencyExchangeRepository;

	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchangeValue currencyExchange(@PathVariable String from, @PathVariable String to) {
		CurrencyExchangeValue exchangeValue = currencyExchangeRepository.findByFromAndTo(from, to);
		if(exchangeValue != null) {
			exchangeValue.setPort(Integer.parseInt(environment.getProperty("server.port")));
		}
		
		logger.info("currency exchange value -> {}", exchangeValue);
		
		return exchangeValue;
	}
}
