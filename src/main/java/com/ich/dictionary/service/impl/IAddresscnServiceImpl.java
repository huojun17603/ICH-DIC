package com.ich.dictionary.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ich.core.base.JsonUtils;
import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.core.http.entity.PageView;
import com.ich.core.http.entity.SortView;
import com.ich.dictionary.dao.IAddresscnMapper;
import com.ich.dictionary.pojo.IAddresscn;
import com.ich.dictionary.pojo.IAddresscnExample;
import com.ich.dictionary.service.IAddresscnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAddresscnServiceImpl implements IAddresscnService {

    @Autowired
    private IAddresscnMapper addressCNMapper;

    @Override
    public HttpResponse add(IAddresscn address) {
        if(ObjectHelper.isEmpty(address.getId())) return new HttpResponse(HttpResponse.HTTP_ERROR,"区域编码不可为空！");
        if(ObjectHelper.isEmpty(address.getName())) return new HttpResponse(HttpResponse.HTTP_ERROR,"区域名称不可为空！");
        if(ObjectHelper.isEmpty(address.getLetter())) return new HttpResponse(HttpResponse.HTTP_ERROR,"手写字母不可为空！");
        if(ObjectHelper.isEmpty(address.getType())) return new HttpResponse(HttpResponse.HTTP_ERROR,"区域类别不可为空！");
        if(address.getType()==1){
            if(ObjectHelper.isNotEmpty(address.getParentid()))
                return new HttpResponse(HttpResponse.HTTP_ERROR,"不可自定义省级区域！");
        }else{
            if(ObjectHelper.isEmpty(address.getParentid()))
                return new HttpResponse(HttpResponse.HTTP_ERROR,"请输入父级！");
            IAddresscn addrx = this.addressCNMapper.selectByPrimaryKey(address.getParentid());
            if(ObjectHelper.isEmpty(addrx))
                return new HttpResponse(HttpResponse.HTTP_ERROR,"无效的区域父级！");
        }
        IAddresscn addr = this.addressCNMapper.selectByPrimaryKey(address.getId());
        if(ObjectHelper.isNotEmpty(addr)) return new HttpResponse(HttpResponse.HTTP_ERROR,"重复的区域编码！");
        if(ObjectHelper.isEmpty(address.getOnum())) address.setOnum(0);
        address.setStatus(0);
        this.addressCNMapper.insert(address);
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public HttpResponse edit(IAddresscn address) {
        IAddresscn addr = this.addressCNMapper.selectByPrimaryKey(address.getId());
        if(ObjectHelper.isEmpty(addr)){
            return new HttpResponse(HttpResponse.HTTP_ERROR,"区域编码不存在！");
        }
        if(ObjectHelper.isEmpty(address.getName())) return new HttpResponse(HttpResponse.HTTP_ERROR,"区域名称不可为空！");
        if(ObjectHelper.isEmpty(address.getLetter())) return new HttpResponse(HttpResponse.HTTP_ERROR,"手写字母不可为空！");
        if(ObjectHelper.isEmpty(address.getType())) return new HttpResponse(HttpResponse.HTTP_ERROR,"区域类别不可为空！");
        if(address.getType()==1){
            if(ObjectHelper.isNotEmpty(address.getParentid()))
                return new HttpResponse(HttpResponse.HTTP_ERROR,"不可自定义省级区域！");
        }else{
            if(ObjectHelper.isEmpty(address.getParentid()))
                return new HttpResponse(HttpResponse.HTTP_ERROR,"请输入父级！");
            IAddresscn addrx = this.addressCNMapper.selectByPrimaryKey(address.getParentid());
            if(ObjectHelper.isEmpty(addrx))
                return new HttpResponse(HttpResponse.HTTP_ERROR,"无效的区域父级！");
        }
        if(ObjectHelper.isEmpty(address.getOnum())) address.setOnum(0);
        this.addressCNMapper.updateByPrimaryKeySelective(address);
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public HttpResponse editStatus(Long id, Integer status) {
        this.addressCNMapper.updateStatus(id,status);
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public List<IAddresscn> findList(PageView page, SortView sort, IAddresscnExample example){
        PageHelper.startPage(page.getPage(),page.getRows());
        if(ObjectHelper.isNotEmpty(sort)){
            if(ObjectHelper.isNotEmpty(sort.getSort())&&ObjectHelper.isNotEmpty(sort.getOrder())){
                example.setOrderByClause(sort.getSort()+" "+sort.getOrder());
            }
        }
        List<IAddresscn> list = addressCNMapper.selectByExample(example);
        PageInfo<IAddresscn> pageInfo = new PageInfo<>(list);
        page.setRowCount(pageInfo.getTotal());
        return list;
    }

    @Override
    public List<IAddresscn> findAddressCNofType(Integer type) {
        return this.addressCNMapper.selectAddressCNofType(type);
    }

    @Override
    public List<IAddresscn> findAddressCNofPid(Long pid) {
        return this.addressCNMapper.selectAddressCNofPid(pid);
    }
}
