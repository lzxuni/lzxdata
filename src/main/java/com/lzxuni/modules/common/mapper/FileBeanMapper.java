package com.lzxuni.modules.common.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzxuni.modules.common.entity.FileBean;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;


/**
 *@Title FileBeanMapper.java
 *@description 
 *@author 孙志强
 *@time 2016年11月4日 下午3:57:10
 *@version 1.0
 **/
@Mapper
public interface FileBeanMapper extends BaseMapper<FileBean> {
    //插入部门
    void insertFileBean(FileBean FileBean) throws SQLException;
    //删除部门
    void delFileBean(String id) throws SQLException ;
    //查询部门列表
    List<FileBean> findFileBeanList() throws SQLException ;
    //根据部门id查询部门
    List<FileBean>  findFileBeanByFileBeanCustom(FileBean fileBeanCustom) throws SQLException ;
}
