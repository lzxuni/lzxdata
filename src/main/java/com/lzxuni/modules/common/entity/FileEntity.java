package com.lzxuni.modules.common.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("sys_file")
public class FileEntity {
	@TableId
	private String id ;
	private String type ;//一个业务中，区分不同表单字段用，只有一个类型的时候，可为null
	private String ywType ;//区分不同业务用
	private String ywId ;
	private String descrption ;
	private String urlPath;//web访问路径
	private String urlsPath;//缩略图访问路径
	private String realPath;//磁盘路径
	private String realName ;//文件真正名称
	private String fileName ;//磁盘存储名称
	private String sfileName ;//若是图片，压缩后的名称
	private Date createTime ;
	private Long realSize;//文件真正大小,单位b，转换kb/1000

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("FileEntity{");
		sb.append("id='").append(id).append('\'');
		sb.append(", type='").append(type).append('\'');
		sb.append(", ywType='").append(ywType).append('\'');
		sb.append(", ywId='").append(ywId).append('\'');
		sb.append(", descrption='").append(descrption).append('\'');
		sb.append(", urlPath='").append(urlPath).append('\'');
		sb.append(", urlsPath='").append(urlsPath).append('\'');
		sb.append(", realPath='").append(realPath).append('\'');
		sb.append(", realName='").append(realName).append('\'');
		sb.append(", fileName='").append(fileName).append('\'');
		sb.append(", sfileName='").append(sfileName).append('\'');
		sb.append(", createTime=").append(createTime);
		sb.append(", realSize=").append(realSize);
//		sb.append('}');
		return sb.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getYwType() {
		return ywType;
	}

	public void setYwType(String ywType) {
		this.ywType = ywType;
	}

	public String getYwId() {
		return ywId;
	}

	public void setYwId(String ywId) {
		this.ywId = ywId;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public String getUrlsPath() {
		return urlsPath;
	}

	public void setUrlsPath(String urlsPath) {
		this.urlsPath = urlsPath;
	}

	public String getRealPath() {
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSfileName() {
		return sfileName;
	}

	public void setSfileName(String sfileName) {
		this.sfileName = sfileName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getRealSize() {
		return realSize;
	}

	public void setRealSize(Long realSize) {
		this.realSize = realSize;
	}
}
