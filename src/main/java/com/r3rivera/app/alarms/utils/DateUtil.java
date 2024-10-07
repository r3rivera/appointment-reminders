package com.r3rivera.app.alarms.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.util.StringUtils;

public final class DateUtil {

    public static final String YYYY_MM_DD_TIMESTAMP = "yyyy-MM-dd HH:mm:ss z";
    private static final String UTC = "UTC";

    private static String getFormat(String format){
        if(StringUtils.hasText(format)){
            return format;
        }
        return YYYY_MM_DD_TIMESTAMP;
    }

    public static final String formatUTC(long timestampUtc, String format){
        final String dflt_format = getFormat(format);
        final Instant instant = Instant.ofEpochMilli(timestampUtc);
        final ZonedDateTime utcDate = ZonedDateTime.ofInstant(instant, ZoneId.of(UTC));
        final DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern(dflt_format);
        return dFormatter.format(utcDate);
    }

    public static long formatString(String dateString, String format){
        final String dflt_format = getFormat(format);
        final DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern(dflt_format);
        final ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateString, dFormatter);
        return zonedDateTime.toInstant().toEpochMilli();
    }
}
