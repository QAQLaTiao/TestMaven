package com.guoy.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionUtil {

	public static String Connect(String address){
		HttpURLConnection conn = null;
		URL url = null;
		InputStream in = null;
		BufferedReader reader = null;
		StringBuffer stringBuffer = null;
		try {
			url = new URL(address);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(10000000);
			conn.setReadTimeout(10000000);
			conn.setDoInput(true);
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			conn.connect();
			in = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			stringBuffer = new StringBuffer();
			String line = null;
			while((line = reader.readLine()) != null){
				stringBuffer.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			conn.disconnect();
			try {
				in.close();
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return stringBuffer.toString();
	}
}
