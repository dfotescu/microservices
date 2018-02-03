package com.example.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationCotroller {
	
	@Autowired
	private LimitConfigProperties limitConfig;
	
	@GetMapping("/limits")
	public LimitConfig limitConfig() {
		return new LimitConfig(limitConfig.getMin(), limitConfig.getMax());
	}
}
