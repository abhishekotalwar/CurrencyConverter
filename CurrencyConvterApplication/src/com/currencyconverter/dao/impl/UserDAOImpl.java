/**
 * 
 */
package com.currencyconverter.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.currencyconverter.dao.UserDataDAO;
import com.currencyconverter.model.UserData;

/**
 * @author abhishek.kotalwar
 *
 */
@Component
public class UserDAOImpl implements UserDataDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * {@inheritDoc}
	 */
	public UserData getUserByUserName(String userName) {
		UserData user = null;
		try {
			TypedQuery<UserData> query = em
					.createQuery("SELECT u FROM UserData u where u.userName = '" + userName + "'", UserData.class);
			user = query.getSingleResult();
		} catch (Exception e) {
			return user;
		}

		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	public UserData getUserByEmail(String userEmail) {
		UserData user = null;
		try {
			TypedQuery<UserData> query = em.createQuery("SELECT u FROM UserData u where u.email = '" + userEmail + "'",
					UserData.class);
			user = query.getSingleResult();
		} catch (Exception e) {
			return user;
		}

		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional
	public void save(UserData user) {
		em.persist(user);
	}
}
