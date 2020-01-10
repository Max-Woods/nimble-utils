package com.maxwoods.nimble.utils.lang;

//
public class BooleanUtils {

	String[] trueStrings={"1","y","t","true","yes","是","真","对"};

	String[] falseStrings={"0","n","f","false","no","否","假","错"};

	/**
	 * 以0，1数字字符的形式返回
	 * @param value
	 * @return
	 */
	public static char toNubmerChar(Boolean value) {
		return value ? '1' : '0';
	}

	/**
	 * 以T,F字符形式返回
	 * @param value
	 * @return
	 */
	public static char toChar(Boolean value) {
		return value ? 'T' : 'F';
	}

	public static char toChineseChar(Boolean value) {
		return value ? '真' : '假';
	}

	public static String toYesNoString(Boolean value) {
		return value ? "yes" : "no";
	}

	public static char toYesNoChar(Boolean value) {
		return value ? 'Y' : 'N';
	}

	public static char toYesNoChineseChar(Boolean value) {
		return value ? '是' : '否';
	}

	/**
	 * 解析字符串为boolean
	 * @param value
	 * @return
	 */
	public Boolean parse(String value)
	{

		switch (value.toLowerCase())
		{
			case "1":
			case "y":
			case "t":
			case "true":
			case "yes":
			case "是":
				return true;
			default:
				return false;
		}
	}
}
