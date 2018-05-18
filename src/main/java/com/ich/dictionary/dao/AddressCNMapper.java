package com.ich.dictionary.dao;

import com.ich.dictionary.pojo.AddressCN;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressCNMapper {

    public void insert(AddressCN address);

    public void update(AddressCN address);

    public AddressCN selectByPrimaryKey(Long id);

    public void updateStatus(@Param("id")Long id, @Param("status")Integer status);

    public List<AddressCN> selectAddressCNofType(Integer type);

    public List<AddressCN> selectAddressCNofPid(Long pid);
}
