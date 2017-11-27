/**
 * 
 */
package com.currencyconverter.enums;

/**
 * @author abhishek.kotalwar
 *
 */
public enum ErrorMessages {
	DUPLICATE_USER(0, "Username already exists"),
    PASSWORD_NOT_MATCH(1, "Password not match"),
	DUPLICATE_EMAIL(2, "Email already exists"),
	INVALID_DATE(3,"Invalid date"),
	PAST_DATE(4,"Enter past date");
	
    
    private final int code;
    private final String errorMessage;

    ErrorMessages(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
