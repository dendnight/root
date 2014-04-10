package com.dendnight.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
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
		String value = null;
		FileInputStream in = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			in = new FileInputStream(file);
			byte[] buffer = new byte[4096];
			int length = -1;
			while ((length = in.read(buffer)) != -1) {
				md5.update(buffer, 0, length);
			}
			BigInteger bi = new BigInteger(1, md5.digest());
			value = bi.toString(16);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException ex) {
			}
		}
		return value.toUpperCase();
	}

	public static void main(String[] args) {
		String v = Md5Utils.getMd5ByFile(new File("D:\\IMG_0069.MOV"));
		System.out.println(v);

	}
}