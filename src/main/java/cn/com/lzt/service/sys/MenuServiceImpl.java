package cn.com.lzt.service.sys;

import cn.com.lzt.common.util.ztree.MenuZTree;
import cn.com.lzt.mapper.TRolerightMapper;
import cn.com.lzt.mapper.TSysmenuMapper;
import cn.com.lzt.mapper.TUserroleMapper;
import cn.com.lzt.model.TSysmenu;
import cn.com.lzt.model.TUserrole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private TUserroleMapper userRoleMapper;

	@Autowired
	private TSysmenuMapper sysMenuMapper;

	@Autowired
	private TRolerightMapper rolerightMapper;

	/**
	 * 菜单查询
	 */
	@Override
	public Map<String, Object> findMenus(Integer userid, Integer roleid,Integer querytype) {
		Map<String, Object> map = new HashMap<String, Object>();
		// querytype(0：菜单导航查询，1：菜单管理查询，2：菜单角色查询)
		if (querytype != 2) {
			TUserrole userRole = this.userRoleMapper.findByUserid(userid);
			roleid = userRole.getRoleid();
		}
		List<TSysmenu> menus = this.sysMenuMapper.findMenus(roleid, userid, querytype);
		List<MenuZTree> menulist = new ArrayList<MenuZTree>();
		if (menus != null && menus.size() > 0) {
			Map<Integer, String> menumap = new HashMap<Integer, String>();
			for (TSysmenu menu : menus) {
				MenuZTree ztree = new MenuZTree(menu.getId(),
						menu.getParentid(), menu.getMenuname(), false,
						menu.getParentflag() == 1 ? true : false,
						menu.getMenulevel(), false, menu.getMenuurl(),
						menu.getMenuimg(), menu.getSortnum(), menu.getIsused());
				if (querytype != 0) {
					// parentid为0或1的默认展开节点
					if (menu.getParentid() == 0 || menu.getParentid() == 1)
						ztree.setOpen(true);
					if (querytype == 2){
						// 分配用户角色权限的时候，点击角色查询角色已分配的权限，并选中节点
						if (menu.getCheckedid() != null)
							ztree.setChecked(true);
					}
				} else {
					// 首页查询的时候将菜单ID和菜单名称保存在map中
					menumap.put(menu.getId(), menu.getMenuname());
				}
				menulist.add(ztree);
			}
			if (querytype == 0)
				map.put("menumap", menumap);
		}
		map.put("menus", menulist);
		return map;
	}

	/**
	 * 保存菜单
	 */
	@Override
	public void saveSysMenu(TSysmenu menu) {
		// 查询父级菜单
		TSysmenu parentmenu = this.sysMenuMapper.selectByPrimaryKey(menu.getParentid());
		String menulevel = parentmenu.getMenulevel() + ".";
		if (menu.getParentid() == 1) {
			menu.setSortlevel(String.valueOf(menu.getSortnum()));
		} else {
			menu.setSortlevel(parentmenu.getSortlevel() + "."
					+ menu.getSortnum());
			// 二级或三级或n+级别的菜单，更新父级菜单是否有子菜单标识
			if (parentmenu.getParentflag() == 0) {
				// 更新父级菜单parentflag标识
				parentmenu.setParentflag(1);
				this.sysMenuMapper.updateByPrimaryKeySelective(parentmenu);
			}
		}
		if (menu.getId() == null) {
			// 新增菜单
			menu.setCreatedate(new Date());
			this.sysMenuMapper.insertSelective(menu);
			menulevel += menu.getId();
		} else {
			// 修改菜单
			menulevel += menu.getId();
			TSysmenu sysMenu = this.sysMenuMapper.selectByPrimaryKey(menu.getId());
			boolean parentchanged = (sysMenu.getParentid().intValue() 
					!= menu.getParentid().intValue()) ? true : false;
			if (sysMenu.getParentflag() == 1) {
				if (sysMenu.getSortnum() != menu.getSortnum() || parentchanged) {
					// 更新子级菜单排序深度
					this.sysMenuMapper.updateMenuSortlevel(
							sysMenu.getSortlevel() + ".", menu.getSortlevel()
									+ ".");
				}
				if (parentchanged) {
					// 更新子级菜单节点深度
					this.sysMenuMapper.updateMenuLevel(sysMenu.getMenulevel()
							+ ".", menulevel + ".");
				}
			}
			// 如果修改的菜单的父级菜单和之前不一样，则判断之前父级菜单是否还有子菜单，并对是否有子菜单标识做更新
			if (parentchanged) {
				// 查询修改的菜单之前的父级菜单是否有子节点，没有子节点更新父级菜单标识
				int haschildren = this.sysMenuMapper.findMenuIsparent(menu
						.getId());
				if (haschildren == 0) {
					// 更新之前的父级菜单父级标识
					TSysmenu sysmenu = new TSysmenu();
					sysmenu.setId(sysMenu.getParentid());
					sysmenu.setParentflag(0);
					this.sysMenuMapper.updateByPrimaryKeySelective(sysmenu);
				}
			}
		}
		menu.setMenulevel(menulevel);
		menu.setCreatedate(new Date());
		this.sysMenuMapper.updateByPrimaryKeySelective(menu);
	}

	/**
	 * 删除菜单
	 * 
	 * @param menuid
	 */
	@Override
	public void deleteMenu(Integer menuid) {
		TSysmenu menu = this.sysMenuMapper.selectByPrimaryKey(menuid);
		this.sysMenuMapper.deleteMenu(menu.getMenulevel());
		// 查询修改的菜单之前的父级菜单是否有子节点，没有子节点更新父级菜单标识
		int haschildren = this.sysMenuMapper.findMenuIsparent(menuid);
		if (haschildren == 0) {
			// 更新之前的父级菜单父级标识
			TSysmenu sysmenu = new TSysmenu();
			sysmenu.setId(menu.getParentid());
			sysmenu.setParentflag(0);
			this.sysMenuMapper.updateByPrimaryKeySelective(sysmenu);
		}
	}

	/**
	 * 保存角色权限
	 */
	@Override
	public void saveRoleright(String[] menuids, int roleid, int userid) {
		// 根据角色删除之前的权限
		this.rolerightMapper.deleteByRoleid(roleid);
		this.rolerightMapper.addRoleright(menuids, roleid, userid);
	}

	/**
	 * 查询菜单图片
	 */
	@Override
	public List<Map<String, Object>> findMenuImgs() {
		return this.sysMenuMapper.findMenuImgs();
	}

}
