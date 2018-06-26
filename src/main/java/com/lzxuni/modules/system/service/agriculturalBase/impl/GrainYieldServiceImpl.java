package com.lzxuni.modules.system.service.agriculturalBase.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.controller.GrainYield;
import com.lzxuni.modules.system.entity.PlantArea;
import com.lzxuni.modules.system.entity.PlantType;
import com.lzxuni.modules.system.mapper.agriculturalBase.GrainYieldMapper;
import com.lzxuni.modules.system.mapper.agriculturalBase.PlantTypeMapper;
import com.lzxuni.modules.system.service.agriculturalBase.GrainYieldService;
import com.lzxuni.modules.system.service.agriculturalBase.PlantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 孙志强
 * @since 2018-06-11
 */
@Service("g rainYieldService")
public class GrainYieldServiceImpl extends ServiceImpl<GrainYieldMapper, GrainYield> implements GrainYieldService {
    @Autowired
    GrainYieldMapper grainYieldMapper;

    @Override
    public PageInfo<GrainYield> queryPage(PageParameter pageParameter, GrainYield grainYield) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        grainYield.setValue(grainYield.getType());
        List<GrainYield> plantAreaList = grainYieldMapper.selectList(new EntityWrapper<GrainYield>(grainYield));
        PageInfo<GrainYield> pageInfo = new PageInfo<>(plantAreaList);
        return pageInfo;
    }
}
