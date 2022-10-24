/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.util;

import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;

/**
 * @author nguyenductho
 */
public class NullAwareBeanUtils extends BeanUtilsBean {

    public static void doCopyProperties(Object dest, Object orig) {
        try {
            NullAwareBeanUtils notNull = new NullAwareBeanUtils();
            notNull.copyProperties(dest, orig);
        } catch (IllegalAccessException | InvocationTargetException ex) {
        }
    }

    @Override
    public void copyProperty(Object dest, String name, Object value)
            throws IllegalAccessException, InvocationTargetException {
        if (value == null) {
            return;
        }
        super.copyProperty(dest, name, value);
    }

}
