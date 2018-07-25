package com.ich.dictionary.dao;

import com.ich.dictionary.pojo.IBank;
import com.ich.dictionary.pojo.IBankExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBankMapper {
    
    int countByExample(IBankExample example);

    int deleteByExample(IBankExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IBank record);

    int insertSelective(IBank record);

    List<IBank> selectByExample(IBankExample example);

    IBank selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IBank record, @Param("example") IBankExample example);

    int updateByExample(@Param("record") IBank record, @Param("example") IBankExample example);

    int updateByPrimaryKeySelective(IBank record);

    int updateByPrimaryKey(IBank record);

    public void updateStatus(@Param("id")Long id, @Param("status")Integer status);

    public List<IBank> selectBanks();

    public List<IBank> selectAllList();
}
