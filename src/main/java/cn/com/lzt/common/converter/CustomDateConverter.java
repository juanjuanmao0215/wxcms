package cn.com.lzt.common.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

public class CustomDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String datestr) {
		SimpleDateFormat sdformate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdformate.parse(datestr);
		} catch (ParseException e) {
			// ignore
		}
		return null;
	}

}
