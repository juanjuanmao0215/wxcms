package cn.com.lzt.common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;

public class FileType {

	private static final HashMap<String, String> mImageFileTypes = new HashMap<String, String>();

	static {
		mImageFileTypes.put("FFD8FF", "jpg");
		mImageFileTypes.put("89504E", "png");
	}

	public static boolean isImage(String filePath) {
		String fileType = mImageFileTypes.get(getFileHeader(filePath));
		boolean isImage = !StringUtils.isEmpty(fileType);
		return isImage;
	}

	public static boolean isImage(byte[] bytes) {
		String fileType = mImageFileTypes.get(getFileHeader(bytes));
		boolean isImage = !StringUtils.isEmpty(fileType);
		return isImage;
	}

	public static String getFileType(String filePath) {
		return mImageFileTypes.get(getFileHeader(filePath));
	}

	public static String getFileType(byte[] bytes) {
		return mImageFileTypes.get(getFileHeader(bytes));
	}

	private static String getFileHeader(byte[] bytes) {
		String value = null;
		try {
			if (bytes != null) {
				byte[] b = new byte[3];
				for (int nIndex = 0; nIndex < 3; ++nIndex) {
					b[nIndex] = bytes[nIndex];
				}
				value = bytesToHexString(b);
			}
		} catch (Exception e) {
		}
		return value;
	}

	// 获取文件头信息
	private static String getFileHeader(String filePath) {
		FileInputStream is = null;
		String value = null;
		try {
			is = new FileInputStream(filePath);
			byte[] b = new byte[3];
			is.read(b, 0, b.length);
			value = bytesToHexString(b);
		} catch (Exception e) {
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
		return value;
	}

	private static String bytesToHexString(byte[] src) {
		StringBuilder builder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		String hv;
		for (int i = 0; i < src.length; i++) {
			hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();
			if (hv.length() < 2) {
				builder.append(0);
			}
			builder.append(hv);
		}
		return builder.toString();
	}
}
