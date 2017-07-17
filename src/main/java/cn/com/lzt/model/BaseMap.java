package cn.com.lzt.model;

import java.util.HashMap;
import java.util.Map;

public class BaseMap {

	public static Map<String, Object> getMap(String msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("restr", msg);
		return map;
	}

}
