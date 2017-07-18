package cn.com.lzt.mapper;

import cn.com.lzt.model.TCodeinfo;
import cn.com.lzt.model.TCodeinfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCodeinfoMapper {
    int countByExample(TCodeinfoCriteria example);

    int deleteByExample(TCodeinfoCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCodeinfo record);

    int insertSelective(TCodeinfo record);

    List<TCodeinfo> selectByExample(TCodeinfoCriteria example);

    TCodeinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCodeinfo record, @Param("example") TCodeinfoCriteria example);

    int updateByExample(@Param("record") TCodeinfo record, @Param("example") TCodeinfoCriteria example);

    int updateByPrimaryKeySelective(TCodeinfo record);

    int updateByPrimaryKey(TCodeinfo record);
}