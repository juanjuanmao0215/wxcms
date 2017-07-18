package cn.com.lzt.mapper;

import cn.com.lzt.model.TSysmenu;
import cn.com.lzt.model.TSysmenuCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TSysmenuMapper {
    int countByExample(TSysmenuCriteria example);

    int deleteByExample(TSysmenuCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSysmenu record);

    int insertSelective(TSysmenu record);

    List<TSysmenu> selectByExample(TSysmenuCriteria example);

    TSysmenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSysmenu record, @Param("example") TSysmenuCriteria example);

    int updateByExample(@Param("record") TSysmenu record, @Param("example") TSysmenuCriteria example);

    int updateByPrimaryKeySelective(TSysmenu record);

    int updateByPrimaryKey(TSysmenu record);

    /**
     * 菜单查询
     *
     * @param roleid
     * @param userid
     * @return
     */
    List<TSysmenu> findMenus(@Param("roleid") Integer roleid,
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