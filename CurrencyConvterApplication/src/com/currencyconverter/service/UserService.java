package com.currencyconverter.service;

import com.currencyconverter.model.UserData;

/**
 * @author abhishek.kotalwar
 *
 */
public interface UserService {

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
	public void save(UserData aUser);

}
