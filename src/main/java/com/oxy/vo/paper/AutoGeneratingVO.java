package com.oxy.vo.paper;

import com.oxy.model.ExaminationPaper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AutoGeneratingVO {
	private String name;
	private Integer selectnum;
	private Integer saqnum;
	private String subject;
	private Integer score;
	private String questionids;
	private String saqids;
	
	public ExaminationPaper toAutoGenerating(){
		ExaminationPaper paper = new ExaminationPaper();
		paper.setName(name);
		paper.setSelectnum(selectnum);
		paper.setSaqnum(saqnum);
		paper.setSubject(subject);
		paper.setScore(score);
		paper.setQuestionids(questionids);
		paper.setSaqids(saqids);
		return paper;
				
	}
}
