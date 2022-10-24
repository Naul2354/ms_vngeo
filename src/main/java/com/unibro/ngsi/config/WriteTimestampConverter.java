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
//@WritingConverter
public class WriteTimestampConverter implements Converter<java.sql.Timestamp, byte[]> {

    @Override
    public byte[] convert(java.sql.Timestamp s) {
        String date = DatetimeHelper.convertDateTime(s, "yyyy-MM-dd HH:mm:ss");
        return date.getBytes();
    }

}
