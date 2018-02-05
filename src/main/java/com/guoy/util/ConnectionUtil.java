package com.guoy.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionUtil {

    public static String Connect(String address) {
        HttpURLConnection conn = null;
        URL url = null;
        InputStream in = null;
        BufferedReader reader = null;
        StringBuffer stringBuffer = null;
        try {
            url = new URL(address);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setDoInput(true);
            int n = RandomUtil.getRandom(1,5);
            System.out.println(n);
            switch (n) {
                case 1:
                    conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                    break;
                case 2:
                    conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.137 Safari/537.36 LBBROWSER 1.1");
                    break;
                case 3:
                    conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 10.0;Windows NT 6.1; WOW64; Trident/6.0)");
                    break;
                default:
                    conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 10.0;Windows NT 6.1; WOW64; Trident/6.0) LBBROWSER");
                    break;
            }
            conn.connect();
            in = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            stringBuffer = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    public static String Connect(String address,String encode) {
        HttpURLConnection conn = null;
        URL url = null;
        InputStream in = null;
        BufferedReader reader = null;
        StringBuffer stringBuffer = null;
        try {
            url = new URL(address);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setDoInput(true);
            int n = RandomUtil.getRandom(1,5);
            System.out.println(n);
            switch (n) {
                case 1:
                    conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                    break;
                case 2:
                    conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.137 Safari/537.36 LBBROWSER 1.1");
                    break;
                case 3:
                    conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 10.0;Windows NT 6.1; WOW64; Trident/6.0)");
                    break;
                default:
                    conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 10.0;Windows NT 6.1; WOW64; Trident/6.0) LBBROWSER");
                    break;
            }
            conn.connect();
            in = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in, encode));
            stringBuffer = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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


