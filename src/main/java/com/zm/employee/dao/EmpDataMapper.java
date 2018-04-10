package com.zm.employee.dao;

import com.zm.employee.bean.EmpData;
import com.zm.employee.bean.EmpDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpDataMapper {
    long countByExample(EmpDataExample example);

    int deleteByExample(EmpDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmpData record);

    int insertSelective(EmpData record);

    List<EmpData> selectByExample(EmpDataExample example);

    EmpData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmpData record, @Param("example") EmpDataExample example);

    int updateByExample(@Param("record") EmpData record, @Param("example") EmpDataExample example);

    int updateByPrimaryKeySelective(EmpData record);

    int updateByPrimaryKey(EmpData record);
}