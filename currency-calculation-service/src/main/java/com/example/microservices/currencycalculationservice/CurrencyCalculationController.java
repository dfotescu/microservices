package com.example.microservices.currencycalculationservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyCalculationController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeService;

	@GetMapping("/currency-calculation/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyCalculationBean currencyCalculation(@PathVariable @NotNull String from, @PathVariable @NotNull String to,
			@PathVariable @Positive BigDecimal quantity) {
		RestTemplate template = new RestTemplate();
		
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		uriVariables.put("quantity", quantity);
		
		ResponseEntity<CurrencyCalculationBean> response = template
				.getForEntity("http://localhost:8000/from/{from}/to/{to}", CurrencyCalculationBean.class, uriVariables);
		
		CurrencyCalculationBean calculationBean = response.getBody();
		calculationBean.setQuantityToConvert(quantity);
		calculationBean.setConvertedQuantity(quantity.multiply(calculationBean.getConversionFactor()));
		
		return calculationBean;
	}
	
	@GetMapping("/currency-calculation-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyCalculationBean currencyCalculation1(@PathVariable String from, @PathVariable String to,
			@PathVariable @Positive BigDecimal quantity) {
		CurrencyCalculationBean calculationBean = currencyExchangeService.currencyExchange(from, to);
		calculationBean.setQuantityToConvert(quantity);
		calculationBean.setConvertedQuantity(quantity.multiply(calculationBean.getConversionFactor()));
		
		logger.info("currency calculation bean -> {}", calculationBean);
		return calculationBean;
	}
}
