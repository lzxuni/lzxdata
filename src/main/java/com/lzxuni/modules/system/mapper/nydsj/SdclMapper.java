package com.lzxuni.modules.system.mapper.nydsj;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.lzxuni.modules.system.entity.nydsj.Sdcl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SdclMapper extends BaseMapper<Sdcl> {
    List<Sdcl> findmohuSdcl(Sdcl sdcl);

    List<Sdcl> queryList(Sdcl sdcl);
}
