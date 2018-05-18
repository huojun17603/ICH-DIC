package com.ich.dictionary.dao;

import com.ich.dictionary.pojo.Bank;
import com.ich.dictionary.pojo.National;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NationalMapper {

    public void insert(National national);

    public void update(National national);

    public void updateStatus(@Param("id") Long id, @Param("status") Integer status);

    public National selectByPrimaryKey(Long id);

    public List<National> selectNationals();
}
