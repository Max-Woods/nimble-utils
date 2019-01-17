package com.maxwoods.nimble.utils.codec;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Base64Utils extends Base64 {

    public static String encodeBase64String(String data) {

            return Base64.encodeBase64String(data.getBytes(UTF_8));

    }

    public static String decodeBase64String(String data) throws UnsupportedEncodingException {
        return new String(Base64.decodeBase64(data), UTF_8);
    }
}
