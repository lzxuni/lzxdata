package com.lzxuni.modules.common.service.nydsj.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;
import com.lzxuni.modules.common.entity.nydsj.Zzmj;
import com.lzxuni.modules.common.mapper.nydsj.ZzmjMapper;
import com.lzxuni.modules.common.service.nydsj.ZzmjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("zzmjService")
public class ZzmjServiceImpl extends ServiceImpl<ZzmjMapper,Zzmj> implements ZzmjService{
    @Autowired
    private ZzmjMapper zzmjMapper;
    @Override
    public List<Zzmj> findmohuZzmj(Zzmj zzmj) {
        return zzmjMapper.findmohuZzmj(zzmj);
    }

    @Override
    public PageInfo<Zzmj> queryPage(PageParameter pageParameter, Zzmj zzmj) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Zzmj> lsjgList;
        if(zzmj.getCategory()!=null){
            lsjgList=zzmjMapper.findmohuZzmj(zzmj);
        }else {
            lsjgList = zzmjMapper.queryList(zzmj);
        }
        PageInfo<Zzmj> pageInfo = new PageInfo<>(lsjgList);
        return pageInfo;
    }
}
