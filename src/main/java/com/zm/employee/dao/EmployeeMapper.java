package com.zm.employee.dao;

import com.zm.employee.bean.Employee;
import com.zm.employee.bean.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    
    List<Employee> selectByExampleAndDept(EmployeeExample example);
    Employee selectByPrimaryKeyAndDept(Integer empId);
    List<Employee> selectEmp(String selectMsg); 
    List<Employee> selectEmpByDept(Integer selectMsg);
	List<Employee> selectEmpByName(String string);
    long updateEmpPwd(@Param("id") Integer id,@Param("pwd") String pwd);
}