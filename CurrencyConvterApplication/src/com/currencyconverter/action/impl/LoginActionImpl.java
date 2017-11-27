/**
 * 
 */
package com.currencyconverter.action.impl;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import com.currencyconverter.action.LoginAction;
import com.currencyconverter.mediator.LoginMediator;
import com.currencyconverter.model.LoginFormData;
import com.currencyconverter.model.UserData;
import com.currencyconverter.view.CurrencyConverterPageData;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class LoginActionImpl implements LoginAction{
	@Inject
	private LoginMediator loginMediator;

	/**
	 * {@inheritDoc}
	 */
	public void userLogOut(HttpSession session, HttpServletResponse response) {
		loginMediator.userLogOut(session, response);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CurrencyConverterPageData userLoggedIn(LoginFormData loginFormData, HttpSession session, HttpServletRequest request) {
		return loginMediator.userLoggedIn(loginFormData, session, request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserData getUserByUserName(String userName) {
		return loginMediator.getUserByUserName(userName);
	}
}
