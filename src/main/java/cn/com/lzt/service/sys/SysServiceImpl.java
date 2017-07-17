package cn.com.lzt.service.sys;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.lzt.mapper.SysUserMapper;
import cn.com.lzt.mapper.UserRoleMapper;
import cn.com.lzt.model.SysUser;
import cn.com.lzt.model.UserRole;
import cn.com.lzt.model.dto.SysUserDto;

@Service
@Transactional
public class SysServiceImpl implements ISysService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;

	/**
	 * 根据登录账号查询用户
	 * 
	 * @param loginid
	 * @return
	 */
	@Override
	public SysUser findUserByLoginId(String loginid) {
		return this.sysUserMapper.findUserByLoginId(loginid);
	}

	/**
	 * 根据用户ID查询用户
	 * 
	 * @param userid
	 * @return
	 */
	@Override
	public SysUserDto findUserById(int userid) {
		return this.sysUserMapper.findUserById(userid);
	}

	/**
	 * 新增用户
	 */
	@Override
	public void addUser(SysUserDto userdto) {
		this.sysUserMapper.add(userdto);
		// 保存用户和角色的关系
		UserRole userRole = new UserRole();
		userRole.setUserid(userdto.getId());
		userRole.setRoleid(userdto.getRoleid());
		userRole.setCreateuserid(userdto.getId());
		this.userRoleMapper.add(userRole);
	}

	/**
	 * 删除用户
	 */
	@Override
	public void deleteUser(Integer userid) {
		this.sysUserMapper.deleteById(userid);
		// 删除用户和角色的关系
		this.userRoleMapper.deleteByUserid(userid);
	}

	/**
	 * 批量删除用户
	 * 
	 * @param ids
	 */
	@Override
	public void batchdeleteuser(String[] ids) {
		this.sysUserMapper.batchdeleteuser(ids);
		// 批量删除用户和角色的关系
		this.userRoleMapper.batchdeleteByUserid(ids);
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 */
	@Override
	public void updateUser(SysUserDto userdto) {
		this.sysUserMapper.update(userdto);
		UserRole userRole = this.userRoleMapper.findByUserid(userdto.getId());
		if (userRole != null && userRole.getRoleid() != userdto.getRoleid()) {
			// 修改用户角色
			this.userRoleMapper.updateUserRoleById(userdto.getRoleid(),userdto.getId());
		}
	}

	/**
	 * 系统用户查询
	 * 
	 * @param userDto
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findSysUsers(SysUserDto userDto) {
		return this.sysUserMapper.findSysUsers(userDto);
	}

}
