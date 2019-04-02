package com.oxy.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oxy.dao.SAQMapper;
import com.oxy.dao.ext.ExtSAQMapper;
import com.oxy.dto.itemBank.PageSaqDTO;
import com.oxy.model.SAQ;
import com.oxy.service.SAQService;
import com.oxy.utils.ServiceException;
import com.oxy.vo.itemBank.AddSaqVO;
import com.oxy.vo.itemBank.PageSaqVO;
import com.oxy.vo.itemBank.UpdateSaqVO;
@Service
public class SAQServiceImpl implements SAQService {
	@Autowired
	private SAQMapper saqMapper;
	@Resource
	private ExtSAQMapper extSAQMapper;
	
	@Override
	public PageInfo<PageSaqDTO> page(PageSaqVO vo){
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		PageSaqDTO dto = PageSaqDTO.builder().question(vo.getQuestion()).subject(vo.getSubject()).chapter(vo.getChapter()).createuser(vo.getCreateuser()).build();
		PageInfo<PageSaqDTO> pageInfo = new PageInfo<>(extSAQMapper.listPage(dto));
		return pageInfo;
	}
	
	@Override
	public void insert(AddSaqVO vo){
		SAQ saq = vo.toSAQ();
		saqMapper.insert(saq);
	}
	
	@Override
	public void update(UpdateSaqVO vo){
		SAQ saq = saqMapper.selectByPrimaryKey(vo.getSaqid());
		if (saq == null ){
			throw new ServiceException(-2,"当前无此简答题信息，请刷新页面");
		}
		saqMapper.updateByPrimaryKeySelective(vo.toSAQ());
	}
	
	@Override
	public void delete(int saqid){
		saqMapper.deleteByPrimaryKey(saqid);
	}
}
