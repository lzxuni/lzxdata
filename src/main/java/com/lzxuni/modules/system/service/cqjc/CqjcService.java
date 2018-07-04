package com.lzxuni.modules.system.service.cqjc;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.cqjc.Cqjc;

public interface CqjcService extends IService<Cqjc>{
    PageInfo<Cqjc> queryPage(PageParameter pageParameter, Cqjc cqjc);
}
