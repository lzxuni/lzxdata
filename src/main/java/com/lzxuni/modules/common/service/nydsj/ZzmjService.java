package com.lzxuni.modules.common.service.nydsj;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;
import com.lzxuni.modules.common.entity.nydsj.Zzmj;

import java.util.List;

public interface ZzmjService extends IService<Zzmj> {
    List<Zzmj> findmohuZzmj(Zzmj zzmj);
    PageInfo<Zzmj> queryPage(PageParameter pageParameter, Zzmj zzmj);
}
