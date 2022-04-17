package com.search;

//import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.zte.mcptt.util.HttpUtil;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DataPut {
	
	@Test
	public void putData() {
		
		String url = "http://localhost:9200/customer/external/1?pretty";
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
				"{ \"name\": \"John Doe\"}");
		int code = HttpUtil.put(url, requestBody);
		System.out.println(code);
		url = "http://localhost:9200/customer/external/2?pretty";
		requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
				"{ \"name\": \"John Doe\"}");
		code = HttpUtil.put(url, requestBody);
		System.out.println(code);
		url = "http://localhost:9200/customer/external?pretty";
		requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
				"{ \"name\": \"Jane Doe\"}");
		code = HttpUtil.post(url, requestBody);
		System.out.println(code);
	}
	
	@Test
	public void updateData() {
		
		String url = "http://localhost:9200/customer/external/1/_update?pretty";
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
				"{ \"doc\": { \"name\": \"Jane Doe\" }}");
		int code = HttpUtil.post(url, requestBody);
		System.out.println(code);
		url = "http://localhost:9200/customer/external/1/_update?pretty";
		requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
				"{ \"doc\": { \"name\": \"Jane Doe\", \"age\": 20  }}");
		code = HttpUtil.post(url, requestBody);
		System.out.println(code);
		url = "http://localhost:9200/customer/external/1/_update?pretty";
		requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
				"{\"script\" : \"ctx._source.age += 5\"}");
		code = HttpUtil.post(url, requestBody);
		System.out.println(code);
		// url = "http://localhost:9200/customer/external/2?pretty";
		// requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
		// "{\"script\" : \"ctx._source.age += 5\"}");
		// Response res = HttpUtil.delete(url);
		// System.out.println(res.code());
	}
	
	@Test
	public void updateBatchData() {
		
		String url = "http://localhost:9200/customer/external/_bulk?pretty";
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
				"{\"index\":{\"_id\":\"1\"}}\n{\"name\": \"John Doe\" }\n{\"index\":{\"_id\":\"2\"}}\n{\"name\": \"Jane Doe\" }");
		// "{\"index\":{\"_id\":\"1\"}}\n{\"name\": \"John Doe\" }\n");
		int code = HttpUtil.post(url, requestBody);
		System.out.println(code);
		url = "http://localhost:9200/customer/external/_bulk?pretty";
		requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
				"{\"update\":{\"_id\":\"1\"}}\n{\"doc\": { \"name\": \"John Doe becomes Jane Doe\" } }\n{\"delete\":{\"_id\":\"2\"}}");
		code = HttpUtil.post(url, requestBody);
		System.out.println(code);
	}
	
	/**
	 * 批量导入银行用户文件
	 */
	@Test
	public void putBankAccoutfile() {
		
		String url = "http://localhost:9200/bank/account1/_bulk?pretty&refresh";
//		System.out
//				.println(Thread.currentThread().getContextClassLoader().getResource("com/search/data.json").getFile());
//		System.out.println(DataPut.class.getClassLoader().getResource("com/search/data.json").getPath());
		// RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new
		// File("F:/workspace/TestJDK/target/test-classes/com/search/data.json"));
		byte[] byte1 = null;
		try {
			InputStream in = DataPut.class.getClassLoader().getResourceAsStream("com/search/accounts.json");
			byte1 = new byte[in.available()];
			in.read(byte1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(new String(byte1));
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), byte1);
//		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "{\"account_number\": 0,\"state\": \"CO\"}\n");
		int code = HttpUtil.post(url, requestBody);
		System.out.println(code);
//		assertThat(code).isEqualTo(200);
	}

	@Test
	public void getAccountSearch() {
		String url = "http://localhost:9200/bank/_search";
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "{\"query\": {\"match_all\": {} },\"size\": 5}");
		Response res = HttpUtil.patch(url,requestBody);
		int a = HttpUtil.post(url,requestBody);
		System.out.println(a);
		try {
			System.out.println(res.body().string());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}
	@Test
	public void getAccountSearch2() {
		String url = "http://localhost:9200/bank/_search?q=*&sort=account_number:asc&size=1&pretty";
		Response res = HttpUtil.get(url);
		try {
			System.out.println(res.body().string());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}
}
