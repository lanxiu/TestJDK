package com.zte.mcptt.util;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/*
 * HTTP 资源操作工具类
 * @author 0216000799
 *
 */
public class HttpUtil {


	/**
	 * http get请求
	 * 
	 * @param url
	 * @return 请求的响应code
	 */
	public static Response get(String url) {

		OkHttpClient okHttpClient = new OkHttpClient();

		Request request = new Request.Builder().url(url)
				.header("Authorization",
						"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtY3B0dF9pZCI6InVzZXItdGVzdC0xQHp0ZS5jb20ifQ.Sisn6rgmgph43Uo34ML76e94QkHD6H-vSQzXjyda78M")
				.build();
		try {
			Response res = okHttpClient.newCall(request).execute();
			return res;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * http get请求
	 * 
	 * @param url
	 * @return 请求的响应code
	 */
	public static Response patch(String url,RequestBody requestBody) {

		OkHttpClient okHttpClient = new OkHttpClient();

		Request request = new Request.Builder().url(url)
				.header("Authorization",
						"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtY3B0dF9pZCI6InVzZXItdGVzdC0xQHp0ZS5jb20ifQ.Sisn6rgmgph43Uo34ML76e94QkHD6H-vSQzXjyda78M")

				.patch(requestBody)
				.build();
		try {
			Response res = okHttpClient.newCall(request).execute();
			return res;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * http put请求
	 * 
	 * @param url 地址
	 * @param responseBody 消息体
	 * @return http响应码
	 */
	public static int put(String url, RequestBody requestBody) {
		
		OkHttpClient okHttpClient = new OkHttpClient();
		Request req = new Request.Builder().url(url)
				.header("Authorization",
						"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtY3B0dF9pZCI6InVzZXItdGVzdC0xQHp0ZS5jb20ifQ.Sisn6rgmgph43Uo34ML76e94QkHD6H-vSQzXjyda78M")
				.put(requestBody).build();
		try {
			Response res = okHttpClient.newCall(req).execute();
			res.close();
			return res.code();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 出现异常
		return -1;
	}

	/**
	 * http post请求
	 * 
	 * @param url 地址
	 * @param responseBody 消息体
	 * @return http响应码
	 */
	public static int post(String url, RequestBody requestBody) {
		
		OkHttpClient okHttpClient = new OkHttpClient();
		Request req = new Request.Builder().url(url)
				.header("Authorization",
						"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtY3B0dF9pZCI6InVzZXItdGVzdC0xQHp0ZS5jb20ifQ.Sisn6rgmgph43Uo34ML76e94QkHD6H-vSQzXjyda78M")
				.post(requestBody).build();
		try {
			Response res = okHttpClient.newCall(req).execute();
			res.close();
			return res.code();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 出现异常
		return -1;
	}

	/**
	 * http get请求
	 * 
	 * @param url
	 * @return 请求的响应code
	 */
	public static Response delete(String url) {

		OkHttpClient okHttpClient = new OkHttpClient();

		Request request = new Request.Builder().url(url)
				.header("Authorization",
						"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtY3B0dF9pZCI6InVzZXItdGVzdC0xQHp0ZS5jb20ifQ.Sisn6rgmgph43Uo34ML76e94QkHD6H-vSQzXjyda78M")
				.delete().build();
		try {
			Response res = okHttpClient.newCall(request).execute();
            res.close();
			return res;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
