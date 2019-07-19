package com.example.dao;

import com.example.bean.Actionlist;
import com.example.bean.ActionlistExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ActionlistMapper {
    long countByExample(ActionlistExample example);

    int deleteByExample(ActionlistExample example);

    int deleteByPrimaryKey(Integer actionlist);

    int insert(Actionlist record);

    int insertSelective(Actionlist record);

    List<Actionlist> selectByExample(ActionlistExample example);

    Actionlist selectByPrimaryKey(Integer actionlist);

    int updateByExampleSelective(@Param("record") Actionlist record, @Param("example") ActionlistExample example);

    int updateByExample(@Param("record") Actionlist record, @Param("example") ActionlistExample example);

    int updateByPrimaryKeySelective(Actionlist record);

    int updateByPrimaryKey(Actionlist record);
}