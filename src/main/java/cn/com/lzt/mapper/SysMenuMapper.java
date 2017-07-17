package cn.com.lzt.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import cn.com.lzt.model.SysMenu;
import cn.com.lzt.model.dto.SysMenuReq;

public interface SysMenuMapper extends BaseMapper<SysMenu> {

	/**
	 * 菜单查询
	 * 
	 * @param roleid
	 * @param userid
	 * @return
	 */
	List<SysMenuReq> findMenus(@Param("roleid") Integer roleid,
			@Param("userid") Integer userid,
			@Param("querytype") Integer querytype);

	/**
	 * 根据菜单id查询父级菜单是否有子节点
	 * 
	 * @param id
	 * @return
	 */
	Integer findMenuIsparent(Integer id);

	/**
	 * 修改菜单排序深度
	 * 
	 * @param preParSortlevel
	 * @param parSortlevel
	 */
	void updateMenuSortlevel(@Param("preParSortlevel") String preParSortlevel,
			@Param("parSortlevel") String parSortlevel);

	/**
	 * 修改菜单深度
	 * 
	 * @param preMenuLevel
	 * @param menuLevel
	 */
	void updateMenuLevel(@Param("preMenuLevel") String preMenuLevel,
			@Param("menuLevel") String menuLevel);

	/**
	 * 删除菜单
	 * 
	 * @param menulevel
	 */
	void deleteMenu(String menulevel);

	/**
	 * 查询菜单图片
	 * 
	 * @return
	 */
	List<Map<String, Object>> findMenuImgs();

}