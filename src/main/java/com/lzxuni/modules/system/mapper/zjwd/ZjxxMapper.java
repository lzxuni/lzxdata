package com.lzxuni.modules.system.mapper.zjwd;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzxuni.modules.system.entity.zjwd.Zjxx;
import com.lzxuni.modules.system.entity.zjwd.ZjxxCustom;
import com.lzxuni.modules.system.entity.zlzs.Photo;
import com.lzxuni.modules.system.entity.zlzs.PhotoCustom;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

/**
 * MachiningMapper
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-27 16:33
 * @description 
 **/
@Mapper
public interface ZjxxMapper extends BaseMapper<Zjxx> {
    //查询部门列表
    List<ZjxxCustom> queryListPhtotAndQszqtp() throws SQLException;

}
