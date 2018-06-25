
package com.lzxuni.modules.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.BaseDataitemDetail;
import com.lzxuni.modules.system.entity.Commodity;
import com.lzxuni.modules.system.entity.Role;
import com.lzxuni.modules.system.mapper.CommodityMapper;
import com.lzxuni.modules.system.mapper.RoleMapper;
import com.lzxuni.modules.system.service.CommodityService;
import com.lzxuni.modules.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Wrapper;
import java.util.Arrays;
import java.util.List;

/**
 * RoleServiceImpl
 *
 * @author liuzp
 * @version 1.0
 * @createTime 2018-05-31 16:43
 * @description 
 **/
@Service("commodityService")
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public PageInfo<Commodity> queryPage(PageParameter pageParameter, Commodity demo) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Commodity> roleList = commodityMapper.selectList(new EntityWrapper<Commodity>(demo));
        PageInfo<Commodity> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }

    @Override
    public List<Commodity> queryList(Commodity demo){
        return commodityMapper.selectList(new EntityWrapper<Commodity>());
    }





}
