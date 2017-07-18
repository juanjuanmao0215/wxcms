package cn.com.lzt.controller;

import cn.com.lzt.common.util.Constants;
import cn.com.lzt.model.TSysuser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

	/** 错误信息 */
	@Value("${ERROR_MSG}")
	public String ERROR_MSG;

	/** 图片访问路径 */
	@Value("${IMAGE_BASEPATH}")
	public String IMAGE_BASEPATH;

	/** 分页大小 */
	@Value("${PER_PAGE}")
	public Integer PER_PAGE;

	/** 查询成功 */
	@Value("${FIND_SUCCESS}")
	public String FIND_SUCCESS;

	/** 注册成功 */
	@Value("${REGIST_SUCCESS}")
	public String REGIST_SUCCESS;

	/** 删除成功 */
	@Value("${DELETE_SUCCESS}")
	public String DELETE_SUCCESS;

	/** 修改成功 */
	@Value("${UPDATE_SUCCESS}")
	public String UPDATE_SUCCESS;

	/** 添加成功 */
	@Value("${ADD_SUCCESS}")
	public String ADD_SUCCESS;

	/** 保存成功 */
	@Value("${SAVE_SUCCESS}")
	public String SAVE_SUCCESS;

	/** 登录成功 */
	@Value("${LOGIN_SUCCESS}")
	public String LOGIN_SUCCESS;

	/** 登录失败 */
	@Value("${LOGIN_FAIL}")
	public String LOGIN_FAIL;

	/** 文件上传路径 */
	@Value("${UPLOAD_DIR}")
	public String UPLOAD_DIR;

	protected TSysuser getSessionUserWeb(HttpServletRequest req) {
		return (TSysuser) WebUtils.getSessionAttribute(req,
				Constants.USER_SESSION_KEY);
	}

	protected void setSessionManager(HttpServletRequest req, Object user) {
		WebUtils.setSessionAttribute(req, Constants.USER_SESSION_KEY, user);
	}

}
