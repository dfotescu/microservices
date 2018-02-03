package com.example.microservices.currencycalculationservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
//	@GetMapping("/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/from/{from}/to/{to}")
	public CurrencyCalculationBean currencyExchange(@PathVariable("from") String from, @PathVariable("to") String to);
}
