package com.guoy.util;

import org.apache.log4j.Logger;

public class Syslog {
	private static final Logger logger = Logger.getLogger(Syslog.class);
	
	//debug生产日志
	public static void debug(Object syslog){
		logger.debug("UMWAP:TRAVEL|"+syslog.toString());
	}
	//业务日志
	public static void bussInfo(String syslog){
		logger.info("UMWAP_NEW:TRAVEL|"+syslog);
	}
	//info生产日志
	public static void info(Object syslog){
		logger.info("UMWAP:TRAVEL|"+syslog.toString());
	}
	//error错误生产日志
	public static void error(Object syslog){
		logger.error("UMWAP:TRAVEL|"+syslog.toString());
	}
	
}
