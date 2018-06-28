
package com.lzxuni.modules.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.Fertilizer;
import com.lzxuni.modules.system.entity.Machining;
import com.lzxuni.modules.system.mapper.FertilizerMapper;
import com.lzxuni.modules.system.mapper.MachiningMapper;
import com.lzxuni.modules.system.service.FertilizerService;
import com.lzxuni.modules.system.service.MachiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MachiningServiceImpl
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-27 16:43
 * @description 
 **/
@Service("fertilizerService")
public class FertilizerServiceImpl extends ServiceImpl<FertilizerMapper, Fertilizer> implements FertilizerService {
    @Autowired
    private FertilizerMapper fertilizerMapper;

    @Override
    public PageInfo<Fertilizer> queryPage(PageParameter pageParameter, Fertilizer demo) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Fertilizer> roleList = fertilizerMapper.selectList(new EntityWrapper<Fertilizer>(demo));
        PageInfo<Fertilizer> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }

    @Override
    public List<Fertilizer> queryList(Fertilizer demo){
        return fertilizerMapper.selectList(new EntityWrapper<Fertilizer>());
    }





}
