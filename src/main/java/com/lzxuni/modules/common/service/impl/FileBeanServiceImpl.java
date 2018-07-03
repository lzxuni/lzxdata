package com.lzxuni.modules.common.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzxuni.common.utils.MethodUtil;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.entity.FileBean;
import com.lzxuni.modules.common.mapper.FileBeanMapper;
import com.lzxuni.modules.common.service.FileBeanService;
import net.sf.json.JSONArray;
import org.apache.http.entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 *@Title FileBeanServiceImpl.java
 *@description TODO
 *@author 孙志强
 *@time 2016年11月4日 下午4:51:58
 *@version 1.0
 **/
@Service("fileBeanService")
public class FileBeanServiceImpl extends ServiceImpl<FileBeanMapper, FileBean> implements FileBeanService {
	@Autowired
	private FileBeanMapper fileBeanMapper;


	@Override
	public List<FileBean> selectList(FileBean fileBean) {
		//return null;
		return fileBeanMapper.selectList(
				new EntityWrapper<FileBean>()
						.eq("ywId", fileBean.getYwId())
						.eq("ywType", fileBean.getYwType())
		);
	}

	@Override
	public void save(FileBean fileBean) {

	}

	@Override
	public void update(FileBean fileBean) {

	}

	@Override
	public void deleteByYwid(String ywid) {

	}
	@Override
	public void insertFileBean(String imgjson,String ywid,String type,String ywType) throws Exception {
		if (imgjson != null) {
			imgjson="["+imgjson+"]";
			JSONArray jArray= JSONArray.fromObject(imgjson);
			@SuppressWarnings("unchecked")
			Iterator<FileBean> it = JSONArray.toCollection(jArray, FileBean.class).iterator();
			while (it.hasNext()) {
				FileBean fileBean = (FileBean) it.next();
				fileBean.setId(UuidUtil.get32UUID());
				fileBean.setYwId(ywid);
				fileBean.setType(type);
				fileBean.setYwType(ywType);
				fileBean.setCreateTime(MethodUtil.getDate(0, null));
				fileBeanMapper.insertFileBean(fileBean);
			}
		}

	}
	@Override
	public void delFileBean(String ywId) throws Exception {
		fileBeanMapper.delFileBean(ywId);
	}
	@Override
	public List<FileBean> findFileBeanByFileBeanCustom(FileBean fielBeanCustom) throws Exception {
		return fileBeanMapper.findFileBeanByFileBeanCustom(fielBeanCustom);
	}
}
