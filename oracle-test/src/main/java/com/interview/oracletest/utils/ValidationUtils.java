package com.interview.oracletest.utils;

public class ValidationUtils {

	public static Boolean validateRegex(String value, String regex) {
		return (regex != null && value.matches(regex));
	}
}
