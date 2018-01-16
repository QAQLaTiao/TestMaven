package com.guoy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

	static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Date date = new Date();
//		String s1="2014-08-13";
//		String s2="2014-08-14";
//		System.out.println(getDateDifference(s1,s2));
		System.out.println(date);

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
		return "" + (Integer.parseInt("" + dayNumber));

	}
	/**
	 * 
	 * 得到年月日 
	 */
	public static String getYMD(Date date){
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String date_1 = df.format(date);
		
		return  date_1;
	}
	/**
	 * 得到时分秒
	 */
	public static String getHMS(Date date){
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		String date_2 = df.format(date);
		return date_2;
	}
	
    /**
     * 获取指定时间的字符串，
     */
    public static String getDateTime(long time){
    	Date date=new Date(time);
    	if(date!=null&&!"".equals(date))
    		return sdf2.format(date);
    	else
    		return "";
    }

}
