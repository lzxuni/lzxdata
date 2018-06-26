package com.lzxuni.modules.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.Commodity;
import com.lzxuni.modules.system.entity.Machining;

import java.util.List;

/**
 * RoleService
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-26 16:42
 * @description 
 **/

public interface MachiningService extends IService<Machining> {
    PageInfo<Machining> queryPage(PageParameter pageParameter, Machining demo);

    List<Machining> queryList(Machining demo) throws Exception;




}
