/**
 * 
 */
package com.currencyconverter.action.impl;

import java.math.BigDecimal;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.currencyconverter.action.CurrencyConverterAction;
import com.currencyconverter.mediator.CurrencyConvertMediator;
import com.currencyconverter.model.CurrencyConvertData;
import com.currencyconverter.view.CurrencyConverterPageData;
import com.currencyconverter.view.FormErrorMessages;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class CurrencyConverterActionImpl implements CurrencyConverterAction {

	@Inject
	private CurrencyConvertMediator currencyConvertMediator;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CurrencyConverterPageData getValidationFailedData(String userName) {
		return currencyConvertMediator.getValidationFailedData(userName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FormErrorMessages validateCurrencyData(CurrencyConvertData currencyConvertData) {
		return currencyConvertMediator.validateCurrencyData(currencyConvertData);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void persistCurrencyConversionData(BigDecimal conversionResult, CurrencyConvertData currencyConvertData,
			String userName) {
		currencyConvertMediator.persistCurrencyConversionData(conversionResult, currencyConvertData, userName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CurrencyConverterPageData extractCurrencyConverterPageData(BigDecimal conversionResult,
			CurrencyConvertData currencyConvertData, String userName) {
		return currencyConvertMediator.extractCurrencyConverterPageData(conversionResult, currencyConvertData,
				userName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getResult(CurrencyConvertData currencyConvertData) {
		return currencyConvertMediator.getResult(currencyConvertData);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CurrencyConverterPageData getCurrencyConverterValidationFailedData(String userName, FormErrorMessages formErrorMessages) {
		return currencyConvertMediator.getCurrencyConverterValidationFailedData(userName, formErrorMessages);	
	}
}
