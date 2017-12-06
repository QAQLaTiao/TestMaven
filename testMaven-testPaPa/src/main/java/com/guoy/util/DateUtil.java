package com.guoy.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class DateUtil {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HHmm");
    static SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
    static SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat sdf6 = new SimpleDateFormat("MM-dd");
	static SimpleDateFormat sdf7 = new SimpleDateFormat("yyMMddHH"); 
	static SimpleDateFormat sdf8 = new SimpleDateFormat("yyMM"); 
	public static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	public static SimpleDateFormat fullFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	public static DateFormat sdf9 = new SimpleDateFormat("yyyy年MM月dd日HH时");
    static GregorianCalendar gc = new GregorianCalendar();
    static List<?> specialDayList = null;
    
    public static final int YEAR = GregorianCalendar.YEAR;
    public static final int MONTH = GregorianCalendar.MONTH;
    public static final int DAY = GregorianCalendar.DATE;
    public static final int HOUR = GregorianCalendar.HOUR;
    public static final int MINUTE = GregorianCalendar.MINUTE;
    public static final int SECOND = GregorianCalendar.SECOND;
    
    private static final char[] zeroArray =
        "0000000000000000000000000000000000000000000000000000000000000000".toCharArray();



    /**
     * 得到年月日
     */
    public static String getYMD(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        String date_1 = df.format(date);

        return date_1;
    }

    /**
     * 得到时分秒
     */
    public static String getHMS(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        String date_2 = df.format(date);
        return date_2;
    }

    /**
     * 获取指定时间的字符串，
     */
    public static String getDateTime(long time) {
        Date date = new Date(time);
        if (date != null && !"".equals(date)) {
            return sdf2.format(date);
        } else {
            return "";
        }
    }


    public static Date format(HttpServletRequest request,String oldString)
	{
		String para = null;
		try {
			para = request.getParameter(oldString); 
			SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd" );
			if(para!=null){
				if(!para.equals(""))
					return sdf.parse(para);
			}else{
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    /**
     * 判断是否周末
     */
    public static boolean isWeekend(Calendar theDay) {
        int dayOfWeek = theDay.get(Calendar.DAY_OF_WEEK);
        
        return (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY);
    }
    
    /**
     * 获取指定时间的月份，信用卡有效期使用
     */
    public static String getMonth(Date date){
    	if(date!=null&&!date.equals(""))
    		return sdf4.format(date);
    	else
    		return "";
    }
    /**
	 * 返回两个日期差
	 * 
	 * @param _date1
	 * @param _date2
	 * @return
	 */
	public static String getDateDifference(String _date1, String _date2) {
		long dayNumber = 0;
		long DAY = 24L * 60L * 60L * 1000L;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date d1 = df.parse(_date1);
			java.util.Date d2 = df.parse(_date2);
			dayNumber = (d2.getTime() - d1.getTime()) / DAY;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "" + (Integer.parseInt("" + dayNumber) + 1);

	}
    /**
     * 获取指定时间的字符串，
     */
    public static String getDateTime(Date date){
    	if(date!=null&&!date.equals(""))
    		return sdf2.format(date);
    	else
    		return "";
    }
    public static String getDateTimeYMD(Date date){
    	if(date!=null&&!date.equals(""))
    		return sdf5.format(date);
    	else
    		return "";
    }
    /**
     * 得到时间 月-日
     * @param date
     * @return
     */
    public static String getDateTimeMD(Date date){
    	if(date!=null&&!date.equals(""))
    		return sdf6.format(date);
    	else
    		return "";
    }

    /**
     * 当前系统时间
     */
    public static Date getSysDate() {
        return new Date();
    }
    
    /**
     * 当前系统时间
     */
    public static Calendar getSysCalendar() {
        Calendar currCalendar = Calendar.getInstance();
        return currCalendar;
    }
    
    /**
     * 取得当前月的字符串形式yyyy-MM
     */
    public static String getCurrMonth(){
        return format(new Date(), "yyyy-MM");
    }
    /**
     * 获取当前日期的年
     * @return
     */
    public static String getCurrYear(){
    	return format(new Date(),"yyyy");
    }
    /*
     * 取得当前时间的字符串形式yyyy-MM-dd
     */
    public static String getCurrDate() {
        return sdf.format(new Date());
    }
    
    /*
     * 取本月第一天
     */
    public static String getFirstDayOfMonth(){
        String curMonth = getCurrMonth();
        return curMonth+"-01";
    }
    
    /*
     * 取得当前时间的字符串形式yyyy-MM-dd
     */
    public static String getCurrTime() {
        return format(new Date(),"yyyy-MM-dd HH:mm:ss");        
    }   
    
    /*
     *  解析字符串中的日期 yyyy-MM-dd
     */
    public static Date parseDate(String s) {
        Date d = null;
        try {
            d = sdf.parse(s);
        } catch (Exception e) {
        }
        return d;
    }
    /*
     *  解析字符串中的日期 yyyy-MM
     */
    public static Date parseDate6(String s) {
        Date d = null;
        try {
            d = sdf6.parse(s);
        } catch (Exception e) {
        }
        return d;
    }
    /**
     *  解析字符串中的日期 yyyy-MM-dd hh:mm:ss
     */
    public static Date parseDateToLocal(String s) {
        Date d = null;
        try {
            d = sdf2.parse(s);
        } catch (Exception e) {
        }
        return d;
    }
    
    public static Date parseDateTime(String s) {
        Date d = null;
        try {
            d = sdf2.parse(s);
        } catch (Exception e) {
        }
        return d;
    }
    
    public static Date parseStrDateTime(String s) {
        Date d = null;
        try {
            d = sdf3.parse(s);
        } catch (Exception e) {
        }
        return d;
    }
    
    public static Calendar parseCalendar(String s) {
        Calendar c = null;
        Date d = parseDate(s);
        
        if (d != null) {
            c = Calendar.getInstance();
            c.setTime(d);
        } 
        return c;
    }
    
    public static Calendar parseCalendarTime(String s) {
        Calendar c = null;
        Date d = parseDateTime(s);
        
        if (d != null) {
            c = Calendar.getInstance();
            c.setTime(d);
        }
        return c;
    }
    
    public static Date parseCSTDate(String s){
        SimpleDateFormat simples = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US); 
        try{
        	Date date = simples.parse(s);
            return date;
        }catch(Exception e){
        	return null;
        }
    }
    
    /**
     *  返回日期的 "yyyy-mm-dd" 形式
     * 
     */
    public static String toString(Date d) {
        String s = null;
        try {
            s = sdf.format(d);
        } catch (Exception e) {
        }
        return s;
    }
    
    public static String toString(Object d) {
        if (d == null) {
            return null;
        }
        if (d instanceof Date) {
            return toString((Date) d);
        }
        return null;
    }
    
    /*
     * 转换日期为指定格式的字符串

     * 用例：format(new Now(), "yyyy-MM-dd")
     *      format(new Now(), "yyyy-MM")
     */
    public static String format(Date d, String format) {
        if (d == null) {
            return null;
        }
        sdf.applyPattern(format);
        String s = sdf.format(d);
        sdf.applyPattern("yyyy-MM-dd");
        return s;
    }
        
    /*
     * 转换日期和时间为指定格式的字符串
     * 用例：format(new Now(), "yyyy-MM-dd")
     *      format(new Now(), "yyyy-MM")
     *      format(new Now(), "yyyy-MM-dd hh:mm:ss")
     */
    public static String format(Calendar c, String format) {
        return format(c == null ? (Date)null : c.getTime(), format);
    }
    
    public static String format(Date d) {
        return format(d, "yyyy-MM-dd");
    }
    
    public static String format(Calendar c) {
        return format(c == null ? (Date)null : c.getTime());
    }
    
    public static String format(String s, String format) {
        Date d = parseDate(s);
        if (d == null) {
            return null;
        }
        return format(d, format);
    }
    
    public static String format2(String s, String format) {
        Date d = parseDateTime(s);
        if (d == null) {
            return null;
        }
        return format(d, format);
    }
    
    public static String format(String s) {
        return format(s, "yyyy-MM-dd");
    }
    
    /**
	 * 通用日期处理
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
		}
		catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	/**
	 * 将Sat Dec 01 00:00:00 CST 2007类型的日期转化为YYMMDDHH
	 * @param date
	 * @return
	 */
	public static String parseDateToString7(Date date){
		String ret = "";
		if(date != null){
			ret = sdf7.format(date);
		}
		return ret;
	}	
	/**
	 * 将Sat Dec 01 00:00:00 CST 2007类型的日期转化为YYMMDDHH
	 * @param date
	 * @return
	 */
	public static Date parseStringToDate8(String date)throws Exception{
		return sdf8.parse(date);
	}
	/**
	 * 将Sat Dec 01 00:00:00 CST 2007类型的日期转化为YYYY年MM月DD日
	 * @param date
	 * @return
	 */
	public static String parseDateToString(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		String ret = "";
		if(date != null){
			ret = df.format(date);
		}
		return ret;
	}
	/**
	 * 将Sat Dec 01 00:00:00 CST 2007类型的日期转化为MM月DD日
	 * @param date
	 * @return
	 */
	public static String parseDateToMMDD(Date date){
		SimpleDateFormat df = new SimpleDateFormat("MM月dd日");
		String ret = "";
		if(date != null){
			ret = df.format(date);
		}
		return ret;
	}
	
	/**
	 * 将Sat Dec 01 00:00:00 CST 2007类型的日期转化为MM月dd日 HH:mm
	 * @param date
	 * @return
	 */
	public static String parseDateTimeToString(Date date){
		SimpleDateFormat df = new SimpleDateFormat("MM月dd日HH:mm");
		String ret = "";
		if(date != null){
			ret = df.format(date);
		}
		return ret;
	}
	
	/**
	 * 将Sat Dec 01 00:00:00 CST 2007类型的日期转化为 HH:mm
	 * @param date
	 * @return
	 */
	public static String parseDateToHHMM(Date date){
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		String ret = "";
		if(date != null){
			ret = df.format(date);
		}
		return ret;
	}
	
	/**
	 * 通用日期处理
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
		}
		catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
    
    /*
     * 例如：addDate(new Date(), UserDate.DAY, 10) -- 在当前日期上加10天

     */
    public static Date addDate(Date date, int field, int amount) {
        gc.setTime(date);
        gc.add(field, amount);
        return gc.getTime();
    }
    
    /*
     * 返回 d1 - d2 之间相差的月份数
     */
    public static int months_between(Date d1, Date d2) {
        int elapsed = 0;
        GregorianCalendar gc1, gc2;
        GregorianCalendar g1 = new GregorianCalendar();
        GregorianCalendar g2 = new GregorianCalendar();
        g1.setTime(d1);
        g2.setTime(d2);
        int zhenfu = 1;
        if (g2.after(g1)) {
            gc2 = (GregorianCalendar) g2.clone();
            gc1 = (GregorianCalendar) g1.clone();
            zhenfu = -1;
        } else {
            gc2 = (GregorianCalendar) g1.clone();
            gc1 = (GregorianCalendar) g2.clone();
        }
        
        gc1.clear(Calendar.MILLISECOND);
        gc1.clear(Calendar.SECOND);
        gc1.clear(Calendar.MINUTE);
        gc1.clear(Calendar.HOUR_OF_DAY);
        gc1.clear(Calendar.DATE);
        
        gc2.clear(Calendar.MILLISECOND);
        gc2.clear(Calendar.SECOND);
        gc2.clear(Calendar.MINUTE);
        gc2.clear(Calendar.HOUR_OF_DAY);
        gc2.clear(Calendar.DATE);
        
        while (gc1.before(gc2)) {
            gc1.add(Calendar.MONTH, 1);
            elapsed++;
        }
        return elapsed * zhenfu;
    }
    
    /*
     * 返回 d1 - d2 之间相差的天数
     */
    public static int daysBetween(Date d1, Date d2) {
        int elapsed = 0;
        GregorianCalendar gc1, gc2;
        GregorianCalendar g1 = new GregorianCalendar();
        GregorianCalendar g2 = new GregorianCalendar();
        g1.setTime(d1);
        g2.setTime(d2);
        int zhenfu = 1;
        if (g2.after(g1)) {
            gc2 = (GregorianCalendar) g2.clone();
            gc1 = (GregorianCalendar) g1.clone();
            zhenfu = -1;
        } else {
            gc2 = (GregorianCalendar) g1.clone();
            gc1 = (GregorianCalendar) g2.clone();
        }
        
        gc1.clear(Calendar.MILLISECOND);
        gc1.clear(Calendar.SECOND);
        gc1.clear(Calendar.MINUTE);
        gc1.clear(Calendar.HOUR_OF_DAY);
        
        gc2.clear(Calendar.MILLISECOND);
        gc2.clear(Calendar.SECOND);
        gc2.clear(Calendar.MINUTE);
        gc2.clear(Calendar.HOUR_OF_DAY);
        
        while (gc1.before(gc2)) {
            gc1.add(Calendar.DATE, 1);
            elapsed++;
        }
        return elapsed * zhenfu;
    }
    
    /*
     * 返回d1-d2相差的分钟数，d1较大时为正数，否则为负数
     */
    public static int minutes_between(Date d1, Date d2) {
        int elapsed = 0;
        GregorianCalendar gc1, gc2;
        GregorianCalendar g1 = new GregorianCalendar();
        GregorianCalendar g2 = new GregorianCalendar();
        g1.setTime(d1);
        g2.setTime(d2);
        int zhenfu = 1;
        if (g2.after(g1)) {
            gc2 = (GregorianCalendar) g2.clone();
            gc1 = (GregorianCalendar) g1.clone();
            zhenfu = -1;
        } else {
            gc2 = (GregorianCalendar) g1.clone();
            gc1 = (GregorianCalendar) g2.clone();
        }
        
        gc1.clear(Calendar.MILLISECOND);
        gc1.clear(Calendar.SECOND);
        
        gc2.clear(Calendar.MILLISECOND);
        gc2.clear(Calendar.SECOND);
        
        while (gc1.before(gc2)) {
            gc1.add(Calendar.MINUTE, 1);
            elapsed++;
        }
        return elapsed * zhenfu;
    }
    
    //判断当前时间是否在时间date2之前
    //时间格式 2005-4-21 16:16:34
    public static boolean isDateBefore(String date2){
        try{
            Date date1 = new Date();
            DateFormat df = DateFormat.getDateTimeInstance();
            return date1.before(df.parse(date2)); 
        }catch(Exception e){
            System.out.print("[SYS] " + e.getMessage());
            return false;
        }
    }
    
    public static boolean newDateBefore(String date2){
        try{
            Date date1 = new Date();
            return date1.before(sdf2.parse(date2)); 
        }catch(Exception e){
            System.out.print("[SYS] " + e.getMessage());
            return false;
        }
    }
    public static boolean newDateBefore(Date date1,Date date2){
        try{
            return date1.before(date2); 
        }catch(Exception e){
            return false;
        }
    }
    //  得到日期的星期
    public static String getDayOfWeek(String date) {
        String str = "";
        Calendar c = parseCalendar(date);
        if (c==null) return str;
        
        int day = c.get(Calendar.DAY_OF_WEEK);
        switch (day) {
        case Calendar.SUNDAY:
            str = "日";
            break;
        case Calendar.MONDAY:
            str = "一";
            break;
        case Calendar.TUESDAY:
            str = "二";
            break;
        case Calendar.WEDNESDAY:
            str = "三";
            break;
        case Calendar.THURSDAY:
            str = "四";
            break;
        case Calendar.FRIDAY:
            str = "五";
            break;
        case Calendar.SATURDAY:
            str = "六";
            break;
        default:
            str = "";
        }
        return str;
    }
    public static String getDayNumOfWeek(String date) {
        String str = "";
        Calendar c = parseCalendar(date);
        if (c==null) return str;
        
        int day = c.get(Calendar.DAY_OF_WEEK);
        switch (day) {
        case Calendar.SUNDAY:
            str = "0";
            break;
        case Calendar.MONDAY:
            str = "1";
            break;
        case Calendar.TUESDAY:
            str = "2";
            break;
        case Calendar.WEDNESDAY:
            str = "3";
            break;
        case Calendar.THURSDAY:
            str = "4";
            break;
        case Calendar.FRIDAY:
            str = "5";
            break;
        case Calendar.SATURDAY:
            str = "6";
            break;
        default:
            str = "";
        }
        return str;
    }
    /**
     * Formats a Date as a fifteen character long String made up of the Date's
     * padded millisecond value.
     *
     * @return a Date encoded as a String.
     */
    public static String dateToMillis(Date date) {
        return zeroPadString(Long.toString(date.getTime()), 15);
    }
    
    /**
     * Pads the supplied String with 0's to the specified length and returns
     * the result as a new String. For example, if the initial String is
     * "9999" and the desired length is 8, the result would be "00009999".
     * This type of padding is useful for creating numerical values that need
     * to be stored and sorted as character data. Note: the current
     * implementation of this method allows for a maximum <tt>length</tt> of
     * 64.
     *
     * @param string the original String to pad.
     * @param length the desired length of the new padded String.
     * @return a new String padded with the required number of 0's.
     */
    public static String zeroPadString(String string, int length) {
        if (string == null || string.length() > length) {
            return string;
        }
        StringBuilder buf = new StringBuilder(length);
        buf.append(zeroArray, 0, length - string.length()).append(string);
        return buf.toString();
    }
    
    /**
	 * 根据传入的开始时间和截止时间，返回该时间范围内的小时列表	
	 */
	public static List<String> getBetweenHourList(String beginTime, String endTime)
	{
		List<String> list = new ArrayList<String>();
		
		if(beginTime != null &&  beginTime.length() >= 2 && endTime != null && endTime.length() >= 2)
		{
			beginTime = beginTime.substring(0,2);//开始时间
			endTime = endTime.substring(0,2); //结束时间
			
			int totalHours = Integer.parseInt(endTime) - Integer.parseInt(beginTime) + 1; //总小时数
			
			for(int i = 0; i < totalHours; i ++)
			{
				String temp = (Integer.parseInt(beginTime) + i) + "";
				if(temp.length() == 1)
				{
					list.add("0" + temp + ":00");
					
					//结束时间不生成半小时
					if(Integer.parseInt(temp) != Integer.parseInt(endTime))
						list.add("0" + temp + ":30");
				}
				else{
					list.add(temp + ":00");
					
					//结束时间不生成半小时
					if(Integer.parseInt(temp) != Integer.parseInt(endTime))
						list.add(temp + ":30");
				}
				
				
			}
		}
		
		return list;
	}
	
	public static String getCurrente(){
		return yyyyMMdd.format(new Date());
	}
	/**
	 * 获得指定日期的前一天
	 */
	public static Date getBeforeDay(Date date){
		return  new Date(date.getTime()-1000*60*60*24);
	}
	
	/**
	 * 获得指定日期的后一天
	 */
	public static Date getaAfterDay(Date date){
		return  new Date(date.getTime()+1000*60*60*24);
	}
	/**
	 * 获得当前时间前毫秒的时间
	 * @param date 所需时间
	 * @param time 相差时间段
	 * @return
	 */
	public static Date getaSubDay(Date date,long time){
		return  new Date(date.getTime()+time);
	}
	public static Date stringToDate(String str) {
		String strFormat = "yyyy-MM-dd HH:mm";
		if (str != null && str.length() == 10) {
		strFormat = "yyyy-MM-dd";
		}
		SimpleDateFormat sdFormat = new SimpleDateFormat(strFormat);
		Date date = new Date();
		try {
		date = sdFormat.parse(str);
		}
		catch(Exception e) {
		//System.out.println("Error="+e);
		return null;
		}
		return date;
	}
	
	/**
	 * 将日期转换成MMdd形式
	 * @param time
	 * @return
	 */
	public String sendDate(String time){
		  Date d = new Date();
		    
	      d = DateUtil.stringToDate(time);
	      
		  SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
			
		  String date = sdf.format(d);
		  
		  return date;
	}
	
	/**
	 * 当前日期下一天转换成YYYY-MM-DD形式
	 */
	public static String getNextDate(){
		Calendar cal = GregorianCalendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Date date = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		return str;
	}
	
	/**
	 * 
	 * @param hh
	 * @param mi
	 * @param ss
	 * @param SSS
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static Date getCurrentDate(Date date,int hh,int mi,int ss,int SSS){
		gc.setTime(date);	
		gc.set(gc.HOUR_OF_DAY, hh);
		gc.set(gc.MINUTE, mi);
		gc.set(gc.SECOND, ss);
		gc.set(gc.MILLISECOND, SSS);
		return gc.getTime();
	}
	
	public static boolean validate(String dateString){		//使用正则表达式 测试 字符 符合 dddd-dd-dd 的格式(d表示数字)		
		Pattern p = Pattern.compile("\\d{4}+[-]\\d{1,2}+[-]\\d{1,2}+");		
		Matcher m = p.matcher(dateString);		
		if(!m.matches()){	
			return false;
		} 				//得到年月日		
		String[] array = dateString.split("-");		
		int year = Integer.valueOf(array[0]);		
		int month = Integer.valueOf(array[1]);		
		int day = Integer.valueOf(array[2]);				
		if(month<1 || month>12){	
			return false;
		}		
		int[] monthLengths = new int[]{0, 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};		
		if(isLeapYear(year)){			
			monthLengths[2] = 29;		
		}else{			
			monthLengths[2] = 28;		
		}		
		int monthLength = monthLengths[month];		
		if(day<1 || day>monthLength){			
			return false;			
		}		
		return true;	
	}		
	/** 是否是闰年 */	
	private static boolean isLeapYear(int year){
		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ;	
	}
	/**
	 * 获取指定年月的月份的最后一天
	 * @param year
	 * @param month
	 * @return
	 */
	public static String assignMonthLastDay (int year, int month) {
	    Calendar calendar=Calendar.getInstance(); 
	    calendar.set(Calendar.YEAR, year);
	    calendar.set(Calendar.MONTH,month-1);
	    @SuppressWarnings("static-access")
		int end=calendar.getActualMaximum(calendar.DAY_OF_MONTH);
	    return String.valueOf(end);
	}
	
	/**
	 * 获得指定日期的前n天
	 */
	public static Date getBeforeOffsetDay(Date date, int offsetDays){
		return  new Date(date.getTime()-(long)offsetDays*1000*60*60*24);
	}
	
	/**
	 * 获得指定日期的后n天
	 */
	public static Date getAfterOffsetDay(Date date, int offsetDays){
		return  new Date(date.getTime() + (long)offsetDays*1000*60*60*24);
	}
	
    /*
     * 取指定日期当月第一天
     */
    public static Date getFirstDayOfTheMonth(Date date){
        
        GregorianCalendar gc =  new GregorianCalendar();
        gc.setTime(date);
        gc.set(Calendar.DATE, 1);
        return gc.getTime();
    }
    
    /*
     * 取指定日期当月最后一天
     */
    public static Date getLastDayOfTheMonth(Date date){
        
        GregorianCalendar gc =  new GregorianCalendar();
        gc.setTime(date);
        gc.set(Calendar.DATE, 1);	// 变为当月第一天	
        gc.add(Calendar.MONTH, 1);	// 变为下月第一天
        gc.add(Calendar.DATE, -1);	// 减去一天，变为当月最后一天
        return gc.getTime();
    }    

	/**
     * 通用方法，给日期加减时间
     * @param time 日期
     * @param type 处理的类型(加或减)
     * @param minute 时间，分钟为单位
     * @param formatPattern 日期的解析格式
     * @return
     */
    public static Date calculateTime(String time,String type,int minute,String formatPattern){
    	Date date1 = getStringDateTime(time,formatPattern);
    	if(date1==null){
    		return null;
    	}
		long s1 = date1.getTime();
		long s2 = 0;
		if("add".equals(type)){
			s2 = s1+(minute*60*1000);
		}else if("sub".equals(type)){
			s2 = s1-(minute*60*1000);
		}
		return new Date(s2);
    }
    public static String calculateTime(Date date,String type,int minute){
    	if(date==null){
    		return null;
    	}
		long s1 = date.getTime();
		long s2 = 0;
		if("add".equals(type)){
			s2 = s1+(minute*60*1000);
		}else if("sub".equals(type)){
			s2 = s1-(minute*60*1000);
		}
		Date date2 = new Date(s2);
		return sdf2.format(date2);
    }
    public static String getDayFullOfWeek(String date) {
        String str = "";
        Calendar c = parseCalendar(date);
        if (c==null) return str;
        
        int day = c.get(Calendar.DAY_OF_WEEK);
        switch (day) {
        case Calendar.SUNDAY:
            str = "星期日";
            break;
        case Calendar.MONDAY:
            str = "星期一";
            break;
        case Calendar.TUESDAY:
            str = "星期二";
            break;
        case Calendar.WEDNESDAY:
            str = "星期三";
            break;
        case Calendar.THURSDAY:
            str = "星期四";
            break;
        case Calendar.FRIDAY:
            str = "星期五";
            break;
        case Calendar.SATURDAY:
            str = "星期六";
            break;
        default:
            str = "";
        }
        return str;
    }
    
    /** 
	 * 判断某一时间是否在一个区间内 
	 *  
	 * @param sourceTime 
	 *            时间区间,半闭合,如[10:00-20:00) 
	 * @param curTime 
	 *            需要判断的时间 如10:00 
	 * @return  
	 * @throws IllegalArgumentException 
	 */  
	public static boolean isInTime(String sourceTime, String curTime) {
	    if (sourceTime == null || !sourceTime.contains("-") || !sourceTime.contains(":")) {
	        throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
	    }
	    if (curTime == null || !curTime.contains(":")) {
	        throw new IllegalArgumentException("Illegal Argument arg:" + curTime);
	    }
	    String[] args = sourceTime.split("-");
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	    try {
	        long now = sdf.parse(curTime).getTime();
	        long start = sdf.parse(args[0]).getTime();
	        long end = sdf.parse(args[1]).getTime();
	        if (args[1].equals("00:00")) {
	            args[1] = "24:00";
	        }
	        if (end < start) {
	            if (now >= end && now < start) {
	                return false;
	            } else {
	                return true;
	            }
	        } 
	        else {
	            if (now >= start && now < end) {
	                return true;
	            } else {
	                return false;
	            }
	        }
	    } catch (ParseException e) {
	        e.printStackTrace();
	        throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
	    }
	}
	

	/**
	 * 根据身份证算性别 true为男   false为女
	 * @param idcard 身份证号
	 * @return
	 */
	public static boolean gender(String idcard){
		String sex = idcard.substring(16, 17);    
        if (Integer.parseInt(sex) % 2 != 0) {    
            return true;    
        } else {    
            return false;    
        }   
	} 
	
	/**
	 * 根据身份照号码获取 出生年月日 返回格式为 yyyy-MM-dd
	 * @param idcard 身份证号码
	 * @return
	 */
	public static String dateOfBirth(String idcard){
		int year = 0; //年(yyyy)
		int month = 0; //月(MM)
		int day = 0; //日(dd)
		try {
			 String birthday = idcard.substring(6, 14);    
	         Date birthdate = new SimpleDateFormat("yyyyMMdd").parse(birthday);    
	         GregorianCalendar currentDay = new GregorianCalendar();    
	         currentDay.setTime(birthdate);    
	         year=currentDay.get(Calendar.YEAR);    
	         month=currentDay.get(Calendar.MONTH) + 1;    
	         day=currentDay.get(Calendar.DAY_OF_MONTH);
		} catch (Exception e) {
			e.printStackTrace();
		}
	   return String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
	}
	
	/**
	 * 如果DATE1大于DATE2返回1  如果DATE1小于DATE2返回-1  否则返回0
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compareDate(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}
