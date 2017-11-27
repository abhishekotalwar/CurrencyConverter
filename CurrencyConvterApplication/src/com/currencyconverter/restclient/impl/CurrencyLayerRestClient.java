package com.currencyconverter.restclient.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import com.currencyconverter.enums.CurrencyEnum;
import com.currencyconverter.restclient.RestClient;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import static java.math.BigDecimal.ROUND_FLOOR;

/**
 * @author abhishek.kotalwar
 *
 */
@Service("CurrencyLayer")
public class CurrencyLayerRestClient implements RestClient {
	private final static String URL_CURRENT = "http://www.apilayer.net/api/live?format=1";
	private final static String URL_HISTORY = "http://apilayer.net/api/historical?date=";
	private final static String API_ID = "0a539788fe3cb5711ad193590bebea39";
	private final static String API_ID_PRM = "&access_key=";
	private static final String ERROR_WHILE_GATHERING_INFORMATION = "Error while gathering information from CurrencyLayer services";

	public BigDecimal getCurrentExchangeRates(CurrencyEnum sourceCurrency, CurrencyEnum destinationCurrency) {
		return getExchangeRates(sourceCurrency, destinationCurrency, getCurrentRates());
	}

	public BigDecimal getHistoricalExchangeRates(CurrencyEnum sourceCurrency, CurrencyEnum currencyTo,
			Calendar calendar) {
		return getExchangeRates(sourceCurrency, currencyTo, getHistoricalRates(calendar));
	}

	private BigDecimal getExchangeRates(CurrencyEnum sourceCurrency, CurrencyEnum destinationCurrency,
			CurrencyLayerRatesContainer rates) {
		BigDecimal sourceCurrencyRate = getRates(sourceCurrency, rates);
		BigDecimal destinationCurrencyRate = getRates(destinationCurrency, rates);
		return destinationCurrencyRate.divide(sourceCurrencyRate, 20, ROUND_FLOOR);
	}

	public CurrencyLayerRatesContainer getCurrentRates() {
		return getEntity(URL_CURRENT, API_ID, CurrencyLayerRatesContainer.class);
	}

	public CurrencyLayerRatesContainer getHistoricalRates(Calendar date) {
		return getEntity(
				URL_HISTORY + date.get(Calendar.YEAR) + "-" + getStringWithLeftPadZero(date.get(Calendar.MONTH) + 1)
						+ "-" + getStringWithLeftPadZero(date.get(Calendar.DAY_OF_MONTH)),
				API_ID, CurrencyLayerRatesContainer.class);
	}

	private String getStringWithLeftPadZero(int number) {
		return String.format("%02d", number);
	}

	private static BigDecimal getRates(CurrencyEnum currency, CurrencyLayerRatesContainer rates) {
		if (rates.getQuotes() == null) {
			throw new RestClientException(ERROR_WHILE_GATHERING_INFORMATION + (rates.getError() != null
					? ", code:" + rates.getError().getCode() + ", error:" + rates.getError().getInfo() : ""));
		} else {
			String rate = rates.getQuotes().get("USD" + currency.getCode());
			return new BigDecimal(rate);
		}
	}

	private static <T> T getEntity(String url, String api, Class<T> entityClass) {
		Response response = null;
		try {
			Client client = ClientBuilder.newBuilder().build();
			response = client.target(url + API_ID_PRM + api).request().get();
			return response.readEntity(entityClass);
		} catch (Exception exp) {
			throw new RestClientException(ERROR_WHILE_GATHERING_INFORMATION + ", error: "
					+ (response != null ? response.getStatusInfo() : exp.getMessage()));
		} finally {
			if (response != null) {
				response.close();
			}
		}
	}

}
