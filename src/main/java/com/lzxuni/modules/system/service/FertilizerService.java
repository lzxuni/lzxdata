package com.lzxuni.modules.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.Fertilizer;
import com.lzxuni.modules.system.entity.Machining;

import java.util.List;

/**
 * RoleService
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-27 16:42
 * @description 
 **/

public interface FertilizerService extends IService<Fertilizer> {
    PageInfo<Fertilizer> queryPage(PageParameter pageParameter, Fertilizer demo);

    List<Fertilizer> queryList(Fertilizer demo) throws Exception;




}
