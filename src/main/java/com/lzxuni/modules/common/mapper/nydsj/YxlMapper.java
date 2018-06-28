package com.lzxuni.modules.common.mapper.nydsj;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;
import com.lzxuni.modules.common.entity.nydsj.Yxl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YxlMapper extends BaseMapper<Yxl>{
    List<Yxl> findmohuYxl(Yxl yxl);
    List<Yxl> queryList(Yxl yxl);
}
