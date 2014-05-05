package com.dendnight.website.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.common.BaseAction;
import com.dendnight.common.Md5Utils;
import com.dendnight.core.domain.ImageInf;
import com.dendnight.core.domain.ParamSys;
import com.dendnight.core.service.ImageService;
import com.dendnight.core.service.ParamSysService;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;

/**
 * 上传图片
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2014年2月23日 上午2:37:46  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Controller("UploadImageAction")
@Scope("prototype")
public class UploadImageAction extends BaseAction {

	private static final long serialVersionUID = 6374328329827914564L;

	Logger log = Logger.getLogger(UploadImageAction.class);

	@Autowired
	private ImageService imageService;

	@Autowired
	private ParamSysService paramSysService;

	/** 图片 */
	private File image;
	private String imageContentType;
	private String imageFileName;

	/**
	 * 1.判断是否已经上传过<br>
	 * 2.生成缩略图获取高宽 <br>
	 * 3.获取图片信息存入数据库
	 */
	public String execute() {

		json = new HashMap<String, Object>();

		if (timeout) {
			json.put(T, 1);
			return JSON;
		}

		if (!"image/jpeg".equalsIgnoreCase(imageContentType)) {
			json.put(S, 0);
			json.put(M, "请上传jpg或jpeg相片");
			return JSON;
		}

		String md5 = "";
		ImageInf imageInf = null;
		try {

			md5 = Md5Utils.getMd5ByFile(image);
			imageInf = imageService.query(info(), md5);
			if (null == imageInf) {
				ParamSys param = paramSysService.query(info(), "IMG_ROOT");
				String root = param.getValue();
				String original = UUID.randomUUID().toString()
						+ imageFileName.substring(imageFileName.lastIndexOf('.'));
				// 创建一个新 File 实例
				File imageFile = new File(root + original);
				// 判断路径是否存在
				if (!imageFile.getParentFile().exists()) {
					// 如果不存在，则递归创建此路径
					imageFile.getParentFile().mkdirs();
				}

				// 将原文件保存到硬盘上,Struts2会帮我们自动删除临时文件
				FileUtils.copyFile(image, imageFile);

				// 生成缩略图
				String thumbnail = UUID.randomUUID().toString() + ".jpg";
				Builder<File> file = Thumbnails.of(image).width(220).outputFormat("jpg");
				file.toFile(root + thumbnail);
				// 获取缩略图高度
				BufferedImage bi = file.asBufferedImage();
				int height = bi.getHeight();

				// 获取Exif信息
				Metadata metadata = ImageMetadataReader.readMetadata(image);
				Directory exifIFD0 = metadata.getDirectory(ExifIFD0Directory.class);
				Directory exifSubIF = metadata.getDirectory(ExifSubIFDDirectory.class);
				// Directory gps = metadata.getDirectory(GpsDirectory.class);

				imageInf = new ImageInf();
				imageInf.setHeight(height);
				imageInf.setWidth(220);

				imageInf.setMd5(md5);
				imageInf.setPath(root);
				root = root.substring(root.indexOf("pictures"));// XXX 去掉前缀

				imageInf.setOriginal(root + original);
				imageInf.setThumbnail(root + thumbnail);
				imageInf.setName(imageFileName);

				imageInf.setCameraBrand(exifIFD0.getString(ExifIFD0Directory.TAG_MAKE));
				imageInf.setCameraModel(exifIFD0.getString(ExifIFD0Directory.TAG_MODEL));
				imageInf.setLensBrand(exifSubIF.getString(ExifSubIFDDirectory.TAG_LENS_MAKE));

				imageInf.setLensModel(exifSubIF.getString(ExifSubIFDDirectory.TAG_LENS_MODEL));
				imageInf.setProgramName(exifIFD0.getString(ExifIFD0Directory.TAG_SOFTWARE));
				imageInf.setDateTaken(exifSubIF.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL));

				imageService.create(info(), imageInf);
			} else {

				imageInf.setName(imageFileName);
				imageInf.setUploadCount(imageInf.getUploadCount() + 1);
				imageService.update(info(), imageInf);
			}

		} catch (IOException | ImageProcessingException e) {
			log.warn(e);
			json.put(S, 0);
			json.put(M, "上传失败");
			return JSON;
		}

		json.put(S, 1);
		json.put(M, "上传成功");

		return JSON;
	}

	/**
	 * @return the {@link #image}
	 */
	public File getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the {@link #image} to set
	 */
	public void setImage(File image) {
		this.image = image;
	}

	/**
	 * @return the {@link #imageContentType}
	 */
	public String getImageContentType() {
		return imageContentType;
	}

	/**
	 * @param imageContentType
	 *            the {@link #imageContentType} to set
	 */
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	/**
	 * @return the {@link #imageFileName}
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * @param imageFileName
	 *            the {@link #imageFileName} to set
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

}
