package com.lzxuni.modules.system.mapper.nydsj;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzxuni.modules.system.entity.nydsj.Yxj;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YxjMapper extends BaseMapper<Yxj> {
    List<Yxj> findmohuYxj(Yxj yxj);
    List<Yxj> queryList(Yxj yxj);
}
