package com.currencyconverter.dao;

import com.currencyconverter.model.UserData;

/**
 * @author abhishek.kotalwar
 *
 */
public interface UserDataDAO {

	/**
	 * This method will return the UserData object for given userName.
	 * 
	 * @param userName
	 * @return
	 */
	public UserData getUserByUserName(String userName);

	/**
	 * This method will return the UserData object for given userEmail.
	 * 
	 * @param userEmail
	 * @return
	 */
	public UserData getUserByEmail(String userEmail);

	/**
	 * This method will persist the UserData object
	 * 
	 * @param user
	 */
	public void save(UserData user);
}
