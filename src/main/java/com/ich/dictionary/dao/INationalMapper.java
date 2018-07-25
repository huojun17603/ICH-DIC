package com.ich.dictionary.dao;

import com.ich.dictionary.pojo.INational;
import com.ich.dictionary.pojo.INationalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface INationalMapper {
    
    int countByExample(INationalExample example);

    int deleteByExample(INationalExample example);

    int deleteByPrimaryKey(Long id);

    int insert(INational record);

    int insertSelective(INational record);

    List<INational> selectByExample(INationalExample example);

    INational selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") INational record, @Param("example") INationalExample example);

    int updateByExample(@Param("record") INational record, @Param("example") INationalExample example);

    int updateByPrimaryKeySelective(INational record);

    int updateByPrimaryKey(INational record);

    public void updateStatus(@Param("id") Long id, @Param("status") Integer status);

    public List<INational> selectNationals();
}
