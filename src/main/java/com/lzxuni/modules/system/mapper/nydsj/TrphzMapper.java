package com.lzxuni.modules.system.mapper.nydsj;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.lzxuni.modules.system.entity.nydsj.Trphz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TrphzMapper extends BaseMapper<Trphz>{
    List<Trphz> findmohuTrphz(Trphz trphz);
    List<Trphz> queryList(Trphz trphz);
}
