package com.ich.dictionary.dao;

import com.ich.dictionary.pojo.IAddresscn;
import com.ich.dictionary.pojo.IAddresscnExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAddresscnMapper {
    
    int countByExample(IAddresscnExample example);

    int deleteByExample(IAddresscnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IAddresscn record);

    int insertSelective(IAddresscn record);

    List<IAddresscn> selectByExample(IAddresscnExample example);

    IAddresscn selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IAddresscn record, @Param("example") IAddresscnExample example);

    int updateByExample(@Param("record") IAddresscn record, @Param("example") IAddresscnExample example);

    int updateByPrimaryKeySelective(IAddresscn record);

    int updateByPrimaryKey(IAddresscn record);

    public void updateStatus(@Param("id")Long id, @Param("status")Integer status);

    public List<IAddresscn> selectAddressCNofType(Integer type);

    public List<IAddresscn> selectAddressCNofPid(Long pid);
}
