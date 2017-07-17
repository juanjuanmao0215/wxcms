package cn.com.lzt.service.role;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.lzt.mapper.RoleMapper;
import cn.com.lzt.model.Role;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;

	/**
	 * 角色查询
	 * 
	 * @return
	 */
	@Override
	public List<Role> findRoles() {
		return this.roleMapper.findRoles();
	}

}
