package cn.com.lzt.mapper;

import cn.com.lzt.model.TSysuser;
import cn.com.lzt.model.TSysuserCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TSysuserMapper {
    int countByExample(TSysuserCriteria example);

    int deleteByExample(TSysuserCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSysuser record);

    int insertSelective(TSysuser record);

    List<TSysuser> selectByExample(TSysuserCriteria example);

    TSysuser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSysuser record, @Param("example") TSysuserCriteria example);

    int updateByExample(@Param("record") TSysuser record, @Param("example") TSysuserCriteria example);

    int updateByPrimaryKeySelective(TSysuser record);

    int updateByPrimaryKey(TSysuser record);

    /**
     * 根据登录账号查询用户
     *
     * @param loginid
     * @return
     */
    TSysuser findUserByLoginId(String loginid);

    /**
     * 根据用户id查询用户信息
     * @param userid
     * @return
     */
    TSysuser findUserById(int userid);

    /**
     * 批量删除用户
     *
     * @param ids
     */
    void batchdeleteuser(String[] ids);

    /**
     * 系统用户查询
     *
     * @param req
     * @return
     */
    List<Map<String, Object>> findSysUsers(TSysuser req);

}