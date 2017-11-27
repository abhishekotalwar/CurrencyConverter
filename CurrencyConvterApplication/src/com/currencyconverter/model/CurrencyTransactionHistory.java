/**
 * 
 */
package com.currencyconverter.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author abhishek.kotalwar
 *
 */
@Entity
@Table
public class CurrencyTransactionHistory implements Serializable {
	private static final long serialVersionUID = 885161577144716049L;
	@Id
	@GeneratedValue
	private int id;
	private String sourceCurrency;
	private String destinationCurrency;
	private String dateValue;
	private BigDecimal amount;
	private String userName;
	private String conversionType;
	private BigDecimal convertedAmount;

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
	 * @return the date
	 */
	public String getDateValue() {
		return dateValue;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDateValue(String date) {
		dateValue = date;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the conversionType
	 */
	public String getConversionType() {
		return conversionType;
	}

	/**
	 * @param conversionType
	 *            the conversionType to set
	 */
	public void setConversionType(String conversionType) {
		this.conversionType = conversionType;
	}

	/**
	 * @return the convertedAmount
	 */
	public BigDecimal getConvertedAmount() {
		return convertedAmount;
	}

	/**
	 * @param convertedAmount
	 *            the convertedAmount to set
	 */
	public void setConvertedAmount(BigDecimal convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
