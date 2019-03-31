package com.oxy.vo.itemBank;

import lombok.Data;

@Data
public class PageSelectVO {
	private String question;
	private String subject;
	private String chapter;
	private Integer pageNum;
	private Integer pageSize;
}
