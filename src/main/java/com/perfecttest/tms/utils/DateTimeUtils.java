package com.perfecttest.tms.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeUtils {

    public static final ZoneId EST_TIME_ZONE = ZoneId.of("America/New_York");
    public static final ZoneId UTC_TIME_ZONE = ZoneId.of("UTC");

    public final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public final static DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);


    public static LocalDateTime parseDate(String dateTimeString, DateTimeFormatter formatter) {
        try{
            return LocalDateTime.parse(dateTimeString, formatter);
        } catch (DateTimeParseException e){
            return null;
        }
    }

    public static LocalDateTime parseDate(String dateTimeString) {
        return parseDate(dateTimeString, DEFAULT_DATE_TIME_FORMATTER);
    }

    public static ZonedDateTime geZonedDateTime(String dateTimeString, ZoneId zoneId){
        System.out.println("Parse date : " + dateTimeString);
        return LocalDateTime.parse(dateTimeString, DEFAULT_DATE_TIME_FORMATTER).atZone(zoneId);
    }

    public static String getDateBefore(int daysCount) {
        return LocalDateTime.now().minusDays(daysCount).format(DEFAULT_DATE_TIME_FORMATTER);
    }

    public static LocalDateTime convertTimeFromEstToUtc(LocalDateTime estTime) {
        ZonedDateTime estDateTime = estTime.atZone(EST_TIME_ZONE);
        return estDateTime.withZoneSameInstant(UTC_TIME_ZONE).toLocalDateTime();
    }

    public static LocalDateTime convertTimeFromUtcToEst(ZonedDateTime utcTime) {
        return utcTime.withZoneSameInstant(EST_TIME_ZONE).toLocalDateTime();
    }

    public static String getCurrentDate() {
        return LocalDateTime.now().format(DEFAULT_DATE_TIME_FORMATTER);
    }

}
