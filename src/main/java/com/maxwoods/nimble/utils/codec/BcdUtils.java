package com.maxwoods.nimble.utils.codec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 */
public class BcdUtils {

	/**
	 * 默认8421非压缩
	 * 
	 * @param bcd 将bcd编码为字节数组
	 * @return 编码后的字节数组
	 */
	public static byte[] encodeBcd(String bcd) throws DecoderException, IOException {
		ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
		for (char c : bcd.toCharArray()) {
			dataStream.write(HexUtils.decodeHex("0" + c));
		}
		return dataStream.toByteArray();
	}

	/**
	 * 8421压缩BCD编码
	 * 
	 * @param bcd 非压缩bcd码字节
	 * @return 压缩后的bcd码
	 */
	public static byte[] encodeBcdCompress(byte[] bcd) throws DecoderException, IOException {
		ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
		dataStream.write(bcd);
		// 不是2的整数倍进行补位
		int mod = bcd.length % 2;
		if (mod != 0) {
			dataStream.write((byte) 0);
		}
		bcd = dataStream.toByteArray();
		String hexbcd = StringUtils.EMPTY;
		// 生成压缩bcd码
		for (int i = 0; i < bcd.length - 1; i += 2) {
			byte[] b = { 0 };
			b[0] = (byte) (bcd[i] << 4 | bcd[i + 1]);
			hexbcd += HexUtils.encodeHex(b);
		}
		dataStream.reset();
		dataStream.write(HexUtils.decodeHex(hexbcd));
		return dataStream.toByteArray();
	}

	public static byte[] encodeBcdCompress(String bcd) throws DecoderException, IOException {
		return BcdUtils.encodeBcdCompress(bcd, 4);
	}

	public static byte[] encodeBcdCompress(String bcd, int padding) throws DecoderException, IOException {
		// 奇数补0
		if (bcd.length() % 2 != 0) {
			switch (padding) {
				case 2:
					bcd = "0".concat(bcd);
					break;
				default:
					bcd = bcd.concat("0");
			}
		}
		return HexUtils.decodeHex(bcd);
	}
}
