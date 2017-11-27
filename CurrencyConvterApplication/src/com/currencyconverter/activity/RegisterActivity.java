/**
 * 
 */
package com.currencyconverter.activity;

import com.currencyconverter.model.RegisterFormData;
import com.currencyconverter.view.FormErrorMessages;

/**
 * @author abhishek.kotalwar
 *
 */
public interface RegisterActivity {

	/**
	 * This method is used to validate registration for data
	 * 
	 * @param registerFormData
	 * @return
	 */
	public FormErrorMessages validateRegistrationData(RegisterFormData registerFormData);

	/**
	 * This method will used to register user date
	 * 
	 * @param registerFormData
	 */
	public void registerUser(RegisterFormData registerFormData);

}
