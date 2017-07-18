package cn.com.lzt.mapper;

import cn.com.lzt.model.TRole;
import cn.com.lzt.model.TRoleCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TRoleMapper {
    int countByExample(TRoleCriteria example);

    int deleteByExample(TRoleCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRole record);

    int insertSelective(TRole record);

    List<TRole> selectByExample(TRoleCriteria example);

    TRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRoleCriteria example);

    int updateByExample(@Param("record") TRole record, @Param("example") TRoleCriteria example);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);
    List<TRole> findRoles();
}