/**
 * 
 */
package com.currencyconverter.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.currencyconverter.dao.CurrencyTransactionHistoryDAO;
import com.currencyconverter.model.CurrencyTransactionHistory;
import com.currencyconverter.service.CurrencyTransactionHistoryService;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class CurrencyTransactionHistoryServiceImpl implements CurrencyTransactionHistoryService {
	@Autowired
	private CurrencyTransactionHistoryDAO currencyTransactionHistoryDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(CurrencyTransactionHistory currencyTransactionHistory) {
		currencyTransactionHistoryDAO.save(currencyTransactionHistory);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CurrencyTransactionHistory> findLast10CurrencyTransactionHistory(String userName) {
		return currencyTransactionHistoryDAO.findLast10CurrencyTransactionHistory(userName);
	}

}
