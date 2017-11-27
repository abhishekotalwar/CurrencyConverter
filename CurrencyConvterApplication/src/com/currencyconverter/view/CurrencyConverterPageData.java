/**
 * 
 */
package com.currencyconverter.view;

import java.math.BigDecimal;
import java.util.List;

import com.currencyconverter.enums.CurrencyEnum;
import com.currencyconverter.model.CurrencyTransactionHistory;

/**
 * @author abhishek.kotalwar
 *
 */
public class CurrencyConverterPageData {
	private List<CurrencyEnum> currencyList;
	private FormErrorMessages message;
	private BigDecimal result;
	private List<CurrencyTransactionHistory> historyList;
	private String sourceCurrency;
	private String destinationCurrency;
	private BigDecimal inputAmount;

	/**
	 * @return the sourceCurrency
	 */
	public String getSourceCurrency() {
		return sourceCurrency;
	}

	/**
	 * @param sourceCurrency
	 *            the sourceCurrency to set
	 */
	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}

	/**
	 * @return the destinationCurrency
	 */
	public String getDestinationCurrency() {
		return destinationCurrency;
	}

	/**
	 * @param destinationCurrency
	 *            the destinationCurrency to set
	 */
	public void setDestinationCurrency(String destinationCurrency) {
		this.destinationCurrency = destinationCurrency;
	}

	/**
	 * @return the currencyList
	 */
	public List<CurrencyEnum> getCurrencyList() {
		return currencyList;
	}

	/**
	 * @param currencyList
	 *            the currencyList to set
	 */
	public void setCurrencyList(List<CurrencyEnum> currencyList) {
		this.currencyList = currencyList;
	}

	/**
	 * @return the message
	 */
	public FormErrorMessages getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(FormErrorMessages message) {
		this.message = message;
	}

	/**
	 * @return the result
	 */
	public BigDecimal getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(BigDecimal result) {
		this.result = result;
	}

	/**
	 * @return the historyList
	 */
	public List<CurrencyTransactionHistory> getHistoryList() {
		return historyList;
	}

	/**
	 * @param historyList
	 *            the historyList to set
	 */
	public void setHistoryList(List<CurrencyTransactionHistory> historyList) {
		this.historyList = historyList;
	}

	/**
	 * @return the inputAmount
	 */
	public BigDecimal getInputAmount() {
		return inputAmount;
	}

	/**
	 * @param inputAmount
	 *            the inputAmount to set
	 */
	public void setInputAmount(BigDecimal inputAmount) {
		this.inputAmount = inputAmount;
	}

}
