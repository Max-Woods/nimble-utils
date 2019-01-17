package com.maxwoods.nimble.utils.lang;

import java.util.Random;

/*** 随机工具类 */
public class RandomUtils {
	private static final char[] randomChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
			'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private static Random random = new Random();

	public static int nextInt() {
		return RandomUtils.random.nextInt();
	}

	public static int nextInt(int bound) {
		return RandomUtils.random.nextInt(bound);
	}

	public static int nextInt(int start, int end) {
		int bound = end - start;
		return RandomUtils.random.nextInt(bound) + start;
	}

	public static long nextLong() {
		return RandomUtils.random.nextLong();
	}

	public static boolean nextBoolean() {
		return RandomUtils.random.nextBoolean();
	}

	public static double nextDouble() {
		return RandomUtils.random.nextDouble();
	}

	public static float nextFloat() {
		return RandomUtils.random.nextFloat();
	}

	public static float nextFloat(float start, float end) {
		float bound = end - start;
		return RandomUtils.random.nextFloat() * bound + start;
	}

	/**
	 * 产生一个随机数,范围（start~end）
	 * 
	 * @param start
	 * @param end
	 * @return
	 * @author: wangjz 2018年6月6日下午7:11:29
	 */
	public static int getInt(int start, int end) {
		return start + new Random().nextInt(end - start);
	}

	/**
	 * 产生一个length长度的数字字符串
	 * 
	 * @param length
	 * @return
	 * @author wangjz 2018年12月28日上午11:18:14
	 */
	public static String getNumString(int length) {
		return getString(length, 0, 9);
	}

	/**
	 * 产生一个length长度的数字字母字符串
	 * 
	 * @param length
	 * @return
	 * @author wangjz 2018年12月28日上午11:18:14
	 */
	public static String getNumAndCharString(int length) {
		return getString(length, 0, randomChars.length);
	}

	/**
	 * 产生一个length长度的字母字符串
	 * 
	 * @param length
	 * @return
	 * @author wangjz 2018年12月28日上午11:18:14
	 */
	public static String getCharString(int length) {
		return getString(length, 10, randomChars.length);
	}

	/**
	 * 产生一个length长度的数字字母字符串
	 * 
	 * @param length
	 * @return
	 * @author wangjz 2018年12月28日上午11:18:14
	 */
	private static String getString(int length, int start, int end) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(randomChars[getInt(start, end)]);
		}
		return sb.toString();
	}
}
