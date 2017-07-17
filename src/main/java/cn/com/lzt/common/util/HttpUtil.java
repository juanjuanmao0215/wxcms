package cn.com.lzt.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import com.alibaba.fastjson.JSON;

public class HttpUtil {

	/**
	 * http请求
	 * 
	 * @param method
	 *            （get或post）
	 * @param url
	 *            （请求地址）
	 * @param paramsMap
	 *            （请求参数）
	 * @return
	 */
	public static String send(String method, String url,
			Map<String, Object> paramsMap) {
		String result = "";
		RequestConfig defaultRequestConfig = RequestConfig.custom()
				.setSocketTimeout(1000 * 60).setConnectTimeout(1000 * 60)
				.setConnectionRequestTimeout(1000 * 60)
				.setStaleConnectionCheckEnabled(true).build();
		CloseableHttpAsyncClient httpclient = HttpAsyncClients.custom()
				.setDefaultRequestConfig(defaultRequestConfig).build();
		try {
			httpclient.start();
			boolean hasparams = paramsMap != null
					&& paramsMap.keySet().size() > 0 ? true : false;
			Future<HttpResponse> future = null;
			if ("post".equalsIgnoreCase(method)) {
				HttpPost post = new HttpPost(url);
				if (hasparams) {
					String postBody = JSON.toJSONString(paramsMap);
					StringEntity se = new StringEntity(postBody, "utf-8");
					se.setContentType("application/json; charset=utf-8");
					post.setEntity(se);
				}
				future = httpclient.execute(post, null);
			} else {
				if (hasparams) {
					int i = 0;
					Set<String> keys = paramsMap.keySet();
					for (String key : keys) {
						if (i > 0) {
							url += "&";
						}
						if (i == 0) {
							url += "?";
						}
						url += key + "=" + paramsMap.get(key);
						i++;
					}
				}
				HttpGet get = new HttpGet(url);
				future = httpclient.execute(get, null);
			}
			if (future != null) {
				HttpResponse response = future.get();
				int status = response.getStatusLine().getStatusCode();
				if (status == 200) {
					InputStreamReader reader = new InputStreamReader(response
							.getEntity().getContent(), "utf-8");
					BufferedReader rd = new BufferedReader(reader);
					StringBuffer sbf = new StringBuffer();
					String line = "";
					while ((line = rd.readLine()) != null) {
						sbf.append(line);
					}
					result = sbf.toString();
				}
			}
		} catch (Exception e) {
			return "";
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
