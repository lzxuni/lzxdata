package com.lzxuni.modules.common.service.nydsj;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;
import com.lzxuni.modules.common.entity.nydsj.Yxl;

public interface YxlService extends IService<Yxl>{
    PageInfo<Yxl> queryPage(PageParameter pageParameter, Yxl yxl);
}
