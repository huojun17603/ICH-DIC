package com.ich.dictionary.service;

import com.ich.core.http.entity.HttpResponse;
import com.ich.core.http.entity.PageView;
import com.ich.core.http.entity.SortView;
import com.ich.dictionary.pojo.IAddresscn;
import com.ich.dictionary.pojo.INational;
import com.ich.dictionary.pojo.INationalExample;

import java.util.List;

public interface INationalService {

    /**
     * 新增或修改国家信息，所有的操作对状态无效，新增的默认状态为不可用
     * @param national 需要保存或修改的数据
     * @return 是否完成
     */
    public HttpResponse add(INational national);

    public HttpResponse edit(INational national);
    /**
     * 修改状态
     * @param id ID
     * @param status 状态值
     * @return 是否完成
     */
    public HttpResponse editStatus(Long id, Integer status);

    List<INational> findList(PageView page, SortView sort, INationalExample example);

    /**
     * 查询所有的有效国家列表
     * @return 列表
     */
    public List<INational> findNationals();
}
