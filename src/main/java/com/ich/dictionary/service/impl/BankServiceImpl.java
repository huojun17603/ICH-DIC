package com.ich.dictionary.service.impl;

import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.dictionary.dao.BankMapper;
import com.ich.dictionary.pojo.AddressCN;
import com.ich.dictionary.pojo.Bank;
import com.ich.dictionary.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankMapper bankMapper;

    @Override
    public List<Bank> findAllList() {
        return this.bankMapper.selectAllList();
    }

    @Override
    public HttpResponse addOrEdit(Bank bank) {
        if(ObjectHelper.isEmpty(bank.getName())) return new HttpResponse(HttpResponse.HTTP_ERROR,"银行名称不可为空！");
        if(ObjectHelper.isEmpty(bank.getCode())) return new HttpResponse(HttpResponse.HTTP_ERROR,"银行编码不可为空！");
        if(ObjectHelper.isEmpty(bank.getThemecode())) return new HttpResponse(HttpResponse.HTTP_ERROR,"主题色不可为空！");
        if(ObjectHelper.isEmpty(bank.getId())){
            this.bankMapper.insert(bank);
        }else{
            this.bankMapper.update(bank);
        }
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public HttpResponse editStatus(Long id, Integer status) {
        this.bankMapper.updateStatus(id,status);
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public List<Bank> findBanks() {
        return this.bankMapper.selectBanks();
    }
}
