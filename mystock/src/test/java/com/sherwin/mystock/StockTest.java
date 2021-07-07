package com.sherwin.mystock;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sherwin.mystock.common.XueqiuConstants;

public class StockTest {
//	@Autowired
//	RestTemplate restTemplate;
	private String XUEQIU_URL = "https://stock.xueqiu.com/v5/stock/";

	@Test
	public void test() throws ClientProtocolException, IOException {
		String realtimeQuote = XUEQIU_URL + "realtime/quotec.json?symbol=SH601318,SH688981,SZ000333,SH601665,SZ002185";
		String listQuote=XueqiuConstants.XUEQIU_DOMAIN+XueqiuConstants.LIST_INFO;
		HttpClientBuilder builder = HttpClientBuilder.create();
		CloseableHttpClient client = builder.build();
		HttpGet httpGet = new HttpGet(listQuote);

		BasicResponseHandler handler = new BasicResponseHandler();
		String response = client.execute(httpGet, handler);
		JSONObject resJson=JSONObject.parseObject(response);
		JSONObject data =resJson.getJSONObject("data");
		JSONArray list=data.getJSONArray("list");
		System.out.println(list.size());
//		System.out.println(response);
		
		// https: //
		// stock.xueqiu.com/v5/stock/realtime/quotec.json?symbol=SH601003,SH601001
		// param.put("symbol", "SH601003");
	}

}
