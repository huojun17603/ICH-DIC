package com.ich.dictionary.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.core.http.entity.PageView;
import com.ich.core.http.entity.SortView;
import com.ich.dictionary.dao.IBankMapper;
import com.ich.dictionary.pojo.IAddresscn;
import com.ich.dictionary.pojo.IBank;
import com.ich.dictionary.pojo.IBankExample;
import com.ich.dictionary.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBankServiceImpl implements IBankService {

    @Autowired
    private IBankMapper bankMapper;

    @Override
    public List<IBank> findAllList() {
        return this.bankMapper.selectAllList();
    }

    @Override
    public HttpResponse add(IBank bank) {
        if(ObjectHelper.isEmpty(bank.getName())) return new HttpResponse(HttpResponse.HTTP_ERROR,"银行名称不可为空！");
        if(ObjectHelper.isEmpty(bank.getCode())) return new HttpResponse(HttpResponse.HTTP_ERROR,"银行编码不可为空！");
        if(ObjectHelper.isEmpty(bank.getThemecode())) return new HttpResponse(HttpResponse.HTTP_ERROR,"主题色不可为空！");
        IBankExample example = new IBankExample();
        example.createCriteria().andCodeEqualTo(bank.getCode());
        List<IBank> list =bankMapper.selectByExample(example);
        if(ObjectHelper.isNotEmpty(list)) return new HttpResponse(HttpResponse.HTTP_ERROR,"重复的银行编码！");
        bank.setStatus(0);
        this.bankMapper.insert(bank);
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public HttpResponse edit(IBank bank) {
        if(ObjectHelper.isEmpty(bank.getId())) return new HttpResponse(HttpResponse.HTTP_ERROR,"请输入记录ID！");
        IBank entity = bankMapper.selectByPrimaryKey(bank.getId());
        if(ObjectHelper.isEmpty(entity)) return new HttpResponse(HttpResponse.HTTP_ERROR,"无效的数据记录！");
        if(ObjectHelper.isEmpty(bank.getName())) return new HttpResponse(HttpResponse.HTTP_ERROR,"银行名称不可为空！");
        if(ObjectHelper.isEmpty(bank.getCode())) return new HttpResponse(HttpResponse.HTTP_ERROR,"银行编码不可为空！");
        if(ObjectHelper.isEmpty(bank.getThemecode())) return new HttpResponse(HttpResponse.HTTP_ERROR,"主题色不可为空！");
        IBankExample example = new IBankExample();
        example.createCriteria().andCodeEqualTo(bank.getCode());
        List<IBank> list =bankMapper.selectByExample(example);
        if(ObjectHelper.isNotEmpty(list)){
            IBank entity2 = list.get(0);
            if(entity2.getId()!=entity.getId())
                return new HttpResponse(HttpResponse.HTTP_ERROR,"重复的银行编码！");
        }
        this.bankMapper.updateByPrimaryKeySelective(bank);
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public HttpResponse editStatus(Long id, Integer status) {
        this.bankMapper.updateStatus(id,status);
        return new HttpResponse(HttpResponse.HTTP_OK,"OK");
    }

    @Override
    public List<IBank> findList(PageView page, SortView sort, IBankExample example){
        PageHelper.startPage(page.getPage(),page.getRows());
        if(ObjectHelper.isNotEmpty(sort)){
            if(ObjectHelper.isNotEmpty(sort.getSort())&&ObjectHelper.isNotEmpty(sort.getOrder())){
                example.setOrderByClause(sort.getSort()+" "+sort.getOrder());
            }
        }
        List<IBank> list = bankMapper.selectByExample(example);
        PageInfo<IBank> pageInfo = new PageInfo<>(list);
        page.setRowCount(pageInfo.getTotal());
        return list;
    }

    @Override
    public List<IBank> findBanks() {
        return this.bankMapper.selectBanks();
    }
}
