package com.lzxuni.modules.system.service.agriculturalBase;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.GrainSales;
import com.lzxuni.modules.system.entity.PlantArea;
import com.lzxuni.modules.system.entity.PlantType;
import sun.util.calendar.Gregorian;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 孙志强
 * @since 2018-06-11
 */
public interface GrainSalesService extends IService<GrainSales> {
    PageInfo<GrainSales> queryPage(PageParameter pageParameter, GrainSales grainSales);

}
