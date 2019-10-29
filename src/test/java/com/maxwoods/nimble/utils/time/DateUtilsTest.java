package com.maxwoods.nimble.utils.time;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.util.Date;
import java.util.TimeZone;

public class DateUtilsTest {

    private static final Logger logger= LoggerFactory.getLogger(DateUtilsTest.class);

    @Test
    void test()
    {
        LocalDateTime currentTime = LocalDateTime.now();
        logger.info("current time is:{}",currentTime);
        ZoneId utcZoneId = ZoneId.of("Asia/Shanghai");
        logger.info("uct zone id:{}",utcZoneId);
        logger.info("local time:{}",Instant.now().atZone(utcZoneId).toLocalDateTime());
        logger.info("local to utc:{}",currentTime.atZone(utcZoneId).toLocalDateTime());
        Date date=Date.from(currentTime.atZone(ZoneId.of("UTC")).toInstant());
        logger.info("uct is:{}",date);
        ZonedDateTime zonedDateTime=ZonedDateTime.now();
        logger.info("zoned date time:{}",zonedDateTime);
        OffsetDateTime offsetDateTim=zonedDateTime.toOffsetDateTime();
        logger.info("offsetDateTim:{}",offsetDateTim);
        logger.info("{}",Date.from(java.time.ZonedDateTime.now().toInstant()));
    }
}
