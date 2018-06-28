package com.lzxuni.modules.common.service.nydsj;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;
import com.lzxuni.modules.common.entity.nydsj.Yxj;

public interface YxjService extends IService<Yxj> {

    PageInfo<Yxj> queryPage(PageParameter pageParameter, Yxj yxj);
}
