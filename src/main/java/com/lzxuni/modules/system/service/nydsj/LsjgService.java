package com.lzxuni.modules.system.service.nydsj;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.nydsj.Lsjg;

import java.util.List;

public interface LsjgService extends IService<Lsjg> {
    List<Lsjg> findmohuLsjg(Lsjg lsjg);

    PageInfo<Lsjg> queryPage(PageParameter pageParameter, Lsjg lsjg);

}
