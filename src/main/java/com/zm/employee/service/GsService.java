package com.zm.employee.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.employee.bean.Gg;
import com.zm.employee.bean.GgExample;
import com.zm.employee.bean.GgExample.Criteria;
import com.zm.employee.dao.GgMapper;

@Service
public class GsService {

	@Autowired
	private GgMapper ggMapper;


	//查询全部
	public List<Gg> showGg() {
		// TODO Auto-generated method stub
		GgExample example = new GgExample();
		example.setOrderByClause("id DESC");		//设置排序规则

		List<Gg> g = ggMapper.selectByExample(example);
		return g;
	}
	
	//查询第一条
		public Gg showGgOne() {
			// TODO Auto-generated method stub
		Gg showGgOne = ggMapper.showGgOne();
			
			return showGgOne;
		}
	
	
	
	

	//新增
	public void addGg(String name, String content) {
		// TODO Auto-generated method stub
		//格式化当前时间
		Date date = new Date();
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = d.format(date);

		ggMapper.insertSelective(new Gg(name, content, format));

	}

	//批量删除
	public void delGg(String id) {
		// TODO Auto-generated method stub
		GgExample example = new GgExample();
		Criteria criteria = example.createCriteria();
		List<Integer> list = new ArrayList<>();
		if(id.contains("-")) {
			String[] split = id.split("-");
			for (String ids : split) {
				list.add(Integer.parseInt(ids));
			}
			//存放所有被删除的id 
			criteria.andIdIn(list);
			ggMapper.deleteByExample(example);
		}else {
			ggMapper.deleteByPrimaryKey(Integer.parseInt(id));
		}
	}
}
