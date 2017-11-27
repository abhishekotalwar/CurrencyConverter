/**
 * 
 */
package com.currencyconverter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.currencyconverter.dao.UserDataDAO;
import com.currencyconverter.model.UserData;
import com.currencyconverter.service.UserService;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDataDAO userDAO;

	/**
	 * {@inheritDoc}
	 */
	public UserData getUserByUserName(String userName) {
		return userDAO.getUserByUserName(userName);
	}

	/**
	 * {@inheritDoc}
	 */
	public UserData getUserByEmail(String userEmail) {
		return userDAO.getUserByEmail(userEmail);
	}

	/**
	 * {@inheritDoc}
	 */
	public void save(UserData aUser) {
		userDAO.save(aUser);
	}
}
