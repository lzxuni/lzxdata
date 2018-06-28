package com.lzxuni.modules.common.service.nydsj.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;
import com.lzxuni.modules.common.entity.nydsj.Sdcl;
import com.lzxuni.modules.common.mapper.nydsj.SdclMapper;
import com.lzxuni.modules.common.service.nydsj.SdclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sdclService")
public class SdclServiceImpl  extends ServiceImpl<SdclMapper,Sdcl> implements SdclService {
    @Autowired
    private SdclMapper sdclMapper;

    @Override
    public List<Sdcl> findmohuSdcl(Sdcl sdcl) {
        return sdclMapper.findmohuSdcl(sdcl);
    }

    @Override
    public PageInfo<Sdcl> queryPage(PageParameter pageParameter, Sdcl sdcl) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Sdcl> sdclList;
        if(sdcl.getVillage()!=null){
            sdclList=sdclMapper.findmohuSdcl(sdcl);
        }else {
            sdclList = sdclMapper.queryList(sdcl);
        }
        PageInfo<Sdcl> pageInfo = new PageInfo<>(sdclList);
        return pageInfo;
    }
}
