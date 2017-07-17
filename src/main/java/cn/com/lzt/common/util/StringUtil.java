package cn.com.lzt.common.util;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

	public static String formatDate(String pattern, Date date) {
		SimpleDateFormat formator = new SimpleDateFormat();
		formator.applyPattern(pattern);
		return formator.format(date);
	}

	public static String getYmdHmsDate(Date date) {
		SimpleDateFormat ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return ymdhms.format(date);
	}

	public static Timestamp getTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	public static Timestamp convertToTimestamp(String strdate) {
		Timestamp ts = null;
		try {
			SimpleDateFormat ymdhm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			ts = new Timestamp(ymdhm.parse(strdate).getTime());
		} catch (Exception e) {
		}
		return ts;
	}

	public static String getUploadpath(String basePath, String relativePath) {
		String uploadpath = basePath + relativePath;
		File file = new File(uploadpath);
		if (!file.exists())
			file.mkdirs();
		return uploadpath;
	}

}
