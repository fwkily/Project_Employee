package com.zm.employee.dao;

import com.zm.employee.bean.Gg;
import com.zm.employee.bean.GgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GgMapper {
    long countByExample(GgExample example);

    int deleteByExample(GgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gg record);

    int insertSelective(Gg record);

    List<Gg> selectByExample(GgExample example);

    Gg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Gg record, @Param("example") GgExample example);

    int updateByExample(@Param("record") Gg record, @Param("example") GgExample example);

    int updateByPrimaryKeySelective(Gg record);

    int updateByPrimaryKey(Gg record);
    
    Gg showGgOne();
    
}