package com.lzxuni.modules.system.service.zjwd;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.zjwd.Zjxx;
import com.lzxuni.modules.system.entity.zjwd.ZjxxCustom;
import com.lzxuni.modules.system.entity.zlzs.Photo;
import com.lzxuni.modules.system.entity.zlzs.PhotoCustom;

import java.util.List;

/**
 * RoleService
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-27 16:42
 * @description 
 **/

public interface ZjxxService extends IService<Zjxx> {
    PageInfo<Zjxx> queryPage(PageParameter pageParameter, Zjxx demo);

    List<Zjxx> queryList(Zjxx demo) throws Exception;

    PageInfo<ZjxxCustom> queryListPhtotAndQszqtp(PageParameter pageParameter, ZjxxCustom demo) throws Exception;


}
