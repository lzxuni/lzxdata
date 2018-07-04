package com.lzxuni.modules.system.service.cqjc.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.cqjc.Cqjc;
import com.lzxuni.modules.system.mapper.cqjc.CqjcMapper;
import com.lzxuni.modules.system.service.cqjc.CqjcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cqjcService")
public class CqjcServiceImpl extends ServiceImpl<CqjcMapper,Cqjc> implements CqjcService {
    @Autowired
    private CqjcMapper cqjcMapper;
    @Override
    public PageInfo<Cqjc> queryPage(PageParameter pageParameter, Cqjc cqjc) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Cqjc> cqjcList;
        if(cqjc.getInsect()!=null){
            cqjcList=cqjcMapper.findmohuCqjc(cqjc);
        }else {
            cqjcList = cqjcMapper.queryList(cqjc);
        }
        PageInfo<Cqjc> pageInfo = new PageInfo<>(cqjcList);
        return pageInfo;
    }
}
