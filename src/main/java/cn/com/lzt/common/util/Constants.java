package cn.com.lzt.common.util;

import java.io.IOException;
import java.util.Properties;

public class Constants {

	/**
	 * 用户登录Session的Key值
	 */
	public static final String USER_SESSION_KEY = "usersessionkey";

	/**
	 * 默认密码
	 */
	public static final String DEFAULT_PWD = "123456";

	static {
		Properties prop = new Properties();
		try {
			prop.load(Constants.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
