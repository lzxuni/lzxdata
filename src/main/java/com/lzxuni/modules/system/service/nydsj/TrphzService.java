package com.lzxuni.modules.system.service.nydsj;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.nydsj.Trphz;

import java.util.List;

public interface TrphzService extends IService<Trphz> {
    List<Trphz> findmohuTrphz(Trphz trphz);
    PageInfo<Trphz> queryPage(PageParameter pageParameter, Trphz trphz);
}
