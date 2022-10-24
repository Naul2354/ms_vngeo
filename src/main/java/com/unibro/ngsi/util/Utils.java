/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.util;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author ThoND
 */
public class Utils {

    public static Date parseDateByFormat(String date, String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat();
            return dateFormat.parse(date);
        } catch (ParseException ex) {
            return new Date();
        }
    }

    public static String getIpAddress(HttpServletRequest httpServlet) {
        String ipAddress = httpServlet.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = httpServlet.getRemoteAddr();
        }
        return ipAddress;
    }

    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replace('đ', 'd').replace('Đ', 'D');
    }

    public static double distance(double lat1, double lng1,
                                  double lat2, double lng2) {
        double a = (lat1 - lat2) * distPerLat(lat1);
        double b = (lng1 - lng2) * distPerLng(lat1);
        return Math.sqrt(a * a + b * b);
    }

    private static double distPerLng(double lat) {
        return 0.0003121092 * Math.pow(lat, 4)
                + 0.0101182384 * Math.pow(lat, 3)
                - 17.2385140059 * lat * lat
                + 5.5485277537 * lat + 111301.967182595;
    }

    private static double distPerLat(double lat) {
        return -0.000000487305676 * Math.pow(lat, 4)
                - 0.0033668574 * Math.pow(lat, 3)
                + 0.4601181791 * lat * lat
                - 1.4558127346 * lat + 110579.25662316;
    }

    public static String[] parseLocation(String address) {
        String[] ret = new String[3];
        ret[0] = "";
        ret[1] = "";
        ret[2] = "";
        String[] data = address.trim().split(",");
        if (data.length >= 1) {
            ret[0] = Utils.removeAccent(data[data.length - 1]).toLowerCase().replace(" ", "");
        }
        if (data.length >= 2) {
            ret[1] = Utils.removeAccent(data[data.length - 2]).toLowerCase().replace(" ", "").replace("thanhpho", "").replace("tinh", "");
        }
        if (data.length >= 3) {
            ret[2] = Utils.removeAccent(data[data.length - 3]).toLowerCase().replace(" ", "").replace("quan", "").replace("huyen", "");
        }
        return ret;
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    public static String getUniqueValue() {
        String value = UUID.randomUUID().toString();
        return getMD5Value(value);
    }

    public static String getMD5Value(String value) {
        final byte[] defaultBytes = value.getBytes();
        try {
            final MessageDigest md5MsgDigest = MessageDigest.getInstance("MD5");
            md5MsgDigest.reset();
            md5MsgDigest.update(defaultBytes);
            final byte[] messageDigest = md5MsgDigest.digest();
            final StringBuffer hexString = new StringBuffer();
            for (final byte element : messageDigest) {
                final String hex = Integer.toHexString(0xFF & element);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            value = hexString + "";
        } catch (final NoSuchAlgorithmException nsae) {
        }
        return value;
    }


    public static String getCodeIdInStr(Integer idCode) {
        String ret = idCode.toString();
        if (ret.length() >= 4) {
            return ret;
        } else {
            String prefix = "";
            for (int i = 0; i < 4 - ret.length(); i++) {
                prefix = "0" + prefix;
            }
            return prefix + ret;
        }
    }

    public static boolean checkKeyValueField(String key) {
        return key.contains(".");
    }

    public static String getPrefix(String key) {
        int index = key.indexOf(".");
        if (index > 0) {
            return key.substring(0, index);
        } else {
            return key;
        }
    }

    public static String getPostfix(String key) {
        int index = key.indexOf(".");
        if (index > 0) {
            return key.substring(index + 1);
        } else {
            return key;
        }
    }

    public static boolean checkContains(String checkdata, String data, String split) {
        String[] arr = data.split(split);
        for (String s : arr) {
            if (s.equals(checkdata)) {
                return true;
            }
        }
        return false;
    }

    public static int daysBetween(Calendar startDate, Calendar endDate) {
        Calendar date = (Calendar) startDate.clone();
        int daysBetween = 0;
        while (date.before(endDate)) {
            date.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }

    public static String currencyFormat(Double vaelue) {
        try {
            // double vaelue = Double.parseDouble(curr);
            String pattern = "###,###";
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            String output = myFormatter.format(vaelue);
            return output;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String formatNumberForRead(double number) {
        NumberFormat nf = NumberFormat.getInstance();
        String temp = nf.format(number);
        String strReturn = "";
        int slen = temp.length();
        for (int i = 0; i < slen; i++) {
            if (String.valueOf(temp.charAt(i)).equals("."))
                break;
            else if (Character.isDigit(temp.charAt(i))) {
                strReturn += String.valueOf(temp.charAt(i));
            }
        }
        return strReturn;

    }

    public static String getRandomColor() {
        // create object of Random class
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);
        // format it as hexadecimal string and print
        String colorCode = String.format("#%06x", rand_num);
        return colorCode;
    }

    public static int monthsBetween(Date d1, Date d2) {
        if (d2 == null || d1 == null) {
            return -1;// Error
        }
        // log.info(d1.toString());
        // log.info(d2.toString());
        Calendar m_calendar = Calendar.getInstance();
        m_calendar.setTime(d1);
        int nMonth1 = 12 * m_calendar.get(Calendar.YEAR) + m_calendar.get(Calendar.MONTH);
        m_calendar.setTime(d2);
        int nMonth2 = 12 * m_calendar.get(Calendar.YEAR) + m_calendar.get(Calendar.MONTH);
        // log.info(nMonth1 + "-" + nMonth2);
        return java.lang.Math.abs(nMonth2 - nMonth1);
    }

    public static SearchCriteria getActiveSearchCriteria() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setKey("deleteFlag");
        criteria.setOperation(SearchOperation.EQUALITY);
        criteria.setOperator("and");
        criteria.setValue(0);
        return criteria;
    }

    public static SearchCriteria getCreateUserCriteria(String userid) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setKey("createUser");
        criteria.setOperation(SearchOperation.EQUALITY);
        criteria.setOperator("and");
        criteria.setValue(userid);
        return criteria;
    }

    public static SearchCriteria getEqualCriteria(String field, Object value) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setKey(field);
        criteria.setOperation(SearchOperation.EQUALITY);
        criteria.setOperator("and");
        criteria.setValue(value);
        return criteria;
    }

    public static SearchCriteria getJsonContainsCriteria(String field, Object value) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setKey(field);
        criteria.setOperation(SearchOperation.JSON_CONTAINS);
        criteria.setOperator("and");
        criteria.setValue(value);
        return criteria;
    }

    public static SearchCriteria getInCriteria(String field, Object value) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setKey(field);
        criteria.setOperation(SearchOperation.IN);
        criteria.setOperator("and");
        criteria.setValue(value);
        return criteria;
    }

    @SuppressWarnings("rawtypes")
    public static Object getValueOf(Object clazz, String lookingForValue) throws Exception {
        Field field = clazz.getClass().getField(lookingForValue);
        Class clazzType = field.getType();
        if (clazzType.toString().equals("Double")) {
            return field.getDouble(clazz);
        } else if (clazzType.toString().equals("Integer")) {
            return field.getInt(clazz);
        }
        // else other type ...
        // and finally
        return field.get(clazz);
    }


    public static String getDoubleInString(double d) {
        // log.info("Value:" + d);
        String ret = String.format("%.10f", d);
        // log.info("Value1:" + ret);
        return ret;
    }

    public static String getDoubleInString1(double d) {
        // log.info("Value:" + d);
        NumberFormat nf = DecimalFormat.getInstance(Locale.ENGLISH);
        DecimalFormat decimalFormatter = (DecimalFormat) nf;
        decimalFormatter.applyPattern("#,###,###.##########");
        String ret = decimalFormatter.format(d);
        // log.info("Value1:" + ret);
        return ret;
    }

    public static String getDoubleInStringRound(double d) {
        // log.info("Value:" + d);
        NumberFormat nf = DecimalFormat.getInstance(Locale.ENGLISH);
        DecimalFormat decimalFormatter = (DecimalFormat) nf;
        decimalFormatter.applyPattern("#,###,###");
        String ret = decimalFormatter.format(d);
        // log.info("Value1:" + ret);
        return ret;
    }

    public static Double getNumberFromString(String data) {
        try {
            return Double.valueOf(data);
        } catch (NumberFormatException ex) {
            return 0.0;
        }
    }
}
