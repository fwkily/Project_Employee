package com.zm.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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
		Admin admin = mapper.selectByPrimaryKey(id);
		//盐值加密  即把用户名加进去   再把MD5加密
		ByteSource credentialsSalt = ByteSource.Util.bytes(admin.getAdminname());
		//SimpleHash执行加密
		SimpleHash simpleHash = new SimpleHash("MD5",pwd, credentialsSalt, 1024);
		
		mapper.updateByPrimaryKeySelective(new Admin(id, simpleHash.toString()));
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
		Admin admin = mapper.selectByPrimaryKey(Integer.parseInt(id));
		long keySelective = 0;
		if(checkPwd(admin,id, oldPwd)>0) {
			//盐值加密  即把用户名加进去   再把MD5加密
			ByteSource credentialsSalt = ByteSource.Util.bytes(admin.getAdminname());
			//SimpleHash执行加密
			SimpleHash simpleHash = new SimpleHash("MD5",newPwd, credentialsSalt, 1024);
			keySelective = mapper.updateAdminPwd(Integer.parseInt(id.trim()), simpleHash.toString());
			return keySelective;
		}else {
			return -1;
		}
	}
	
	//检查原密码是否正确
		public int checkPwd(Admin admin,String id,String oldPwd) {
			//加密验证
			//盐值加密  即把用户名加进去   再把MD5加密
			ByteSource credentialsSalt = ByteSource.Util.bytes(admin.getAdminname());
			//SimpleHash执行加密
			SimpleHash simpleHash = new SimpleHash("MD5",oldPwd, credentialsSalt, 1024);
			
			AdminExample example = new AdminExample();
			Criteria criteria = example.createCriteria();
			criteria.andAdminpwdEqualTo(simpleHash.toString());
			criteria.andIdEqualTo(Integer.parseInt(id));
			List<Admin> list = mapper.selectByExample(example);
			return list.size();
		}
}


