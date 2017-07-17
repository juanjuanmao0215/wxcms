package cn.com.lzt.mapper;

import java.util.List;
import java.util.Map;
import cn.com.lzt.model.SysUser;
import cn.com.lzt.model.dto.SysUserDto;

public interface SysUserMapper extends BaseMapper<SysUser> {

	/**
	 * 根据登录账号查询用户
	 * 
	 * @param loginid
	 * @return
	 */
	SysUser findUserByLoginId(String loginid);

	/**
	 * 根据用户id查询用户信息
	 * @param userid
	 * @return
	 */
	SysUserDto findUserById(int userid);
	
	/**
	 * 批量删除用户
	 * 
	 * @param ids
	 */
	void batchdeleteuser(String[] ids);

	/**
	 * 系统用户查询
	 * 
	 * @param req
	 * @return
	 */
	List<Map<String, Object>> findSysUsers(SysUserDto req);
	
}