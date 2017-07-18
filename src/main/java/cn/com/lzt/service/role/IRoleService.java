package cn.com.lzt.service.role;

import cn.com.lzt.model.TRole;

import java.util.List;

public interface IRoleService {

	/**
	 * 角色查询
	 * 
	 * @return
	 */
	List<TRole> findRoles();

}
