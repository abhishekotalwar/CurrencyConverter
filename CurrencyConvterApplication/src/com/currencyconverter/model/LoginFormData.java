/**
 * 
 */
package com.currencyconverter.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author abhishek.kotalwar
 *
 */
public class LoginFormData {
	@NotEmpty
	private String userName;
	@NotEmpty
	private String password;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
