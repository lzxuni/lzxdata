package com.lzxuni.modules.common.service.nydsj.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;
import com.lzxuni.modules.common.entity.nydsj.Tryjz;
import com.lzxuni.modules.common.mapper.nydsj.TryjzMapper;
import com.lzxuni.modules.common.service.nydsj.TryjzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tryjzService")
public class TryjzServiceImpl extends ServiceImpl<TryjzMapper,Tryjz> implements TryjzService {
    @Autowired
    private TryjzMapper tryjzMapper;
    @Override
    public List<Tryjz> findmohuTryjz(Tryjz tryjz) {
        return tryjzMapper.findmohuTryjz(tryjz);
    }

    @Override
    public PageInfo<Tryjz> queryPage(PageParameter pageParameter, Tryjz tryjz) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Tryjz> tryjzList;
        if(tryjz.getOrganic()!=null){
            tryjzList=tryjzMapper.findmohuTryjz(tryjz);
        }else {
            tryjzList = tryjzMapper.queryList(tryjz);
        }
        PageInfo<Tryjz> pageInfo = new PageInfo<>(tryjzList);
        return pageInfo;
    }
}
