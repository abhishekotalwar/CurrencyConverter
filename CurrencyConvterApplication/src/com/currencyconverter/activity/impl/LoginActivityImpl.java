/**
 * 
 */
package com.currencyconverter.activity.impl;

import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import com.currencyconverter.activity.LoginActivity;
import com.currencyconverter.enums.CurrencyEnum;
import com.currencyconverter.model.CurrencyTransactionHistory;
import com.currencyconverter.model.LoginFormData;
import com.currencyconverter.model.UserData;
import com.currencyconverter.service.CurrencyTransactionHistoryService;
import com.currencyconverter.service.UserService;
import com.currencyconverter.view.CurrencyConverterPageData;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class LoginActivityImpl implements LoginActivity {

	@Inject
	CurrencyTransactionHistoryService currencyTransactionHistoryService;
	@Inject
	UserService userService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void userLogOut(HttpSession session, HttpServletResponse response) {
		session.removeAttribute("userName");
		session.invalidate();
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CurrencyConverterPageData userLoggedIn(LoginFormData loginFormData, HttpSession session,
			HttpServletRequest request) {
		session = request.getSession();
		session.setAttribute("userName", loginFormData.getUserName());

		List<CurrencyEnum> currencyList = Arrays.asList(CurrencyEnum.values());

		List<CurrencyTransactionHistory> listOfHistryTranscation = currencyTransactionHistoryService
				.findLast10CurrencyTransactionHistory(loginFormData.getUserName());

		CurrencyConverterPageData currencyConverterPageData = new CurrencyConverterPageData();
		currencyConverterPageData.setCurrencyList(currencyList);
		currencyConverterPageData.setHistoryList(listOfHistryTranscation);
		return currencyConverterPageData;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserData getUserByUserName(String userName) {
		UserData user = userService.getUserByUserName(userName);
		return user;
	}
}
