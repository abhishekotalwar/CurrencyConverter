/**
 * 
 */
package com.currencyconverter.model;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author abhishek.kotalwar
 *
 */
public class CurrencyConvertData {
	@NotEmpty
	private String sourceCurrency;
	@NotEmpty
	private String destinationCurrency;
	@NotNull
	private BigDecimal amount = new BigDecimal(0.0);
	@NotEmpty
	private String type;
	private String dateValue;

	/**
	 * @return the dateValue
	 */
	public String getDateValue() {
		return dateValue;
	}

	/**
	 * @param dateValue
	 *            the dateValue to set
	 */
	public void setDateValue(String dateValue) {
		this.dateValue = dateValue;
	}

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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
