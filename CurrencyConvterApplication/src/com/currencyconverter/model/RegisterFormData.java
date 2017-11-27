/**
 * 
 */
package com.currencyconverter.model;

import org.hibernate.validator.constraints.NotEmpty;
import com.currencyconverter.annotations.IsValidEmail;
import com.currencyconverter.annotations.IsValidName;

/**
 * @author abhishek.kotalwar
 *
 */

public class RegisterFormData {
	@NotEmpty
	private String userName;
	@NotEmpty
	private String password;
	@NotEmpty
	private String reEnterPassword;
	@IsValidName
	private String firstName;
	@IsValidName
	private String lastName;
	@IsValidEmail
	private String email;

	/**
	 * @return the reEnterPassword
	 */
	public String getReEnterPassword() {
		return reEnterPassword;
	}

	/**
	 * @param reEnterPassword
	 *            the reEnterPassword to set
	 */
	public void setReEnterPassword(String reEnterPassword) {
		this.reEnterPassword = reEnterPassword;
	}

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

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
