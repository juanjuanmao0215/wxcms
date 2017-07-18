package cn.com.lzt.service.role;

import cn.com.lzt.mapper.RoleMapper;
import cn.com.lzt.mapper.TRoleMapper;
import cn.com.lzt.model.TRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private TRoleMapper troleMapper;

	/**
	 * 角色查询
	 * 
	 * @return
	 */
	@Override
	public List<TRole> findRoles() {
		return this.troleMapper.findRoles();
	}

}
