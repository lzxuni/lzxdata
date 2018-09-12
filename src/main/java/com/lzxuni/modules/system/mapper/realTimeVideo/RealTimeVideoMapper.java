package com.lzxuni.modules.system.mapper.realTimeVideo;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzxuni.modules.system.entity.realTimeVideo.RealTimeVideo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RealTimeVideoMapper extends BaseMapper<RealTimeVideo> {
    List<RealTimeVideo> queryList(RealTimeVideo realTimeVideo);
    List<RealTimeVideo> findmohuList(RealTimeVideo realTimeVideo);
}
