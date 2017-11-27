package com.currencyconverter.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author abhishek.kotalwar
 *
 */
public class NameValidator implements ConstraintValidator<IsValidName, String> {

	private Boolean notEmpty;
	private Integer min;
	private Integer max;
	private String messageNotEmpty;
	private String messageLength;
	private String wrongPatternValue;

	public void initialize(IsValidName field) {
		notEmpty = field.notEmpty();
		min = field.min();
		max = field.max();
		messageNotEmpty = field.messageNotEmpty();
		messageLength = field.messageLength();
		wrongPatternValue = field.messageWrongPattern();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		if (notEmpty && value.isEmpty()) {
			context.buildConstraintViolationWithTemplate(messageNotEmpty).addConstraintViolation();
			return false;
		}

		if (!(value.length() > min || value.length() < max)) {
			context.buildConstraintViolationWithTemplate(messageLength).addConstraintViolation();
			return false;
		}

		if (!value.matches("^[a-z,A-Z]+")) {
			context.buildConstraintViolationWithTemplate(wrongPatternValue).addConstraintViolation();
			return false;
		}

		return true;
	}

}
