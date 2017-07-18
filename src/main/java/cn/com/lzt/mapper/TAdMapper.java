package cn.com.lzt.mapper;

import cn.com.lzt.model.TAd;
import cn.com.lzt.model.TAdCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAdMapper {
    int countByExample(TAdCriteria example);

    int deleteByExample(TAdCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TAd record);

    int insertSelective(TAd record);

    List<TAd> selectByExample(TAdCriteria example);

    TAd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TAd record, @Param("example") TAdCriteria example);

    int updateByExample(@Param("record") TAd record, @Param("example") TAdCriteria example);

    int updateByPrimaryKeySelective(TAd record);

    int updateByPrimaryKey(TAd record);
}