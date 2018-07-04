package com.lzxuni.modules.system.mapper.nydsj;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzxuni.modules.system.entity.nydsj.Hf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HfMapper extends BaseMapper<Hf> {
    List<Hf> findmohuHf(Hf hf);
    List<Hf> queryList(Hf hf);
}
