
package com.lzxuni.modules.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.TblCompany;
import com.lzxuni.modules.system.mapper.TblCompanyMapper;
import com.lzxuni.modules.system.service.TblCompanyService;
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
@Service("tblCompanyService")
public class TblCompanyServiceImpl extends ServiceImpl<TblCompanyMapper, TblCompany> implements TblCompanyService {
    @Autowired
    private TblCompanyMapper tblCompanyMapper;

    @Override
    public PageInfo<TblCompany> queryPage(PageParameter pageParameter, TblCompany demo) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<TblCompany> demoList = tblCompanyMapper.selectList(new EntityWrapper<TblCompany>());
        PageInfo<TblCompany> pageInfo = new PageInfo<>(demoList);
        return pageInfo;
    }

    @Override
    public List<TblCompany> queryList(TblCompany demo){
        return tblCompanyMapper.selectList(new EntityWrapper<TblCompany>());
    }





}
