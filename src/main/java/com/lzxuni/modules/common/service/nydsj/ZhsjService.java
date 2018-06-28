package com.lzxuni.modules.common.service.nydsj;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;
import com.lzxuni.modules.common.entity.nydsj.Zhsj;

public interface ZhsjService extends IService<Zhsj> {
    PageInfo<Zhsj> queryPage(PageParameter pageParameter, Zhsj zhsj);
}
