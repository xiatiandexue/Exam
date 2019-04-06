package com.oxy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oxy.dao.ExaminationPaperMapper;
import com.oxy.dao.SAQMapper;
import com.oxy.dao.SingleselectMapper;
import com.oxy.model.ExaminationPaper;
import com.oxy.model.SAQ;
import com.oxy.model.SAQExample;
import com.oxy.model.Singleselect;
import com.oxy.model.SingleselectExample;
import com.oxy.service.PaperService;
import com.oxy.vo.paper.AutoGeneratingVO;
@Service
public class PaperServiceImpl implements PaperService{
//	@Resource
//	private ExaminationPaper paper;
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
		System.out.println("单选题："+selectList.get(0).getQuestionid());
		System.out.println("简答题："+saqList.get(0).getSaqid());
		int allSelectCount = selectList.size(); //单选题总数
		int allSaqCount = saqList.size(); //简答题总数
		//取单选题id列表
		List<Integer> questionTemp = new ArrayList<Integer>(); 
//		int [] questionTemp = new int [selectList.size()];
		for(int i = 0; i < selectList.size(); i++) { //取通过章节排序后的单选题题目id
//			questionTemp[i] = selectList.get(i).getQuestionid();
			questionTemp.add(selectList.get(i).getQuestionid());
		}
		System.out.println("单选题临时列表："+questionTemp);
		//取简答题id列表
		List<Integer> saqTemp = new ArrayList<Integer>(); 
//		int [] saqTemp = new int [saqList.size()];
		for(int i = 0; i < saqList.size(); i++) { //取通过章节排序后的简答题题目id
			saqTemp.add(saqList.get(i).getSaqid());
		}
		//随机抽取题目
		//抽取单选题
		int selectBegin; //单选题开始随机数
		selectBegin = new Random().nextInt(2);
		System.out.println("单选题开始随机数："+selectBegin);
		int selectNext; //单选题递增数
		selectNext = (allSelectCount - selectBegin) / selectCount;
//		int [] questionids = new int [vo.getSelect()];
		List<Integer> questionidlist = new ArrayList<Integer>(); 
		for(int i = 0; i < selectCount; i++) {
			questionidlist.add(questionTemp.get(selectBegin));
			selectBegin = selectBegin + selectNext;
		}
		String questionids = questionidlist.toString();
		System.out.println("单选题id"+questionids);
		//抽取简答题
		int saqBegin; //简答题开始随机数
		saqBegin = new Random().nextInt(1);
		int saqNext;
		saqNext = (allSaqCount - saqBegin) / saqCount;
//		int [] saqid = new int [vo.getSaq()];
		List<Integer> saqidlist = new ArrayList<Integer>(); 
		for(int i = 0; i < saqCount; i++) {
			saqidlist.add(saqTemp.get(saqBegin));
			saqBegin = saqBegin + saqNext;
		}
		String saqids = saqidlist.toString();
		System.out.println("简答题id"+saqids);
		//添加进数据库中
//		AutoGeneratingDTO dto = AutoGeneratingDTO.builder().name(vo.getName()).selectnum(vo.getSelectnum()).saqnum(vo.getSaqnum()).score(vo.getScore()).
//				subject(vo.getSubject()).questionids(questionids).saqids(saqids).build();
		vo.setQuestionids(questionids);
		vo.setSaqids(saqids);
		ExaminationPaper paper = vo.toAutoGenerating();
		System.out.println("试卷："+paper);
//		paper.setName(vo.getName());
//		paper.setSelectnum(vo.getSelectnum());
//		paper.setSaqnum(vo.getSaqnum());
//		paper.setSubject(vo.getSubject());
//		paper.setScore(vo.getScore());
//		paper.setQuestionids(questionids);
//		paper.setSaqids(saqids);
		paperMapper.insertSelective(paper);
	}
}
