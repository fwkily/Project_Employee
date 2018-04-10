package com.zm.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.employee.bean.Admin;
import com.zm.employee.bean.AdminExample;
import com.zm.employee.bean.AdminExample.Criteria;
import com.zm.employee.dao.AdminMapper;

@Service
public class AdminService {
 
	@Autowired
	private AdminMapper mapper;

	//获取
	public List<Admin> getAdminMsg() {
		// TODO Auto-generated method stub
		List<Admin> list = mapper.selectByExample(null);
		return list;
	}

	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		mapper.insertSelective(admin);
	}

	public void updateAdmin(Integer id, String pwd) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKeySelective(new Admin(id, pwd));
	}

	//批量删除
	public void delAdmin(String id) {
		// TODO Auto-generated method stub
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();

		List<Integer> list = new ArrayList<>();
		if(id.contains("-")) {
			String[] split = id.split("-");
			for (String ids : split) {
				list.add(Integer.parseInt(ids));
			}
			//存放所有被删除的id 
			criteria.andIdIn(list);
			mapper.deleteByExample(example);
		}else {
			mapper.deleteByPrimaryKey(Integer.parseInt(id));
		}
	}

	public Admin login(String name, String pwd) {
		// TODO Auto-generated method stub
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andAdminnameEqualTo(name.trim());
		criteria.andAdminpwdEqualTo(pwd.trim());
		List<Admin> list = mapper.selectByExample(example);
		Admin a = new Admin();
		if(list.size()>0) {
			for (Admin admin : list) {
				a.setId(admin.getId());
				a.setAdminname(admin.getAdminname());
				a.setAdminpower(admin.getAdminpower());
				a.setAdminpwd(admin.getAdminpwd());
				a.setAdmindesc(admin.getAdmindesc());
			}
			return a;
		}
			return null;
	}

	public long updatePwd(String id, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		long keySelective = 0;
		if(checkPwd(id, oldPwd)>0) {
			keySelective = mapper.updateAdminPwd(Integer.parseInt(id.trim()), newPwd.trim());
			return keySelective;
		}else {
			return -1;
		}
	}
	
	//检查原密码是否正确
		public int checkPwd(String id,String oldPwd) {
			AdminExample example = new AdminExample();
			Criteria criteria = example.createCriteria();
			criteria.andAdminpwdEqualTo(oldPwd);
			criteria.andIdEqualTo(Integer.parseInt(id));
			List<Admin> list = mapper.selectByExample(example);
			return list.size();
		}
}


