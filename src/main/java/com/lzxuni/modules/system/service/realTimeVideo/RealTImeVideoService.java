package com.lzxuni.modules.system.service.realTimeVideo;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.realTimeVideo.RealTimeVideo;

public interface RealTImeVideoService extends IService<RealTimeVideo>{
    PageInfo<RealTimeVideo> queryPage(PageParameter pageParameter,RealTimeVideo realTimeVideo);

}
