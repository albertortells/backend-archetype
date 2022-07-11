package com.brickncode.backendarchetype.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface IUtilParser {

	/**
	 * @param str -
	 * @return Date
	 * @throws ParseException -
	 */
	static Date parseStringToDate(String str) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy").parse(str);
	}
}
