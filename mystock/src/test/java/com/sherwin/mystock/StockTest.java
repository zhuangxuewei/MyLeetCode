package com.sherwin.mystock;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

class StockTest {
	@Autowired
	RestTemplate restTemplate;
	private String XUEQIU_URL = "https://stock.xueqiu.com/v5/stock/";

	@Test
	void test() throws ClientProtocolException, IOException {
		String realtimeQuote = XUEQIU_URL + "realtime/quotec.json?symbol=SH601318,SH688981,SZ000333,SH601665,SZ002185";
		HttpClientBuilder builder = HttpClientBuilder.create();
		CloseableHttpClient client = builder.build();
		HttpGet httpGet = new HttpGet(realtimeQuote);

		BasicResponseHandler handler = new BasicResponseHandler();
		String response = client.execute(httpGet, handler);
		System.out.println(response);
//		https: // stock.xueqiu.com/v5/stock/realtime/quotec.json?symbol=SH601003,SH601001
//		param.put("symbol", "SH601003");
	}

}
