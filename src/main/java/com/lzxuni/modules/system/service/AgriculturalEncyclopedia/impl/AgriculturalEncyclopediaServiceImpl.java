package com.lzxuni.modules.system.service.AgriculturalEncyclopedia.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.AgriculturalEncyclopedia.AgriculturalEncyclopedia;
import com.lzxuni.modules.system.mapper.AgriculturalEncyclopedia.AgriculturalEncyclopediaMapper;
import com.lzxuni.modules.system.service.AgriculturalEncyclopedia.AgriculturalEncyclopediaService;
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
@Service("agriculturalEncyclopediaService")
public class AgriculturalEncyclopediaServiceImpl extends ServiceImpl<AgriculturalEncyclopediaMapper, AgriculturalEncyclopedia> implements AgriculturalEncyclopediaService {
    @Autowired
    AgriculturalEncyclopediaMapper agriculturalEncyclopediaMapper;

    @Override
    public PageInfo<AgriculturalEncyclopedia> queryPage(PageParameter pageParameter, AgriculturalEncyclopedia agriculturalEncyclopedia) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<AgriculturalEncyclopedia> precisionFarmings = agriculturalEncyclopediaMapper.selectList(new EntityWrapper<AgriculturalEncyclopedia>(agriculturalEncyclopedia));
        PageInfo<AgriculturalEncyclopedia> pageInfo = new PageInfo<>(precisionFarmings);
        return pageInfo;
    }
}
