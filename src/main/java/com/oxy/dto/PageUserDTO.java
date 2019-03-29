package com.oxy.dto;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class PageUserDTO {
	private String usercode;
	private String name;
	private String role;
	
}
