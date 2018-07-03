package com.lzxuni.common.utils;

import com.lzxuni.common.exception.LzxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件工具类
 *
 * @author
 */
public class FileUtil {
	protected static Logger log = LoggerFactory.getLogger(FileUtil.class);
	/**
	 * 下载文件时，针对不同浏览器，进行附件名的编码
	 *
	 * @param filename
	 *            下载文件名
	 * @param agent
	 *            客户端浏览器
	 * @return 编码后的下载附件名
	 * @throws IOException
	 */
	public static String encodeDownloadFilename(String filename, String agent) throws IOException {
		if (agent.contains("Firefox")) { // 火狐浏览器
			filename = "=?UTF-8?B?" + new BASE64Encoder().encode(filename.getBytes("utf-8")) + "?=";
			filename = filename.replaceAll("\r\n", "");
		} else { // IE及其他浏览器
			filename = URLEncoder.encode(filename, "utf-8");
			filename = filename.replace("+", " ");
		}
		return filename;
	}

	/**
	 * 读取到字节数组2
	 *
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray2(String filePath) throws IOException {

		File f = new File(filePath);
		if (!f.exists()) {
			throw new FileNotFoundException(filePath);
		}

		FileChannel channel = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(f);
			channel = fs.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
			while ((channel.read(byteBuffer)) > 0) {
				// do nothing
				// System.out.println("reading");
			}
			return byteBuffer.array();
		} catch (IOException e) {
			log.error(e.getClass().getName()+":"+e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				channel.close();
			} catch (IOException e) {
				log.error(e.getClass().getName()+":"+e.getMessage());
				e.printStackTrace();
			}
			try {
				fs.close();
			} catch (IOException e) {
				log.error(e.getClass().getName()+":"+e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static BufferedImage toBufferedImage(Image image) {
		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}

		// This code ensures that all the pixels in the image are loaded
		image = new ImageIcon(image).getImage();

		// Determine if the image has transparent pixels; for this method's
		// implementation, see e661 Determining If an Image Has Transparent
		// Pixels
		// boolean hasAlpha = hasAlpha(image);

		// Create a buffered image with a format that's compatible with the
		// screen
		BufferedImage bimage = null;
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			// Determine the type of transparency of the new buffered image
			int transparency = Transparency.OPAQUE;
			/*
			 * if (hasAlpha) { transparency = Transparency.BITMASK; }
			 */

			// Create the buffered image
			GraphicsDevice gs = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gs.getDefaultConfiguration();
			bimage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), transparency);
		} catch (HeadlessException e) {
			log.error(e.getClass().getName()+":"+e.getMessage());
		} catch (Exception e) {
			log.error(e.getClass().getName()+":"+e.getMessage());
			e.printStackTrace();
		}

		if (bimage == null) {
			// Create a buffered image using the default color model
			int type = BufferedImage.TYPE_INT_RGB;
			// int type = BufferedImage.TYPE_3BYTE_BGR;//by wang
			/*
			 * if (hasAlpha) { type = BufferedImage.TYPE_INT_ARGB; }
			 */
			bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
		}

		// Copy image to buffered image
		Graphics g = bimage.createGraphics();

		// Paint the image onto the buffered image
		g.drawImage(image, 0, 0, null);
		g.dispose();

		return bimage;
	}

	/**
	 * 是否是允许上传文件
	 *
	 * @param logoFileName
	 * @return
	 */
	public static boolean isAllowUp(String logoFileName) {
		logoFileName = logoFileName.toLowerCase();
		String allowTYpe = "gif,jpg,jpeg,bmp,swf,png,rar,doc,docx,xls,xlsx,pdf,zip,ico,txt,mp4,flv";
		if (!logoFileName.trim().equals("") && logoFileName.length() > 0) {
			String ex = logoFileName.substring(logoFileName.lastIndexOf(".") + 1, logoFileName.length());
			// return allowTYpe.toString().indexOf(ex) >= 0;
			// lzf edit 20110717
			// 解决只认小写问题
			// 同时加入jpeg扩展名/png扩展名
			return allowTYpe.toUpperCase().indexOf(ex.toUpperCase()) >= 0;
		} else {
			return false;
		}
	}
	/**
	 * 是否是允许上传文件
	 *
	 * @param logoFileName
	 * @return
	 */
	public static boolean isNotAllowUp(String logoFileName) {
		logoFileName = logoFileName.toLowerCase();
		String allowTYpe = "exe,sh,bat";
		if (!logoFileName.trim().equals("") && logoFileName.length() > 0) {
			String ex = logoFileName.substring(logoFileName.lastIndexOf(".") + 1, logoFileName.length());
			// return allowTYpe.toString().indexOf(ex) >= 0;
			// lzf edit 20110717
			// 解决只认小写问题
			// 同时加入jpeg扩展名/png扩展名
			return allowTYpe.toUpperCase().indexOf(ex.toUpperCase()) >= 0;
		} else {
			return false;
		}
	}
	/**
	 * 是否是允许上传的图片
	 *
	 * @param imgFileName
	 * @return
	 */
	public static boolean isAllowUpImg(String imgFileName) {
		imgFileName = imgFileName.toLowerCase();
		String allowTYpe = "gif,jpg,bmp,png,jpeg,mp4";
		if (!imgFileName.trim().equals("") && imgFileName.length() > 0) {
			String ex = imgFileName.substring(imgFileName.lastIndexOf(".") + 1, imgFileName.length());
			return allowTYpe.toUpperCase().indexOf(ex.toUpperCase()) >= 0;
		} else {
			return false;
		}
	}

	/**
	 * 得到文件的扩展名
	 *
	 * @param fileName
	 * @return
	 */
	public static String getFileExt(String fileName) {
		int potPos = fileName.lastIndexOf('.') + 1;
		String type = fileName.substring(potPos, fileName.length());
		return type;
	}

	/**
	 *<b>功能：</b> 创建父子目录<br>
	 *<b>作者：</b>孙志强<br>
	 *<b>日期：</b> 2017年7月1日 下午10:22:25 <br>
	 * @param parentDir
	 * @param subDir
	 * @return
	 */
	public static String createDirs(String parentDir, String subDir) {
		String path = parentDir + subDir;
		File parentFile = new File(parentDir);
		if (!parentFile.exists()) {
			parentFile.mkdirs();
		}
		if (parentFile.exists()) {
			File subFile = new File(path);
			if (!subFile.exists()) {
				subFile.mkdirs();
			}
		}
		return path;
	}


	/**
	 *<b>功能：</b>重命名文件或者文件夹 <br>
	 *<b>作者：</b>孙志强<br>
	 *<b>日期：</b> 2017年7月1日 下午10:20:55 <br>
	 * @param path
	 * @param oldName
	 * @param newName
	 * @throws LzxException
	 */
	public static void renameFile(String path, String oldName, String newName) throws LzxException {
		if (!oldName.equals(newName)) {// 新的文件名和以前文件名不同时,才有必要进行重命名
			File oldfile = new File(path + File.separator + oldName);
			File newfile = new File(path + File.separator + newName);
			if (!oldfile.exists()) {
				throw new LzxException("重命名文件不存在");
			}
			if (newfile.exists()) {// 若在该目录下已经有一个文件和新文件名相同，则不允许重命名
				throw new LzxException(newName + "已经存在！");
			} else {
				oldfile.renameTo(newfile);
			}
		} else {
			throw new LzxException("新文件名和旧文件名相同...");
		}
	}

	public static void main(String arg[]) throws IOException {
		// FileUtil.createDirs("D:\\system\\", "file");
	}

}
