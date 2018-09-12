package com.lzxuni.modules.system.service.zjwd;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.zjwd.Nztj;
import com.lzxuni.modules.system.entity.zjwd.Zjwd;

import java.util.List;

/**
 * RoleService
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-27 16:42
 * @description 
 **/

public interface NztjService extends IService<Nztj> {
    PageInfo<Nztj> queryPage(PageParameter pageParameter, Nztj demo);

    List<Nztj> queryList(Nztj demo) throws Exception;

    //PageInfo<ZjwdCustom> queryListPhtotAndQszqtp(PageParameter pageParameter, ZjwdCustom demo) throws Exception;


}
