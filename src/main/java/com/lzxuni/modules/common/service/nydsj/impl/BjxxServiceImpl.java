package com.lzxuni.modules.common.service.nydsj.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.entity.nydsj.Bjxx;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;
import com.lzxuni.modules.common.mapper.nydsj.BjxxMapper;
import com.lzxuni.modules.common.service.nydsj.BjxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bjxxService")
public class BjxxServiceImpl extends ServiceImpl<BjxxMapper,Bjxx> implements BjxxService {
    @Autowired
    private BjxxMapper bjxxMapper;
    @Override
    public List<Bjxx> findmohuBjxx(Bjxx bjxx) {
        return bjxxMapper.findmohuBjxx(bjxx);
    }

    @Override
    public PageInfo<Bjxx> queryPage(PageParameter pageParameter, Bjxx bjxx) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Bjxx> lsjgList;
        if(bjxx.getCreateDate()!=null){
            lsjgList=bjxxMapper.findmohuBjxx(bjxx);
        }else {
            lsjgList = bjxxMapper.queryList(bjxx);
        }
        PageInfo<Bjxx> pageInfo = new PageInfo<>(lsjgList);
        return pageInfo;
    }
}
