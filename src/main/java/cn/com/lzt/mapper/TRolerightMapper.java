package cn.com.lzt.mapper;

import cn.com.lzt.model.TRoleright;
import cn.com.lzt.model.TRolerightCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TRolerightMapper {
    int countByExample(TRolerightCriteria example);

    int deleteByExample(TRolerightCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRoleright record);

    int insertSelective(TRoleright record);

    List<TRoleright> selectByExample(TRolerightCriteria example);

    TRoleright selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRoleright record, @Param("example") TRolerightCriteria example);

    int updateByExample(@Param("record") TRoleright record, @Param("example") TRolerightCriteria example);

    int updateByPrimaryKeySelective(TRoleright record);

    int updateByPrimaryKey(TRoleright record);

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