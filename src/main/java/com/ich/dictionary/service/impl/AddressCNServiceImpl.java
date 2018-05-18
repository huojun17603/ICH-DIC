package com.ich.dictionary.service.impl;


import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.dictionary.dao.AddressCNMapper;
import com.ich.dictionary.pojo.AddressCN;
import com.ich.dictionary.service.AddressCNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressCNServiceImpl implements AddressCNService {

    @Autowired
    private AddressCNMapper  addressCNMapper;

    @Override
    public HttpResponse addOrEdit(AddressCN address) {
        if(ObjectHelper.isEmpty(address.getId())) return new HttpResponse(HttpResponse.HTTP_ERROR,"ID不可为空！");
        if(ObjectHelper.isEmpty(address.getName())) return new HttpResponse(HttpResponse.HTTP_ERROR,"区域名称不可为空！");
        if(ObjectHelper.isEmpty(address.getLetter())) return new HttpResponse(HttpResponse.HTTP_ERROR,"手写字母不可为空！");
        if(ObjectHelper.isEmpty(address.getType())) return new HttpResponse(HttpResponse.HTTP_ERROR,"区域类别不可为空！");
        AddressCN addr = this.addressCNMapper.selectByPrimaryKey(address.getId());
        if(ObjectHelper.isEmpty(addr)){
            this.addressCNMapper.insert(address);
        }else{
            this.addressCNMapper.update(address);
        }
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public HttpResponse editStatus(Long id, Integer status) {
        this.addressCNMapper.updateStatus(id,status);
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public List<AddressCN> findAddressCNofType(Integer type) {
        return this.addressCNMapper.selectAddressCNofType(type);
    }

    @Override
    public List<AddressCN> findAddressCNofPid(Long pid) {
        return this.addressCNMapper.selectAddressCNofPid(pid);
    }
}
