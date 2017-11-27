package com.currencyconverter.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author abhishek.kotalwar
 *
 */
public class EmailValidator implements ConstraintValidator<IsValidEmail, String> {

	private boolean notEmpty;
	private String messageNotEmpty;
	private String messageWrongEmail;

	public void initialize(IsValidEmail field) {
		// TODO Auto-generated method stub
		notEmpty = field.notEmpty();
		messageNotEmpty = field.messageNotEmpty();
		messageWrongEmail = field.messageWrongEmail();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		if (notEmpty && value.isEmpty()) {
			context.buildConstraintViolationWithTemplate(messageNotEmpty).addConstraintViolation();
			return false;
		}

		else if (!value.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			context.buildConstraintViolationWithTemplate(messageWrongEmail).addConstraintViolation();
			return false;
		}

		return true;
	}

}
