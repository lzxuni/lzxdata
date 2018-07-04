package com.lzxuni.modules.system.service.nydsj;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.nydsj.Bjxx;

import java.util.List;

public interface BjxxService extends IService<Bjxx> {
    List<Bjxx> findmohuBjxx(Bjxx bjxx);
    PageInfo<Bjxx> queryPage(PageParameter pageParameter, Bjxx bjxx);
}
