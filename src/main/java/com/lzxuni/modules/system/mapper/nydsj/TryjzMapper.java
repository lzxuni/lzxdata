package com.lzxuni.modules.system.mapper.nydsj;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzxuni.modules.system.entity.nydsj.Tryjz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TryjzMapper extends BaseMapper<Tryjz> {
    List<Tryjz> findmohuTryjz(Tryjz tryjz);
    List<Tryjz> queryList(Tryjz tryjz);
}
