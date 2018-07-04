package com.lzxuni.modules.system.mapper.nydsj;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzxuni.modules.system.entity.nydsj.Zhsj;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZhsjMapper extends BaseMapper<Zhsj> {
    List<Zhsj> findmuhuZhsj(Zhsj zhsj);
    List<Zhsj> queryList(Zhsj zhsj);
}
