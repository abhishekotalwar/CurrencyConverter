/**
 * 
 */
package com.currencyconverter.mediator.impl;

import java.math.BigDecimal;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.currencyconverter.activity.CurrencyConverterActivity;
import com.currencyconverter.mediator.CurrencyConvertMediator;
import com.currencyconverter.model.CurrencyConvertData;
import com.currencyconverter.view.CurrencyConverterPageData;
import com.currencyconverter.view.FormErrorMessages;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class CurrencyConverterMediatorImpl implements CurrencyConvertMediator {
	@Inject
	private CurrencyConverterActivity currencyConverterActivity;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CurrencyConverterPageData getValidationFailedData(String userName ) {
		return currencyConverterActivity.getValidationFailedData(userName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FormErrorMessages validateCurrencyData(CurrencyConvertData currencyConvertData) {
		return currencyConverterActivity.validateCurrencyData(currencyConvertData);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void persistCurrencyConversionData(BigDecimal conversionResult, CurrencyConvertData currencyConvertData,
			String userName) {
		currencyConverterActivity.persistCurrencyConversionData(conversionResult, currencyConvertData, userName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CurrencyConverterPageData extractCurrencyConverterPageData(BigDecimal conversionResult,
			CurrencyConvertData currencyConvertData, String userName) {
		return currencyConverterActivity.extractCurrencyConverterPageData(conversionResult, currencyConvertData, userName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getResult(CurrencyConvertData currencyConvertData) {
		return currencyConverterActivity.getResult(currencyConvertData);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CurrencyConverterPageData getCurrencyConverterValidationFailedData(String userName, FormErrorMessages formErrorMessages) {
		return currencyConverterActivity.getCurrencyConverterValidationFailedData(userName, formErrorMessages);
	}
}
