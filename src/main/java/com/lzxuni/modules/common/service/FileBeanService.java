package com.lzxuni.modules.common.service;


import com.baomidou.mybatisplus.service.IService;
import com.lzxuni.modules.common.entity.FileBean;

import java.util.List;

/**
 *@Title FileBeanService.java
 *@description TODO
 *@author 孙志强
 *@time 2016年11月4日 下午4:50:40
 *@version 1.0
 **/
public interface FileBeanService extends IService<FileBean> {
	List<FileBean> selectList(FileBean fileBean);

	void save(FileBean fileBean);

	void update(FileBean fileBean);

	void deleteByYwid(String ywid);
	//多图插入
	void insertFileBean(String imgJson,String ywid,String type,String ywType) throws Exception ;
	//删除部门
	void delFileBean(String ywid) throws Exception ;


	//根据部门id查询部门
	List<FileBean> findFileBeanByFileBeanCustom(FileBean fielBeanCustom) throws Exception ;

}
