package com.maxwoods.nimble.utils.lang;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StringUtilsTest {

    private static final Logger logger= LoggerFactory.getLogger(StringUtilsTest.class);

    @Test
    void randomNumberString()
    {
        logger.info("{}", StringUtils.randomNumberString(15));
    }
}
