/**
 * 
 */
package com.currencyconverter.activity.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.currencyconverter.activity.CurrencyConverterActivity;
import com.currencyconverter.common.DateUtils;
import com.currencyconverter.converter.CurrencyConvector;
import com.currencyconverter.enums.CurrencyConversionType;
import com.currencyconverter.enums.CurrencyEnum;
import com.currencyconverter.enums.ErrorMessages;
import com.currencyconverter.model.CurrencyConvertData;
import com.currencyconverter.model.CurrencyTransactionHistory;
import com.currencyconverter.service.CurrencyTransactionHistoryService;
import com.currencyconverter.view.CurrencyConverterPageData;
import com.currencyconverter.view.FormErrorMessages;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class CurrencyConverterActivityImpl implements CurrencyConverterActivity {
	private static final String VALID_DATE = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";

	@Inject
	CurrencyTransactionHistoryService currencyTransactionHistoryService;
	@Inject
	CurrencyConvector currencyConvector;

	@Override
	public CurrencyConverterPageData getValidationFailedData(String userName) {
		List<CurrencyEnum> currencyList = Arrays.asList(CurrencyEnum.values());
		List<CurrencyTransactionHistory> listOfHistryTranscation = currencyTransactionHistoryService
				.findLast10CurrencyTransactionHistory(userName);

		CurrencyConverterPageData currencyConverterPageData = new CurrencyConverterPageData();
		currencyConverterPageData.setCurrencyList(currencyList);
		currencyConverterPageData.setHistoryList(listOfHistryTranscation);

		return currencyConverterPageData;
	}

	@Override
	public FormErrorMessages validateCurrencyData(CurrencyConvertData currencyConvertData) {
		FormErrorMessages formErrorMessages = new FormErrorMessages();

		if (currencyConvertData.getDateValue() == null || currencyConvertData.getDateValue().isEmpty()
				|| !currencyConvertData.getDateValue().matches(VALID_DATE)) {
			formErrorMessages.setDateMessage(ErrorMessages.INVALID_DATE.getErrorMessage());
		} else {
			Date date = DateUtils.getFormattedDate_YYYY_MM_DD((currencyConvertData.getDateValue()));
			LocalDateTime now = LocalDateTime.now();
			Date dateToday = DateUtils.getFormattedDate_YYYY_MM_DD(now.toString());
			if (!date.before(dateToday)) {
				formErrorMessages.setDateMessage(ErrorMessages.PAST_DATE.getErrorMessage());
			}
		}

		return formErrorMessages;
	}

	@Override
	public void persistCurrencyConversionData(BigDecimal conversionResult, CurrencyConvertData currencyConvertData,
			String userName) {
		CurrencyTransactionHistory currencyTransactionHistory = new CurrencyTransactionHistory();
		currencyTransactionHistory.setAmount(currencyConvertData.getAmount());
		currencyTransactionHistory.setConvertedAmount(conversionResult.setScale(2, BigDecimal.ROUND_HALF_EVEN));
		currencyTransactionHistory.setConversionType(currencyConvertData.getType());
		currencyTransactionHistory.setDateValue(currencyConvertData.getDateValue());
		currencyTransactionHistory.setSourceCurrency(currencyConvertData.getSourceCurrency());
		currencyTransactionHistory.setDestinationCurrency(currencyConvertData.getDestinationCurrency());
		currencyTransactionHistory.setUserName(userName);
		currencyTransactionHistoryService.save(currencyTransactionHistory);
	}

	@Override
	public CurrencyConverterPageData extractCurrencyConverterPageData(BigDecimal conversionResult,
			CurrencyConvertData currencyConvertData, String userName) {
		List<CurrencyEnum> currencyList = Arrays.asList(CurrencyEnum.values());
		List<CurrencyTransactionHistory> listOfHistryTranscation = currencyTransactionHistoryService
				.findLast10CurrencyTransactionHistory(userName);

		CurrencyConverterPageData currencyConverterPageData = new CurrencyConverterPageData();
		currencyConverterPageData.setCurrencyList(currencyList);
		currencyConverterPageData.setResult(conversionResult.setScale(2, BigDecimal.ROUND_HALF_EVEN));
		currencyConverterPageData.setHistoryList(listOfHistryTranscation);
		currencyConverterPageData.setSourceCurrency(currencyConvertData.getSourceCurrency());
		currencyConverterPageData.setDestinationCurrency(currencyConvertData.getDestinationCurrency());
		currencyConverterPageData.setInputAmount(currencyConvertData.getAmount());
		return currencyConverterPageData;
	}

	@Override
	public BigDecimal getResult(CurrencyConvertData currencyConvertData) {
		Calendar cal = Calendar.getInstance();
		if (currencyConvertData.getType() != null
				&& CurrencyConversionType.HISTORY.getDescription().equalsIgnoreCase(currencyConvertData.getType())) {
			cal.setTime(DateUtils.getFormattedDate_YYYY_MM_DD(currencyConvertData.getDateValue()));
		}

		return currencyConvector.getConvertedValue(currencyConvertData.getType(), currencyConvertData.getAmount(),
				CurrencyEnum.valueOf(currencyConvertData.getSourceCurrency()),
				CurrencyEnum.valueOf(currencyConvertData.getDestinationCurrency()), cal);
	}

	@Override
	public CurrencyConverterPageData getCurrencyConverterValidationFailedData(String userName, FormErrorMessages formErrorMessages) {
		List<CurrencyEnum> currencyList = Arrays.asList(CurrencyEnum.values());
		List<CurrencyTransactionHistory> listOfHistryTranscation = currencyTransactionHistoryService
				.findLast10CurrencyTransactionHistory(userName);
		
		CurrencyConverterPageData currencyConverterPageData = new CurrencyConverterPageData();
		currencyConverterPageData.setCurrencyList(currencyList);
		currencyConverterPageData.setMessage(formErrorMessages);
		currencyConverterPageData.setHistoryList(listOfHistryTranscation);
		
		return currencyConverterPageData;
	}

}
