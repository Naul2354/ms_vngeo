/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.config;

import com.unibro.ngsi.util.DatetimeHelper;
import org.springframework.core.convert.converter.Converter;

/**
 * @author LenovoUser
 */
//@Component
//@ReadingConverter
public class ReadingTimestampConverter implements Converter<byte[], java.sql.Timestamp> {

    @Override
    public java.sql.Timestamp convert(byte[] s) {
        String date = new String(s);
        return DatetimeHelper.parseSqlDateTimestamp(date, "yyyy-MM-dd HH:mm:ss");
    }

}
