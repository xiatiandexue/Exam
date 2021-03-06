package com.oxy.service;

import com.github.pagehelper.PageInfo;
import com.oxy.dto.itemBank.PageSaqDTO;
import com.oxy.vo.itemBank.AddSaqVO;
import com.oxy.vo.itemBank.PageSaqVO;
import com.oxy.vo.itemBank.UpdateSaqVO;

public interface SAQService {
	PageInfo<PageSaqDTO> page(PageSaqVO req);
	void insert(AddSaqVO vo);
	void update(UpdateSaqVO vo);
	void delete(int saqid);
}
