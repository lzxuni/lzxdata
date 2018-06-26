
package com.lzxuni.modules.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.Commodity;
import com.lzxuni.modules.system.entity.Machining;
import com.lzxuni.modules.system.mapper.CommodityMapper;
import com.lzxuni.modules.system.mapper.MachiningMapper;
import com.lzxuni.modules.system.service.CommodityService;
import com.lzxuni.modules.system.service.MachiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MachiningServiceImpl
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-26 16:43
 * @description 
 **/
@Service("machiningService")
public class MachiningServiceImpl extends ServiceImpl<MachiningMapper, Machining> implements MachiningService {
    @Autowired
    private MachiningMapper machiningMapper;

    @Override
    public PageInfo<Machining> queryPage(PageParameter pageParameter, Machining demo) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Machining> roleList = machiningMapper.selectList(new EntityWrapper<Machining>(demo));
        PageInfo<Machining> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }

    @Override
    public List<Machining> queryList(Machining demo){
        return machiningMapper.selectList(new EntityWrapper<Machining>());
    }





}
