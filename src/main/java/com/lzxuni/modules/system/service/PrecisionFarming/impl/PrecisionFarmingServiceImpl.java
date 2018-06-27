package com.lzxuni.modules.system.service.PrecisionFarming.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.PrecisionFarming.PrecisionFarming;
import com.lzxuni.modules.system.mapper.PrecisionFarming.PrecisionFarmingMapper;
import com.lzxuni.modules.system.service.PrecisionFarming.PrecisionFarmingService;
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
@Service("precisionFarmingService")
public class PrecisionFarmingServiceImpl extends ServiceImpl<PrecisionFarmingMapper, PrecisionFarming> implements PrecisionFarmingService {
    @Autowired
    PrecisionFarmingMapper PrecisionFarmingMapper;

    @Override
    public PageInfo<PrecisionFarming> queryPage(PageParameter pageParameter, PrecisionFarming precisionFarming) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<PrecisionFarming> plantAreaList = PrecisionFarmingMapper.selectList(new EntityWrapper<PrecisionFarming>(precisionFarming));
        PageInfo<PrecisionFarming> pageInfo = new PageInfo<>(plantAreaList);
        return pageInfo;
    }
}
