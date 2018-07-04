package com.lzxuni.modules.system.service.nydsj;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.nydsj.Hf;

public interface HfService extends IService<Hf> {
    PageInfo<Hf> queryPage(PageParameter pageParameter, Hf hf);
}
