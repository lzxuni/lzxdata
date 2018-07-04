package com.lzxuni.modules.system.mapper.cqjc;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzxuni.modules.system.entity.cqjc.Cqjc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CqjcMapper extends BaseMapper<Cqjc> {
    List<Cqjc> queryList(Cqjc cqjc);
    List<Cqjc> findmohuCqjc(Cqjc cqjc);
}
