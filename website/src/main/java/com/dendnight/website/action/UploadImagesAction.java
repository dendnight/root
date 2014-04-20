package com.dendnight.website.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dendnight.common.BaseAction;
import com.dendnight.common.Md5Utils;
import com.dendnight.core.domain.ImageInf;
import com.dendnight.core.service.ImageService;

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
@Controller("UploadImagesAction")
@Scope("prototype")
public class UploadImagesAction extends BaseAction {

	private static final long serialVersionUID = 6374328329827914564L;

	Logger log = Logger.getLogger(UploadImagesAction.class);

	@Autowired
	private ImageService imageService;

	private File[] images;
	private String[] imagesContentType;
	private String[] imagesFileName;

	public String execute() {

		json = new HashMap<String, Object>();

		if (timeout) {
			json.put(T, 1);
			return JSON;
		}

		for (int i = 0; i < images.length; i++) {

			int width = 0;// FIXME 图片属性
			int height = 0;
			String md5 = "";
			String path = "";
			ImageInf imageInf = null;
			try {

				md5 = Md5Utils.getMd5ByFile(images[i]);
				imageInf = imageService.query(info(), md5);
				if (null == imageInf) {// 不存在则创建copy

					// 图片路径 FIXME
					String dateTime = new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
					String uuid = UUID.randomUUID().toString();

					path = "pictures/" + dateTime + uuid
							+ imagesFileName[i].substring(imagesFileName[i].lastIndexOf('.'));
					// 创建一个新 File 实例
					File imageFile = new File("D:/temp/" + path);
					// 判断路径是否存在
					if (!imageFile.getParentFile().exists()) {
						// 如果不存在，则递归创建此路径
						imageFile.getParentFile().mkdirs();
					}

					// 将原文件保存到硬盘上,Struts2会帮我们自动删除临时文件
					FileUtils.copyFile(images[i], imageFile);

					imageInf = new ImageInf();
					imageInf.setHeight(height);
					imageInf.setWidth(width);
					imageInf.setId(md5);
					imageInf.setPath(path);
					imageInf.setReadme(imagesFileName[i]);// 默认
					imageService.create(info(), imageInf);
				} else {

					imageInf.setReadme(imagesFileName[i]);
					imageInf.setCount(imageInf.getCount() + 1);
					imageService.update(info(), imageInf);
				}

			} catch (IOException e) {
				log.warn(e);
				json.put(S, 0);
				json.put(M, "上传失败");
				return JSON;
			}

		}
		json.put(S, 1);
		json.put(M, "上传成功");

		return JSON;
	}

	public File[] getImages() {
		return images;
	}

	public void setImages(File[] images) {
		this.images = images;
	}

	public String[] getImagesContentType() {
		return imagesContentType;
	}

	public void setImagesContentType(String[] imagesContentType) {
		this.imagesContentType = imagesContentType;
	}

	public String[] getImagesFileName() {
		return imagesFileName;
	}

	public void setImagesFileName(String[] imagesFileName) {
		this.imagesFileName = imagesFileName;
	}

}
