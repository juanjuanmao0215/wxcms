package cn.com.lzt.service.sys;

import cn.com.lzt.model.TSysmenu;

import java.util.List;
import java.util.Map;

public interface IMenuService {

	/**
	 * 菜单查询
	 * 
	 * @param userid
	 * @param roleid
	 * @param querytype
	 * @return
	 */
	Map<String, Object> findMenus(Integer userid, Integer roleid,
			Integer querytype);

	/**
	 * 保存菜单
	 * 
	 * @param menu
	 */
	void saveSysMenu(TSysmenu menu);

	/**
	 * 删除菜单
	 * 
	 * @param menuid
	 */
	void deleteMenu(Integer menuid);

	/**
	 * 保存角色权限
	 * 
	 * @param menuids
	 * @param roleid
	 */
	void saveRoleright(String[] menuids, int roleid, int userid);

	/**
	 * 查询菜单图片
	 * 
	 * @return
	 */
	List<Map<String, Object>> findMenuImgs();

}
