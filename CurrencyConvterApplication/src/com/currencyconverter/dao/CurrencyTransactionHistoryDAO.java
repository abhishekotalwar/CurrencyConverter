/**
 * 
 */
package com.currencyconverter.dao;

import java.util.List;
import com.currencyconverter.model.CurrencyTransactionHistory;

/**
 * @author abhishek.kotalwar
 *
 */
public interface CurrencyTransactionHistoryDAO {
	/**
	 * Save the values of the given <code>CurrencyTransactionHistory</code> in
	 * the database so long it doesn't already exist
	 * 
	 * @param currencyTransactionHistory
	 *            of type CurrencyTransactionHistory
	 */
	public void save(CurrencyTransactionHistory currencyTransactionHistory);

	/**
	 * Returns the list of currency transaction for given user name
	 * 
	 * @param userName String
	 * 
	 * @return an List of CurrencyTransactionHistory object
	 */
	public List<CurrencyTransactionHistory> findLast10CurrencyTransactionHistory(String userName);
}
