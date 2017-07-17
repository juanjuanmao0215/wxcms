package cn.com.lzt.mapper;

import org.apache.ibatis.annotations.Param;
import cn.com.lzt.model.UserRole;

public interface UserRoleMapper extends BaseMapper<UserRole> {

	/**
	 * 删除用户和角色的关系
	 * 
	 * @param userid
	 */
	void deleteByUserid(Integer userid);

	/**
	 * 批量删除用户和角色的关系
	 * 
	 * @param ids
	 */
	void batchdeleteByUserid(String[] ids);

	/**
	 * 根据用户ID查询用户角色
	 * 
	 * @param userid
	 * @return
	 */
	UserRole findByUserid(Integer userid);

	/**
	 * 根据用户ID修改用户角色
	 * @param roleid
	 * @param userid
	 */
	void updateUserRoleById(@Param("roleid") int roleid,
			@Param("userid") int userid);

}