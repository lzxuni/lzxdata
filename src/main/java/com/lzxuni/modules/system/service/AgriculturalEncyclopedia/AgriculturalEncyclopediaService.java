package com.lzxuni.modules.system.service.AgriculturalEncyclopedia;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.AgriculturalEncyclopedia.AgriculturalEncyclopedia;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 孙志强
 * @since 2018-06-11
 */
public interface AgriculturalEncyclopediaService extends IService<AgriculturalEncyclopedia> {
    PageInfo<AgriculturalEncyclopedia> queryPage(PageParameter pageParameter, AgriculturalEncyclopedia agriculturalEncyclopedia);

}
