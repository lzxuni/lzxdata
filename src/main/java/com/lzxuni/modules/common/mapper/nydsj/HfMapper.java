package com.lzxuni.modules.common.mapper.nydsj;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzxuni.modules.common.entity.nydsj.Hf;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HfMapper extends BaseMapper<Hf>{
    List<Hf> findmohuHf(Hf hf);
    List<Hf> queryList(Hf hf);
}
