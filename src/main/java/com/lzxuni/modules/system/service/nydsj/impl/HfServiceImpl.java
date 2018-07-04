package com.lzxuni.modules.system.service.nydsj.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzxuni.modules.common.entity.PageParameter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.system.entity.nydsj.Hf;
import com.lzxuni.modules.system.mapper.nydsj.HfMapper;
import com.lzxuni.modules.system.service.nydsj.HfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hfService")
public class HfServiceImpl extends ServiceImpl<HfMapper,Hf> implements HfService {
    @Autowired
    private HfMapper hfMapper;

    @Override
    public PageInfo<Hf> queryPage(PageParameter pageParameter, Hf hf) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Hf> hfList;
        if(hf.getCategory()!=null){
            hfList=hfMapper.findmohuHf(hf);
        }else {
            hfList = hfMapper.queryList(hf);
        }
        PageInfo<Hf> pageInfo = new PageInfo<>(hfList);
        return pageInfo;
    }


}
