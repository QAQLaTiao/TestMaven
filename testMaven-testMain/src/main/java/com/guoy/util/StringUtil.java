package com.guoy.util;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

/**
 * 字符串相关工具类
 *
 * @author tlt
 */
public class StringUtil implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static MessageDigest digest = null;

    private static final String numberChar = "0123456789";


    /**
     * @param args
     */
    public static void main(String[] args) {
//		System.out.println(StringUtil.parseToDate("2007年05月17日"));
        String phone = "131124533333";

        System.out.println(StringUtil.formatPhoneNum(phone));
    }

    /**
     * 判断是否为数字
     * @param param
     * @return
     */
    public static Boolean isNumeric(String param) {
        try {
            Double.valueOf(param);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    /**
     * 通用日期处理
     *
     * @param date
     * @param formatPattern
     * @return
     */
    public static Date getStringDateTime(String date, String formatPattern) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        try {
            if ((formatPattern == null) || formatPattern.equals("")) {
                formatPattern = "yyyy-MM-dd HH:mm:ss";
            }
            sdf.applyPattern(formatPattern);
            return sdf.parse(date);
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    /**
     * 将Sat Dec 01 00:00:00 CST 2007类型的日期转化为YYYY年MM月DD日
     *
     * @param date
     * @return
     */
    public static String parseDateToString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        String ret = "";
        if (date != null) {
            ret = df.format(date);
        }
        return ret;
    }


    /**
     * 根据格式转换日期
     *
     * @param date
     * @param format
     * @return
     */
    public static String parseDateToString(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        String ret = "";
        if (date != null) {
            ret = df.format(date);
        }
        return ret;
    }

    /**
     * 将Sat Dec 01 00:00:00 CST 2007类型的日期转化为MM月DD日
     *
     * @param date
     * @return
     */
    public static String parseDateToMMDD(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("MM月dd日");
        String ret = "";
        if (date != null) {
            ret = df.format(date);
        }
        return ret;
    }

    /**
     * 将Sat Dec 01 00:00:00 CST 2007类型的日期转化为MM月dd日 HH:mm
     *
     * @param date
     * @return
     */
    public static String parseDateTimeToString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("MM月dd日HH:mm");
        String ret = "";
        if (date != null) {
            ret = df.format(date);
        }
        return ret;
    }

    /**
     * 通用日期处理
     *
     * @param date
     * @param formatPattern
     * @return String
     */
    public static String getDateToString(Date date, String formatPattern) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        try {
            if ((formatPattern == null) || formatPattern.equals("")) {
                formatPattern = "yyyy-MM-dd HH:mm:ss";
            }
            sdf.applyPattern(formatPattern);
            return sdf.format(date);
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    /**
     * @param str 2007年05月17日
     * @return
     */
    public static Date parseToDate(String str) {
        if (str == null || str.equals(""))
            return null;
        else {
            int y = 0, m = 0, d = 0;
            y = str.indexOf("年");
            m = str.indexOf("月");
            d = str.indexOf("日");
            if (y == -1 || m == -1 || d == -1)
                return null; // 非法日期格式
            else {
                String temp = str.substring(0, y) + "-" + str.substring(y + 1, m) + "-" + str.substring(m + 1, d);
                // System.out.println(temp);
                return getStringDateTime(temp, "yyyy-MM-dd");
            }
        }
    }

    /**
     * @param str 2007年05月17日
     * @return String
     */
    public static String parseToDate_String(String str) {
        if (str == null || str.equals(""))
            return null;
        else {
            int y = 0, m = 0, d = 0;
            y = str.indexOf("年");
            m = str.indexOf("月");
            d = str.indexOf("日");
            if (y == -1 || m == -1 || d == -1)
                return null; // 非法日期格式
            else {
                String temp = str.substring(0, y) + "-" + str.substring(y + 1, m) + "-" + str.substring(m + 1, d);
                // System.out.println(temp);
                return temp;
            }
        }
    }

    /**
     * @param str 2007年05月
     * @return String 2007-05
     */
    public static String parseToDateString(String str) {
        if (str == null || str.equals(""))
            return null;
        else {
            int y = 0, m = 0;
            y = str.indexOf("年");
            m = str.indexOf("月");
            if (y == -1 || m == -1)
                return null; // 非法日期格式
            else {
                String temp = str.substring(0, y) + "-" + str.substring(y + 1, m);
                return temp;
            }
        }
    }

    /**
     * @param str 2007年05月
     * @return
     */
    public static Date parseToDateMM(String str) {
        if (str == null || str.equals(""))
            return null;
        else {
            int y = 0, m = 0, d = 0;
            y = str.indexOf("年");
            m = str.indexOf("月");
            if (y == -1 || m == -1 || d == -1)
                return null; // 非法日期格式
            else {
                String temp = str.substring(0, y) + "-" + str.substring(y + 1, m);
                // System.out.println(temp);
                return getStringDateTime(temp, "yyyy-MM");
            }
        }
    }

    /**
     * @param str 2007年05月
     * @return
     */
    public static String parseToDate_MM(String str) {
        if (str == null || str.equals(""))
            return null;
        else {
            int y = 0, m = 0, d = 0;
            y = str.indexOf("年");
            m = str.indexOf("月");
            if (y == -1 || m == -1 || d == -1)
                return null; // 非法日期格式
            else {
                String temp = str.substring(0, y) + "-" + str.substring(y + 1, m);
                // System.out.println(temp);
                return temp;
            }
        }
    }

    /**
     * @param str 2007年05月17日
     * @return
     */
    public static Date parseToDateTime(String str) {
        if (str == null || str.equals(""))//"2007年05月17日 15:20"
            return null;
        else {
            int y = 0, m = 0, d = 0, h = 0;
            y = str.indexOf("年");
            m = str.indexOf("月");
            d = str.indexOf("日");
            h = str.indexOf(":");
            if (y == -1 || m == -1 || d == -1)
                return null; // 非法日期格式
            else {
                String temp = str.substring(0, y) + "-" + str.substring(y + 1, m) + "-" + str.substring(m + 1, d) + " " + str.substring(d + 1, h) + ":" + str.substring(h + 1);
                // System.out.println(temp);
                return getStringDateTime(temp, "yyyy-MM-dd HH:mm");
            }
        }
    }

    /**
     * wang-ww
     * 20071206
     *
     * @param str 2007年05月17日
     * @return
     */
    public static Date parseStringToDate(String str) {
        if (str == null || str.equals(""))//"2007年05月17日 15:20"
            return null;
        else {
            int y = 0, m = 0, d = 0;
            y = str.indexOf("年");
            m = str.indexOf("月");
            d = str.indexOf("日");
            if (y == -1 || m == -1 || d == -1)
                return null; // 非法日期格式
            else {
                String temp = str.substring(0, y) + "-" + str.substring(y + 1, m) + "-" + str.substring(m + 1, d);
                // System.out.println(temp);
                return getStringDateTime(temp, "yyyy-MM-dd");
            }
        }
    }

    public static float parseFloat(String str) {
        float f = 0f;
        try {
            f = Float.parseFloat(str);
        } catch (Exception e) {
        }
        return f;
    }

    public static String processNull(String str) {
        if (str == null) {
            return "";
        } else {
            if (str.trim().equalsIgnoreCase("null")) {
                return "";
            } else {
                return str;
            }
        }
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return boolean
     */
    public static boolean isNull(String str) {
        return str == null || str.length() == 0 || "".equalsIgnoreCase(str.trim()) || "null".equalsIgnoreCase(str.trim());
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str
     * @return boolean
     */
    public static boolean notNull(String str) {
        return !isNull(str);
    }

    /**
     * 将日期中的时间归零
     *
     * @param date
     * @param formatPattern
     * @return
     */
    public static Date getDateTimeToDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        try {
            sdf.applyPattern("yyyy-MM-dd");
            return sdf.parse(sdf.format(date));
        } catch (Exception e) {
            return null;
        }
    }

    public static String getLocalDate() {
        Date d = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 E");
        String str = sf.format(d);
        return str;
    }


    /**
     * 将当前系统日期转化为yyyymmddhhmmss格式字符串
     */
    public static String parseSysDateToString() {
        Date dt = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        return df.format(dt);
    }

    /**
     * 获取随机字符串
     *
     * @param randomLength
     * @return
     */
    public static String randomStr(int randomLength) {
        char[] randoms = {'0', '1', '2', '3',
                '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z'};
        Random random = new Random();
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < randomLength; i++) {
            ret.append(randoms[random.nextInt(randoms.length)]);
        }
        random = null;
        return ret.toString();
    }

    /**
     * 获取随机字符串+时间戳
     *
     * @param randomLength
     * @return
     */
    public static String randomStrTime() {

        Long seed = System.currentTimeMillis();// 获得系统时间，作为生成随机数的种子

        StringBuffer sb = new StringBuffer();// 装载生成的随机数

        Random random = new Random(seed);// 调用种子生成随机数

        for (int i = 0; i < 20; i++) {

            sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
        }
        sb.append(seed);
        return sb.toString();

    }

    /**
     * 获取客户端
     *
     * @param request
     * @return
     */
    public static final String getIpAddr(HttpServletRequest request) {
        if (request == null)
            return null;
        String ip = request.getHeader("X-Real-IP");//该值为运维配置项
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 字符串加密
     *
     * @param data
     * @return
     */
    public synchronized static final String hash(String data) {
        if (digest == null) {
            try {
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException nsae) {
                System.err.println("Failed to load the MD5 MessageDigest. " + "Jive will be unable to function normally.");
                nsae.printStackTrace();
            }
        }
        // Now, compute hash.
        try {
            digest.update(data.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return encodeHex(digest.digest());
    }

    public static final String encodeHex(byte[] bytes) {
        StringBuffer buf = new StringBuffer(bytes.length * 2);
        int i;

        for (i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return buf.toString();
    }

    public static String formatPhoneNum(String phone) {
        if (StringUtil.isNull(phone)) {
            return null;
        } else {
            if (phone.length() <= 7) {
                return phone;
            } else {
                return phone.substring(0, 3) + "****" + phone.substring(7, phone.length());
            }
        }
    }

    /**
     * byte转字符串
     *
     * @param arrB
     * @return
     * @throws Exception
     */
    public static String byteArr2HexStr(byte[] arrB)
            throws Exception {
        int iLen = arrB.length;

        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];

            while (intTmp < 0) {
                intTmp += 256;
            }

            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * 字符串转byte
     *
     * @param strIn
     * @return
     * @throws Exception
     */
    public static byte[] hexStr2ByteArr(String strIn)
            throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;

        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i += 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[(i / 2)] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    /**
     * 取当天零点零分零秒
     */
    public static String getTodayStart() {
        Calendar calendar = Calendar.getInstance();
        //如果没有这种设定的话回去系统的当期的时间
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = new Date(calendar.getTimeInMillis());
        return getDateToString(date, "");
    }

    /**
     * 取当天23点59分59秒
     */
    public static String getTodayEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date date = new Date(calendar.getTimeInMillis());
        return getDateToString(date, "");
    }

    /**
     * 空字符串校验
     *
     * @param v
     * @return
     */
    public static String checkValue4String(String v) {
        v = v == null ? "" : v;
        v = "null".equals(v.trim()) ? "" : v;
        return v.trim();
    }

    public static String encode(String str, String code) {
        try {
            return URLEncoder.encode(str, code);
        } catch (Exception e) {
            return "";
        }
    }

    public static String decode(String str, String code) {
        try {
            return URLDecoder.decode(str, code);
        } catch (Exception e) {
            return "";
        }
    }
}

