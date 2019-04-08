package com.oxy.dto.paper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagePaperDTO {
	private Integer paperid;
	private String name;
	private Integer selectnum;
	private Integer saqnum;
	private Integer score;
	private String subject;
	private String createuser;
}
