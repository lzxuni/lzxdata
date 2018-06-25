package com.lzxuni.modules.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.Commodity;
import com.lzxuni.modules.system.entity.TblCompany;

import java.util.List;

/**
 * RoleService
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-22 9:42
 * @description 
 **/

public interface TblCompanyService extends IService<TblCompany> {
    PageInfo<TblCompany> queryPage(PageParameter pageParameter, TblCompany demo);

    List<TblCompany> queryList(TblCompany demo) throws Exception;




}
