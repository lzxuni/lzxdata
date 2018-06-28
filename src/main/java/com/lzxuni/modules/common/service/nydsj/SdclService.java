package com.lzxuni.modules.common.service.nydsj;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;
import com.lzxuni.modules.common.entity.nydsj.Sdcl;

import java.util.List;

public interface SdclService extends IService<Sdcl> {
    List<Sdcl> findmohuSdcl(Sdcl sdcl);

    PageInfo<Sdcl> queryPage(PageParameter pageParameter, Sdcl sdcl);
}
