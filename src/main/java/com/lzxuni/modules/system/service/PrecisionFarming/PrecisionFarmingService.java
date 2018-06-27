package com.lzxuni.modules.system.service.PrecisionFarming;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.PrecisionFarming.PrecisionFarming;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 孙志强
 * @since 2018-06-11
 */
public interface PrecisionFarmingService extends IService<PrecisionFarming> {
    PageInfo<PrecisionFarming> queryPage(PageParameter pageParameter, PrecisionFarming precisionFarming);

}
