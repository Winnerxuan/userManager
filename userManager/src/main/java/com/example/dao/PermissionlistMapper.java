package com.example.dao;

import com.example.bean.Permissionlist;
import com.example.bean.PermissionlistExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PermissionlistMapper {
    long countByExample(PermissionlistExample example);

    int deleteByExample(PermissionlistExample example);

    int deleteByPrimaryKey(String permissionlistid);

    int insert(Permissionlist record);

    int insertSelective(Permissionlist record);

    List<Permissionlist> selectByExample(PermissionlistExample example);

    Permissionlist selectByPrimaryKey(String permissionlistid);

    int updateByExampleSelective(@Param("record") Permissionlist record, @Param("example") PermissionlistExample example);

    int updateByExample(@Param("record") Permissionlist record, @Param("example") PermissionlistExample example);

    int updateByPrimaryKeySelective(Permissionlist record);

    int updateByPrimaryKey(Permissionlist record);
}