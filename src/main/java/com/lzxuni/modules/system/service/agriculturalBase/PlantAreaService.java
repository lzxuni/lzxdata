package com.lzxuni.modules.system.service.agriculturalBase;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.PlantArea;
import com.lzxuni.modules.system.entity.Role;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 孙志强
 * @since 2018-06-11
 */
public interface PlantAreaService extends IService<PlantArea> {
    PageInfo<PlantArea> queryPage(PageParameter pageParameter, PlantArea PlantArea);

}
