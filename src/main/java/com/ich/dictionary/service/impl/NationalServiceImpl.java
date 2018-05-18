package com.ich.dictionary.service.impl;

import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.dictionary.dao.BankMapper;
import com.ich.dictionary.dao.NationalMapper;
import com.ich.dictionary.pojo.Bank;
import com.ich.dictionary.pojo.National;
import com.ich.dictionary.service.BankService;
import com.ich.dictionary.service.NationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationalServiceImpl implements NationalService {

    @Autowired
    private NationalMapper nationalMapper;

    @Override
    public HttpResponse addOrEdit(National national) {
        if(ObjectHelper.isEmpty(national.getName())) return new HttpResponse(HttpResponse.HTTP_ERROR,"国家名称不可为空！");
        if(ObjectHelper.isEmpty(national.getCode())) return new HttpResponse(HttpResponse.HTTP_ERROR,"国家编码不可为空！");
        if(ObjectHelper.isEmpty(national.getId())){
            this.nationalMapper.insert(national);
        }else{
            this.nationalMapper.update(national);
        }
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public HttpResponse editStatus(Long id, Integer status) {
        this.nationalMapper.updateStatus(id,status);
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public List<National> findNationals() {
        return this.nationalMapper.selectNationals();
    }
}
