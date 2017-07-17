package cn.com.lzt.common.converter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.FileCopyUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

public class CustomStringHttpMessageConverter extends
		AbstractHttpMessageConverter<Object> {

	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	private final Charset defaultCharset;
	private final List<Charset> availableCharsets;
	private boolean writeAcceptCharset;

	public CustomStringHttpMessageConverter() {
		this(DEFAULT_CHARSET);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CustomStringHttpMessageConverter(Charset defaultCharset) {
		super(new MediaType[] { new MediaType("text", "plain", defaultCharset),
				MediaType.ALL });
		this.writeAcceptCharset = true;
		this.defaultCharset = defaultCharset;
		this.availableCharsets = new ArrayList(Charset.availableCharsets()
				.values());
	}

	public void setWriteAcceptCharset(boolean writeAcceptCharset) {
		this.writeAcceptCharset = writeAcceptCharset;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	protected Object readInternal(Class<? extends Object> clazz,
			HttpInputMessage inputMessage) throws IOException,
			HttpMessageNotReadableException {
		try {
			Charset charset = getContentTypeCharset(inputMessage.getHeaders()
					.getContentType());
			return JSON.parseObject(FileCopyUtils
					.copyToString(new InputStreamReader(inputMessage.getBody(),
							charset)), clazz);
		} catch (JSONException e) {
			throw new HttpMessageNotReadableException("Could not read JSON: "
					+ e.getMessage(), e);
		}
	}

	@Override
	protected void writeInternal(Object t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		if (this.writeAcceptCharset)
			outputMessage.getHeaders().setAcceptCharset(getAcceptedCharsets());
		String json = JSON.toJSONStringWithDateFormat(t, "yyyy-MM-dd HH:mm:ss");
		Charset charset = getContentTypeCharset(outputMessage.getHeaders()
				.getContentType());
		FileCopyUtils.copy(json, new OutputStreamWriter(
				outputMessage.getBody(), charset));
	}

	protected List<Charset> getAcceptedCharsets() {
		return this.availableCharsets;
	}

	protected Long getContentLength(String s, MediaType contentType) {
		Charset charset = getContentTypeCharset(contentType);
		try {
			return Long.valueOf(s.getBytes(charset.name()).length);
		} catch (UnsupportedEncodingException ex) {
			throw new IllegalStateException(ex);
		}
	}

	private Charset getContentTypeCharset(MediaType contentType) {
		if ((contentType != null) && (contentType.getCharSet() != null)) {
			return contentType.getCharSet();
		}
		return this.defaultCharset;
	}

}