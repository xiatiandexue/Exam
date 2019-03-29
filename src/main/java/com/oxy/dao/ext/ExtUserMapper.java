package com.oxy.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.oxy.dto.PageUserDTO;
@Mapper
public interface ExtUserMapper {
	List<PageUserDTO> listPage(@Param("param") PageUserDTO pageUserDTO);
}
