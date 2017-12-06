package com.guoy.util;

import java.security.MessageDigest;


/**
 * 12580 OPEN_API 生成sing签名以及对sing加密
 * @author wzq
 *
 */
public class MD5Util {

    /**
     * 传过来的字符串进行签名(字符串计算32位大写MD5值)
     * @param plain
     * @return
     */
	public static  String MD5_32bit(String plain) { 
		StringBuilder su = new StringBuilder();
		try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte [] b = md.digest(plain.getBytes());  
            int temp = 0;  
            for(int offset = 0,bLen = b.length; offset < bLen; offset++){  
                temp = b[offset];  
                if(temp < 0){  
                    temp += 256;  
                }  
                int d1 = temp / 16;  
                int d2 = temp % 16;  
                su.append(Integer.toHexString(d1) + Integer.toHexString(d2)) ;  
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return su.toString().toUpperCase();   
    }  
	/**
	 * 传过来的字符串进行签名(字符串计算32位小写md5值)
	 * @param plain
	 * @return
	 */
	public static  String md5_32bit(String plain) { 
		StringBuilder su = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte [] b = md.digest(plain.getBytes());  
			int temp = 0;  
			for(int offset = 0,bLen = b.length; offset < bLen; offset++){  
				temp = b[offset];  
				if(temp < 0){  
					temp += 256;  
				}  
				int d1 = temp / 16;  
				int d2 = temp % 16;  
				su.append(Integer.toHexString(d1) + Integer.toHexString(d2)) ;  
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return su.toString();   
	}  
}
