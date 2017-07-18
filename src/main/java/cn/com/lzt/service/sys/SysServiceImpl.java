package cn.com.lzt.service.sys;

import cn.com.lzt.mapper.TSysuserMapper;
import cn.com.lzt.mapper.TUserroleMapper;
import cn.com.lzt.model.TSysuser;
import cn.com.lzt.model.TUserrole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SysServiceImpl implements ISysService {

	@Autowired
	private TSysuserMapper sysUserMapper;

	@Autowired
	private TUserroleMapper userRoleMapper;

	/**
	 * 根据登录账号查询用户
	 * 
	 * @param loginid
	 * @return
	 */
	@Override
	public TSysuser findUserByLoginId(String loginid) {
		return this.sysUserMapper.findUserByLoginId(loginid);
	}

	/**
	 * 根据用户ID查询用户
	 * 
	 * @param userid
	 * @return
	 */
	@Override
	public TSysuser findUserById(int userid) {
		return this.sysUserMapper.findUserById(userid);
	}

	/**
	 * 新增用户
	 */
	@Override
	public void addUser(TSysuser userdto) {
		this.sysUserMapper.insertSelective(userdto);
		// 保存用户和角色的关系
		TUserrole userRole = new TUserrole();
		userRole.setUserid(userdto.getId());
		userRole.setRoleid(userdto.getRoleId());
		userRole.setCreateuserid(userdto.getId());
		this.userRoleMapper.insertSelective(userRole);
	}

	/**
	 * 删除用户
	 */
	@Override
	public void deleteUser(Integer userid) {
		this.sysUserMapper.deleteByPrimaryKey(userid);
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
	 * @param userdto
	 */
	@Override
	public void updateUser(TSysuser userdto) {
		this.sysUserMapper.updateByPrimaryKeySelective(userdto);
		TUserrole userRole = this.userRoleMapper.findByUserid(userdto.getId());
		if (userRole != null && userRole.getRoleid() != userdto.getRoleId()) {
			// 修改用户角色
			this.userRoleMapper.updateUserRoleById(userdto.getRoleId(),userdto.getId());
		}
	}

	/**
	 * 系统用户查询
	 * 
	 * @param userDto
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findSysUsers(TSysuser userDto) {
		return this.sysUserMapper.findSysUsers(userDto);
	}

}
