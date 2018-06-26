package com.lzxuni.modules.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.Commodity;
import com.lzxuni.modules.system.entity.Distribution;

import java.util.List;

/**
 * RoleService
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-21 16:42
 * @description 
 **/

public interface DistributionService extends IService<Distribution> {
    PageInfo<Distribution> queryPage(PageParameter pageParameter, Distribution demo);

    List<Distribution> queryList(Distribution demo) throws Exception;




}
