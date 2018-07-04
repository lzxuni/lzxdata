package com.lzxuni.modules.system.service.nydsj.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.nydsj.Yxl;
import com.lzxuni.modules.system.mapper.nydsj.YxlMapper;
import com.lzxuni.modules.system.service.nydsj.YxlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("yxlService")
public class YxlServiceImpl extends ServiceImpl<YxlMapper,Yxl> implements YxlService {
    @Autowired
    private YxlMapper yxlMapper;
    @Override
    public PageInfo<Yxl> queryPage(PageParameter pageParameter, Yxl yxl) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Yxl> yxlList;
        if(yxl.getPhosphorus()!=null){
            yxlList=yxlMapper.findmohuYxl(yxl);
        }else {
            yxlList = yxlMapper.queryList(yxl);
        }
        PageInfo<Yxl> pageInfo = new PageInfo<>(yxlList);
        return pageInfo;
    }
}
