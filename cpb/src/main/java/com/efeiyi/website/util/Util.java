package com.efeiyi.website.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Util {
    private static Logger log;

    public static String getAgeByBirthday(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date birthday = null;
        try {
            birthday = sdf.parse(str);
        } catch (ParseException e) {
            return "";
        }

        Calendar cal = Calendar.getInstance();

        if (cal.before(birthday)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }
        return age + "";

    }

    public static String firstUpperCase(String source) {
        String first = source.substring(0, 1).toUpperCase();
        String rest = source.substring(1, source.length());
        return new StringBuffer(first).append(rest).toString();
    }

    public static String firstLowerCase(String source) {
        String first = source.substring(0, 1).toLowerCase();
        String rest = source.substring(1, source.length());
        return new StringBuffer(first).append(rest).toString();
    }

    public static String getUUId() {
        return UUIDGenerator.generateId();
    }

    public static String getColumnNameFromFieldName(String fieldName) {
        StringBuilder columnName = new StringBuilder(fieldName);
        int i = 0;
        while (i < columnName.length()) {
            char ch = columnName.charAt(i);
            if (Character.isUpperCase(ch)) {
                columnName.setCharAt(i, Character.toLowerCase(ch));
                columnName.insert(i, '_');
                i++;
            }
            i++;
        }
        return columnName.toString();
    }

    public static String getTableNameFromEntityName(String entityName) {
        StringBuilder tableName = new StringBuilder(entityName);
        int i = 0;
        while (i < tableName.length()) {
            char ch = tableName.charAt(i);
            if (Character.isUpperCase(ch)) {
                tableName.setCharAt(i, Character.toLowerCase(ch));
                if (i != 0) {
                    tableName.insert(i, '_');
                }
                i++;
            }
            i++;
        }
        return tableName.toString();
    }

    public static String getFieldNameFromColumnName(String columnName) {
        StringBuilder setMethodName = new StringBuilder(columnName);
        int i = 0;
        while (i < setMethodName.length()) {
            if (setMethodName.charAt(i) == '_') {
                char c = setMethodName.charAt(i + 1);
                c = Character.toUpperCase(c);
                setMethodName.setCharAt(i + 1, c);
                setMethodName.deleteCharAt(i);
                i--;
            }
            i++;
        }
        return setMethodName.toString();
    }

    public static String getMD5(String str) {
        String value = null;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder();
            value = baseEncoder.encode(md5.digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static byte[] encode2bytes(String source) {
        byte[] result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(source.getBytes("UTF-8"));
            result = md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String encode2hex(String source) {
        byte[] data = encode2bytes(source);

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            String hex = Integer.toHexString(0xff & data[i]);

            if (hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);
        }

        return hexString.toString();
    }

    @SuppressWarnings("rawtypes")
    public static Logger getLogger(Class clazz) {
        if (log == null) {
            log = LoggerFactory.getLogger(clazz);
        }
        return log;
    }

    public static String getDateTime() {
        return getDate("yyyy-MM-dd HH:mm:ss");
    }

    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    public static String getTime() {
        return getDate("HH:mm:ss");
    }

    public static String getYear() {
        return getDate("yyyy");
    }

    public static String getMonth() {
        return getDate("MM");
    }

    public static String getDay() {
        return getDate("dd");
    }

    public static String getWeek() {
        return getDate("E");
    }

    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    public static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }

        return strDigest;
    }

    public static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }

    public static String getBasePath(HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":"
                + request.getServerPort()
                + path + "/";
        return basePath;
    }

    public static String getRelativePath(HttpServletRequest request) {
        int index = request.getServletPath().indexOf('?');
        if(index == -1) {
            return request.getServletPath();
        } else {
            return  request.getServletPath().substring(0, request.getServletPath().indexOf('?'));
        }
    }


    /**
     * 努娜加密
     *
     * @param password  密码字符串
     * @param algorithm 加密算法 SHA
     * @return
     */
    public static String encodePassword(String password, String algorithm) {
        byte[] unencodedPassword = {};
        try {
            unencodedPassword = password.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (Exception e) {
            return password;
        }
        md.reset();
        md.update(unencodedPassword);
        byte[] encodedPassword = md.digest();
        return getFormattedText(encodedPassword);
    }

    private static String getFormattedText(byte bytes[]) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for (int j = 0; j < bytes.length; j++) {
            buf.append(HEX_DIGITS[bytes[j] >> 4 & 15]);
            buf.append(HEX_DIGITS[bytes[j] & 15]);
        }
        return buf.toString();
    }

    private static final char HEX_DIGITS[] = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static boolean isBaseType(Class<?> type) {
        if (type.isPrimitive()) {
            return true;
        } else if(String.class.isAssignableFrom(type)) {
            return true;
        } else if (Date.class.isAssignableFrom(type)) {
            return true;
        }   else if (byte[].class.isAssignableFrom(type)) {
            return true;
        } else if (BigDecimal.class.isAssignableFrom(type)) {
            return true;
        }
        return false;
    }


    public static Object parseObject(String s, Class<?> type) {
        if(type == short.class) {
            return Short.parseShort(s);
        } else if(type == int.class) {
            return Integer.parseInt(s);
        } else if(type == long.class) {
            return Long.parseLong(s);
        } else if(type == float.class) {
            return Float.parseFloat(s);
        } else if(type == double.class) {
            Double.parseDouble(s);
        } else if(type == byte.class) {
            Byte.parseByte(s);
        } else if(type == char.class) {
            return s.charAt(0);
        } else if (type == boolean.class) {
            return Boolean.parseBoolean(s);
        } else if(type == String.class) {
            return s;
        } else if(type == BigDecimal.class) {
            return new BigDecimal(s);
        } else if(type == Date.class) {
            return new Date(Long.parseLong(s));
        }
        return null;
    }

    public static String baseTypeToString(Object obj) {
        if(!isBaseType(obj.getClass())) {
            return  null;
        }
        if(obj instanceof  Date) {
            long time = ((Date) obj).getTime();
            return String.valueOf(time);
        } else {
            return obj.toString();
        }
    }

}
