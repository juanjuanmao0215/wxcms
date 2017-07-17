package cn.com.lzt.mapper;

import org.apache.ibatis.annotations.Param;
import cn.com.lzt.model.Roleright;

public interface RolerightMapper extends BaseMapper<Roleright> {

	/**
	 * 根据角色id删除角色绑定的菜单
	 * 
	 * @param roleid
	 */
	void deleteByRoleid(int roleid);

	/**
	 * 保存菜单和角色的关系
	 * 
	 * @param menuids
	 * @param roleid
	 * @param userid
	 */
	void addRoleright(@Param("menuids") String[] menuids,
			@Param("roleid") int roleid, @Param("userid") int userid);

}