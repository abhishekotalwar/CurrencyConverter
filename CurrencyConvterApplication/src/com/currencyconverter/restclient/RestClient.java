package com.currencyconverter.restclient;

import java.math.BigDecimal;
import java.util.Calendar;
import com.currencyconverter.enums.CurrencyEnum;

/**
 * @author abhishek.kotalwar
 *
 */
public interface RestClient {
	/**
	 * This method will return the current exchange rate
	 * 
	 * @param currecnyFrom
	 * @param currecnyTo
	 * @return
	 */
	BigDecimal getCurrentExchangeRates(CurrencyEnum currecnyFrom, CurrencyEnum currecnyTo);

	/**
	 * This method will return the historical exchange rate
	 * 
	 * @param currencyFrom
	 * @param currencyTo
	 * @param calendar
	 * @return
	 */
	BigDecimal getHistoricalExchangeRates(CurrencyEnum currencyFrom, CurrencyEnum currencyTo, Calendar calendar);
}
