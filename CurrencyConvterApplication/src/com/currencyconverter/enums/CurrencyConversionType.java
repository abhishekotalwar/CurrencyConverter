/**
 * 
 */
package com.currencyconverter.enums;

/**
 * @author abhishek.kotalwar
 *
 */
public enum CurrencyConversionType {
	CURRENT("C", "Current"), HISTORY("H", "History");

	private final String type;
	private final String description;

	CurrencyConversionType(String type, String description) {
		this.type = type;
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}
}
