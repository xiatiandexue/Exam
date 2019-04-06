package com.oxy.dto.paper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AutoGeneratingDTO {
	private String name;
	private Integer selectnum;
	private Integer saqnum;
	private Integer score;
	private String subject;
	private String questionids;
	private String saqids;
}
