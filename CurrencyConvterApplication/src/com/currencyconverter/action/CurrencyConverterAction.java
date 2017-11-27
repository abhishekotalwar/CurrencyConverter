/**
 * 
 */
package com.currencyconverter.action;

import java.math.BigDecimal;
import com.currencyconverter.model.CurrencyConvertData;
import com.currencyconverter.view.CurrencyConverterPageData;
import com.currencyconverter.view.FormErrorMessages;

/**
 * @author abhishek.kotalwar
 *
 */
public interface CurrencyConverterAction {

	/**
	 * This method will return the validation failed data which will used to
	 * while rendering front end.
	 * 
	 * @param userName
	 * 
	 * @return
	 */
	public CurrencyConverterPageData getValidationFailedData(String userName);

	/**
	 * This method will validate currency data
	 * 
	 * @param currencyConvertData
	 * @param userName
	 * @return
	 */
	public FormErrorMessages validateCurrencyData(CurrencyConvertData currencyConvertData);

	/**
	 * This method will store the conversion data
	 * 
	 * @param conversionResult
	 * @param currencyConvertData
	 * @param userName
	 */
	public void persistCurrencyConversionData(BigDecimal conversionResult, CurrencyConvertData currencyConvertData,
			String userName);

	/**
	 * This method will return the conversion data while will used while
	 * rendering front end.
	 * 
	 * @param conversionResult
	 * @param currencyConvertData
	 * @param userName
	 * @return
	 */
	public CurrencyConverterPageData extractCurrencyConverterPageData(BigDecimal conversionResult,
			CurrencyConvertData currencyConvertData, String userName);

	/**
	 * This method will the converted amount
	 * 
	 * @param currencyConvertData
	 * @return
	 */
	public BigDecimal getResult(CurrencyConvertData currencyConvertData);

	/**
	 * This method will return the error message data to display on front end
	 * 
	 * @param userName
	 * @param formErrorMessages
	 * @return
	 */
	public CurrencyConverterPageData getCurrencyConverterValidationFailedData(String userName, FormErrorMessages formErrorMessages);

}
