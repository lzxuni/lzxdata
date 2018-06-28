package com.lzxuni.modules.common.mapper.nydsj;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzxuni.modules.common.entity.nydsj.Lsjg;
import com.lzxuni.modules.common.entity.nydsj.Zhsj;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZhsjMapper extends BaseMapper<Zhsj>{
    List<Zhsj> findmuhuZhsj(Zhsj zhsj);
    List<Zhsj> queryList(Zhsj zhsj);
}
