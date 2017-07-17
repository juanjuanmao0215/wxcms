package cn.com.lzt.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import cn.com.lzt.common.util.Constants;
import cn.com.lzt.common.util.MD5;
import cn.com.lzt.model.BaseMap;
import cn.com.lzt.model.Role;
import cn.com.lzt.model.SysUser;
import cn.com.lzt.model.dto.LoginReq;
import cn.com.lzt.model.dto.SysUserDto;
import cn.com.lzt.service.role.IRoleService;
import cn.com.lzt.service.sys.ISysService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sys")
public class SysController extends BaseController {

	@Autowired
	private ISysService sysService;

	@Autowired
	private IRoleService roleService;

	/**
	 * 系统登录
	 * 
	 * @param sysuser
	 * @return
	 */
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestBody LoginReq req, HttpServletRequest request) {
		Map<String, Object> map = BaseMap.getMap(LOGIN_SUCCESS);
		SysUser user = this.sysService.findUserByLoginId(req.getLoginid());
		boolean loginsuccess = false;
		if (user != null) {
			if (user.getPwd().equals(req.getPwd())) {
				setSessionManager(request, user);
				map.put("user", user);
				loginsuccess = true;
			}
		}
		if (!loginsuccess) {
			map.put("code", 1);
			map.put("restr", LOGIN_FAIL);
		}
		return map;
	}

	/**
	 * 系统用户
	 * 
	 * @param userDto
	 * @return
	 */
	@RequestMapping("toSysUsers.do")
	public ModelAndView toSysUsers(@ModelAttribute("user") SysUserDto userDto) {
		ModelAndView mav = new ModelAndView();
		List<Role> roles = this.roleService.findRoles();
		mav.addObject("roles", roles);
		mav.setViewName("sys/sysusers");
		return mav;
	}
	
	/**
	 * 系统用户查询
	 * @param userDto
	 * @return
	 */
	@RequestMapping(value = "findSysUsers.do", method = RequestMethod.POST)
	@ResponseBody
	public Object findSysUsers(SysUserDto userDto){
		Map<String, Object> map = BaseMap.getMap(FIND_SUCCESS);
		if (StringUtils.isEmpty(userDto.getSortcolumn())) {
			userDto.setSortcolumn("createdate");
			userDto.setSorttype("DESC");
		}
		int pagenum = userDto.getPagenum();
		PageHelper.startPage(pagenum, this.PER_PAGE);
		List<Map<String, Object>> users = this.sysService.findSysUsers(userDto);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(users);
		map.put("pageResult", pageInfo);
		map.put("sorttype", userDto.getSorttype());
		return map;
	}

	/**
	 * 保存系统用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "saveUser.do", method = RequestMethod.POST)
	@ResponseBody
	public Object saveUser(SysUserDto userDto) {
		Map<String, Object> map = BaseMap.getMap(SAVE_SUCCESS);
		if (userDto.getId() == null) {
			// 添加用户
			// 设置默认密码
			userDto.setPwd(MD5.enCrpt(Constants.DEFAULT_PWD));
			this.sysService.addUser(userDto);
		} else {
			// 修改用户
			this.sysService.updateUser(userDto);
		}
		return map;
	}

	/**
	 * 删除系统用户
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "deleteUser.do", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteUser(Integer id) {
		Map<String, Object> map = BaseMap.getMap(DELETE_SUCCESS);
		this.sysService.deleteUser(id);
		return map;
	}

	/**
	 * 批量删除系统用户
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "batchdeleteuser.do", method = RequestMethod.POST)
	@ResponseBody
	public Object batchdeleteuser(String[] ids) {
		Map<String, Object> map = BaseMap.getMap(DELETE_SUCCESS);
		this.sysService.batchdeleteuser(ids);
		return map;
	}
	
	/**
	 * 系统用户详情查询
	 * 
	 * @param userreq
	 * @return
	 */
	@RequestMapping("toUserinfo.do")
	public ModelAndView toUserinfo(SysUserDto userDto) {
		ModelAndView mav = new ModelAndView();
		if (userDto.getId() != null) {
			// 修改用户的时候根据用户id查询用户信息
			SysUserDto user = this.sysService.findUserById(userDto.getId());
			mav.addObject("user", user);
		}
		List<Role> roles = this.roleService.findRoles();
		mav.addObject("roles", roles);
		mav.setViewName("sys/sysuserinfo");
		return mav;
	}

}
