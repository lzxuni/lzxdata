package com.lzxuni.modules.common.controller;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.*;
import com.lzxuni.config.AttachmentConfig;
import com.lzxuni.modules.common.entity.FileEntity;
import com.lzxuni.modules.common.service.FileEntityService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 
 * @Description: 上传文件controller，图片路径为项目根目录下upload/时间/文件名
 * @author 孙志强
 * @date 2017年3月4日 下午1:09:22
 *
 */
@Controller
public class FileEntityController extends BaseController {
	protected Logger log = LoggerFactory.getLogger(FileEntityController.class);

	@Autowired
	private AttachmentConfig attachmentConfig;
	/**
	 * 
	 * @Title: uploadImage
	 * @Description: 上传文集核心controller
	 * @param @param file
	 * @param @param type
	 * @param @param thumbWidth压缩图片宽
	 * @param @param thumbHeight压缩图片高
	 * @param @param request
	 * @return Object 返回类型
	 *         格式json{\"result\":1,\"message\":1}，0，代result0，代表失败，message消息
	 *         成功result=1，data类型为json，FileBeanjson统一处理
	 */

	@Autowired
	private FileEntityService fileBeanService;

	@ResponseBody
	@RequestMapping(value = "upload.html")
	public Object uploadImage(MultipartFile file, String type1, HttpServletRequest request) {
		String date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		try {
			if (file != null) {
				if (type1.equals("image")) {
					if (!FileUtil.isAllowUpImg(file.getOriginalFilename())) {
						return JsonResultUtil.getErrorJson("不允许上传的图片格式");
					}
				} else {
					if (FileUtil.isNotAllowUp(file.getOriginalFilename())) {
						return JsonResultUtil.getErrorJson("不允许上传的文件格式");
					}
				}
				// 文件会上传到项目\\upload\\时间\\文件夹中
				// String realPath =
				// request.getSession().getServletContext().getRealPath("/upload");
				String basePath = attachmentConfig.getPath();//D:/

				String realPath = "resource/" + date + "/";//D:/Resource/2018/06/29
				String fileName = UuidUtil.get32UUID() + "." + FileUtil.getFileExt(file.getOriginalFilename());
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(basePath + realPath, fileName));
				if (type1.equals("image")) {
					// 获得图片宽高
					BufferedImage srcImage = null;
					srcImage = ImageIO.read(new File(basePath + realPath, fileName));
					//Integer thumbHeight = srcImage.getHeight();
					Integer thumbWidth = srcImage.getWidth();
					
					JavaImageIOCreator creator = new JavaImageIOCreator(basePath + realPath + fileName, basePath + realPath + "s"
							+ fileName);
					// 等比压缩
					creator.resize(thumbWidth, 0.9);
				}
				FileEntity fileBean = new FileEntity();
				fileBean.setFileName(fileName);
				fileBean.setRealName(file.getOriginalFilename());
				fileBean.setRealSize(file.getSize());

				fileBean.setRealPath(realPath + fileName);
				fileBean.setSfileName("s" + fileName);
				fileBean.setUrlPath("resource/" + date + "/" + fileName);
				fileBean.setUrlsPath("resource/" + date + "/" + "s" + fileName);
				return JsonResultUtil.getSuccessJson(JSON.toJSONString(fileBean));

			}
		} catch (Exception e) {
			log.error(e.getClass().getName()+":"+e.getMessage());
			return JsonResultUtil.getErrorJson("上传出错：" + e.getLocalizedMessage());
		}
		return JsonResultUtil.getErrorJson("失败");
	}
	
	@RequestMapping(value="/attachment.do")
	public void attachment(String id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		FileEntity fileBean = fileBeanService.queryObject(id) ;
		if(fileBean==null){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}else{
			String url=attachmentConfig.getPath()+fileBean.getUrlPath();
			FileDownload.fileDownload(request,response, url,fileBean.getRealName());
		}
	}
	/**
	 *<b>功能：</b> 图片修改回显<br>
	 *<b>作者：</b>孙志强<br>
	 *<b>日期：</b> 2017年10月26日 下午2:54:25 <br>
	 * @param fileEntity
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "filelist.html")
	public Object updateDo(FileEntity fileEntity) throws Exception {
		List<FileEntity> fileBeans = fileBeanService.queryListByFileEntity(fileEntity);
		return fileBeans;
	}
}