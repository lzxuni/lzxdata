package com.lzxuni.modules.common.mapper.nydsj;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzxuni.modules.common.entity.nydsj.Bjxx;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BjxxMapper extends BaseMapper<Bjxx> {
    List<Bjxx> findmohuBjxx(Bjxx bjxx);
    List<Bjxx> queryList(Bjxx bjxx);
}
