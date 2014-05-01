package com.dendnight.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

/**
 * WEB工具
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c)2013  
 * Company:		DENDNIGHT
 * Author:		dendnight
 * Version:		1.0  
 * Create at:	2014年5月1日 下午11:34:28  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public class WebUtil {

	public static final String X_FORWARDED_FOR = "x-forwarded-for";

	// private static final Logger log = LoggerFactory.getLogger(WebUtil.class);

	/**
	 * 返回一张验证码图片，并把验证码存放在session里面
	 * 
	 * @return
	 */
	public static BufferedImage getCaptchaImage(final Map<Object, Object> session, String KEY) {
		int width = 90;
		int height = 30;
		// 创建一个图片对象
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		// 得到图像的环境对象
		Graphics g = image.createGraphics();
		// 用随机颜色填充图像背景
		Random random = new Random();
		g.setColor(getColor(180, 250));
		g.fillRect(0, 0, width, height);
		for (int i = 0; i < 5; i++) {
			g.setColor(getColor(50, 100));
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			g.drawOval(x, y, 4, 4);
		}

		g.setFont(new Font("", Font.PLAIN, 28));
		// 生成随机字符串
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			// 生成随机颜色
			g.setColor(new Color(20 + random.nextInt(80), 20 + random.nextInt(100), 20 + random.nextInt(90)));
			g.drawString(sRand, 15, 25);
			// 生成干扰向
			for (int j = 0; j < 12; j++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int x1 = random.nextInt(9);
				int y1 = random.nextInt(9);
				g.drawLine(x, y, x + x1, y + y1);
			}
		}
		session.put(KEY, sRand);
		return image;

	}

	/**
	 * 产生一个随机的颜色
	 * 
	 * @return
	 */
	private static Color getColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}

		int red = fc + random.nextInt(bc - fc);
		int green = fc + random.nextInt(bc - fc);
		int blue = fc + random.nextInt(bc - fc);

		return new Color(red, green, blue);
	}

	/**
	 * 获取客户端IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteIP(HttpServletRequest request) {

		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip != null && ip.length() > 15) {
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
				String ipLeval = ip.substring(ip.indexOf(",") + 1, ip.length());
				while ("unknown".equals(ip)) {
					if (ip.indexOf(",") > 0) {
						ip = ipLeval.substring(0, ipLeval.indexOf(","));
					} else {
						ip = ipLeval;
						break;
					}
				}
			}
		}
		return ip;
	}

}
