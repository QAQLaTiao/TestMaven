package com.guoy.util;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/** HttpClient工具类 **/
public class HttpClientUtil {

	public static String doGet(String url, Map<String, String> param) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();
			HttpGet get = new HttpGet(uri);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
			get.setConfig(requestConfig);
			response = httpClient.execute(get);
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpClient.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		return resultString;
	}

	public static String doGet(String url) {
		return doGet(url, null);
	}

	public static String doPost(String url, Map<String, String> param) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
			httpPost.setConfig(requestConfig);
			
			if (param != null) {
				List<NameValuePair> list = new ArrayList<NameValuePair>();
				for (String key : param.keySet()) {
					NameValuePair nv = new BasicNameValuePair(key, param.get(key));
					list.add(nv);
				}
				UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");
				httpPost.setEntity(encodedFormEntity);
			}
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpClient.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		return resultString;
	}

	public static String doPost(String url) {
		return doPost(url, null);
	}

	/**
	 * 提交json数据
	 * 
	 * @param url
	 * @param json
	 * @return
	 */
	public static String doPostJson(String url, String json) {
		CloseableHttpClient httpClient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			HttpPost httpPost = new HttpPost(url);
			StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(stringEntity);
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpClient.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		return resultString;
	}

	/**
	 * 模拟form表单提交
	 * 
	 * @param url
	 * @param str
	 * @return
	 */
	public static String doPostParam(String url, String str) {
		CloseableHttpClient httpClient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			HttpPost httpPost = new HttpPost(url);
			StringEntity stringEntity = new StringEntity(str, ContentType.create(
					"application/x-www-form-urlencoded", Consts.UTF_8));
			httpPost.setEntity(stringEntity);
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpClient.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return resultString;
	}

}
