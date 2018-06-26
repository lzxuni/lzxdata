
package com.lzxuni.modules.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.Commodity;
import com.lzxuni.modules.system.entity.Distribution;
import com.lzxuni.modules.system.mapper.CommodityMapper;
import com.lzxuni.modules.system.mapper.DistributionMapper;
import com.lzxuni.modules.system.service.CommodityService;
import com.lzxuni.modules.system.service.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RoleServiceImpl
 *
 * @author liuzp
 * @version 1.0
 * @createTime 2018-05-31 16:43
 * @description 
 **/
@Service("distributionService")
public class DistributionServiceImpl extends ServiceImpl<DistributionMapper, Distribution> implements DistributionService {
    @Autowired
    private DistributionMapper distributionMapper;

    @Override
    public PageInfo<Distribution> queryPage(PageParameter pageParameter, Distribution demo) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Distribution> roleList = distributionMapper.selectList(new EntityWrapper<Distribution>(demo));
        PageInfo<Distribution> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }

    @Override
    public List<Distribution> queryList(Distribution demo){
        return distributionMapper.selectList(new EntityWrapper<Distribution>());
    }





}
