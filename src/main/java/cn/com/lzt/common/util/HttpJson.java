package cn.com.lzt.common.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import com.alibaba.fastjson.JSON;

public class HttpJson {

	/**
	 * 发送HttpPost请求
	 * 
	 * @param strURL
	 *            服务地址
	 * @param params
	 *            json字符串,例如: "{ \"id\":\"12345\" }" ;其中属性名必须带双引号<br/>
	 * @return 成功:返回json字符串<br/>
	 */
	public static HttpRespons post(String strURL, String params) {
		try {
			HttpRespons httpResponser = new HttpRespons();
			URL url = new URL(strURL);// 创建连接
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestMethod("POST"); // 设置请求方式
			connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
			connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
			connection.connect();
			OutputStreamWriter out = new OutputStreamWriter(
					connection.getOutputStream(), "UTF-8"); // utf-8编码
			out.append(params);
			out.flush();
			out.close();
			// 读取响应
			InputStream is = connection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(is));
			httpResponser.contentCollection = new Vector<String>();
			StringBuffer temp = new StringBuffer();
			String line = bufferedReader.readLine();
			while (line != null) {
				httpResponser.contentCollection.add(line);
				temp.append(line).append("\r\n");
				line = bufferedReader.readLine();
			}
			bufferedReader.close();

			httpResponser.urlString = strURL;
			httpResponser.defaultPort = connection.getURL().getDefaultPort();
			httpResponser.file = connection.getURL().getFile();
			httpResponser.host = connection.getURL().getHost();
			httpResponser.path = connection.getURL().getPath();
			httpResponser.port = connection.getURL().getPort();
			httpResponser.protocol = connection.getURL().getProtocol();
			httpResponser.query = connection.getURL().getQuery();
			httpResponser.ref = connection.getURL().getRef();
			httpResponser.userInfo = connection.getURL().getUserInfo();

			httpResponser.content = new String(temp.toString().getBytes(),
					"UTF-8");
			httpResponser.contentEncoding = "UTF-8";
			httpResponser.code = connection.getResponseCode();
			httpResponser.message = connection.getResponseMessage();
			httpResponser.contentType = connection.getContentType();
			httpResponser.method = connection.getRequestMethod();
			httpResponser.connectTimeout = connection.getConnectTimeout();
			httpResponser.readTimeout = connection.getReadTimeout();

			return httpResponser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {

		String basePath = "http://localhost:8080/bsframe/test/";
		String login = basePath + "test.do";

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pageNo", 1);

		System.out.println(post(login, JSON.toJSONString(map)).getContent());

	}

}
