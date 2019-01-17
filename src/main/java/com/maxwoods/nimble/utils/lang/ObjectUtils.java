package com.maxwoods.nimble.utils.lang;

public class ObjectUtils extends org.apache.commons.lang3.ObjectUtils {

	/** 判断对象是否为空 */
	public static boolean isNull(Object object) {
		return null == object;
	}

	/** 判断对象是否不为空 */
	public static boolean isNotNull(Object object) {
		return null != object;
	}

	/** 判断对象是否任意为空 */
	public static boolean isAnyNull(Object... objects) {
		for (Object object : objects) {
			if (null == object) {
				return true;
			}
		}
		return false;
	}

	/** 判断对象是否全不为空 */
	public static boolean isAllNotNull(Object... objects) {
		for (Object object : objects) {
			if (null == object) {
				return false;
			}
		}
		return true;
	}

	/** 判断对象是否全为空 */
	public static boolean isAllNull(Object... objects) {
		for (Object object : objects) {
			if (null != object) {
				return false;
			}
		}
		return true;
	}
}
