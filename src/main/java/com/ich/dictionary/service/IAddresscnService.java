package com.ich.dictionary.service;

import com.ich.core.http.entity.HttpResponse;
import com.ich.core.http.entity.PageView;
import com.ich.core.http.entity.SortView;
import com.ich.dictionary.pojo.IAddresscn;
import com.ich.dictionary.pojo.IAddresscnExample;

import java.util.List;

public interface IAddresscnService {

    /**
     * 新增或修改区域信息，所有的操作对状态无效，新增的默认状态为不可用
     * @param address 需要保存或修改的数据
     * @return 是否完成
     */
    public HttpResponse add(IAddresscn address);

    public HttpResponse edit(IAddresscn address);
    /**
     * 修改状态
     * @param id ID
     * @param status 状态值
     * @return 是否完成
     */
    public HttpResponse editStatus(Long id,Integer status);

    List<IAddresscn> findList(PageView page, SortView sort, IAddresscnExample example);

    /**
     * 根据区域类别查询对应列表
     * @param type 区域类别
     * @return 列表
     */
    public List<IAddresscn> findAddressCNofType(Integer type);

    /**
     * 根据父级ID查询其子集列表
     * @param pid 父级ID
     * @return 列表
     */
    public List<IAddresscn> findAddressCNofPid(Long pid);

}
