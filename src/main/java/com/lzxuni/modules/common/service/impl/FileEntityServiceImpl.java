package com.lzxuni.modules.common.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.common.utils.MethodUtil;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.config.AttachmentConfig;
import com.lzxuni.modules.common.entity.FileEntity;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.mapper.FileEntityMapper;
import com.lzxuni.modules.common.service.FileEntityService;
import com.lzxuni.modules.system.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @Title FileBeanServiceImpl.java
 * @description TODO
 * @author 孙志强
 * @time 2016年11月4日 下午4:51:58
 * @version 1.0
 **/
@Service
public class FileEntityServiceImpl implements FileEntityService {
	protected Logger log = LoggerFactory.getLogger(FileEntityServiceImpl.class);
	@Autowired
	private AttachmentConfig attachmentConfig;
	@Autowired
	private FileEntityMapper fileEntityMapper;

	@Override
	public PageInfo<FileEntity> queryPage(PageParameter pageParameter, FileEntity fileEntity) {
		PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
				pageParameter.getSidx() + " " + pageParameter.getSord());
		List<FileEntity> fileEntityList = fileEntityMapper.selectList(null);
		PageInfo<FileEntity> pageInfo = new PageInfo<>(fileEntityList);
		return pageInfo;
	}
	@Override
	public List<FileEntity> queryListByFileEntity(FileEntity fileEntity) throws Exception {

		return fileEntityMapper.selectList(
				new EntityWrapper<FileEntity>()
						.eq("yw_id", fileEntity.getYwId())
						.eq("yw_type", fileEntity.getYwType())
		);
	}
	 @Override
	 public FileEntity queryObject(String id) throws Exception {
		 return fileEntityMapper.selectById(id);
	 }
	 /**
	  * 功能描述: <br>
	  * @Author 孙志强
	  * @date 2018/7/2 11:35
	  * @param imgjson
	  * @param ywid  业务主表ID
	  * @param type  全局业务类型，自定义
	  * @param ywType //相同模块，不同字段
	  * @param descrption //图片描述
	  * @return:void
	  */
	@Override
	public void insert(String imgjson, String ywid, String type, String ywType,String descrption) throws Exception {

		if (imgjson != null) {
			imgjson = "[" + imgjson.replace("\\", "\\\\") + "]";
			List<FileEntity> jArray = JSONArray.parseArray(imgjson, FileEntity.class);
			Iterator<FileEntity> it = jArray.iterator();
			while (it.hasNext()) {
				FileEntity fileEntity = it.next();
				fileEntity.setId(UuidUtil.get32UUID());
				fileEntity.setYwId(ywid);
				fileEntity.setType(type);
				fileEntity.setDescrption(descrption);
				fileEntity.setYwType(ywType);
				fileEntity.setCreateTime(MethodUtil.getDate(0, null));
				fileEntityMapper.insert(fileEntity);
				// 调取截取视频图片方法
				try {
					ffmpeg(fileEntity);
				}catch (Exception e){
					log.error("视频截取组件尚未配置");
				}

			}
		}

	}

	@Override
	public void deleteById(String id) {
		fileEntityMapper.deleteById(id);
	}

	@Override
	public void deleteByYwId(String ywId) {
		fileEntityMapper.delete(new EntityWrapper<FileEntity>().eq("yw_id", ywId));
	}

    // 截取视频图片
	public void ffmpeg(FileEntity fileEntity) throws Exception{
        String veido_path = attachmentConfig.getPath() + fileEntity.getUrlPath();
        String ffmpeg_path = "D:/soft/ffmpeg/ffmpeg.exe";
        List<String> commands = new java.util.ArrayList<>();
        commands.add(ffmpeg_path);
        commands.add("-i");
        commands.add(veido_path);
        commands.add("-y");
        commands.add("-f");
        commands.add("image2");
        commands.add("-ss");
        commands.add("12");// 这个参数是设置截取视频多少秒时的画面
        commands.add("-s");
        commands.add("700x525");
        commands.add(veido_path.substring(0, veido_path.lastIndexOf(".")).replaceFirst("vedio", "file") + ".jpg");
        ProcessBuilder builder = new ProcessBuilder();
        builder.command(commands);
        builder.start();
    }

}
