package com.lzxuni.modules.system.service.nydsj;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.nydsj.Tryjz;

import java.util.List;

public interface TryjzService extends IService<Tryjz> {
    List<Tryjz> findmohuTryjz(Tryjz tryjz);
    PageInfo<Tryjz> queryPage(PageParameter pageParameter, Tryjz tryjz);
}
