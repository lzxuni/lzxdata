package com.lzxuni.modules.system.service.agriculturalBase.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.GrainSales;
import com.lzxuni.modules.system.entity.PlantArea;
import com.lzxuni.modules.system.entity.PlantType;
import com.lzxuni.modules.system.mapper.agriculturalBase.GrainSalesMapper;
import com.lzxuni.modules.system.mapper.agriculturalBase.PlantTypeMapper;
import com.lzxuni.modules.system.service.agriculturalBase.GrainSalesService;
import com.lzxuni.modules.system.service.agriculturalBase.PlantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.calendar.Gregorian;

import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 孙志强
 * @since 2018-06-11
 */
@Service("grainSalesService")
public class GrainSalesServiceImpl extends ServiceImpl<GrainSalesMapper, GrainSales> implements GrainSalesService {
    @Autowired
    GrainSalesMapper grainSalesMapper;

    @Override
    public PageInfo<GrainSales> queryPage(PageParameter pageParameter, GrainSales grainSales) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<GrainSales> grainSales1 = grainSalesMapper.selectList(new EntityWrapper<GrainSales>(grainSales));
        PageInfo<GrainSales> pageInfo = new PageInfo<>(grainSales1);
        return pageInfo;
    }
}
