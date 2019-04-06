package com.oxy.dao;

import org.apache.ibatis.annotations.Mapper;

import com.oxy.model.Examination;
@Mapper
public interface ExaminationMapper {
    int deleteByPrimaryKey(Integer examinationid);

    int insert(Examination record);

    int insertSelective(Examination record);

    Examination selectByPrimaryKey(Integer examinationid);

    int updateByPrimaryKeySelective(Examination record);

    int updateByPrimaryKey(Examination record);
}