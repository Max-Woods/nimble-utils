package com.maxwoods.nimble.utils.lang;

public class ByteUtils {

	public static byte[] bytesXor(byte[] block1, byte[] block2) {
		int len = block1.length;
		byte[] result = new byte[len];
		for (int i = 0; i < len; i++) {
			result[i] = (byte) (block1[i] ^ block2[i]);
		}
		return result;
	}

	public static int byte2ToUnsignedShort(byte[] bytes) {
		return ByteUtils.byte2ToUnsignedShort(bytes, 0);
	}

	public static int byte2ToUnsignedShort(byte[] bytes, int off) {
		int high = bytes[off];
		int low = bytes[off + 1];
		return (high << 8 & 0xFF00) | (low & 0xFF);
	}
}
