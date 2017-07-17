package cn.com.lzt.common.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import com.alibaba.fastjson.JSON;

public class CustomExceptionResolver extends SimpleMappingExceptionResolver {

	@Value("${ERROR_MSG}")
	public String ERROR_MSG;

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ex.printStackTrace();
		CustomException customException = null;
		if (ex instanceof CustomException) {
			customException = (CustomException) ex;
		} else {
			customException = new CustomException(ERROR_MSG);
		}
		// JSP格式返回
		if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
				.getHeader("X-Requested-With") != null && request.getHeader(
				"X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
			String viewName = determineViewName(ex, request);
			// 如果不是异步请求
			Integer statusCode = determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response, statusCode);
			}
			if (StringUtils.isEmpty(viewName))
				viewName = "error/500";
			ModelAndView mav = new ModelAndView();
			mav.setViewName(viewName);
			mav.addObject("restr", customException.getErrormsg());
			return mav;
		} else {
			// JSON格式返回
			try {
				response.setContentType("text/json;charset=utf-8");
				PrintWriter writer = response.getWriter();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("code", 1);
				map.put("restr", customException.getErrormsg());
				writer.print(JSON.toJSONString(map));
				writer.flush();
				writer.close();
				writer = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
}
