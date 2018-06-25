package com.lzxuni.modules.system.service.agriculturalBase.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.PlantArea;
import com.lzxuni.modules.system.entity.PlantType;
import com.lzxuni.modules.system.mapper.agriculturalBase.PlantTypeMapper;
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
@Service("plantTypeService")
public class PlantTypeServiceImpl extends ServiceImpl<PlantTypeMapper, PlantType> implements PlantTypeService {
    @Autowired
    PlantTypeMapper plantTypeMapper;

    @Override
    public PageInfo<PlantType> queryPage(PageParameter pageParameter, PlantType plantType) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<PlantType> plantAreaList = plantTypeMapper.selectList(new EntityWrapper<PlantType>(plantType));
        PageInfo<PlantType> pageInfo = new PageInfo<>(plantAreaList);
        return pageInfo;
    }
}
