package com.lzxuni.modules.system.service.zjwd;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.zjwd.Zjwd;
import com.lzxuni.modules.system.entity.zjwd.ZjwdCustom;
import com.lzxuni.modules.system.entity.zjwd.Zjxx;
import com.lzxuni.modules.system.entity.zjwd.ZjxxCustom;

import java.util.List;

/**
 * RoleService
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-27 16:42
 * @description 
 **/

public interface ZjwdService extends IService<Zjwd> {
    PageInfo<Zjwd> queryPage(PageParameter pageParameter, Zjwd demo);

    List<Zjwd> queryList(Zjwd demo) throws Exception;

    PageInfo<ZjwdCustom> queryListPhtotAndQszqtp(PageParameter pageParameter, ZjwdCustom demo) throws Exception;


}
