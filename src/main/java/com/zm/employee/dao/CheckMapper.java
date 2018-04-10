package com.zm.employee.dao;

import com.zm.employee.bean.Check;
import com.zm.employee.bean.CheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckMapper {
    long countByExample(CheckExample example);

    int deleteByExample(CheckExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Check record);

    int insertSelective(Check record);

    List<Check> selectByExample(CheckExample example);

    Check selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Check record, @Param("example") CheckExample example);

    int updateByExample(@Param("record") Check record, @Param("example") CheckExample example);

    int updateByPrimaryKeySelective(Check record);

    int updateByPrimaryKey(Check record);
    
    //多个参数用@Param指定
    int updateDkEmpid(@Param("id") String id, @Param("date") String date);
    
}