/**
 * 
 */
package com.currencyconverter.mediator.impl;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.currencyconverter.activity.RegisterActivity;
import com.currencyconverter.mediator.RegisterMediator;
import com.currencyconverter.model.RegisterFormData;
import com.currencyconverter.view.FormErrorMessages;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class RegisterMediatorImpl implements RegisterMediator {
	@Inject
	private RegisterActivity registerActivity;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FormErrorMessages validateRegistrationData(RegisterFormData registerFormData) {
		return registerActivity.validateRegistrationData(registerFormData);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registerUser(RegisterFormData registerFormData) {
		registerActivity.registerUser(registerFormData);
	}

}
