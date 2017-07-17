package cn.com.lzt.service.role;

import java.util.List;
import cn.com.lzt.model.Role;

public interface IRoleService {

	/**
	 * 角色查询
	 * 
	 * @return
	 */
	List<Role> findRoles();

}
