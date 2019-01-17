package com.maxwoods.nimble.utils.lang;

/**
 * @author Max Woods
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	public static boolean isAllNotBlank(final CharSequence... css) {
		return !org.apache.commons.lang3.StringUtils.isAnyBlank(css);
	}

	/**
	 * 字符串左补空格到指定长度
	 * @param str
	 * @param size
	 * @return
	 */
	public static String leftPadSpace(final String str, final int size) {
		return org.apache.commons.lang3.StringUtils.leftPad(str, size, StringUtils.SPACE);
	}

	/**
	 * 字符串右补空格到指定长度
	 * @param str
	 * @param size
	 * @return
	 */
	public static String rightPadSpace(final String str, final int size) {
		return org.apache.commons.lang3.StringUtils.rightPad(str, size,  StringUtils.SPACE);
	}

	public static String leftPadZero(final String str, final int size) {
		return org.apache.commons.lang3.StringUtils.leftPad(str, size, '0');
	}

	public static String rightPadZero(final String str, final int size) {
		return org.apache.commons.lang3.StringUtils.rightPad(str, size,  '0');
	}

	/** 返回随机数字字符串 */
	public static String randomNumberString() {
		return Integer.toString(Math.abs(RandomUtils.nextInt()));
	}

	/** 返回定长随机数字字符串 */
	public static String randomNumberString(int length) {
		StringBuilder sb = new StringBuilder(StringUtils.randomNumberString());
		// 如果大于指定长度
		int len = sb.length();
		int diff = len - length;
		// 如果不足，则再次补长
		while (diff < 0) {
			sb.append(StringUtils.randomNumberString());
			len = sb.length();
			diff = len - length;
		}
		// 如果超长则截取
		if (diff > 0) {
			return sb.delete(length, len).toString();
		}
		return sb.toString();
	}

	public static String includeSlash(String str) {
		return org.apache.commons.lang3.StringUtils.appendIfMissing(str, "/", "/");
	}

	public static String includeBackslash(String str) {
		return org.apache.commons.lang3.StringUtils.appendIfMissing(str, "\\", "\\");
	}

	public static String section(String str, int sectionWidth, String delimter) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < str.length(); i += sectionWidth) {
			String section = substring(str, i, i + sectionWidth);
			stringBuilder.append(section).append(delimter);
		}
		return stringBuilder.toString();
	}
}