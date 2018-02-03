package com.example.microservices.currencycalculationservice;

import java.math.BigDecimal;

public class CurrencyCalculationBean {
	
	private Integer id;
	private String from;
	private String to;
	private BigDecimal conversionFactor;
	private BigDecimal quantityToConvert;
	private BigDecimal convertedQuantity;
	private int port;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(BigDecimal conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	public BigDecimal getQuantityToConvert() {
		return quantityToConvert;
	}
	public void setQuantityToConvert(BigDecimal quantityToConvert) {
		this.quantityToConvert = quantityToConvert;
	}
	public BigDecimal getConvertedQuantity() {
		return convertedQuantity;
	}
	public void setConvertedQuantity(BigDecimal convertedQuantity) {
		this.convertedQuantity = convertedQuantity;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
}
