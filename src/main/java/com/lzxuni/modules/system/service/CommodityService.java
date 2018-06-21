package com.lzxuni.modules.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.Commodity;
import com.lzxuni.modules.system.entity.Role;

import java.util.List;

/**
 * RoleService
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-21 16:42
 * @description 
 **/

public interface CommodityService extends IService<Commodity> {
    PageInfo<Commodity> queryPage(PageParameter pageParameter, Commodity demo);

    List<Commodity> queryList(Commodity demo) throws Exception;




}
