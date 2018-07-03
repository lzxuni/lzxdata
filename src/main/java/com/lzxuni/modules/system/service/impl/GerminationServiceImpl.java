
package com.lzxuni.modules.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.zlzs.Germination;
import com.lzxuni.modules.system.entity.zlzs.Photo;
import com.lzxuni.modules.system.mapper.GerminationMapper;
import com.lzxuni.modules.system.mapper.PhotoMapper;
import com.lzxuni.modules.system.service.GerminationService;
import com.lzxuni.modules.system.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MachiningServiceImpl
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-28 16:43
 * @description 
 **/
@Service("germinationService")
public class GerminationServiceImpl extends ServiceImpl<GerminationMapper, Germination> implements GerminationService {
    @Autowired
    private GerminationMapper germinationMapper;

    @Override
    public PageInfo<Germination> queryPage(PageParameter pageParameter, Germination demo) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Germination> roleList = germinationMapper.selectList(new EntityWrapper<Germination>(demo));
        PageInfo<Germination> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }

    @Override
    public List<Germination> queryList(Germination demo){
        return germinationMapper.selectList(new EntityWrapper<Germination>());
    }





}
