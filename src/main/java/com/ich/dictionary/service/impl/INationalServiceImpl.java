package com.ich.dictionary.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.core.http.entity.PageView;
import com.ich.core.http.entity.SortView;
import com.ich.dictionary.dao.INationalMapper;
import com.ich.dictionary.pojo.IBank;
import com.ich.dictionary.pojo.IBankExample;
import com.ich.dictionary.pojo.INational;
import com.ich.dictionary.pojo.INationalExample;
import com.ich.dictionary.service.INationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class INationalServiceImpl implements INationalService {

    @Autowired
    private INationalMapper nationalMapper;

    @Override
    public HttpResponse add(INational national) {
        if(ObjectHelper.isEmpty(national.getCode())) return new HttpResponse(HttpResponse.HTTP_ERROR,"国家编码不可为空！");
        if(ObjectHelper.isEmpty(national.getName())) return new HttpResponse(HttpResponse.HTTP_ERROR,"国家名称不可为空！");
        if(ObjectHelper.isEmpty(national.getOnum())) national.setOnum(0);
        national.setStatus(0);
        INationalExample example = new INationalExample();
        example.createCriteria().andCodeEqualTo(national.getCode());
        List<INational> list =nationalMapper.selectByExample(example);
        if(ObjectHelper.isNotEmpty(list)) return new HttpResponse(HttpResponse.HTTP_ERROR,"重复的国家编码！");
        this.nationalMapper.insert(national);
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public HttpResponse edit(INational national) {
        if(ObjectHelper.isEmpty(national.getId())) return new HttpResponse(HttpResponse.HTTP_ERROR,"请输入记录ID！");
        INational entity = nationalMapper.selectByPrimaryKey(national.getId());
        if(ObjectHelper.isEmpty(entity)) return new HttpResponse(HttpResponse.HTTP_ERROR,"无效的数据记录！");
        if(ObjectHelper.isEmpty(national.getCode())) return new HttpResponse(HttpResponse.HTTP_ERROR,"国家编码不可为空！");
        if(ObjectHelper.isEmpty(national.getName())) return new HttpResponse(HttpResponse.HTTP_ERROR,"国家名称不可为空！");
        if(ObjectHelper.isEmpty(national.getOnum())) national.setOnum(0);
        INationalExample example = new INationalExample();
        example.createCriteria().andCodeEqualTo(national.getCode());
        List<INational> list =nationalMapper.selectByExample(example);
        if(ObjectHelper.isNotEmpty(list)){
            INational entity2 = list.get(0);
            if(entity2.getId()!=entity.getId())
                return new HttpResponse(HttpResponse.HTTP_ERROR,"重复的国家编码！");
        }
        this.nationalMapper.updateByPrimaryKeySelective(national);
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public HttpResponse editStatus(Long id, Integer status) {
        this.nationalMapper.updateStatus(id,status);
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public List<INational> findList(PageView page, SortView sort,INationalExample example){
        PageHelper.startPage(page.getPage(),page.getRows());
        if(ObjectHelper.isNotEmpty(sort)){
            if(ObjectHelper.isNotEmpty(sort.getSort())&&ObjectHelper.isNotEmpty(sort.getOrder())){
                example.setOrderByClause(sort.getSort()+" "+sort.getOrder());
            }
        }
        List<INational> list = nationalMapper.selectByExample(example);
        PageInfo<INational> pageInfo = new PageInfo<>(list);
        page.setRowCount(pageInfo.getTotal());
        return list;
    }

    @Override
    public List<INational> findNationals() {
        return this.nationalMapper.selectNationals();
    }
}
