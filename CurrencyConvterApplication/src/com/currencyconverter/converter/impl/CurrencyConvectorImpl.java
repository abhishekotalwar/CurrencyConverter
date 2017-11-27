/**
 * 
 */
package com.currencyconverter.converter.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.currencyconverter.converter.CurrencyConvector;
import com.currencyconverter.enums.CurrencyConversionType;
import com.currencyconverter.enums.CurrencyEnum;
import com.currencyconverter.restclient.RestClient;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class CurrencyConvectorImpl implements CurrencyConvector {
	@Inject
	RestClient restClient;

	/*
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getConvertedValue(String type, BigDecimal amount, CurrencyEnum sourceCurrency,
			CurrencyEnum destinationCurrency, Calendar calendar) {

		if (type.equalsIgnoreCase(CurrencyConversionType.HISTORY.getDescription())) {
			return getConvertedHistoricalValue(amount, sourceCurrency, destinationCurrency, calendar);
		} else {
			return getConvertedCurrentValue(amount, sourceCurrency, destinationCurrency);
		}
	}

	private BigDecimal getConvertedCurrentValue(BigDecimal amount, CurrencyEnum sourceCurrency,
			CurrencyEnum destinationCurrency) {
		return amount.multiply(restClient.getCurrentExchangeRates(sourceCurrency, destinationCurrency));
	}

	private BigDecimal getConvertedHistoricalValue(BigDecimal amount, CurrencyEnum sourceCurrency,
			CurrencyEnum destinationCurrency, Calendar calendar) {
		return amount.multiply(restClient.getHistoricalExchangeRates(sourceCurrency, destinationCurrency, calendar));
	}

}
