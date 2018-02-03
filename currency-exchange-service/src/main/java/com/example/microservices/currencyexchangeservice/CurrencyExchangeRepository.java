package com.example.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeValue, Integer>{

	CurrencyExchangeValue findByFromAndTo(String from, String to);
}
