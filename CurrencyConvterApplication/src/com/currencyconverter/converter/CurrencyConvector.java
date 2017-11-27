package com.currencyconverter.converter;

import java.math.BigDecimal;
import java.util.Calendar;

import com.currencyconverter.enums.CurrencyEnum;

/**
 * @author abhishek.kotalwar
 *
 */
public interface CurrencyConvector {
	/**
	 * This method will provide the converted value
	 * 
	 * @param type
	 * @param amount
	 * @param currencyFrom
	 * @param currencyTo
	 * @param calendar
	 * @return
	 */
	BigDecimal getConvertedValue(String type, BigDecimal amount, CurrencyEnum sourceCurrency,
			CurrencyEnum destinationCurrency, Calendar calendar);
}
