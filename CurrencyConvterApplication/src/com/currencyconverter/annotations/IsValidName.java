package com.currencyconverter.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;

/**
 * @author abhishek.kotalwar
 *
 */
@Documented
@Target(value = ElementType.FIELD)
@Constraint(validatedBy = NameValidator.class)
@Retention(RetentionPolicy.RUNTIME)

public @interface IsValidName {

	String message() default "Wrong data for string field";

	String messageWrongPattern() default "Please provide the Valid Value";

	String messageNotEmpty() default "Field can't be empty";

	String messageLength() default "Please provide the Valid Value";

	boolean notEmpty() default true;

	int min() default 1;

	int max() default 30;

	Class<?>[] groups() default {};

	Class<?>[] payload() default {};
}