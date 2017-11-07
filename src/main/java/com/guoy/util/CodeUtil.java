package com.guoy.util;


import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
	public static String translate(HttpServletRequest request,String oldString)
	{
		String para = null;
		try {
			 para = request.getParameter(oldString);
			 if(para!=null){return new String(para.getBytes("ISO-8859-1"),"UTF-8");}
			 else{return para;}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return para;
	}
}
