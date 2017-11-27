/**
 * 
 */
package com.currencyconverter.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author abhishek.kotalwar
 *
 */
public class DateUtils {
	private static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
	
	public static Date getFormattedDate_YYYY_MM_DD(String dateValue) {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		try {
			date = formatter.parse(dateValue);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
