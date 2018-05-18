package com.ich.dictionary.dao;

import com.ich.dictionary.pojo.Bank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BankMapper {

    public void insert(Bank bank);

    public void update(Bank bank);

    public void updateStatus(@Param("id")Long id, @Param("status")Integer status);

    public Bank selectByPrimaryKey(Long id);

    public List<Bank> selectBanks();

    public List<Bank> selectAllList();
}
