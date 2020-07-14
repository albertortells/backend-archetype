package com.brickncode.backendarchetype.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parsers {

	/**
	 *
	 * @param str -
	 * @return Date
	 */
	public static Date parseStringToDate(String str) {
		Date d = null;

		try {
			d = new SimpleDateFormat("dd/MM/yyyy").parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return d;
	}
}
