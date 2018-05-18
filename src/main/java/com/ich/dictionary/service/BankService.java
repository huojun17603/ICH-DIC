package com.ich.dictionary.service;

import com.ich.core.http.entity.HttpResponse;
import com.ich.dictionary.pojo.AddressCN;
import com.ich.dictionary.pojo.Bank;

import java.util.List;

public interface BankService {

    /**
     *  请求所有列表
     */
    public List<Bank> findAllList();

    /**
     * 新增或修改银行信息，所有的操作对状态无效，新增的默认状态为不可用
     * @param bank 需要保存或修改的数据
     * @return 是否完成
     */
    public HttpResponse addOrEdit(Bank bank);

    /**
     * 修改状态
     * @param id ID
     * @param status 状态值
     * @return 是否完成
     */
    public HttpResponse editStatus(Long id,Integer status);
    /**
     * 查询所有的有效银行列表
     * @return 列表
     */
    public List<Bank> findBanks();
}
