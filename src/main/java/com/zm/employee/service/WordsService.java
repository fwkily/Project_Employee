package com.zm.employee.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.employee.bean.Words;
import com.zm.employee.bean.WordsExample;
import com.zm.employee.bean.WordsExample.Criteria;
import com.zm.employee.dao.WordsMapper;

@Service
public class WordsService {

	@Autowired
	private WordsMapper mapper;

	//查询
	public List<Words> showW() {
		// TODO Auto-generated method stub
		WordsExample example = new WordsExample();
		example.setOrderByClause("id DESC");
		List<Words> list = mapper.selectByExample(example);
		return list;
	}

	//新增
	public void addW(String name, String content) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = d.format(date);
		mapper.insertSelective(new Words(name, content, format));
	}

	//删除
	public void delW(String id) {
		// TODO Auto-generated method stub
		WordsExample example = new WordsExample();
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
}
