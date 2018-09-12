package com.lzxuni.modules.system.service.realTimeVideo.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.realTimeVideo.RealTimeVideo;
import com.lzxuni.modules.system.mapper.realTimeVideo.RealTimeVideoMapper;
import com.lzxuni.modules.system.service.realTimeVideo.RealTImeVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("realTImeVideoService")
public class RealTimeVIdeoServiceImpl extends ServiceImpl<RealTimeVideoMapper,RealTimeVideo> implements RealTImeVideoService{
    @Autowired
    RealTimeVideoMapper realTimeVideoMapper;
    @Override
    public PageInfo<RealTimeVideo> queryPage(PageParameter pageParameter, RealTimeVideo realTimeVideo) {
        PageHelper.startPage(pageParameter.getPage(),pageParameter.getRows()).setOrderBy(pageParameter.getSidx()+" "+pageParameter.getSord());
        List<RealTimeVideo> realTimeVideoList = realTimeVideoMapper.queryList(realTimeVideo);
        PageInfo<RealTimeVideo> PageInfo = new PageInfo<>(realTimeVideoList);
        return PageInfo;
    }
}
