package com.lzxuni.modules.system.mapper.nydsj;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.lzxuni.modules.system.entity.nydsj.Zzmj;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZzmjMapper extends BaseMapper<Zzmj>{
    List<Zzmj> findmohuZzmj(Zzmj zzmj);
    List<Zzmj> queryList(Zzmj zzmj);
}
