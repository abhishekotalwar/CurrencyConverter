/**
 * 
 */
package com.currencyconverter.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.currencyconverter.dao.CurrencyTransactionHistoryDAO;
import com.currencyconverter.model.CurrencyTransactionHistory;

/**
 * @author abhishek.kotalwar
 *
 */
@Component
public class CurrencyTransactionHistoryDAOImpl implements CurrencyTransactionHistoryDAO {
	@PersistenceContext
	private EntityManager em;

	/**
	 * {@inheritDoc}
	 */
	@Transactional
	public void save(CurrencyTransactionHistory currencyTransactionHistory) {
		em.persist(currencyTransactionHistory);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<CurrencyTransactionHistory> findLast10CurrencyTransactionHistory(String userName) {
		TypedQuery<CurrencyTransactionHistory> query = em.createQuery(
				"SELECT cts FROM CurrencyTransactionHistory cts where cts.userName = '"+userName+"' ORDER BY cts.id desc",
				CurrencyTransactionHistory.class);
		return query.getResultList();
	}
}
