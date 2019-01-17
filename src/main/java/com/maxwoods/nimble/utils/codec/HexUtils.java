package com.maxwoods.nimble.utils.codec;

import com.maxwoods.nimble.utils.lang.StringUtils;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class HexUtils {

	public static String encodeHex(byte[] data) {
		return Hex.encodeHexString(data).toUpperCase();
	}

	public static String encodeHex(int data) {
		byte[] bytes = new byte[4];
		bytes[0] = (byte) (data >>> 24);// bytes[0]表示一个int值的最高8位
		bytes[1] = (byte) (data >>> 16);// bytes[1]表示一个int值的接下来的8位
		bytes[2] = (byte) (data >>> 8);// bytes[2]表示一个int值的再接下来的8位
		bytes[3] = (byte) (data);
		return Hex.encodeHexString(bytes).toUpperCase();
	}

	public static String encodeByte(int data) {
		byte[] bytes = new byte[1];
		bytes[0] = (byte) (data & 0x0FF);// 低8位
		return Hex.encodeHexString(bytes).toUpperCase();
	}

	public static String encodeWord(int data) {
		byte[] bytes = new byte[2];
		bytes[0] = (byte) ((data & 0xFF00) >>> 8);// 高8位
		bytes[1] = (byte) (data & 0x00FF);// 低8位
		return Hex.encodeHexString(bytes).toUpperCase();
	}

	public static byte[] decodeHex(char[] hex) throws DecoderException {
		return Hex.decodeHex(hex);
	}

	public static byte[] decodeHex(String hex) throws DecoderException {
		return Hex.decodeHex(hex.toCharArray());
	}

	/**
	 * 将字节转换为带空格分区的十六进制串
	 * 
	 * @param data
	 * @return
	 */
	public static String encodeHexSection(byte[] data) {
		return HexUtils.hexSection(HexUtils.encodeHex(data));
	}

	/**
	 * 将十六进制串转换为带空格分区的十六进制串
	 * 
	 * @param hex
	 * @return
	 */

	public static String hexSection(String hex) {
		return StringUtils.section(hex, 2, org.apache.commons.lang3.StringUtils.SPACE);
	}
}
