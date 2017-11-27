/**
 * 
 */
package com.currencyconverter.activity.impl;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.currencyconverter.activity.RegisterActivity;
import com.currencyconverter.enums.ErrorMessages;
import com.currencyconverter.model.RegisterFormData;
import com.currencyconverter.model.UserData;
import com.currencyconverter.service.UserService;
import com.currencyconverter.view.FormErrorMessages;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class RegisterActivityImpl implements RegisterActivity {
	@Inject
	private UserService userService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FormErrorMessages validateRegistrationData(RegisterFormData registerFormData) {
		FormErrorMessages registerFormDataErrorMessages = new FormErrorMessages();

		UserData userNameFromDatabase = userService.getUserByUserName(registerFormData.getUserName());

		UserData emailFromDatabase = userService.getUserByEmail(registerFormData.getEmail());

		Boolean isPasswordMatch = Boolean.FALSE;
		if (registerFormData.getPassword().equalsIgnoreCase(registerFormData.getReEnterPassword())) {
			isPasswordMatch = Boolean.TRUE;
		}

		if (userNameFromDatabase != null) {
			registerFormDataErrorMessages.setDuplicateUser(ErrorMessages.DUPLICATE_EMAIL.getErrorMessage());
		}

		if (emailFromDatabase != null) {
			registerFormDataErrorMessages.setEmailExist(ErrorMessages.DUPLICATE_EMAIL.getErrorMessage());
		}

		if (!isPasswordMatch) {
			registerFormDataErrorMessages.setPassowrdNotmatch(ErrorMessages.PASSWORD_NOT_MATCH.getErrorMessage());
		}

		return registerFormDataErrorMessages;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registerUser(RegisterFormData registerFormData) {
		UserData userData = new UserData();
		userData.setEmail(registerFormData.getEmail());
		userData.setFirstName(registerFormData.getFirstName());
		userData.setLastName(registerFormData.getLastName());
		userData.setPassword(registerFormData.getPassword());
		userData.setUserName(registerFormData.getUserName());
		userService.save(userData);
	}
}
