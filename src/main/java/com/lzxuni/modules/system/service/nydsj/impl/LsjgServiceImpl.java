package com.lzxuni.modules.system.service.nydsj.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.nydsj.Lsjg;
import com.lzxuni.modules.system.mapper.nydsj.LsjgMapper;
import com.lzxuni.modules.system.service.nydsj.LsjgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lsjgService")
public class LsjgServiceImpl extends ServiceImpl<LsjgMapper,Lsjg> implements LsjgService {
    @Autowired
    private LsjgMapper lsjgMapper;
    @Override
    public List<Lsjg> findmohuLsjg(Lsjg lsjg) {

        return lsjgMapper.findmohuLsjg(lsjg);
    }

    @Override
    public PageInfo<Lsjg> queryPage(PageParameter pageParameter, Lsjg lsjg) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Lsjg> lsjgList;
        if(lsjg.getCategory()!=null){
            lsjgList=lsjgMapper.findmohuLsjg(lsjg);
        }else {
            lsjgList = lsjgMapper.queryList(lsjg);
        }
        PageInfo<Lsjg> pageInfo = new PageInfo<>(lsjgList);
        return pageInfo;
    }


}

