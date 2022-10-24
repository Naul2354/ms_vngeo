package com.unibro.ngsi.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConverterNotFoundException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Date time Helper Class.
 *
 * @author Thond
 */
@Slf4j
public class DatetimeHelper {

    public static String convertDateTime(Date date, String format) throws ConverterNotFoundException {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static Date parseDateTime(String date, String format) {
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.parse(date);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static Date parseDateTimeFromISODate(Object date) {
        try {
            if (date instanceof java.util.Date) {
                return (Date) date;
            }
            Date retDate = Date.from(ZonedDateTime.parse(date.toString()).toInstant());
            return retDate;
        } catch (Exception ex) {
            log.error(ex.toString());
            return null;
        }
    }

    public static Date parseDateTimeSpecial(String date, String format) {
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.parse(date.substring(0, 19).replace("T", " "));
        } catch (ParseException ex) {
            log.error(ex.toString());
            return null;
        }
    }

    public static java.sql.Timestamp parseSqlDateTimestamp(String date, String format) {
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            Date d = dateFormat.parse(date);
            return new java.sql.Timestamp(d.getTime());
        } catch (ParseException ex) {
            log.error(ex.toString());
            return null;
        }
    }
}
