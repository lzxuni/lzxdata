package com.lzxuni.modules.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.zlzs.Germination;
import com.lzxuni.modules.system.entity.zlzs.Photo;

import java.util.List;

/**
 * RoleService
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-27 16:42
 * @description 
 **/

public interface GerminationService extends IService<Germination> {
    PageInfo<Germination> queryPage(PageParameter pageParameter, Germination demo);

    List<Germination> queryList(Germination demo) throws Exception;



}
