package com.lzxuni.modules.common.service.nydsj;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;

import java.util.List;

public interface LsjgService extends IService<Lsjg> {
    List<Lsjg> findmohuLsjg(Lsjg lsjg);

    PageInfo<Lsjg> queryPage(PageParameter pageParameter, Lsjg lsjg);

}
