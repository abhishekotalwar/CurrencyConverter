/**
 * 
 */
package com.currencyconverter.action.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.currencyconverter.action.RegisterAction;
import com.currencyconverter.mediator.RegisterMediator;
import com.currencyconverter.model.RegisterFormData;
import com.currencyconverter.view.FormErrorMessages;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class RegisterActionImpl implements RegisterAction {
	@Inject
	private RegisterMediator registerMediator;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FormErrorMessages validateRegistrationData(RegisterFormData registerFormData) {
		return registerMediator.validateRegistrationData(registerFormData);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registerUser(RegisterFormData registerFormData) {
		registerMediator.registerUser(registerFormData);
	}

}
