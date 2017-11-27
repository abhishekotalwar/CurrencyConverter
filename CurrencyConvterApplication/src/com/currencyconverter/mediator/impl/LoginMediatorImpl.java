/**
 * 
 */
package com.currencyconverter.mediator.impl;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import com.currencyconverter.activity.LoginActivity;
import com.currencyconverter.mediator.LoginMediator;
import com.currencyconverter.model.LoginFormData;
import com.currencyconverter.model.UserData;
import com.currencyconverter.view.CurrencyConverterPageData;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class LoginMediatorImpl implements LoginMediator {

	@Inject
	private LoginActivity loginActivity;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void userLogOut(HttpSession session, HttpServletResponse response) {
		loginActivity.userLogOut(session, response);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CurrencyConverterPageData userLoggedIn(LoginFormData loginFormData, HttpSession session, HttpServletRequest request) {
		return loginActivity.userLoggedIn(loginFormData, session, request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserData getUserByUserName(String userName) {
		return loginActivity.getUserByUserName(userName);
	}
}
