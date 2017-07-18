package cn.com.lzt.mapper;

import cn.com.lzt.model.TUserrole;
import cn.com.lzt.model.TUserroleCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserroleMapper {
    int countByExample(TUserroleCriteria example);

    int deleteByExample(TUserroleCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserrole record);

    int insertSelective(TUserrole record);

    List<TUserrole> selectByExample(TUserroleCriteria example);

    TUserrole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserrole record, @Param("example") TUserroleCriteria example);

    int updateByExample(@Param("record") TUserrole record, @Param("example") TUserroleCriteria example);

    int updateByPrimaryKeySelective(TUserrole record);

    int updateByPrimaryKey(TUserrole record);

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
    TUserrole findByUserid(Integer userid);

    /**
     * 根据用户ID修改用户角色
     * @param roleid
     * @param userid
     */
    void updateUserRoleById(@Param("roleid") int roleid,
                            @Param("userid") int userid);
    
}