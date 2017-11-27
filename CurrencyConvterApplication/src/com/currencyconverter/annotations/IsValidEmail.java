package com.currencyconverter.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;

/**
 * @author abhishek.kotalwar
 *
 */
@Documented
@Constraint(validatedBy = EmailValidator.class)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface IsValidEmail {
	String message() default "Wrong data for Email field";

	String messageWrongEmail() default "Please provide the Valid Email";

	String messageNotEmpty() default "Field can't be empty";

	boolean notEmpty() default true;

	Class<?>[] groups() default {};

	Class<?>[] payload() default {};
}
