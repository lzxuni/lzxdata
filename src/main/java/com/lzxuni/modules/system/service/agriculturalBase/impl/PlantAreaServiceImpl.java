package com.lzxuni.modules.system.service.agriculturalBase.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.PlantArea;
import com.lzxuni.modules.system.entity.Role;
import com.lzxuni.modules.system.mapper.RoleMapper;
import com.lzxuni.modules.system.mapper.agriculturalBase.PlantAreaMapper;
import com.lzxuni.modules.system.service.agriculturalBase.PlantAreaService;
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
@Service("plantAreaService")
public class PlantAreaServiceImpl extends ServiceImpl<PlantAreaMapper, PlantArea> implements PlantAreaService {
    @Autowired
    private PlantAreaMapper plantAreaMapper;

    @Override
    public PageInfo<PlantArea> queryPage(PageParameter pageParameter, PlantArea plantArea) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        plantArea.setValue(plantArea.getType());
        List<PlantArea> plantAreaList = plantAreaMapper.selectList(new EntityWrapper<PlantArea>(plantArea));
        PageInfo<PlantArea> pageInfo = new PageInfo<>(plantAreaList);
        return pageInfo;
    }
}
