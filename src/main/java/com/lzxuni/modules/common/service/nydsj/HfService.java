package com.lzxuni.modules.common.service.nydsj;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.entity.nydsj.Hf;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;

import java.util.List;

public interface HfService extends IService<Hf> {
    PageInfo<Hf> queryPage(PageParameter pageParameter, Hf hf);
}
