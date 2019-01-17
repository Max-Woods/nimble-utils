package com.maxwoods.nimble.utils.codec;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Base64UtilsTest {

    private static final Logger logger= LoggerFactory.getLogger(Base64UtilsTest.class);

    @Test
    void encodeTest()
    {
        String result=Base64Utils.encodeBase64String("中华人民共和国");
        logger.info("base64:{}",result);
    }
}
