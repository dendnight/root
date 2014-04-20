package com.dendnight.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		Dendnight
 * Version:		1.0  
 * Create at:	2013年12月1日 下午4:44:56  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public class Md5Utils {

	/**
	 * MD5字符串签名
	 * 
	 * @param src
	 * @return
	 * @throws Exception
	 */
	public static String getMd5ByStr(String str) {
		// 定义数字签名方法, 可用：MD5, SHA-1
		MessageDigest md5;
		StringBuilder sb = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] b = md5.digest(str.getBytes("utf-8"));

			sb = new StringBuilder();
			for (int i = 0; i < b.length; i++) {
				String s = Integer.toHexString(b[i] & 0xFF);
				if (s.length() == 1) {
					sb.append("0");
				}
				sb.append(s);
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * MD5文件签名
	 * 
	 * @param file
	 * @return
	 */
	public static String getMd5ByFile(File file) {
		InputStream fis;
		byte[] buffer = new byte[1024];
		int numRead = 0;
		MessageDigest md5;
		try {
			fis = new FileInputStream(file);
			md5 = MessageDigest.getInstance("MD5");
			while ((numRead = fis.read(buffer)) > 0) {
				md5.update(buffer, 0, numRead);
			}
			fis.close();
			return toHexString(md5.digest());
		} catch (Exception e) {
			System.out.println("error");
			return null;
		}
	}

	private static String toHexString(byte[] b) {
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
			sb.append(HEX_DIGITS[b[i] & 0x0f]);
		}
		return sb.toString();
	}

	private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
			'E', 'F' };

	public static void main(String[] args) {
		String v = Md5Utils.getMd5ByFile(new File("D:\\IMG_0069.MOV"));
		System.out.println(v);

	}
}