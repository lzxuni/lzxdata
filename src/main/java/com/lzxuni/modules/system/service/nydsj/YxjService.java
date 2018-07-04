package com.lzxuni.modules.system.service.nydsj;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.nydsj.Yxj;

public interface YxjService extends IService<Yxj> {

    PageInfo<Yxj> queryPage(PageParameter pageParameter, Yxj yxj);
}
