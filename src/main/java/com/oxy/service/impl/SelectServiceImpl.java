package com.oxy.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oxy.dao.SingleselectMapper;
import com.oxy.dao.ext.ExtSingleselectMapper;
import com.oxy.dto.itemBank.PageSelectDTO;
import com.oxy.model.Singleselect;
import com.oxy.service.SelectService;
import com.oxy.utils.ServiceException;
import com.oxy.vo.itemBank.AddSelectVO;
import com.oxy.vo.itemBank.PageSelectVO;
import com.oxy.vo.itemBank.UpdateSelectVO;
@Service
public class SelectServiceImpl implements SelectService{
	@Autowired
	private SingleselectMapper selectMapper;
	@Resource
	private ExtSingleselectMapper extSelectMapper;
	@Override
	public void insert(AddSelectVO vo){
		Singleselect select = vo.toSelect();
		selectMapper.insert(select);
	}
	@Override
	public PageInfo<PageSelectDTO> page(PageSelectVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		PageSelectDTO dto = PageSelectDTO.builder().question(vo.getQuestion()).subject(vo.getSubject()).chapter(vo.getChapter()).build();
		System.out.println(dto);
		PageInfo<PageSelectDTO> pageInfo = new PageInfo<>(extSelectMapper.listPage(dto));
		return pageInfo;
	}
	@Override
	public void update(UpdateSelectVO vo){
		Singleselect select = selectMapper.selectByPrimaryKey(vo.getQuestionid());
		if (select == null){
			throw new ServiceException(-2,"当前无此单选题信息，请刷新页面");
		}
		selectMapper.updateByPrimaryKeySelective(vo.toSelect());
	}
	
	@Override
	public void delete(int questionid){
		selectMapper.deleteByPrimaryKey(questionid);
	}
}
