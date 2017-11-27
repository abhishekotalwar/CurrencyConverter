package com.currencyconverter.restclient.impl;

import java.util.Map;

/**
 * @author abhishek.kotalwar
 *
 */
public class CurrencyLayerRatesContainer {
	private Boolean success;
	private String terms;
	private String privacy;
	private Boolean historical;
	private String date;
	private String source;
	private Long timestamp;
	private ErrorContainer error;
	private Map<String, String> quotes;

	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	/**
	 * @return the terms
	 */
	public String getTerms() {
		return terms;
	}

	/**
	 * @param terms
	 *            the terms to set
	 */
	public void setTerms(String terms) {
		this.terms = terms;
	}

	/**
	 * @return the privacy
	 */
	public String getPrivacy() {
		return privacy;
	}

	/**
	 * @param privacy
	 *            the privacy to set
	 */
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	/**
	 * @return the historical
	 */
	public Boolean getHistorical() {
		return historical;
	}

	/**
	 * @param historical
	 *            the historical to set
	 */
	public void setHistorical(Boolean historical) {
		this.historical = historical;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the error
	 */
	public ErrorContainer getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(ErrorContainer error) {
		this.error = error;
	}

	/**
	 * @return the quotes
	 */
	public Map<String, String> getQuotes() {
		return quotes;
	}

	/**
	 * @param quotes
	 *            the quotes to set
	 */
	public void setQuotes(Map<String, String> quotes) {
		this.quotes = quotes;
	}

	public static class ErrorContainer {
		public String code;
		public String info;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}

		@Override
		public String toString() {
			return "ErrorContainer{" + "code='" + code + '\'' + ", info='" + info + '\'' + '}';
		}
	}
}
