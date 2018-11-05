package com.jw.util;

public class StringUtil {

	public static String nullToString(Object value) {
		return (value == null) || ("null".equals(value)) ? "" : value.toString().trim();
	}

	public static boolean isNullStr(String str) {
		if ((str == null) || (str.trim().equals("")) || (str.trim().length() == 0)) {
			return true;
		}
		return false;
	}

	public static String null2Str(String value) {
		return (value == null) || ("null".equals(value)) ? "" : value.trim();
	}

	public static String null2Str(Object value) {
		return (value == null) || ("null".equals(value.toString())) ? "" : value.toString();
	}
}