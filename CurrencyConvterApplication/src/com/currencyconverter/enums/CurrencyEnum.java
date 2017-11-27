/**
 * 
 */
package com.currencyconverter.enums;

/**
 * @author abhishek.kotalwar
 *
 */
public enum CurrencyEnum {
	INR("INR", "Indian Rupee (INR)"),
    EUR("EUR", "Euro (EUR)"),
	AUD("AUD", "Australian Dollar (AUD)"),
    JPY("JPY", "Japanese Yen (JPY)"),
    HUF("HUF", "Hungarian Forint (HUF)"),
    USD("USD", "US Dollar (USD)"),
    GBP("GBP", "British Pound (GBP)"),
    NZD("NZD", "New Zealand Dollar (NZD)"),
    RUB("RUB", "Russian Ruble (RUB)"),
    PLN("PLN", "Polish Zloty (PLN)");
	
    private final String code;
    private final String description;

    CurrencyEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
