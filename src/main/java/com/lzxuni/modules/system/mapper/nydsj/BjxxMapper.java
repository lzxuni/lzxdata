package com.lzxuni.modules.system.mapper.nydsj;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzxuni.modules.system.entity.nydsj.Bjxx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BjxxMapper extends BaseMapper<Bjxx> {
    List<Bjxx> findmohuBjxx(Bjxx bjxx);
    List<Bjxx> queryList(Bjxx bjxx);
}
