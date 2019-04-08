package com.oxy.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Joiner;
import com.oxy.dao.ExaminationPaperMapper;
import com.oxy.dao.SAQMapper;
import com.oxy.dao.SingleselectMapper;
import com.oxy.dao.ext.ExtPaperMapper;
import com.oxy.dto.paper.PagePaperDTO;
import com.oxy.model.ExaminationPaper;
import com.oxy.model.SAQ;
import com.oxy.model.SAQExample;
import com.oxy.model.Singleselect;
import com.oxy.model.SingleselectExample;
import com.oxy.service.PaperService;
import com.oxy.utils.ServiceException;
import com.oxy.vo.paper.AutoGeneratingVO;
import com.oxy.vo.paper.PagePaperVO;
import com.oxy.vo.paper.SelectIdVO;
@Service
public class PaperServiceImpl implements PaperService{
	@Resource
	private ExtPaperMapper extPaperMapper;
	@Resource
	private SingleselectMapper selectMapper;
	@Resource
	private SAQMapper saqMapper;
	@Resource
	private ExaminationPaperMapper paperMapper;
	/*
	 * @Description 单选题list(根据科目选择，然后用章节排序)
	 */
	@Override
	public List<Singleselect> getSelect(String subject){
		SingleselectExample selectExample = new SingleselectExample();
		com.oxy.model.SingleselectExample.Criteria selectCriteria = selectExample.createCriteria();
		selectCriteria.andSubjectEqualTo(subject);
		selectExample.setOrderByClause("Chapter ASC");
		List<Singleselect> selectList = selectMapper.selectByExample(selectExample);
		if (selectList != null && selectList.size() > 0) {
			return selectList;
		}
		return null;
	}
	/*
	 * @Description 简答题list(根据科目选择，然后用章节排序)
	 */
	@Override
	public List<SAQ> getSaq(String subject){
		SAQExample saqExample = new SAQExample();
		com.oxy.model.SAQExample.Criteria saqCriteria = saqExample.createCriteria();
		saqCriteria.andSubjectEqualTo(subject);
		saqExample.setOrderByClause("Chapter ASC");
		List<SAQ> saqList = saqMapper.selectByExample(saqExample);
		if (saqList != null && saqList.size() > 0) {
			return saqList;
		}
		return null;
	}
	/*
	 * 自动组卷
	 */
	@Override
	public void insert(AutoGeneratingVO vo){
		int selectCount = vo.getSelectnum(); //要抽取的单选题数量
		int saqCount = vo.getSaqnum(); //要抽取的简答题数量
		List<Singleselect> selectList = getSelect(vo.getSubject()); //单选题list
		List<SAQ> saqList = getSaq(vo.getSubject()); //简答题list
		int allSelectCount = selectList.size(); //单选题总数
		int allSaqCount = saqList.size(); //简答题总数
		//取单选题id列表
		List<Integer> questionTemp = new ArrayList<Integer>(); 
		for(int i = 0; i < selectList.size(); i++) { //取通过章节排序后的单选题题目id
			questionTemp.add(selectList.get(i).getQuestionid());
		}
		if(questionTemp.size() < selectCount){
			throw new ServiceException(-2,"题库题目数量不足以组卷");
		}
		System.out.println("单选题临时列表："+questionTemp);
		//取简答题id列表
		List<Integer> saqTemp = new ArrayList<Integer>(); 
		for(int i = 0; i < saqList.size(); i++) { //取通过章节排序后的简答题题目id
			saqTemp.add(saqList.get(i).getSaqid());
		}
		if(saqTemp.size() < saqCount){
			throw new ServiceException(-2,"题库题目数量不足以组卷");
		}
		//随机抽取题目
		//抽取单选题
		int selectBegin; //单选题开始随机数
		selectBegin = new Random().nextInt(2);
		System.out.println("单选题开始随机数："+selectBegin);
		int selectNext; //单选题递增数
		selectNext = (allSelectCount - selectBegin) / selectCount;
		List<Integer> questionidlist = new ArrayList<Integer>(); 
		for(int i = 0; i < selectCount; i++) {
			questionidlist.add(questionTemp.get(selectBegin));
			selectBegin = selectBegin + selectNext;
		}
		String questionids = Joiner.on(",").join(questionidlist); 
//		String questionids = questionidlist.toString();
		System.out.println("单选题id:"+questionids);
		//抽取简答题
		int saqBegin; //简答题开始随机数
		saqBegin = new Random().nextInt(1);
		int saqNext;
		saqNext = (allSaqCount - saqBegin) / saqCount;
		List<Integer> saqidlist = new ArrayList<Integer>(); 
		for(int i = 0; i < saqCount; i++) {
			saqidlist.add(saqTemp.get(saqBegin));
			saqBegin = saqBegin + saqNext;
		}
		String saqids = Joiner.on(",").join(saqidlist); 
//		String saqids = saqidlist.toString(",");
		System.out.println("简答题id:"+saqids);
		//添加进数据库中
		vo.setQuestionids(questionids);
		vo.setSaqids(saqids);
		ExaminationPaper paper = vo.toAutoGenerating();
		paperMapper.insertSelective(paper);
	}
	
	/*
	 * 分页查询试卷
	 */
	@Override
	public PageInfo<PagePaperDTO> page(PagePaperVO vo){
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		PagePaperDTO dto = PagePaperDTO.builder().subject(vo.getSubject()).createuser(vo.getCreateuser()).build();
		PageInfo<PagePaperDTO> pageInfo = new PageInfo<>(extPaperMapper.listPage(dto));
		return pageInfo;
	}
	/*
	 * 删除试卷
	 */
	@Override
	public void delete(int paperid){
		paperMapper.deleteByPrimaryKey(paperid);
	}
	/*
	 * 根据id查询试卷信息
	 */
	@Override
	public ExaminationPaper selectById(int paperid){
		ExaminationPaper paper = paperMapper.selectByPrimaryKey(paperid);
		return paper;
		
	}
	/*
	 * 根据id查询单选题信息
	 */
	@Override
	public List<Singleselect> getSelectById(String questionids){
//		System.out.println(questionids);
		String str[] = questionids.split(",");
		List<String> questionIds = Arrays.asList(str);
//		System.out.println(questionIds);
		List<Singleselect> list = new ArrayList<>(questionIds.size());
//		ArrayList list = new ArrayList(questionids);
		for (int i = 0; i < questionIds.size(); i++ ) {
			int questionid = Integer.parseInt(questionIds.get(i));
//			System.out.println(questionid);
			list.add(selectMapper.selectByPrimaryKey(questionid));
		}
		return list;
	}
	/*
	 * 根据id查询简答题信息
	 */
	@Override
	public List<SAQ> getSAQById(String saqids){
//		System.out.println(saqids);
		String str[] = saqids.split(",");
		List<String> saqIds = Arrays.asList(str);
//		System.out.println(saqIds);
		List<SAQ> list = new ArrayList<>(saqIds.size());
		for (int i = 0; i < saqIds.size(); i++ ) {
			int saqid = Integer.parseInt(saqIds.get(i));
//			System.out.println(saqid);
			list.add(saqMapper.selectByPrimaryKey(saqid));
		}
		return list;
	}
	/*
	 * 删除单选题
	 */
	@Override
	public void deleteSelect(SelectIdVO vo){
		ExaminationPaper paper = selectById(vo.getPaperid());
		String str[] = paper.getQuestionids().split(",");
		List<String> questionIds = Arrays.asList(str);
		Integer selectid = vo.getQuestionid();
		System.out.println("selectid:"+selectid);
		for(int i = questionIds.size() - 1; i >=0; i--){
			Integer item = Integer.parseInt(questionIds.get(i));
			System.out.println(item);
			if(selectid.equals(item)){
				questionIds.remove(item);
				System.out.println("删除后的选择题id："+questionIds);
			}
		}
		System.out.println(questionIds.size());
	}
}
