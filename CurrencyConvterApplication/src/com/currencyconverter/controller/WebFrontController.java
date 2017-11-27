package com.currencyconverter.controller;

import java.math.BigDecimal;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.currencyconverter.action.CurrencyConverterAction;
import com.currencyconverter.action.LoginAction;
import com.currencyconverter.action.RegisterAction;
import com.currencyconverter.enums.CurrencyConversionType;
import com.currencyconverter.model.CurrencyConvertData;
import com.currencyconverter.model.LoginFormData;
import com.currencyconverter.model.RegisterFormData;
import com.currencyconverter.model.UserData;
import com.currencyconverter.view.CurrencyConverterPageData;
import com.currencyconverter.view.FormErrorMessages;

/**
 * @author abhishek.kotalwar
 *
 */
@Controller
public class WebFrontController {
	private static final String LOGIN_URL = "/login";
	private static final String REGISTER_URL = "/register";
	private static final String VERIFY_LOGIN_URL = "/loginVerify";
	private static final String VERIFY_REGISTRATION_URL = "/registrationVerify";
	private static final String CURRENCY_CONVERTER_URL = "/currencyconverter";
	private static final String LOG_OUT_URL = "/logout";

	@Inject
	private LoginAction loginAction;
	@Inject
	private RegisterAction registerAction;
	@Inject
	private CurrencyConverterAction currencyConverterAction;

	@RequestMapping(LOGIN_URL)
	public ModelAndView userLogin() {
		return new ModelAndView("login");
	}

	@RequestMapping(LOG_OUT_URL)
	public ModelAndView userLogout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		loginAction.userLogOut(session, response);
		return new ModelAndView("login", "message", "Loged out sccessfully.");
	}

	@RequestMapping(REGISTER_URL)
	public ModelAndView userRegistration() {
		return new ModelAndView("registration");
	}

	@RequestMapping(CURRENCY_CONVERTER_URL)
	public ModelAndView currencyConverter(
			@Valid @ModelAttribute("currencyConvertData") CurrencyConvertData currencyConvertData, BindingResult result,
			HttpSession session) {
		String userName = (String) session.getAttribute("userName");

		if (null == userName) {
			return new ModelAndView("sessionTimeout", "errorMessage", "Sesssion Expired Please login again.");
		} else {
			if (result.hasErrors()) {
				CurrencyConverterPageData currencyConverterPageData = currencyConverterAction
						.getValidationFailedData(userName);
				return new ModelAndView("currencyConverterValidationFailed", "pageData", currencyConverterPageData);
			} else {
				if (currencyConvertData.getType().equalsIgnoreCase(CurrencyConversionType.HISTORY.getDescription())) {
					FormErrorMessages formErrorMessages = currencyConverterAction
							.validateCurrencyData(currencyConvertData);
					if (formErrorMessages.getDateMessage() != null) {
						CurrencyConverterPageData currencyConverterPageData = currencyConverterAction.getCurrencyConverterValidationFailedData(userName, formErrorMessages);
						return new ModelAndView("currencyConverterDateValidationFailed", "pageData",
								currencyConverterPageData);
					}
				}
				BigDecimal conversionResult = currencyConverterAction.getResult(currencyConvertData);
				currencyConverterAction.persistCurrencyConversionData(conversionResult, currencyConvertData, userName);
				CurrencyConverterPageData extractCurrencyConverterPageData = currencyConverterAction
						.extractCurrencyConverterPageData(conversionResult, currencyConvertData, userName);
				return new ModelAndView("currencyConversionSuccess", "pageData", extractCurrencyConverterPageData);
			}
		}
	}

	@RequestMapping(VERIFY_LOGIN_URL)
	public ModelAndView handleLoginForm(@Valid @ModelAttribute("loginFormData") LoginFormData loginFormData,
			BindingResult result, HttpSession session, HttpServletRequest request) {
		if (result.hasErrors()) {
			return new ModelAndView("loginFailIncompleteData");
		} else {
			UserData user = loginAction.getUserByUserName(loginFormData.getUserName());
			if (user == null) {
				return new ModelAndView("loginFailUserNotFound", "errorMessage",
						"Please enter correct username or passoword");
			}
		}
		CurrencyConverterPageData currencyConverterPageData = loginAction.userLoggedIn(loginFormData, session, request);
		return new ModelAndView("currencyConverterForm", "pageData", currencyConverterPageData);
	}

	/**
	 * @param registerFormData
	 * @param result
	 * @return
	 */
	@RequestMapping(VERIFY_REGISTRATION_URL)
	public ModelAndView handleRegisterForm(@Valid @ModelAttribute("registerFormData") RegisterFormData registerFormData,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("registrationFailed");
		} else {
			FormErrorMessages formErrorMessages = registerAction.validateRegistrationData(registerFormData);

			if (formErrorMessages.getDuplicateUser() != null || formErrorMessages.getEmailExist() != null
					|| formErrorMessages.getPassowrdNotmatch() != null) {
				return new ModelAndView("registrationFailedDataError", "errorMessage", formErrorMessages);
			} else {
				registerAction.registerUser(registerFormData);
				return new ModelAndView("login", "message", "Registration success.");
			}
		}
	}
}
