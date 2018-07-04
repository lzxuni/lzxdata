package com.lzxuni.modules.common.service;

import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.FileEntity;
import com.lzxuni.modules.common.entity.PageParameter;

import java.util.List;


/**
 * @Title FileBeanService.java
 * @description TODO
 * @author 孙志强
 * @time 2016年11月4日 下午4:50:40
 * @version 1.0
 **/
public interface FileEntityService {
	PageInfo<FileEntity> queryPage(PageParameter pageParameter, FileEntity fileEntity);
	// 查询列表
	List<FileEntity> queryListByFileEntity(FileEntity fileEntity) throws Exception;
	// 查询对象
	FileEntity queryObject(String id) throws Exception;
	// 插入
	void insert(String imgJson, String ywId, String type, String ywType, String descrption) throws Exception;

	void deleteById(String id);
	// 根据ywId，批量删除
	void deleteByYwId(String ywId);
	//按YWID查询
	FileEntity queryByYwId(FileEntity fileEntity) throws Exception;
}
