package com.oxy.service;

import java.util.List;

import com.oxy.model.SAQ;
import com.oxy.model.Singleselect;
import com.oxy.vo.paper.AutoGeneratingVO;

public interface PaperService {
	List<Singleselect> getSelect(String subject);
	
	List<SAQ> getSaq(String subject);
	
	void insert(AutoGeneratingVO vo);
}
