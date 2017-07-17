package cn.com.lzt.mapper;

import java.util.List;
import cn.com.lzt.model.Role;

public interface RoleMapper extends BaseMapper<Role> {

	/**
	 * 角色查询
	 * 
	 * @return
	 */
	List<Role> findRoles();

}