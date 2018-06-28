package com.lzxuni.modules.common.service.nydsj;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.entity.nydsj.Bjxx;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;

import java.util.List;

public interface BjxxService extends IService<Bjxx> {
    List<Bjxx> findmohuBjxx(Bjxx bjxx);
    PageInfo<Bjxx> queryPage(PageParameter pageParameter, Bjxx bjxx);
}
