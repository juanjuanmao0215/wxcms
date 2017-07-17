package cn.com.lzt.common.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import cn.com.lzt.common.util.Constants;

public class SpringInteceptor implements HandlerInterceptor {

	// 设置不需要过滤的url
	private static final String[] noFilters = new String[] { "login.do",
			"logout.do", "nosession.do", "forgetpwd.do" };

	/**
	 * 该方法会在render view完成后执行，也可以说在请求过程（request processing）完成之后执行。该方法可以用来清理资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	/**
	 * 这个方法在业务处理器处理完请求后，但是DispatcherServlet向客户端返回请求前被调用，在该方法中对用户请求request进行处理
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	/**
	 * 该方法会在Controller的方法执行前会被调用，可以使用这个方法来中断或者继续执行链的处理，当返回true时，处理执行链会继续，
	 * 当返回false时，则不会去执行Controller的方法
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		String uri = request.getRequestURI().replaceAll(
				request.getContextPath() + "/", "");
		boolean beFilter = true;
		if (uri.equals("")) {
			beFilter = false;
		} else {
			for (String s : noFilters) {
				if (uri.indexOf(s) != -1) {
					beFilter = false;
					break;
				}
			}
		}
		if (beFilter) {
			return true;
			/*
			 * SysUser manager = (SysUser) WebUtils.getSessionAttribute(request,
			 * Constants.USER_SESSION_KEY); if (manager == null) {
			 * response.sendRedirect(request.getContextPath() +
			 * "/nosession.html"); return false; } else { // 在这里可以做权限的校验 return
			 * true; }
			 */

		} else {
			return true;
		}
	}
}
