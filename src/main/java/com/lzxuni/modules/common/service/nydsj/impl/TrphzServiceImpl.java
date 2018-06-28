package com.lzxuni.modules.common.service.nydsj.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;
import com.lzxuni.modules.common.entity.nydsj.Trphz;
import com.lzxuni.modules.common.mapper.nydsj.TrphzMapper;
import com.lzxuni.modules.common.service.nydsj.TrphzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("trPhzService")
public class TrphzServiceImpl extends ServiceImpl<TrphzMapper,Trphz> implements TrphzService {
    @Autowired
    private TrphzMapper trphzMapper;
    @Override
    public List<Trphz> findmohuTrphz(Trphz trphz) {
        return trphzMapper.findmohuTrphz(trphz);
    }

    @Override
    public PageInfo<Trphz> queryPage(PageParameter pageParameter, Trphz trphz) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Trphz> trphzList;
        if(trphz.getRegion()!=null){
            trphzList=trphzMapper.findmohuTrphz(trphz);
        }else {
            trphzList = trphzMapper.queryList(trphz);
        }
        PageInfo<Trphz> pageInfo = new PageInfo<>(trphzList);
        return pageInfo;
    }
}
