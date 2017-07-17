package cn.com.lzt.service.sys;

import java.util.List;
import java.util.Map;
import cn.com.lzt.model.SysUser;
import cn.com.lzt.model.dto.SysUserDto;

public interface ISysService {

	/**
	 * 根据登录账号查询用户
	 * 
	 * @param loginid
	 * @return
	 */
	SysUser findUserByLoginId(String loginid);

	/**
	 * 根据用户ID查询用户
	 * 
	 * @param userid
	 * @return
	 */
	SysUserDto findUserById(int userid);

	/**
	 * 新增用户
	 * 
	 * @param userreq
	 */
	void addUser(SysUserDto userreq);

	/**
	 * 删除用户
	 * 
	 * @param userid
	 */
	void deleteUser(Integer userid);

	/**
	 * 批量删除用户
	 * 
	 * @param ids
	 */
	void batchdeleteuser(String[] ids);

	/**
	 * 修改用户
	 * 
	 * @param user
	 */
	void updateUser(SysUserDto userreq);

	/**
	 * 系统用户查询
	 * 
	 * @param userDto
	 * @return
	 */
	List<Map<String, Object>> findSysUsers(SysUserDto userDto);
	
}
