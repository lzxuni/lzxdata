package com.lzxuni.modules.system.mapper.nydsj;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzxuni.modules.system.entity.nydsj.Lsjg;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface LsjgMapper extends BaseMapper<Lsjg> {
    List<Lsjg> findmohuLsjg(Lsjg lsjg);

    List<Lsjg> queryList(Lsjg lsjg);
}
