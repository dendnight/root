package com.dendnight.test;

import java.io.File;

import com.drew.imaging.ImageMetadataReader;
import com.drew.lang.Rational;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;

/**
 * 图片exif
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年5月3日 下午10:28:43  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public class MetadataTest {
	public static void main(String[] args) {
		// File jpegFile = new File("C:\\1\\IMG_0310.JPG");
		// Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
		//
		// Directory exifDirectory =
		// metadata.getDirectory(ExifDirectory.class);
		// String cameraMake =
		// exifDirectory.getString(ExifDirectory.TAG_MAKE);
		// String cameraModel =
		// exifDirectory.getString(ExifDirectory.TAG_MODEL);
		// String lon = exifDirectory.getString(ExifDirectory.TAG_SUB_IFDS);
		// System.out.println("相机品牌：" + cameraMake + "\n相机型号：" + cameraModel
		// + "\n" + lon);

		try {
			File jpegFile = new File("C:\\1\\IMG_0310.JPG");
			Metadata metadata = ImageMetadataReader.readMetadata(jpegFile);
			for (Directory directory : metadata.getDirectories()) {
				for (Tag tag : directory.getTags()) {
					// System.out.println(tag);
				}
			}
			Directory exifIFD0 = metadata.getDirectory(ExifIFD0Directory.class);
			Directory exifSubIF = metadata.getDirectory(ExifSubIFDDirectory.class);
			Directory gps = metadata.getDirectory(GpsDirectory.class);

			System.out.println(exifIFD0.getString(ExifIFD0Directory.TAG_MAKE));// 相机品牌
			System.out.println(exifIFD0.getString(ExifIFD0Directory.TAG_MODEL));// 相机型号
			System.out.println(exifIFD0.getString(ExifIFD0Directory.TAG_SOFTWARE));// 相机型号

			System.out.println(gps.getDouble(GpsDirectory.TAG_GPS_ALTITUDE));// 海拔
			System.out.println(gps.getString(GpsDirectory.TAG_GPS_LATITUDE));// 纬度
			System.out.println(gps.getString(GpsDirectory.TAG_GPS_LONGITUDE));// 经度

			System.out.println(exifSubIF.getString(ExifSubIFDDirectory.TAG_LENS_MAKE));// 镜头品牌
			System.out.println(exifSubIF.getString(ExifSubIFDDirectory.TAG_LENS_MODEL));// 镜头型号

			Directory directory = metadata.getDirectory(GpsDirectory.class);
			String s = directory.getString(GpsDirectory.TAG_GPS_LATITUDE);
			Rational s1 = directory.getRational(GpsDirectory.TAG_GPS_ALTITUDE);
			System.out.println(s);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
