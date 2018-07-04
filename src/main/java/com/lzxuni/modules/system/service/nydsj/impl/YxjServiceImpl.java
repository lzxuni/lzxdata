package com.lzxuni.modules.system.service.nydsj.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.nydsj.Yxj;
import com.lzxuni.modules.system.mapper.nydsj.YxjMapper;
import com.lzxuni.modules.system.service.nydsj.YxjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("yxjService")
public class YxjServiceImpl extends ServiceImpl<YxjMapper,Yxj> implements YxjService {
    @Autowired
    private YxjMapper yxjMapper;
    @Override
    public PageInfo<Yxj> queryPage(PageParameter pageParameter, Yxj yxj) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Yxj> yxjList;
        if(yxj.getRegion()!=null){
            yxjList=yxjMapper.findmohuYxj(yxj);
        }else {
            yxjList = yxjMapper.queryList(yxj);
        }
        PageInfo<Yxj> pageInfo = new PageInfo<>(yxjList);
        return pageInfo;
    }
}
